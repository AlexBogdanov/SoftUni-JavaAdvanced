package p04ValidPerson.domain;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty() || firstName.trim().isBlank()) {
            throw new IllegalArgumentException("Invalid first name: " + firstName);
        }

        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty() || lastName.trim().isBlank()) {
            throw new IllegalArgumentException("Invalid last name: " + lastName);
        }

        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }

        this.age = age;
    }

}
