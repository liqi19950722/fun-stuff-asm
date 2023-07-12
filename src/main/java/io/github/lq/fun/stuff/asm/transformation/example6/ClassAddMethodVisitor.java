package io.github.lq.fun.stuff.asm.transformation.example6;

import org.objectweb.asm.ClassVisitor;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.IMUL;
import static org.objectweb.asm.Opcodes.IRETURN;

public class ClassAddMethodVisitor extends ClassVisitor {


    protected ClassAddMethodVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public void visitEnd() {
        var methodVisitor = super.visitMethod(ACC_PUBLIC, "mul", "(II)I", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(ILOAD, 1);
        methodVisitor.visitVarInsn(ILOAD, 2);
        methodVisitor.visitInsn(IMUL);
        methodVisitor.visitInsn(IRETURN);
        methodVisitor.visitMaxs(0, 0);
        methodVisitor.visitEnd();

        super.visitEnd();
    }
}
