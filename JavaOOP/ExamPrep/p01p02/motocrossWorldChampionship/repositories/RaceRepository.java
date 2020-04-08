package motocrossWorldChampionship.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.repositories.interfaces.Repository;

public class RaceRepository implements Repository<Race> {

    private Collection<Race> repo;

    public RaceRepository() {
        this.repo = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        return this.repo.stream()
            .filter(r -> r.getName().equals(name))
            .limit(1)
            .findFirst()
            .orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.repo);
    }

    @Override
    public void add(Race model) {
        this.repo.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.repo.removeIf(r -> r.getName().equals(model.getName()));
    }

}
