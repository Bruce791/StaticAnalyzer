package antlr.com.graphics;

import antlr.com.semantics.RegularExpressionConstants;
import antlr.com.semantics.SemanticAnalysis;
import antlr.com.syntax.SyntaxAnalysis;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AppFrame implements RegularExpressionConstants {
    private JFrame theFrame;
    private JMenuBar mainMenu;
    private JLabel inputLabel;
    private JLabel outputLabel;
    private JTextArea inputText;
    private JTextArea outputText;
    private JScrollPane inScrollPane;
    private JScrollPane outScrollPane;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JMenu file;
    private JMenu edit;
    private JMenu find;
    private JMenu help;
    private JMenuItem exit;
    private JMenuItem cut;
    private Font font;
    private SemanticAnalysis startAnalyze;
    private SyntaxAnalysis chekStructure;

    private ArrayList<String> listSave;

    static {
        // Выбор темы для фрейма
        makeMainThemeInFrame();
    }

    AppFrame() {
        // Настройки главного фрейма
        theFrame = new JFrame();
        theFrame.setBounds(750, 250, 500, 500);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setLayout(null);
        theFrame.setResizable(false);
        theFrame.setVisible(true);

        // Создание строки меню
        mainMenu = new JMenuBar();

        // Добовление элементов меню
        makeOptionsMenu();

        // Добовление окон ввода и вывода
        makeTextArea();

        // Добовление необходимых кнопок
        makeButtons();

        // Добовление меток и создание шрифта
        makeLabelAndFont();
    }

    private void makeOptionsMenu() {
        // Создание вкладок в меню
        file = new JMenu("File");
        edit = new JMenu("Edit");
        find = new JMenu("Find");
        help = new JMenu("Help");

        // Добавление итемов и мненмонику в меню file (open/save) и необходимая логика
        JMenuItem openMenuItem = new JMenuItem("Open", 'O');
        openMenuItem.addActionListener(e -> {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(theFrame);
            inputText.setText("");
            inputText.append(openFile(fileOpen.getSelectedFile()));

        });
        file.add(openMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save", 'S');
        saveMenuItem.addActionListener(e -> {
            listSave = new ArrayList<>(Arrays.asList(inputText.getText().split("\n")));
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(theFrame);
            saveFile(fileSave.getSelectedFile());
        });
        file.add(saveMenuItem);
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        file.addSeparator(); // разделительная линия между итемами
        exit = file.add(new JMenuItem("Exit", 'E'));
        // добавление события для закрытия приложения
        exit.addActionListener(e -> System.exit(0));
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E")); // добавление хоткеев

        // Добавление итемов и мненмонику в меню edit (cut/copy)
        cut = edit.add(new JMenuItem("Cut", 'C'));
        cut.setEnabled(false); // кнопка заблокированна
        edit.add(new JMenuItem("Copy", 'o'));
        edit.add(find);
        find.add("Find.."); // вложенные итемы

        // Добавление итемов и мненмонику в меню help
        help.add(new JMenuItem("? Help", 'H'));

        // Добовление элементов на главную панель
        mainMenu.add(file);
        mainMenu.add(edit);
        mainMenu.add(find);
        mainMenu.add(help);

        // Добовление строки главного меню на фрейм
        theFrame.setJMenuBar(mainMenu);
    }



    private void makeTextArea() {
        // Создание окна ввода
        inputText = new JTextArea("/* enter your G-code */", 10, 20);
        inputText.setLineWrap(true);

        // Создание скроллера для ввода
        inScrollPane = new JScrollPane(inputText);
        inScrollPane.setBounds(100, 40, 350, 150);

        // Создание окна вывода
        outputText = new JTextArea(10, 20);
        outputText.setLineWrap(true);
//        outputText.setWrapStyleWord(true); // Сделать нормальный перенос строки
        outputText.setEditable(false);

        // Создание скроллера для вывода
        outScrollPane = new JScrollPane(outputText);
        outScrollPane.setBounds(20, 260, 440, 150);

        // Добовление на главный фрейм
        theFrame.add(inScrollPane);
        theFrame.add(outScrollPane);
    }

    private void makeButtons() {
        // Создание кнопок их распположение на фрейме
        button1 = new JButton("Structure");
        button2 = new JButton("Analyze");
        button3 = new JButton("Clear");
        button1.setBounds(5, 40, 85, 30);
        button2.setBounds(5, 80, 85, 30);
        button3.setBounds(5, 120, 85, 30);

        // Необходимые слушатели для кнопок
        button1.addActionListener(e -> {
            String userText = inputText.getText();
            outputText.setText("");

            chekStructure = new SyntaxAnalysis();
            chekStructure.getInLoader(userText);

            String resultString = chekStructure.printResultOfAnalysis(chekStructure.getErrCount());
            if (resultString.contains("invalid")) {
                outputText.setForeground(Color.RED);
            } else {
                outputText.setForeground(Color.BLUE);
            }
            outputText.append(resultString);
        });
        button2.addActionListener(e -> {
            ArrayList<String> list = new ArrayList<>(Arrays.asList(inputText.getText().split("\n")));
            outputText.setText("");
            startAnalyze = new SemanticAnalysis();
            startAnalyze.checkG(REGULAR_EXPRESSION_G_COMMAND, list);
            startAnalyze.checkT(REGULAR_EXPRESSION_T_COMMAND, list);
            startAnalyze.checkF(REGULAR_EXPRESSION_F_COMMAND, list);
            startAnalyze.checkS(REGULAR_EXPRESSION_S_COMMAND, list);
            startAnalyze.checkM(REGULAR_EXPRESSION_M_COMMAND, list);

            if (startAnalyze.results.isEmpty()) {
                outputText.setForeground(Color.BLUE);
                outputText.append("Process finished with exit code 0");
            } else {
                for (String s : startAnalyze.results) {
                    outputText.setForeground(Color.RED);
                    outputText.append(s + "\n");
                }
            }
        });
        button3.addActionListener(e -> {outputText.setText("");});

        // Добовление на главный фрейм
        theFrame.add(button1);
        theFrame.add(button2);
        theFrame.add(button3);
    }


    private void makeLabelAndFont() {
        // Создание меток и шрифта
        font = new Font("", Font.BOLD, 13);
        inputLabel = new JLabel("Input window for G-code: ");
        outputLabel = new JLabel("Result output window: ");

        // Добовление шрифта для меток и их размещение на фрейме
        inputLabel.setFont(font);
        outputLabel.setFont(font);
        inputLabel.setBounds(100, 20, 250, 13);
        outputLabel.setBounds(20, 240, 250, 13);

        // Добовление на главный фрейм
        theFrame.add(inputLabel);
        theFrame.add(outputLabel);
    }

    // Метод для сохранения программы в файл
    private void saveFile(File selectedFile) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));

            for (String s : listSave) {
                writer.write(s + "\n");
            }
            writer.close();
        } catch (IOException ex) {

        }
    }

    private String openFile(File selectedFile) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(selectedFile));

            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            br.close();
        } catch (IOException ex) {

        }
        return sb.toString();
    }

    private static void makeMainThemeInFrame() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
    }
}
