package p02CompanyRoster;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import p02CompanyRoster.classes.Department;
import p02CompanyRoster.classes.Employee;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Department> departments = handleInput(scanner);
        StringBuilder sb = formOutput(departments);

        System.out.println(sb);

    }

    private static Map<String, Department> handleInput(Scanner scanner) {
        Map<String, Department> departments = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Employee employee;
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String departmentName = tokens[3];

            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);

                employee = new Employee(name, salary, position, departmentName, email, age);
            } else if (tokens.length == 5) {
                if (tokens[4].matches("\\d+")) {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, departmentName, age);
                } else {
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, departmentName, email);
                }
            } else {
                employee = new Employee(name, salary, position, departmentName);
            }

            if (departments.containsKey(departmentName)) {
                Department department = departments.get(departmentName);
                department.addEmployee(employee);
                departments.put(departmentName, department);
            } else {
                Department department = new Department(departmentName);
                department.addEmployee(employee);
                departments.put(departmentName, department);
            }
        }

        return departments;
    }

    private static StringBuilder formOutput(Map<String, Department> departments) {
        StringBuilder sb = new StringBuilder();

        Department department = departments.values().stream()
            .max((d1, d2) -> Double.compare(d1.calculateAvgSalary(), d2.calculateAvgSalary()))
            .orElseThrow(NoSuchElementException::new);

        sb.append("Highest Average Salary: " + department.name);

        department.employees.stream()
            .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
            .forEach(e -> {
                sb.append(String.format(
                    "%n%s %.2f %s %d"
                , e.name, e.salary, e.email, e.age
                ));
            });

        return sb;
    }

}
