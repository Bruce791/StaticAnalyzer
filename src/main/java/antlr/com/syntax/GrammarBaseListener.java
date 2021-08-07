package antlr.com.syntax;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class GrammarBaseListener implements GrammarListener {

    @Override
    public void enterMainProgram(GrammarParser.MainProgramContext ctx) {
    }

    @Override
    public void exitMainProgram(GrammarParser.MainProgramContext ctx) {
    }

    @Override
    public void enterFrame_ISO_7bit(GrammarParser.Frame_ISO_7bitContext ctx) {
    }

    @Override
    public void exitFrame_ISO_7bit(GrammarParser.Frame_ISO_7bitContext ctx) {
    }

    @Override
    public void enterDecimal_number(GrammarParser.Decimal_numberContext ctx) {
    }

    @Override
    public void exitDecimal_number(GrammarParser.Decimal_numberContext ctx) {
    }


    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
    }

    @Override
    public void visitTerminal(TerminalNode node) {
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
    }
}