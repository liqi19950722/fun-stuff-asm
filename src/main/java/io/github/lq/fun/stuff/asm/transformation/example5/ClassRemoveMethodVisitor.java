package io.github.lq.fun.stuff.asm.transformation.example5;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

public class ClassRemoveMethodVisitor extends ClassVisitor {


    protected ClassRemoveMethodVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        if (name.equals("add") && descriptor.equals("(II)I")) {
            return null;
        }
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }
}
