package p05CustomException.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import p05CustomException.exceptions.InvalidPersonNameException;

public class Student extends Person {

    private static String validateFirstName(String name) {
        String pattern = "^[A-Za-z]+$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(name);

        if (!m.find()) {
            throw new InvalidPersonNameException("Invalid name");
        }

        return name;
    }

    private String email;

    public Student(String firstName, String lastName, int age, String email) {
        super(validateFirstName(firstName), lastName, age);
        this.setEmail(email);
    }

    public String getEmail() {
        return this.email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

}
