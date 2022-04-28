/*
 * Created by JFormDesigner on Wed Apr 27 22:56:31 MSK 2022
 */

package org.me.main.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Allan
 */
public class TestingForm extends JFrame {
    public TestingForm() {
        generateQuestions();
        initComponents();
        refreshData();

    }

    int id = 0;
    int selectedRadio;

    static HashMap<Integer, ArrayList<String>> answers = new HashMap<>();
    HashMap<Integer, Integer> rightAnswers = new HashMap<>();
    ArrayList<String> questions = new ArrayList<>();
    HashMap<Integer, Integer> userAnswers = new HashMap<>();

    // next
    private void button1Event(ActionEvent e) {

        userAnswers.put(id, selectedRadio);

        if (id + 1 > questions.size() - 1) {
            finishTest();
            return;
        }
        radioButton1.setSelected(false);
        radioButton2.setSelected(false);
        radioButton3.setSelected(false);

        id = id + 1;
        refreshData();
    }

    // prew
    private void button2(ActionEvent e) {
        if (id - 1 < 0) return;
        id = id - 1;
        refreshData();
    }

    private void finishTest() {
        radioButton1.setVisible(false);
        radioButton2.setVisible(false);
        radioButton3.setVisible(false);
        button1.setVisible(false);
        button2.setVisible(false);

        var questionsCount = questions.size();
        int rightCount = 0;
        for (int i = 0; i < userAnswers.size(); i++) {
            if (rightAnswers.get(i).equals(userAnswers.get(i))) {
                rightCount++;
            }
        }

        textArea1.setText("Успех!\nВсего вопросов: %s\nПравильных ответов: %s".formatted(questionsCount, rightCount));
    }

    public void refreshData() {
        this.textArea1.setText(questions.get(id));

        button1.setEnabled(false);

        this.radioButton1.setText(answers.get(id).get(0));
        this.radioButton2.setText(answers.get(id).get(1));
        this.radioButton3.setText(answers.get(id).get(2));

    }

    private void generateQuestions() {
        questions.add("В каком году вышла Java 1.7?");

        var temp = new ArrayList<String>();
        temp.add("2000 Год");
        temp.add("2007 Год");
        temp.add("2011 Год");
        rightAnswers.put(0, 1);
        answers.put(0, (ArrayList<String>) temp.clone());
        temp.clear();

        questions.add("Какой тип данных\nзанимает меньше памяти?");
        temp.add("Bool");
        temp.add("Byte");
        temp.add("Short");
        rightAnswers.put(1, 0);
        answers.put(1, (ArrayList<String>) temp.clone());
        temp.clear();

        questions.add("Какое максимальное значение Integer?");
        temp.add("Целое число от -32768 до 32767");
        temp.add("Целое число от -2147483648 до 2147483647");
        temp.add("Целое число от -128 до 127");
        rightAnswers.put(2, 1);
        answers.put(2, (ArrayList<String>) temp.clone());
        temp.clear();

    }


    private void radioButton1(ActionEvent e) {
        selectedRadio = 0;
        this.radioButton2.setSelected(false);
        this.radioButton3.setSelected(false);
        button1.setEnabled(true);
    }

    private void radioButton2(ActionEvent e) {
        selectedRadio = 1;

        this.radioButton1.setSelected(false);
        this.radioButton3.setSelected(false);
        button1.setEnabled(true);

    }

    private void radioButton3(ActionEvent e) {
        selectedRadio = 2;

        this.radioButton1.setSelected(false);
        this.radioButton2.setSelected(false);
        button1.setEnabled(true);

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Allan
        button1 = new JButton();
        button2 = new JButton();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setTitle("\u0422\u0435\u0441\u0442");
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText("\u0414\u0430\u043b\u0435\u0435");
        button1.addActionListener(e -> button1Event(e));

        //---- button2 ----
        button2.setText("\u041d\u0430\u0437\u0430\u0434");
        button2.addActionListener(e -> button2(e));

        //---- radioButton1 ----
        radioButton1.setText("text");
        radioButton1.addActionListener(e -> radioButton1(e));

        //---- radioButton2 ----
        radioButton2.setText("text");
        radioButton2.addActionListener(e -> radioButton2(e));

        //---- radioButton3 ----
        radioButton3.setText("text");
        radioButton3.addActionListener(e -> radioButton3(e));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(scrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                        .addGap(11, 11, 11)
                                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(radioButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(radioButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(radioButton3, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))))
                                .addContainerGap(46, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioButton3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(button2)
                                        .addComponent(button1))
                                .addGap(22, 22, 22))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Allan
    private JButton button1;
    private JButton button2;
    public JRadioButton radioButton1;
    public JRadioButton radioButton2;
    public JRadioButton radioButton3;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
