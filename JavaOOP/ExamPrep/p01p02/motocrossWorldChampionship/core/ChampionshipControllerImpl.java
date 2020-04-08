package motocrossWorldChampionship.core;

import java.util.List;
import java.util.stream.Collectors;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.common.OutputMessages;
import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.entities.PowerMotorcycle;
import motocrossWorldChampionship.entities.RaceImpl;
import motocrossWorldChampionship.entities.RiderImpl;
import motocrossWorldChampionship.entities.SpeedMotorcycle;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

public class ChampionshipControllerImpl implements ChampionshipController {

    private Repository<Rider> riderRepo;
    private Repository<Motorcycle> motorcycleRepo;
    private Repository<Race> raceRepo;

    public ChampionshipControllerImpl(Repository<Rider> riderRepo, Repository<Motorcycle> motorcycleRepo, Repository<Race> raceRepo) {
        this.riderRepo = riderRepo;
        this.motorcycleRepo = motorcycleRepo;
        this.raceRepo = raceRepo;
    }

    @Override
    public String createRider(String riderName) {
        Rider fetchedRider = this.riderRepo.getByName(riderName);

        if (fetchedRider != null) {
            throw new IllegalArgumentException(String.format(
                ExceptionMessages.RIDER_EXISTS, riderName
            ));
        }

        this.riderRepo.add(new RiderImpl(riderName));

        return String.format(OutputMessages.RIDER_CREATED, riderName);
    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {
        Motorcycle fetchedMotorcycle = this.motorcycleRepo.getByName(model);

        if (fetchedMotorcycle != null) {
            throw new IllegalArgumentException(String.format(
                ExceptionMessages.MOTORCYCLE_EXISTS, model
            ));
        }

        Motorcycle motorcycle;

        switch (type) {
            case "Speed":
                motorcycle = new SpeedMotorcycle(model, horsePower);
                break;
            case "Power":
                motorcycle = new PowerMotorcycle(model, horsePower);
                break;
            default:
                motorcycle = null;
        }

        if (motorcycle == null) {
            throw new IllegalArgumentException(ExceptionMessages.MOTORCYCLE_INVALID);
        }

        this.motorcycleRepo.add(motorcycle);

        return String.format(OutputMessages.MOTORCYCLE_CREATED, type + "Motorcycle", model);
    }

    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {
        Rider rider = this.riderRepo.getByName(riderName);

        if (rider == null) {
            throw new NullPointerException(String.format(
                ExceptionMessages.RIDER_NOT_FOUND, riderName
            ));
        }

        Motorcycle motorcycle = this.motorcycleRepo.getByName(motorcycleModel);

        if (motorcycle == null) {
            throw new NullPointerException(String.format(
                ExceptionMessages.MOTORCYCLE_NOT_FOUND, motorcycleModel
            ));
        }

        rider.addMotorcycle(motorcycle);

        return String.format(OutputMessages.MOTORCYCLE_ADDED, riderName, motorcycleModel);
    }

    @Override
    public String addRiderToRace(String raceName, String riderName) {
        Race race = this.raceRepo.getByName(raceName);

        if (race == null) {
            throw new NullPointerException(String.format(
                ExceptionMessages.RACE_NOT_FOUND, raceName
            ));
        }

        Rider rider = this.riderRepo.getByName(riderName);

        if (rider == null) {
            throw new NullPointerException(String.format(
                ExceptionMessages.RIDER_NOT_FOUND, riderName
            ));
        }

        race.addRider(rider);

        return String.format(OutputMessages.RIDER_ADDED, riderName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepo.getByName(raceName);

        if (race == null) {
            throw new NullPointerException(String.format(
                ExceptionMessages.RACE_NOT_FOUND, raceName
            ));
        }

        if (race.getRiders().size() < 3) {
            throw new IllegalArgumentException(String.format(
                ExceptionMessages.RACE_INVALID, raceName, 3
            ));
        }

        List<Rider> winners = race.getRiders().stream()
            .sorted((r1, r2) -> Double.compare(r2.getMotorcycle().calculateRacePoints(race.getLaps()), r1.getMotorcycle().calculateRacePoints(race.getLaps())))
            .limit(3)
            .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(OutputMessages.RIDER_FIRST_POSITION, winners.get(0).getName(), raceName))
            .append(System.lineSeparator())
            .append(String.format(OutputMessages.RIDER_SECOND_POSITION, winners.get(1).getName(), raceName))
            .append(System.lineSeparator())
            .append(String.format(OutputMessages.RIDER_THIRD_POSITION, winners.get(2).getName(), raceName));

        this.raceRepo.remove(race);

        return sb.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race fetchedRace = this.raceRepo.getByName(name);

        if (fetchedRace != null) {
            throw new IllegalArgumentException(String.format(
                ExceptionMessages.RACE_EXISTS, name
            ));
        }

        Race race = new RaceImpl(name, laps);
        this.raceRepo.add(race);

        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
