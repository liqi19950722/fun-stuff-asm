package io.github.lq.fun.stuff.asm.transformation.example2;

import java.util.Arrays;

public class HelloWorldRun {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("io.github.lq.fun.stuff.asm.transformation.example2.HelloWorld");

        Arrays.stream(aClass.getAnnotatedInterfaces()).forEach(annotatedType -> System.out.println(annotatedType.getType()));
    }
}
