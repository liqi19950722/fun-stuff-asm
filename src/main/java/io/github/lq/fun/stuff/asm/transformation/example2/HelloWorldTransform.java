package io.github.lq.fun.stuff.asm.transformation.example2;

import io.github.lq.fun.stuff.asm.ByteCodeUtil;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import static io.github.lq.fun.stuff.asm.ByteCodeUtil.byteCodeWriteToFile;
import static org.objectweb.asm.ClassReader.SKIP_DEBUG;
import static org.objectweb.asm.ClassReader.SKIP_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;
import static org.objectweb.asm.Opcodes.ASM9;

public class HelloWorldTransform {
    public static void main(String[] args) throws Exception {
        String pkg = "io/github/lq/fun/stuff/asm/transformation/example2";
        String className = "HelloWorld.class";
        byte[] classFile = ByteCodeUtil.readClassFileToByteArray(pkg + "/" + className);
        byteCodeWriteToFile(pkg, className, () -> transform(classFile));
    }

    private static byte[] transform(byte[] classFile) {
        var classReader = new ClassReader(classFile);
        var classWriter = new ClassWriter(COMPUTE_MAXS | COMPUTE_FRAMES);
        var classVisitor = new ClassCloneVisitor(ASM9, classWriter);

        classReader.accept(classVisitor, SKIP_DEBUG | SKIP_FRAMES);

        return classWriter.toByteArray();
    }

}
