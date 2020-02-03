package p02CompanyRoster.classes;

import java.util.ArrayList;
import java.util.List;

public class Department {

    public String name;
    public List<Employee> employees = new ArrayList<>();
    double avgSalary;

    public Department(String name) {
        this.name = name;
    }

    public Department() { }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public double calculateAvgSalary() {
        double sum = 0.0;

        for (Employee employee : this.employees) {
            sum += employee.salary;
        }

        this.avgSalary = sum / this.employees.size();
        return this.avgSalary;
    }

}
