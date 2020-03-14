package p06Animals.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    public static boolean isValidType(String type) {
        if (type.equals("Dog") || type.equals("Frog") || type.equals("Cat") ||
            type.equals("Kitten") || type.equals("Tomcat")) {
            return true;
        }

        return false;
    }

    public static boolean areArgsValid(String type, String[] args) {
        if (args.length == 3) {
            if (isValidName(args[0]) && isValidAge(args[1]) && isValidGender(args[2])) {
                return true;
            }

            return false;
        }

        if (args.length == 2) {
            if (type.equals("Kitten") || type.equals("Tomcat")) {
                if (isValidName(args[0]) && isValidAge(args[1])) {
                    return true;
                }

                return false;
            }

            return false;
        }

        return false;
    }

    private static boolean isValidName(String name) {
        String pattern = "";
        Pattern p = Pattern.compile(pattern);
        Matcher m =p.matcher(name);
        
        return m.find();
    }

    private static boolean isValidAge(String age) {
        String pattern = "";
        Pattern p = Pattern.compile(pattern);
        Matcher m =p.matcher(age);

        if (m.find() && Integer.parseInt(age) > 0) {
            return true;
        }

        return false;
    }

    private static boolean isValidGender(String gender) {
        if (gender.equals("Male") || gender.equals("Female")) {
            return true;
        }

        return false;
    }

}
