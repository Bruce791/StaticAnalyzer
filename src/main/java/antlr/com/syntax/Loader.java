package antlr.com.syntax;

public class Loader extends GrammarBaseVisitor<Void> {
    private String body;

    @Override
    public Void visitFrame_ISO_7bit(GrammarParser.Frame_ISO_7bitContext ctx) {
        this.body = ctx.getText();
        return super.visitFrame_ISO_7bit(ctx);
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" Body: \n" + getBody());
        return stringBuffer.toString();
    }
}
