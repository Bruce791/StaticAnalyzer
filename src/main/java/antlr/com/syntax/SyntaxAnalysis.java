package antlr.com.syntax;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class SyntaxAnalysis {
    private int errCount;

    private int getNumbersOfErr(int number) {
        this.errCount = number;
        return errCount;
    }

    public int getErrCount() {
        return errCount;
    }

    public Loader getInLoader(String s) {
        ANTLRInputStream inputStream = new ANTLRInputStream(s);
        GrammarLexer lexer = new GrammarLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        GrammarParser grammarParser = new GrammarParser(tokenStream);
        ParseTree parseTree = grammarParser.mainProgram();
        getNumbersOfErr(grammarParser.getNumberOfSyntaxErrors());
        Loader loader = new Loader();
        loader.visit(parseTree);
        return loader;
    }

    public String printResultOfAnalysis(int errorCount) {
        String result = errorCount > 0 ? "The program has an invalid structure. The number of syntax errors is - "
                + errCount + "!\n " +
                "List of possible causes:\n " +
                "mismatched input 'Alpha' expecting {'-', Digit},\n " +
                "mismatched input 'Sign' expecting <EOF>,\n " +
                "mismatched input ' ' expecting {'-', Digit},\n " +
                "mismatched input 'Digit' expecting <EOF>,\n " +
                "extraneous input '.' expecting {'-', Digit}." :
                "The program has an valid structure. The number of syntax errors is - "
                + errCount + "!";
        return result;
    }
}
