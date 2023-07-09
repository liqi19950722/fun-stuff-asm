package io.github.lq.fun.stuff.asm.generator.example2;

import java.util.Arrays;

public class HelloWorldRun {
    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("example2.HelloWorld");

        System.out.println("Fields: ");
        Arrays.stream(klass.getDeclaredFields()).forEach(field -> System.out.println("\t" + field.getName()));

        System.out.println("Methods: ");
        Arrays.stream(klass.getDeclaredMethods()).forEach(method -> System.out.println("\t" + method.getName()));

    }
}
