package io.github.lq.fun.stuff.asm.generator.example8;

import org.objectweb.asm.ClassWriter;

import static io.github.lq.fun.stuff.asm.ByteCodeUtil.byteCodeWriteToFile;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.ISTORE;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V17;

public class HelloWorldGenerator {
    public static void main(String[] args) throws Exception {
        byteCodeWriteToFile("example8", "HelloWorld.class", HelloWorldGenerator::dump);
    }

    private static byte[] dump() {

        var classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        classWriter.visit(V17, ACC_PUBLIC | ACC_SUPER, "example8/HelloWorld", null,
                "java/lang/Object", null);

        var constructor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        constructor.visitCode();
        constructor.visitVarInsn(ALOAD, 0);
        constructor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitInsn(RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();

        var testMethod = classWriter.visitMethod(ACC_PUBLIC, "test", "(II)V", null, null);
        testMethod.visitCode();
        testMethod.visitVarInsn(ILOAD, 1);
        testMethod.visitVarInsn(ILOAD, 2);
        testMethod.visitMethodInsn(INVOKESTATIC, "java/lang/Math", "max",
                "(II)I", false);
        testMethod.visitVarInsn(ISTORE, 3);
        testMethod.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        testMethod.visitVarInsn(ILOAD, 3);
        testMethod.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
        testMethod.visitInsn(RETURN);
        testMethod.visitMaxs(2, 4);
        testMethod.visitEnd();

        classWriter.visitEnd();

        return classWriter.toByteArray();
    }
}
