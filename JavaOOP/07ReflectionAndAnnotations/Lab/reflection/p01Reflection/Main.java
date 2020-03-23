package reflection.p01Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws 
            InstantiationException,
            IllegalAccessException,
            IllegalArgumentException,
            InvocationTargetException,
            NoSuchMethodException,
            SecurityException {
        
        Class<?> reflection = Reflection.class;

        System.out.println("class " + reflection.getSimpleName());
        System.out.println(reflection.getSuperclass());

        Class<?>[] interfaces = reflection.getInterfaces();

        for (Class<?> interfacee : interfaces) {
            System.out.println(interfacee);
        }

        Object reflectionObj = reflection.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObj);

    }

}
