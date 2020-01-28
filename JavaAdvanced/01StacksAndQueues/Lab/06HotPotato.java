import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s+");
        int n = scanner.nextInt();
        ArrayDeque<String> participants = new ArrayDeque<>();
        Collections.addAll(participants, kids);
        int i = 1;

        while (participants.size() > 1) {
            String currParticipant = participants.poll();

            if (i % n == 0) {
                System.out.println("Removed " + currParticipant);
            } else {
                participants.offer(currParticipant);
            }

            i++;
        }

        System.out.println("Last is " + participants.poll());

    }

}
