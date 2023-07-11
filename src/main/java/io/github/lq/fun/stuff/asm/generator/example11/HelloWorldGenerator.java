package io.github.lq.fun.stuff.asm.generator.example11;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;

import static io.github.lq.fun.stuff.asm.generator.ByteCodeUtil.byteCodeWriteToFile;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.BIPUSH;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.IF_ICMPGE;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.ISTORE;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V17;

public class HelloWorldGenerator {
    public static void main(String[] args) throws Exception {
        byteCodeWriteToFile("example11", "HelloWorld.class", HelloWorldGenerator::dump);
    }

    static byte[] dump() {
        var classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        classWriter.visit(V17, ACC_PUBLIC | ACC_SUPER, "example11/HelloWorld", null,
                "java/lang/Object", null);

        var constructor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        constructor.visitCode();
        constructor.visitVarInsn(ALOAD, 0);
        constructor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitInsn(RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();


        var testMethod = classWriter.visitMethod(ACC_PUBLIC, "test", "()V", null, null);

        Label conditionalLabel = new Label();
        Label returnLabel = new Label();

        testMethod.visitCode();
        testMethod.visitInsn(ICONST_0);
        testMethod.visitVarInsn(ISTORE, 1);

        testMethod.visitLabel(conditionalLabel);
        testMethod.visitVarInsn(ILOAD, 1);
        testMethod.visitIntInsn(BIPUSH, 10);
        testMethod.visitJumpInsn(IF_ICMPGE, returnLabel);
        testMethod.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        testMethod.visitVarInsn(ILOAD, 1);
        testMethod.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
        testMethod.visitIincInsn(1, 1);
        testMethod.visitJumpInsn(GOTO, conditionalLabel);


        testMethod.visitLabel(returnLabel);
        testMethod.visitInsn(RETURN);
        testMethod.visitMaxs(0, 0);
        classWriter.visitEnd();
        return classWriter.toByteArray();
    }
}
