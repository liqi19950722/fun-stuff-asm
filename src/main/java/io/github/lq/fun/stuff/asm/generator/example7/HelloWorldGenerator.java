package io.github.lq.fun.stuff.asm.generator.example7;

import org.objectweb.asm.ClassWriter;

import static io.github.lq.fun.stuff.asm.generator.ByteCodeUtil.byteCodeWriteToFile;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.BIPUSH;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V17;

public class HelloWorldGenerator {
    public static void main(String[] args) throws Exception {
        byteCodeWriteToFile("example7", "HelloWorld.class", HelloWorldGenerator::dump);
    }

    private static byte[] dump() {

        var classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        classWriter.visit(V17, ACC_PUBLIC | ACC_SUPER, "example7/HelloWorld", null,
                "java/lang/Object", null);

        var constructor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        constructor.visitCode();
        constructor.visitVarInsn(ALOAD, 0);
        constructor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitInsn(RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();

        var testMethod = classWriter.visitMethod(ACC_PUBLIC, "test", "()V", null, null);
        testMethod.visitCode();
        testMethod.visitTypeInsn(NEW, "io/github/lq/fun/stuff/test/GoodChild");
        testMethod.visitInsn(DUP);
        testMethod.visitLdcInsn("Lucy");
        testMethod.visitIntInsn(BIPUSH, 8);
        testMethod.visitMethodInsn(INVOKESPECIAL, "io/github/lq/fun/stuff/test/GoodChild", "<init>",
                "(Ljava/lang/String;I)V", false);
        testMethod.visitVarInsn(ASTORE, 1);
        testMethod.visitInsn(RETURN);
        testMethod.visitMaxs(4, 2);
        testMethod.visitEnd();

        classWriter.visitEnd();

        return classWriter.toByteArray();
    }
}
