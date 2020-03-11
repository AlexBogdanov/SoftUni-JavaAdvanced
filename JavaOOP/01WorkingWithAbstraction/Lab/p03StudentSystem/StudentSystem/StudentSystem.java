package p03StudentSystem.StudentSystem;

import java.util.HashMap;
import java.util.Map;

import p03StudentSystem.Student.Student;

public class StudentSystem {

    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public void ParseCommand(String[]args) {
        switch (args[0]) {
            case "Create":
                create(args);
                break;
            default:
                show(args);
        }
    }

    private void show(String[] args) {
        var name = args[1];

        if (repo.containsKey(name)) {
            var student = repo.get(name);
            System.out.println(student.toString());
        }
    }

    private void create(String[] args) {
        var name = args[1];
        var age = Integer.parseInt(args[2]);
        var grade =Double.parseDouble(args[3]);

        if (!repo.containsKey(name)) {
            var student = new Student(name, age, grade);
            repo.put(name,student);
        }
    }

}
