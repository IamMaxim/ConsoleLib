package ru.iammaxim.GUIlib;

import ru.iammaxim.GUIlib.ToolbarButtons.CloseButton;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by maxim on 24.08.2016.
 */
public class Console {
    public ConsoleWindow main = ConsoleWindow.instance;
    public JPanel panel;
    public JTextField inputField;
    private CloseButton closeButton;
    private JPanel toolbarPanel;
    private JScrollPane outputPanel;
    public JTextArea label = new JTextArea("");
    private JLabel title;

    private Point lastMousePoint;

    public Console() {
        title.setText(ConsoleWindow.title);
        toolbarPanel.setBackground(toolbarPanel.getParent().getBackground());
        outputPanel.setBackground(new Color(0, 0, 0, 0));
        outputPanel.setBorder(null);
        outputPanel.getViewport().setBackground(new Color(0, 0, 0, 0));
        label.setWrapStyleWord(true);
        label.setLineWrap(true);
        label.setEditable(false);
        label.setForeground(Color.WHITE);
        label.setBackground(panel.getBackground());
        label.setMargin(new Insets(0, 5, 0, 5));
        label.setFont(new Font("Consolas", Font.PLAIN, 16));
        outputPanel.getViewport().add(label);
        outputPanel.getVerticalScrollBar().setBackground(new Color(50, 50, 50));
        closeButton.addActionListener(e -> {
            main.stop();
        });
        inputField.setBorder(null);
        ((DefaultCaret)inputField.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        toolbarPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                lastMousePoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getLocationOnScreen().y < 3) main.maximize();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        toolbarPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (main.isMaximized) {
                    lastMousePoint.setLocation(lastMousePoint.x - (main.frame.getMaximizedBounds().width - main.lastBounds.width)/2, lastMousePoint.y);
                    main.unmaximize();
                }
                Point coords = e.getLocationOnScreen();
                main.frame.setLocation(coords.x - lastMousePoint.x, coords.y - lastMousePoint.y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
    }

    public void println(String s) {
        label.setText(label.getText() + '\n' + s);
    }
}
