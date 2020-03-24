package p02BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws
        NoSuchMethodException,
        SecurityException,
        InstantiationException,
        IllegalAccessException,
        IllegalArgumentException,
        InvocationTargetException {

        Object obj = createReflectionObj();

        Scanner scanner = new Scanner(System.in);

        try {
            handleInput(scanner, obj);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private static void handleInput(Scanner scanner, Object obj) throws
        NoSuchMethodException,
        SecurityException,
        IllegalAccessException,
        IllegalArgumentException,
        InvocationTargetException,
        NoSuchFieldException {
        for (String input = scanner.nextLine(); !input.equals("END"); input = scanner.nextLine()) {
            String[] tokens = input.split("\\_+");
            String command = tokens[0];
            int val = Integer.parseInt(tokens[1]);

            switch(command) {
                case "add":
                    handleMethod("add", val, obj);
                    break;
                case "subtract":
                    handleMethod("subtract", val, obj);
                    break;
                case "multiply":
                    handleMethod("multiply", val, obj);
                    break;
                case "divide":
                    handleMethod("divide", val, obj);
                    break;
                case "leftShift":
                    handleMethod("leftShift", val, obj);
                    break;
                case "rightShift":
                    handleMethod("rightShift", val, obj);
                    break;
            }
        }
    }

    private static void handleMethod(String methodName, int val, Object obj) throws NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        Method method = obj.getClass().getDeclaredMethod(methodName, int.class);
        method.setAccessible(true);
        method.invoke(obj, val);

        Field field = obj.getClass().getDeclaredField("innerValue");
        field.setAccessible(true);
        System.out.println(field.getInt(obj));
    }

    private static Object createReflectionObj()
            throws InstantiationException,
            IllegalAccessException,
            IllegalArgumentException,
            InvocationTargetException,
            NoSuchMethodException,
            SecurityException {
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> ctor = clazz.getDeclaredConstructor(int.class);
        ctor.setAccessible(true);
        return ctor.newInstance(0);
    }

}
