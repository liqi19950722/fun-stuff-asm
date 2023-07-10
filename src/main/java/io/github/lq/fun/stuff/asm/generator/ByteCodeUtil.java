package io.github.lq.fun.stuff.asm.generator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;

public class ByteCodeUtil {
    public static void byteCodeWriteToFile(String pkg, String className, Supplier<byte[]> supplier) throws Exception {
        var resource = Thread.currentThread().getContextClassLoader().getResource("").toURI();

        var dir = Paths.get(resource).resolve(pkg);
        if (!Files.exists(dir)) {
            Files.createDirectory(dir);
        }

        var path = dir.resolve(className);
        Files.write(path, supplier.get());
    }
}
