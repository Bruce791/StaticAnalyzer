package antlr.com.syntax;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, Digit = 3, Alpha = 4, Whitespace = 5;
    public static final int
            RULE_mainProgram = 0, RULE_frame_ISO_7bit = 1, RULE_decimal_number = 2;

    private static String[] makeRuleNames() {
        return new String[]{
                "mainProgram", "frame_ISO_7bit", "decimal_number"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'-'", "'.'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, "Digit", "Alpha", "Whitespace"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "Grammar.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public GrammarParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class MainProgramContext extends ParserRuleContext {
        public Frame_ISO_7bitContext frame_ISO_7bit() {
            return getRuleContext(Frame_ISO_7bitContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(GrammarParser.EOF, 0);
        }

        public MainProgramContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_mainProgram;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GrammarListener) ((GrammarListener) listener).enterMainProgram(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GrammarListener) ((GrammarListener) listener).exitMainProgram(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof GrammarVisitor)
                return ((GrammarVisitor<? extends T>) visitor).visitMainProgram(this);
            else return visitor.visitChildren(this);
        }
    }

    public final MainProgramContext mainProgram() throws RecognitionException {
        MainProgramContext _localctx = new MainProgramContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_mainProgram);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(6);
                frame_ISO_7bit();
                setState(7);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Frame_ISO_7bitContext extends ParserRuleContext {
        public List<TerminalNode> Alpha() {
            return getTokens(GrammarParser.Alpha);
        }

        public TerminalNode Alpha(int i) {
            return getToken(GrammarParser.Alpha, i);
        }

        public List<Decimal_numberContext> decimal_number() {
            return getRuleContexts(Decimal_numberContext.class);
        }

        public Decimal_numberContext decimal_number(int i) {
            return getRuleContext(Decimal_numberContext.class, i);
        }

        public List<TerminalNode> Whitespace() {
            return getTokens(GrammarParser.Whitespace);
        }

        public TerminalNode Whitespace(int i) {
            return getToken(GrammarParser.Whitespace, i);
        }

        public Frame_ISO_7bitContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_frame_ISO_7bit;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GrammarListener) ((GrammarListener) listener).enterFrame_ISO_7bit(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GrammarListener) ((GrammarListener) listener).exitFrame_ISO_7bit(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof GrammarVisitor)
                return ((GrammarVisitor<? extends T>) visitor).visitFrame_ISO_7bit(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Frame_ISO_7bitContext frame_ISO_7bit() throws RecognitionException {
        Frame_ISO_7bitContext _localctx = new Frame_ISO_7bitContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_frame_ISO_7bit);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(18);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(9);
                            match(Alpha);
                            setState(10);
                            decimal_number();
                            setState(16);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == Whitespace) {
                                {
                                    setState(12);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                    do {
                                        {
                                            {
                                                setState(11);
                                                match(Whitespace);
                                            }
                                        }
                                        setState(14);
                                        _errHandler.sync(this);
                                        _la = _input.LA(1);
                                    } while (_la == Whitespace);
                                }
                            }

                        }
                    }
                    setState(20);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == Alpha);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Decimal_numberContext extends ParserRuleContext {
        public List<TerminalNode> Digit() {
            return getTokens(GrammarParser.Digit);
        }

        public TerminalNode Digit(int i) {
            return getToken(GrammarParser.Digit, i);
        }

        public Decimal_numberContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_decimal_number;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GrammarListener) ((GrammarListener) listener).enterDecimal_number(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GrammarListener) ((GrammarListener) listener).exitDecimal_number(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof GrammarVisitor)
                return ((GrammarVisitor<? extends T>) visitor).visitDecimal_number(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Decimal_numberContext decimal_number() throws RecognitionException {
        Decimal_numberContext _localctx = new Decimal_numberContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_decimal_number);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(23);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__0) {
                    {
                        setState(22);
                        match(T__0);
                    }
                }

                setState(26);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(25);
                            match(Digit);
                        }
                    }
                    setState(28);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == Digit);
                setState(36);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__1) {
                    {
                        setState(30);
                        match(T__1);
                        setState(32);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        do {
                            {
                                {
                                    setState(31);
                                    match(Digit);
                                }
                            }
                            setState(34);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        } while (_la == Digit);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\7)\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\3\2\3\2\3\2\3\3\3\3\3\3\6\3\17\n\3\r\3\16\3\20\5\3\23\n\3\6" +
                    "\3\25\n\3\r\3\16\3\26\3\4\5\4\32\n\4\3\4\6\4\35\n\4\r\4\16\4\36\3\4\3" +
                    "\4\6\4#\n\4\r\4\16\4$\5\4\'\n\4\3\4\2\2\5\2\4\6\2\2\2,\2\b\3\2\2\2\4\24" +
                    "\3\2\2\2\6\31\3\2\2\2\b\t\5\4\3\2\t\n\7\2\2\3\n\3\3\2\2\2\13\f\7\6\2\2" +
                    "\f\22\5\6\4\2\r\17\7\7\2\2\16\r\3\2\2\2\17\20\3\2\2\2\20\16\3\2\2\2\20" +
                    "\21\3\2\2\2\21\23\3\2\2\2\22\16\3\2\2\2\22\23\3\2\2\2\23\25\3\2\2\2\24" +
                    "\13\3\2\2\2\25\26\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\5\3\2\2\2\30" +
                    "\32\7\3\2\2\31\30\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33\35\7\5\2\2\34" +
                    "\33\3\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37&\3\2\2\2 \"\7" +
                    "\4\2\2!#\7\5\2\2\"!\3\2\2\2#$\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2" +
                    "& \3\2\2\2&\'\3\2\2\2\'\7\3\2\2\2\t\20\22\26\31\36$&";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}