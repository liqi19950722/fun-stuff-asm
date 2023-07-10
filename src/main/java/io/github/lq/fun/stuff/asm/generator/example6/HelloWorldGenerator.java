package io.github.lq.fun.stuff.asm.generator.example6;

import org.objectweb.asm.ClassWriter;

import static io.github.lq.fun.stuff.asm.generator.ByteCodeUtil.byteCodeWriteToFile;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V17;

public class HelloWorldGenerator {
    public static void main(String[] args) throws Exception {
        byteCodeWriteToFile("example6", "HelloWorld.class", HelloWorldGenerator::dump);
    }

    private static byte[] dump() {

        var classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        classWriter.visit(V17, ACC_PUBLIC | ACC_SUPER, "example6/HelloWorld", null,
                "java/lang/Object", null);

        var constructor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        constructor.visitCode();
        constructor.visitVarInsn(ALOAD, 0);
        constructor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitInsn(RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();

        var staticMethod = classWriter.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
        staticMethod.visitCode();
        staticMethod.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        staticMethod.visitLdcInsn("class initialization method");
        staticMethod.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println",
                "(Ljava/lang/String;)V", false);
        staticMethod.visitInsn(RETURN);
        staticMethod.visitMaxs(2,0);
        staticMethod.visitEnd();

        classWriter.visitEnd();

        return classWriter.toByteArray();
    }
}
