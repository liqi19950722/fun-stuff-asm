package io.github.lq.fun.stuff.asm.generator.example7;

public class HelloWorldRun {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("example7.HelloWorld");
        var testMethod = aClass.getDeclaredMethod("test");
        testMethod.invoke(aClass.getDeclaredConstructor().newInstance());
    }
}
