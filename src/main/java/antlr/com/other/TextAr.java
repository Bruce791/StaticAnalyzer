package antlr.com.other;

import antlr.com.semantics.RegularExpressionConstants;
import antlr.com.semantics.SemanticAnalysis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class TextAr implements ActionListener, RegularExpressionConstants {

    private JTextArea text;
    private SemanticAnalysis startAnalyze;

    public static void main(String[] args) {
        TextAr gui = new TextAr();
        gui.go();
    }

    public String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Just Click It");
        button.addActionListener(this);
        text = new JTextArea( 10,20);
        text.setLineWrap(true);

        JScrollPane scroller = new JScrollPane(text);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scroller);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(350,300);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(text.getText().split("\n")));
        text.setText("");

        startAnalyze = new SemanticAnalysis();
        startAnalyze.checkG(REGULAR_EXPRESSION_G_COMMAND, list);
        startAnalyze.checkM(REGULAR_EXPRESSION_M_COMMAND, list);
        startAnalyze.checkF(REGULAR_EXPRESSION_F_COMMAND, list);
        startAnalyze.checkS(REGULAR_EXPRESSION_S_COMMAND, list);
        startAnalyze.checkT(REGULAR_EXPRESSION_T_COMMAND, list);

        for (String s : startAnalyze.results) {
            text.append(s + "\n");
        }
    }
}
