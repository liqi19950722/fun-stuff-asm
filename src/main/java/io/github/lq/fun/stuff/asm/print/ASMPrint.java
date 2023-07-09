package io.github.lq.fun.stuff.asm.print;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.Printer;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.IOException;
import java.io.PrintWriter;

public class ASMPrint {
    public static void main(String[] args) throws IOException {
//        String className = "io.github.lq.fun.stuff.asm.print.HelloWorld";
        String className = "java.lang.Comparable";
        int parseOption = ClassReader.SKIP_FRAMES | ClassReader.SKIP_DEBUG;
        boolean asmCode = true;

        Printer printer = asmCode ? new ASMifier() : new Textifier();
        PrintWriter printerWriter = new PrintWriter(System.out, true);
        TraceClassVisitor visitor = new TraceClassVisitor(null, printer, printerWriter);

        new ClassReader(className).accept(visitor, parseOption);

    }
}
