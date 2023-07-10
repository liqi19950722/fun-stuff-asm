package io.github.lq.fun.stuff.asm.print;

public class HelloWorld {
    public void test() {
        System.out.println("Test Method");
    }

    public void branch(boolean flag) {
        if (flag) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}
