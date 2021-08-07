package antlr.com.syntax;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {

    T visitMainProgram(GrammarParser.MainProgramContext ctx);

    T visitFrame_ISO_7bit(GrammarParser.Frame_ISO_7bitContext ctx);

    T visitDecimal_number(GrammarParser.Decimal_numberContext ctx);
}