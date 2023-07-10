package io.github.lq.fun.stuff.asm.generator.example5;

import io.github.lq.fun.stuff.annotation.MyTag;

import java.util.Arrays;

public class HelloWorldRun {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("example5.HelloWorld");

        System.out.println("AnnotationValue: ");
        Arrays.stream(aClass.getDeclaredFields()).forEach(field -> {
            var myTag = field.getAnnotation(MyTag.class);
            System.out.printf("\tname: %s, age: %d", myTag.name(), myTag.age());
        });
    }
}
