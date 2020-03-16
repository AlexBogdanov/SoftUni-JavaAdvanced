package p02AnimalFarm;

public class Chicken {

    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private double calculateProductPerDay() {
        double res = 0;
        
        for (int year = 0; year <= this.age; year++) {
            if (year < 6) {
                res += 2;
            } else if (year >= 6 && year < 12) {
                res += 1;
            } else if (year >= 12) {
                res += 0.75;
            }
        }

        return res / this.age;
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    private void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    private void setAge(int age) {
        if (age > 15 || age < 1) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }

        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(
            "Chicken %s (age %d) can produce %.2f eggs per day.",
            this.name,
            this.age,
            this.productPerDay()
        );
    }

}
