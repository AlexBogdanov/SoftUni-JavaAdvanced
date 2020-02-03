package p07Google.classes;

public class WorkInfo {

    public String companyName;
    public String departmentName;
    public double salary;

    public WorkInfo(String companyName, String departmentName, double salary) {
        this.companyName = companyName;
        this.departmentName = departmentName;
        this.salary = salary;
    }

    public WorkInfo() {
        this.companyName = "n/a";
        this.departmentName = "n/a";
        this.salary = -1;
    }

}
