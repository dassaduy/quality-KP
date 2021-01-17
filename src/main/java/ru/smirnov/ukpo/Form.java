package ru.smirnov.ukpo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JLabel label;
    private JPanel root;
    private JButton button1;

    public Form() {
        Container contentPane = this.getContentPane();
        contentPane.add(root);
        this.button1.addActionListener(new MyButtonListener());
        button1.setName("Calculation");

        textArea1.setName("input");
        textArea2.setName("res");

    }

    public class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            btnclick();
        }
    }


    void btnclick() {
        try {
            String[] f = textArea1.getText().split("\n");
            Double[][] s = new Double[f.length][f[0].split(" ").length];

            for (int i = 0; i < f.length; i++) {
                String[] temp = f[i].split(" ");
                if (f.length != temp.length - 1) {
                    textArea2.setText("Данные некорректны");
                    return;
                }
                for (int j = 0; j < temp.length; j++) {
                    s[i][j] = Double.parseDouble(temp[j]);
                }
            }

            Gauss gauss = new Gauss();
            textArea2.setText(gauss.countTheMatrix(s));
        } catch (Exception e) {
            textArea2.setText("Данные некорректны");
        }
    }
}
