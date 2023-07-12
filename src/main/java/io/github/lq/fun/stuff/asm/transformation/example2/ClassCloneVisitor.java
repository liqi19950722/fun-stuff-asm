package io.github.lq.fun.stuff.asm.transformation.example2;

import org.objectweb.asm.ClassVisitor;

public class ClassCloneVisitor extends ClassVisitor {
    protected ClassCloneVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, new String[]{"java/lang/Cloneable"});
    }
}
