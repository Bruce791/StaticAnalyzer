package antlr.com.semantics;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticAnalysis {
    // Подумать над листом
    public ArrayList<String> results = new ArrayList<>();

    public void checkG(Pattern regEx, ArrayList<String> textFile) {
        int cadr = 0;

        while (cadr < textFile.size()) {
            for (String item : textFile) {
                Matcher m = regEx.matcher(item);
                if (m.matches()) {
                    results.add("ОШИБКА В КАДРЕ N" + (cadr + 1) + "0 :"
                            + " две и более команды интерполяции 'G,g' в одном кадре");
                }
                cadr += 1;
            }
        }
    }

    public void checkM(Pattern regEx, ArrayList<String> textFile) {
        int cadr = 0;
        while (cadr < textFile.size()) {
            for (String item : textFile) {
                Matcher m = regEx.matcher(item);
                if (m.matches()) {
                    results.add("ОШИБКА В КАДРЕ N" + (cadr + 1) + "0 :"
                            + " две и более вспомогательные команды 'M,m' в одном кадре");
                }
                cadr += 1;
            }
        }
    }

    public void checkT(Pattern regEx, ArrayList<String> textFile) {
        int cadr = 0;
        while (cadr < textFile.size()) {
            for (String item : textFile) {
                Matcher m = regEx.matcher(item);
                if (m.matches()) {
                    results.add("ОШИБКА В КАДРЕ N" + (cadr + 1) + "0 :"
                            + " команды смены инструмента 'Т,t' не могут содержать '-'");
                }
                cadr += 1;
            }
        }
    }

    public void checkS(Pattern regEx, ArrayList<String> textFile) {
        int cadr = 0;
        while (cadr < textFile.size()) {
            for (String item : textFile) {
                Matcher m = regEx.matcher(item);
                if (m.matches()) {
                    results.add("ОШИБКА В КАДРЕ N" + (cadr + 1) + "0 :"
                            + " значение скорости вращения шпинделя 'S,s' не может быть отрицательным");
                }
                cadr += 1;
            }
        }
    }

    public void checkF(Pattern regEx, ArrayList<String> textFile) {
        int cadr = 0;
        while (cadr < textFile.size()) {
            for (String item : textFile) {
                Matcher m = regEx.matcher(item);
                if (m.matches()) {
                    results.add("ОШИБКА В КАДРЕ N" + (cadr + 1) + "0 :"
                            + " значение скорости рабочей подачи 'F,f' не может быть отрицательным");
                }
                cadr += 1;
            }
        }
    }
}
