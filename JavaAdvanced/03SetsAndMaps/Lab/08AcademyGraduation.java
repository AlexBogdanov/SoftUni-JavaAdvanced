import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

class AcademyGraduation {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Map<String, double[]> students = createMap(scanner);

        StringBuilder sb = new StringBuilder();
        formOutput(sb, students);

        System.out.println(sb);

    }

    private static Map<String, double[]> createMap (Scanner scanner) {
        Map<String, double[]> students = new TreeMap<>();
        int numOfStudents = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 1; i <= numOfStudents * 2; i += 2) {
            String student = scanner.nextLine().trim();
            double[] grades = Stream.of(scanner.nextLine().split("\\s+"))
                .map(el -> el.trim())
                .mapToDouble(n -> Double.parseDouble(n))
                .toArray();
            
            students.put(student, grades);
        }

        return students;
    }

    private static void formOutput (StringBuilder sb, Map<String, double[]> students) {
        for (String student : students.keySet()) {
            double avgGrade = calculateAvg(students.get(student));
            sb.append(String.format("%s is graduated with %s", student, avgGrade));
            sb.append(System.lineSeparator());
        }
    }

    private static double calculateAvg (double[] grades) {
        double gradesSum = 0;

        for (int i = 0; i < grades.length; i++) {
            gradesSum += grades[i];
        }

        return gradesSum / grades.length;
    }

}
