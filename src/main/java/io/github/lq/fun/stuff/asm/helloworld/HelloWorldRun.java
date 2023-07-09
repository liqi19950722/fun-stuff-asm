package io.github.lq.fun.stuff.asm.helloworld;

public class HelloWorldRun {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new MyClassLoader();
        Class<?> helloWorld = classLoader.loadClass("sample.HelloWorld");
        Object object = helloWorld.getDeclaredConstructor().newInstance();
        System.out.println(object);
    }

    static class MyClassLoader extends ClassLoader {
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            if (name.equals("sample.HelloWorld")) {
                return defineClass(name, HelloWorldDump.dump(), 0, HelloWorldDump.dump().length);
            }
            return super.findClass(name);
        }
    }
}
