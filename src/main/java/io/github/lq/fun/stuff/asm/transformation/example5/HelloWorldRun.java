package io.github.lq.fun.stuff.asm.transformation.example5;

import java.util.Arrays;

public class HelloWorldRun {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("io.github.lq.fun.stuff.asm.transformation.example5.HelloWorld");

        Arrays.stream(aClass.getDeclaredMethods()).forEach(method -> System.out.println(method.getName()));
    }
}
