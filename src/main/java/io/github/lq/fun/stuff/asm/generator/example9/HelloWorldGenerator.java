package io.github.lq.fun.stuff.asm.generator.example9;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;

import static io.github.lq.fun.stuff.asm.ByteCodeUtil.byteCodeWriteToFile;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V17;

public class HelloWorldGenerator {
    public static void main(String[] args) throws Exception {
        byteCodeWriteToFile("example9", "HelloWorld.class", HelloWorldGenerator::dump);
    }

    static byte[] dump() {
        var classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        classWriter.visit(V17, ACC_PUBLIC | ACC_SUPER, "example9/HelloWorld", null,
                "java/lang/Object", null);

        var constructor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        constructor.visitCode();
        constructor.visitVarInsn(ALOAD, 0);
        constructor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitInsn(RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();


        var testMethod = classWriter.visitMethod(ACC_PUBLIC, "test", "(I)V", null, null);
        Label elseLabel = new Label();
        Label returnLabel = new Label();
        testMethod.visitCode();
        testMethod.visitVarInsn(ILOAD, 1);
        testMethod.visitJumpInsn(IFNE, elseLabel);

        testMethod.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        testMethod.visitLdcInsn("value is 0");
        testMethod.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println",
                "(Ljava/lang/String;)V", false);
        testMethod.visitJumpInsn(GOTO, returnLabel);

        testMethod.visitLabel(elseLabel);
        testMethod.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        testMethod.visitLdcInsn("value is not 0");
        testMethod.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println",
                "(Ljava/lang/String;)V", false);

        testMethod.visitLabel(returnLabel);
        testMethod.visitInsn(RETURN);
        testMethod.visitMaxs(0, 0);
        classWriter.visitEnd();
        return classWriter.toByteArray();
    }
}
