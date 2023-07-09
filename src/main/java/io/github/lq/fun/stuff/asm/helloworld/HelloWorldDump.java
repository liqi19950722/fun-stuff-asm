package io.github.lq.fun.stuff.asm.helloworld;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.RETURN;

public class HelloWorldDump {

    public static byte[] dump() {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V17, ACC_PUBLIC | ACC_SUPER, "sample/HelloWorld", null,
                "java/lang/Object", null);

        var constructor = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);

        constructor.visitCode();
        constructor.visitVarInsn(ALOAD, 0);
        constructor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitInsn(RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();

        var toStringMethod = cw.visitMethod(ACC_PUBLIC, "toString", "()Ljava/lang/String;", null, null);
        toStringMethod.visitCode();

        toStringMethod.visitLdcInsn("This is a HelloWorld Object.");
        toStringMethod.visitInsn(ARETURN);
        toStringMethod.visitMaxs(1, 1);
        toStringMethod.visitEnd();


        cw.visitEnd();
        return cw.toByteArray();
    }
}
