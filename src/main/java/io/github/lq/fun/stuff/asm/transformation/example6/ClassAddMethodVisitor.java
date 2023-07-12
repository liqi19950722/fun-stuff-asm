package io.github.lq.fun.stuff.asm.transformation.example6;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.IMUL;
import static org.objectweb.asm.Opcodes.IRETURN;

public class ClassAddMethodVisitor extends ClassVisitor {

    private boolean methodIsExists = false;

    protected ClassAddMethodVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        if (name.equals("mul") && descriptor.equals("(II)I")) {
            methodIsExists = true;
        }
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }

    @Override
    public void visitEnd() {
        if (!methodIsExists) {
            var methodVisitor = super.visitMethod(ACC_PUBLIC, "mul", "(II)I", null, null);
            methodVisitor.visitCode();
            methodVisitor.visitVarInsn(ILOAD, 1);
            methodVisitor.visitVarInsn(ILOAD, 2);
            methodVisitor.visitInsn(IMUL);
            methodVisitor.visitInsn(IRETURN);
            methodVisitor.visitMaxs(0, 0);
            methodVisitor.visitEnd();
        }


        super.visitEnd();
    }
}
