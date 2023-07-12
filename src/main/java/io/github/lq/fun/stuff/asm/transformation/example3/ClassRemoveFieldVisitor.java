package io.github.lq.fun.stuff.asm.transformation.example3;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

public class ClassRemoveFieldVisitor extends ClassVisitor {


    protected ClassRemoveFieldVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {

        if (name.equals("strValue") && descriptor.equals("Ljava/lang/String;")) {
            return null;
        }
        return super.visitField(access, name, descriptor, signature, value);
    }
}
