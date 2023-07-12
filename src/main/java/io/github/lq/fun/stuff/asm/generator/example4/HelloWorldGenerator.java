package io.github.lq.fun.stuff.asm.generator.example4;

import org.objectweb.asm.ClassWriter;

import static io.github.lq.fun.stuff.asm.ByteCodeUtil.byteCodeWriteToFile;
import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_INTERFACE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.V17;

public class HelloWorldGenerator {
    public static void main(String[] args) throws Exception {
        byteCodeWriteToFile("example4", "HelloWorld.class", HelloWorldGenerator::dump);
    }

    static byte[] dump() {
        var classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        classWriter.visit(V17, ACC_PUBLIC | ACC_ABSTRACT | ACC_INTERFACE, "example4/HelloWorld", null,
                "java/lang/Object", null);

        var fieldIntValue = classWriter.visitField(ACC_PUBLIC | ACC_STATIC | ACC_FINAL, "intValue", "I", null, 123);
        fieldIntValue.visitEnd();

        var fieldStrValue = classWriter.visitField(ACC_PUBLIC | ACC_STATIC | ACC_FINAL, "strValue", "Ljava/lang/String;", null, "abc");
        fieldStrValue.visitEnd();

        classWriter.visitEnd();

        return classWriter.toByteArray();
    }
}
