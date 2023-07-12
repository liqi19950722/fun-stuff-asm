package io.github.lq.fun.stuff.asm.generator.example1;

import org.objectweb.asm.ClassWriter;

import static io.github.lq.fun.stuff.asm.ByteCodeUtil.byteCodeWriteToFile;
import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_INTERFACE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.V17;


public class HelloWorldGenerator {
    public static void main(String[] args) throws Exception {
        byteCodeWriteToFile("example1", "HelloWorld.class", HelloWorldGenerator::dump);
    }


    static byte[] dump() {
        var classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        classWriter.visit(V17, ACC_PUBLIC | ACC_INTERFACE | ACC_ABSTRACT,
                "example1/HelloWorld", null, "java/lang/Object", null);
        classWriter.visitEnd();

        return classWriter.toByteArray();
    }
}
