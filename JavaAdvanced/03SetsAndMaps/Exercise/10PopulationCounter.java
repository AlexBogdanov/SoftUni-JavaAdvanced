import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class PopulationCounter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Long>> countriesCities = readInput(scanner);
        StringBuilder sb = formOutput(countriesCities);

        System.out.println(sb);

    }

    private static Map<String, Map<String, Long>> readInput(Scanner scanner) {
        Map<String, Map<String, Long>> countriesCities = new LinkedHashMap<>();

        for (String input = scanner.nextLine(); !"report".equals(input); input = scanner.nextLine()) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            if (countriesCities.containsKey(country)) {
                Map<String, Long> cities = countriesCities.get(country);

                if (cities.containsKey(city)) {
                    long oldVal = cities.get(city);
                    cities.put(city, oldVal + population);
                } else {
                    cities.put(city, population);
                }

                countriesCities.put(country, cities);
            } else {
                Map<String, Long> cities = new LinkedHashMap<>();
                cities.put(city, population);
                countriesCities.put(country, cities);
            }
        }

        return countriesCities;
    }

    private static StringBuilder formOutput(Map<String, Map<String, Long>> countriesCities) {
        StringBuilder sb = new StringBuilder();
        
        countriesCities.entrySet().stream()
            .sorted(Comparator.comparing(a -> a.getValue().values().stream()
                .mapToLong(Long::valueOf)
                .sum(),
                Comparator.reverseOrder()))
            .forEach(pair -> {
                long totalPopulation = pair.getValue().values().stream()
                    .mapToLong(Long::valueOf)
                    .sum();
                sb.append(String.format("%s (total population: %d)\n", pair.getKey(), totalPopulation));

                pair.getValue().entrySet().stream()
                    .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                    .forEach(nestedPair -> {
                        sb.append(String.format("=>%s: %d\n", nestedPair.getKey(), nestedPair.getValue()));
                    });
            });

        return sb;
    }

}
