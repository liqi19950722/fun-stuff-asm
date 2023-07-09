package io.github.lq.fun.stuff.asm.generator.example2;

import org.objectweb.asm.ClassWriter;

import static io.github.lq.fun.stuff.asm.generator.ByteCodeUtil.byteCodeWriteToFile;
import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_INTERFACE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.V17;

public class HelloWorldGenerator {
    public static void main(String[] args) throws Exception {
        byteCodeWriteToFile("example2", "HelloWorld.class", HelloWorldGenerator::dump);
    }

    static byte[] dump() {

        var classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        classWriter.visit(V17, ACC_PUBLIC | ACC_ABSTRACT | ACC_INTERFACE, "example2/HelloWorld",
                null, "java/lang/Object", new String[]{"java/lang/Cloneable"});

        var fieldLess = classWriter.visitField(ACC_PUBLIC | ACC_STATIC | ACC_FINAL, "LESS", "I", null, -1);
        fieldLess.visitEnd();

        var fieldEqual = classWriter.visitField(ACC_PUBLIC | ACC_STATIC | ACC_FINAL, "EQUAL", "I", null, 0);
        fieldEqual.visitEnd();

        var fieldGreater = classWriter.visitField(ACC_PUBLIC | ACC_STATIC | ACC_FINAL, "GREATER", "I", null, 1);
        fieldGreater.visitEnd();

        var methodCompareTo = classWriter.visitMethod(ACC_PUBLIC | ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null);
        methodCompareTo.visitEnd();


        classWriter.visitEnd();

        return classWriter.toByteArray();
    }
}
