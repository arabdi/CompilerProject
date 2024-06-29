package compiler;

import gen.japyLexer;
import gen.japyListener;
import gen.japyParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Compiler {
    public static void main (String[] args) throws IOException {
        String filename = "G:\\compilerProject\\sample\\test.txt";
        String filename2 = "G:\\compilerProject\\sample\\test2.txt";
        String filename3 = "G:\\compilerProject\\sample\\test3.txt";
        CharStream stream = CharStreams.fromFileName(filename);
        japyLexer lexer = new japyLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        japyParser parser = new japyParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        japyListener listener = new ProgramPrinter();

        walker.walk(listener, tree);
    }
}
