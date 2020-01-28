import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class HandsOfCards {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> players = readInput(scanner);
        Map<String, Integer> scores = calculateScores(players);
        StringBuilder sb = formOutput(scores);

        System.out.println(sb);

    }

    private static Map<String, Set<String>> readInput(Scanner scanner) {
        Map<String, Set<String>> players = new LinkedHashMap<>();

        for (String input = scanner.nextLine(); !"JOKER".equals(input); input = scanner.nextLine()) {
            String[] tokens = input.split(":\\s+");
            String name = tokens[0];
            String[] cards = tokens[1].split(",\\s+");
            Set<String> deck = new HashSet<>();
            
            if (players.containsKey(name)) {
                deck = players.get(name);
            }

            for (String card : cards) {
                deck.add(card);
            }

            players.put(name, deck);
        }

        return players;
    }

    private static Map<String, Integer> calculateScores(Map<String, Set<String>> players) {
        Map<String, Integer> scores = new LinkedHashMap<>();

        for (Map.Entry<String, Set<String>> pair : players.entrySet()) {
            int score = 0;

            for (String card : pair.getValue()) {
                int power;
                switch (card.charAt(0)) {
                    case '1':
                        power = 10;
                        break;
                    case 'J':
                        power = 11;
                        break;
                    case 'Q':
                        power = 12;
                        break;
                    case 'K':
                        power = 13;
                        break;
                    case 'A':
                        power = 14;
                        break;
                    default:
                        power = card.charAt(0) - '0';
                }

                int suit;
                switch (card.charAt(card.length() - 1)) {
                    case 'S':
                        suit = 4;
                        break;
                    case 'H':
                        suit = 3;
                        break;
                    case 'D':
                        suit = 2;
                        break;
                    default:
                        suit = 1;
                }

                score += power * suit;
            }

            scores.put(pair.getKey(), score);
        }

        return scores;
    }

    private static StringBuilder formOutput(Map<String, Integer> scores) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> pair : scores.entrySet()) {
            sb.append(String.format("%s: %d\n", pair.getKey(), pair.getValue()));
        }

        return sb;
    }

}
