package io.github.lq.fun.stuff.asm.generator.example5;

import io.github.lq.fun.stuff.annotation.MyTag;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;

import static io.github.lq.fun.stuff.asm.generator.ByteCodeUtil.byteCodeWriteToFile;
import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_INTERFACE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.V17;
import static org.objectweb.asm.Type.getDescriptor;

public class HelloWorldGenerator {
    public static void main(String[] args) throws Exception {
        byteCodeWriteToFile("example5", "HelloWorld.class", HelloWorldGenerator::dump);
    }

    static byte[] dump() {
        var classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        classWriter.visit(V17, ACC_PUBLIC | ACC_ABSTRACT | ACC_INTERFACE, "example5/HelloWorld", null,
                "java/lang/Object", null);

        var fieldIntValue = classWriter.visitField(ACC_PUBLIC | ACC_STATIC | ACC_FINAL, "intValue", Type.INT_TYPE.getDescriptor(), null, 100);

        var annotationVisitor = fieldIntValue.visitAnnotation(getDescriptor(MyTag.class), true);
        annotationVisitor.visitEnd();
        annotationVisitor.visit("name", "Tomcat");
        annotationVisitor.visit("age", 10);

        fieldIntValue.visitEnd();

        classWriter.visitEnd();

        return classWriter.toByteArray();
    }
}
