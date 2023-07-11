package io.github.lq.fun.stuff.asm.generator.example12;

public class HelloWorldRun {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("example12.HelloWorld");
        var testMethod = aClass.getDeclaredMethod("test");
        testMethod.invoke(aClass.getDeclaredConstructor().newInstance());
    }
}
