package annotations.p02CodingTracker;

import java.util.Arrays;

public class Tracker {

    @Author(name = "Alex")
    public static void printMethodsByAuthor(Class<?> clazz) {
        Arrays.stream(clazz.getDeclaredMethods())
            .forEach(m -> {
                Author annotation = Arrays.stream(m.getAnnotations())
                    .filter(a -> a.annotationType().getName().equals(Author.class.getName()))
                    .map(a -> (Author) a)
                    .findFirst()
                    .orElse(null);

                if (annotation != null) {
                    System.out.println(annotation.name() + ": " + m.getName() + "()");
                }
            });
    }

}
