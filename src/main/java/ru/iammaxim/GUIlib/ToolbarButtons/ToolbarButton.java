package ru.iammaxim.GUIlib.ToolbarButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by maxim on 25.08.2016.
 */
public class ToolbarButton extends JButton {
    protected boolean hovered = false;
    protected int width = 21, height = 25;
    protected Image button, hoveredButton;

    @Override
    protected void paintComponent(Graphics g) {
        if (hovered) g.drawImage(hoveredButton, 0, 0, width, height, null);
        else g.drawImage(button, 0, 0, width, height, null);
    }

    public ToolbarButton() {
        setOpaque(false);
        Dimension size = new Dimension(width, height);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setBorder(null);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
            }
            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
            }
        });
    }
}
