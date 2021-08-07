package antlr.com.syntax;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class GrammarBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements GrammarVisitor<T> {

    @Override
    public T visitMainProgram(GrammarParser.MainProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitFrame_ISO_7bit(GrammarParser.Frame_ISO_7bitContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitDecimal_number(GrammarParser.Decimal_numberContext ctx) {
        return visitChildren(ctx);
    }
}