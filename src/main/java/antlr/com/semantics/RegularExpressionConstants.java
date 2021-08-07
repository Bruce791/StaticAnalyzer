package antlr.com.semantics;

import java.util.regex.Pattern;

public interface RegularExpressionConstants {
    Pattern REGULAR_EXPRESSION_G_COMMAND = Pattern.compile(".*?( [g,G]01| [g,G]00| [g,G]02| " +
            "[g,G]03| CSPLINE| cspline| CSpLINE)");
    Pattern REGULAR_EXPRESSION_M_COMMAND = Pattern.compile(".*?( [m,M]01| [m,M]00| [m,M]02| [m,M]99)");
    Pattern REGULAR_EXPRESSION_T_COMMAND = Pattern.compile(".*?( [t,T]-\\d{1,3}| [t,T]=-\\d{1,3})");
    Pattern REGULAR_EXPRESSION_S_COMMAND = Pattern.compile(".*?( [s,S]-\\d{3,6}| [s,S]=-\\d{3,6})");
    Pattern REGULAR_EXPRESSION_F_COMMAND = Pattern.compile(".*?( [f,F]-\\d{3,6}| [f,F]=-\\d{3,6})");
}
