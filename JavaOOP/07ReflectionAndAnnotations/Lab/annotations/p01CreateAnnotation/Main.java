package annotations.p01CreateAnnotation;

import java.lang.annotation.Annotation;

public class Main {

    public static void main(String[] args) {

        Class<?> clazz = TestClass.class;
        Annotation[] annotations = clazz.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

    }

}
