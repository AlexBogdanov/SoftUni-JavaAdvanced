package p05Telephony.domain;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        String pattern = "[ˆ(\\d|+|\\-)]";

        for (String url : this.urls) {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(url);

            if (m.find()) {
                sb.append("Invalid URL!").append(System.lineSeparator());
                continue;
            }

            sb.append("Browsing: " + url + "!").append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        String pattern = "^[A-Za-z]*, $";

        for (String number : this.numbers) {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(number);

            if (!m.find()) {
                sb.append("Calling... " + number).append(System.lineSeparator());
                continue;
            }

            sb.append("Invalid number!").append(System.lineSeparator());
        }

        return sb.toString();
    }

}
