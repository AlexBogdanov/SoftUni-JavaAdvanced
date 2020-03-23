package reflection.p02GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Class<?> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();
        
        Arrays.stream(methods)
            .filter(m -> m.getName().startsWith("get"))
            .sorted(Comparator.comparing(Method::getName))
            .forEach(m -> {
                System.out.println(String.format(
                    "%s will return class %s",
                    m.getName(),
                    m.getReturnType().getName()
                ));
            });
        
        Arrays.stream(methods)
            .filter(m -> m.getName().startsWith("set"))
            .sorted(Comparator.comparing(Method::getName))
            .forEach(m -> {
                System.out.println(String.format(
                    "%s and will set field of class %s",
                    m.getName(),
                    m.getParameterTypes()[0].getName()
                ));
            });

    }

}
