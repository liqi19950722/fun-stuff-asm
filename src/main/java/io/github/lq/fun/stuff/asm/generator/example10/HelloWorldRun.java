package io.github.lq.fun.stuff.asm.generator.example10;

public class HelloWorldRun {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("example10.HelloWorld");
        var testMethod = aClass.getDeclaredMethod("test", int.class);
        for (int i = 1; i <= 5; i++) {
            testMethod.invoke(aClass.getDeclaredConstructor().newInstance(), i);
        }
    }
}
