package io.github.lq.fun.stuff.asm.transformation.example4;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

public class ClassAddFieldVisitor extends ClassVisitor {


    protected ClassAddFieldVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public void visitEnd() {
        FieldVisitor fieldVisitor = super.visitField(ACC_PUBLIC, "objValue", "Ljava/lang/Object;", null, null);
        fieldVisitor.visitEnd();
        super.visitEnd();
    }
}
