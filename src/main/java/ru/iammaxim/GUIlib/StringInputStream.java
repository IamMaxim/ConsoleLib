package ru.iammaxim.GUIlib;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by maxim on 24.08.2016.
 */
public class StringInputStream extends InputStream implements ActionListener {
    private JTextField tf;
    private String str = null;
    private int pos = 0;
    private JTextArea out;
    private Console console;

    public StringInputStream(Console console) {
        this.console = console;
        tf = console.inputField;
        tf.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        str = tf.getText();
        if (!str.isEmpty()) {
            console.println(tf.getText());
        }
        str = str  + "\n";
        pos = 0;
        tf.setText("");
        synchronized (this) {
            this.notify();
        }
    }

    @Override
    public int read() {
        if(str != null && pos == str.length()){
            str = null;
            return java.io.StreamTokenizer.TT_EOF;
        }
        while (str == null || pos >= str.length()) {
            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        return str.charAt(pos++);
    }
}
