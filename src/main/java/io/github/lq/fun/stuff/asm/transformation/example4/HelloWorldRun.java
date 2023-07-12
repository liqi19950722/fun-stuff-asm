package io.github.lq.fun.stuff.asm.transformation.example4;

import java.util.Arrays;

public class HelloWorldRun {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("io.github.lq.fun.stuff.asm.transformation.example4.HelloWorld");

        Arrays.stream(aClass.getDeclaredFields()).forEach(field -> System.out.println(field.getName()));
    }
}
