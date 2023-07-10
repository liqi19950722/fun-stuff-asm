package io.github.lq.fun.stuff.asm.generator.example8;

public class HelloWorldRun {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("example8.HelloWorld");
        var testMethod = aClass.getDeclaredMethod("test", int.class, int.class);
        testMethod.invoke(aClass.getDeclaredConstructor().newInstance(), 10, 20);
    }
}
