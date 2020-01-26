import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

class VoinaNumberGame {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        Set<Integer> firstPlayerDeck = new LinkedHashSet<>();
        Set<Integer> secondPlayerDeck = new LinkedHashSet<>();
        readCards(scanner, firstPlayerDeck, secondPlayerDeck);

        String winner = playGame(firstPlayerDeck, secondPlayerDeck);
        System.out.println(winner);

    }

    private static void readCards (Scanner scanner, Set<Integer> firstPlayerDeck, Set<Integer> secondPlayerDeck) {
        for (int i = 1; i <= 20; i++) {
            firstPlayerDeck.add(scanner.nextInt());
        }

        for (int i = 21; i <= 40; i++) {
            secondPlayerDeck.add(scanner.nextInt());
        }
    }

    private static String playGame (Set<Integer> firstPlayerDeck, Set<Integer> secondPlayerDeck) {
        String winner = "";

        for (int round = 1; round <= 50; round++) {
            if (round == 50) {
                if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
                    winner = "First player win!";
                } else if (firstPlayerDeck.size() < secondPlayerDeck.size()) {
                    winner = "Second player win!";
                } else {
                    winner = "Draw!";
                }

                break;
            }

            int firstPlayerCard = firstPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstPlayerCard);
            int secondPlayerCard = secondPlayerDeck.iterator().next();
            secondPlayerDeck.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            } else if (firstPlayerCard < secondPlayerCard) {
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            } else {
                firstPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }

            if (firstPlayerDeck.size() == 0) {
                winner = "Second player win!";
                break;
            }

            if (secondPlayerDeck.size() == 0) {
                winner = "First player win!";
                break;
            }
        }

        return winner;
    }

}
