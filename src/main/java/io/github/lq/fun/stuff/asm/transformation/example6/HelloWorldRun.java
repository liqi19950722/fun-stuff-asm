package io.github.lq.fun.stuff.asm.transformation.example6;

import java.util.Arrays;

public class HelloWorldRun {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("io.github.lq.fun.stuff.asm.transformation.example6.HelloWorld");

        Arrays.stream(aClass.getDeclaredMethods()).forEach(method -> System.out.println(method.getName()));

        var mulMethod = aClass.getDeclaredMethod("mul", int.class, int.class);
        System.out.println(mulMethod.invoke(aClass.getDeclaredConstructor().newInstance(), 2, 2));
    }
}
