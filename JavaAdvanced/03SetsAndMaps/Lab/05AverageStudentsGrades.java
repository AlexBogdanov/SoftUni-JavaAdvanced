import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class AverageStudentsGrades {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Map<String, Deque<Double>> students = readData(scanner);
        StringBuilder sb = new StringBuilder();
        formOutput(sb, students);

        System.out.println(sb);

    }

    private static Map<String, Deque<Double>> readData (Scanner scanner) {
        Map<String, Deque<Double>> students = new TreeMap<>();
        int studentsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < studentsCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String student = tokens[0].trim();
            double grade = Double.parseDouble(tokens[1].trim());

            if (students.containsKey(student)) {
                Deque<Double> grades = students.get(student);
                grades.offer(grade);
                students.put(student, grades);
            } else {
                Deque<Double> grades = new ArrayDeque<>();
                grades.offer(grade);
                students.put(student, grades);
            }
        }

        return students;
    }

    private static void formOutput (StringBuilder sb, Map<String, Deque<Double>> students) {
        for (String student : students.keySet()) {
            Deque<Double> grades = students.get(student);
            sb.append(student + " ->");
            double averageGrade = calculateGrade(sb, grades);
            sb.append(String.format(" (avg: %.2f)", averageGrade));
            sb.append(System.lineSeparator());
        }
    }

    private static double calculateGrade (StringBuilder sb, Deque<Double> grades) {
        double gradesVal = 0.0;
        int gradesCount = grades.size();

        while (grades.size() > 0) {
            double grade = grades.poll();
            gradesVal += grade;

            sb.append(String.format(" %.2f", grade));
        }

        double averageGrade = gradesVal / gradesCount;
        return averageGrade;
    }

}
