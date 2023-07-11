package io.github.lq.fun.stuff.asm.generator.example9;


public class HelloWorldRun {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("example9.HelloWorld");
        var testMethod = aClass.getDeclaredMethod("test", int.class);
        testMethod.invoke(aClass.getDeclaredConstructor().newInstance(), 0);
        testMethod.invoke(aClass.getDeclaredConstructor().newInstance(), 1);
    }
}
