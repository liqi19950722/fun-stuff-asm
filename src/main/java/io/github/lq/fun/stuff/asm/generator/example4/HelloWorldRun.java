package io.github.lq.fun.stuff.asm.generator.example4;

import java.lang.reflect.Field;
import java.util.Arrays;

public class HelloWorldRun {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("example4.HelloWorld");

        System.out.println("Fields: ");
        Arrays.stream(aClass.getDeclaredFields())
                .forEach(field -> System.out.printf("\t%s: %s\n", field.getName(), getValue(field)));

    }

    private static Object getValue(Field field) {
        try {
            return field.get(null);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
