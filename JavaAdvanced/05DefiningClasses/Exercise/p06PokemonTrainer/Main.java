package p06PokemonTrainer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import p06PokemonTrainer.classes.Pokemon;
import p06PokemonTrainer.classes.Trainer;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainers = readPokemons(scanner);
        handleTournament(scanner, trainers);
        List<Trainer> sortedTrainers = sortTrainers(trainers);
        StringBuilder sb = formOutput(sortedTrainers);

        System.out.println(sb);

    }

    private static Map<String, Trainer> readPokemons(Scanner scanner) {
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        for (String input = scanner.nextLine(); !"Tournament".equals(input); input = scanner.nextLine()) {
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (trainers.containsKey(trainerName)) {
                Trainer trainer = trainers.get(trainerName);
                List<Pokemon> pokemons = trainer.getPokemons();
                pokemons.add(pokemon);
                trainer.setPokemons(pokemons);
                trainers.put(trainerName, trainer);
            } else {
                List<Pokemon> pokemons = new ArrayList<>();
                pokemons.add(pokemon);
                
                Trainer trainer = new Trainer(trainerName, pokemons);
                trainers.put(trainerName, trainer);
            }
        }

        return trainers;
    }

    private static void handleTournament(Scanner scanner, Map<String, Trainer> trainers) {
        for (String element = scanner.nextLine(); !"End".equals(element); element = scanner.nextLine()) {
            for (Map.Entry<String, Trainer> pair : trainers.entrySet()) {
                Trainer trainer = pair.getValue();
                boolean hasPokemonWithEl = trainer.hasPokemonWithEl(element);

                if (hasPokemonWithEl) {
                    trainer.increaseBadges();
                } else {
                    trainer.damagePokemons();
                }
            }
        }
    }

    private static List<Trainer> sortTrainers(Map<String, Trainer> trainers) {
        List<Trainer> sortedTrainers = trainers.values().stream()
            .sorted((t1, t2) -> t2.getBadges() - t1.getBadges())
            .collect(Collectors.toList());

        return sortedTrainers;
    }

    private static StringBuilder formOutput(List<Trainer> sortedTrainers) {
        StringBuilder sb = new StringBuilder();

        for (Trainer trainer : sortedTrainers) {
            sb.append(trainer.getInfo());
            sb.append(System.lineSeparator());
        }

        return sb;
    }

}
