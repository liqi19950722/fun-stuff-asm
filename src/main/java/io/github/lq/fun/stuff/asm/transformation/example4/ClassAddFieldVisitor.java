package io.github.lq.fun.stuff.asm.transformation.example4;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

public class ClassAddFieldVisitor extends ClassVisitor {

    private boolean fieldIsExist = false;

    protected ClassAddFieldVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        if (name.equals("objValue") && descriptor.equals("Ljava/lang/Object;")) {
            fieldIsExist = true;
        }
        return super.visitField(access, name, descriptor, signature, value);
    }

    @Override
    public void visitEnd() {
        if (!fieldIsExist) {
            FieldVisitor fieldVisitor = super.visitField(ACC_PUBLIC, "objValue", "Ljava/lang/Object;", null, null);
            fieldVisitor.visitEnd();
        }
        super.visitEnd();
    }
}
