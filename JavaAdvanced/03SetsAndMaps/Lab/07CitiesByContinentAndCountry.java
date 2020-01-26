import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class CitiesByContinentAndCountry {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, ArrayList<String>>> continents = createMap(scanner);

        StringBuilder sb = new StringBuilder();
        formOutput(sb, continents);

        System.out.println(sb);

    }

    private static Map<String, Map<String, ArrayList<String>>> createMap (Scanner scanner) {
        Map<String, Map<String, ArrayList<String>>> continents = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0].trim();
            String country = tokens[1].trim();
            String city = tokens[2].trim();

            if (continents.containsKey(continent)) {
                Map<String, ArrayList<String>> countries = continents.get(continent);

                if (countries.containsKey(country)) {
                    ArrayList<String> cities = countries.get(country);
                    cities.add(city);
                    countries.put(country, cities);
                } else {
                    ArrayList<String> cities = new ArrayList<>();
                    cities.add(city);
                    countries.put(country, cities);
                }
                
                continents.put(continent, countries);
            } else {
                ArrayList<String> cities = new ArrayList<>();
                cities.add(city);
                Map<String, ArrayList<String>> countries = new LinkedHashMap<>();
                countries.put(country, cities);
                continents.put(continent, countries);
            }
        }

        return continents;
    }

    private static void formOutput (StringBuilder sb, Map<String, Map<String, ArrayList<String>>> continents) {
        for (String continent : continents.keySet()) {
            sb.append(continent + ":\n");
            Map<String, ArrayList<String>> countries = continents.get(continent);

            for (String country : countries.keySet()) {
                sb.append("\t" + country + " -> ");
                ArrayList<String> cities = countries.get(country);

                for (String city : cities) {
                    sb.append(city + ", ");
                }

                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                sb.append(System.lineSeparator());
            }
        }
    }

}
