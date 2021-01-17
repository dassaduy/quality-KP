package ru.smirnov.ukpo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;

public class Form extends JFrame {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JLabel label;
    private JPanel root;
    private JButton button1;

    public Form() {
        Container contentPane = getContentPane();
        contentPane.add(root);
        this.button1.addActionListener(new MyButtonListener());
        button1.setName("Calculation");

        textArea1.setName("input");
        textArea2.setName("res");

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        root = new JPanel();
        root.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        textArea1 = new JTextArea();
        root.add(textArea1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        textArea2 = new JTextArea();
        textArea2.setText("");
        root.add(textArea2, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        label = new JLabel();
        label.setText("Result:");
        root.add(label, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        button1 = new JButton();
        button1.setText("Button");
        root.add(button1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return root;
    }

    public class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            btnclick();
        }
    }


    void btnclick() {
        String message = new String("Данные некорректны".getBytes(), StandardCharsets.UTF_8);
        try {
            String[] f = textArea1.getText().split("\n");
            Double[][] s = new Double[f.length][f[0].split(" ").length];

            for (int i = 0; i < f.length; i++) {
                String[] temp = f[i].split(" ");
                if (f.length != temp.length - 1) {
                    textArea2.setText(message);
                    return;
                }
                for (int j = 0; j < temp.length; j++) {
                    s[i][j] = Double.parseDouble(temp[j]);
                }
            }

            Gauss gauss = new Gauss();
            textArea2.setText(gauss.countTheMatrix(s));
        } catch (Exception e) {
            textArea2.setText(message);
        }
    }
}
