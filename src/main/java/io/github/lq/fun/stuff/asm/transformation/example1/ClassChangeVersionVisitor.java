package io.github.lq.fun.stuff.asm.transformation.example1;

import org.objectweb.asm.ClassVisitor;

import static org.objectweb.asm.Opcodes.V11;

public class ClassChangeVersionVisitor extends ClassVisitor {

    protected ClassChangeVersionVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(V11, access, name, signature, superName, interfaces);
    }
}
