package antlr.com.syntax;

import org.antlr.v4.runtime.tree.ParseTreeListener;

public interface GrammarListener extends ParseTreeListener {

    void enterMainProgram(GrammarParser.MainProgramContext ctx);

    void exitMainProgram(GrammarParser.MainProgramContext ctx);

    void enterFrame_ISO_7bit(GrammarParser.Frame_ISO_7bitContext ctx);

    void exitFrame_ISO_7bit(GrammarParser.Frame_ISO_7bitContext ctx);

    void enterDecimal_number(GrammarParser.Decimal_numberContext ctx);

    void exitDecimal_number(GrammarParser.Decimal_numberContext ctx);
}