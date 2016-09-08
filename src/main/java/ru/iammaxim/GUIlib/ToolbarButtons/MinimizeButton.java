package ru.iammaxim.GUIlib.ToolbarButtons;

import ru.iammaxim.GUIlib.ConsoleWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by maxim on 25.08.2016.
 */
public class MinimizeButton extends ToolbarButton implements ActionListener {
    public MinimizeButton() {
        super();
        try {
            button = ImageIO.read(getClass().getResource("/data/images/buttons/minimizeButton.png"));
            hoveredButton = ImageIO.read(getClass().getResource("/data/images/buttons/minimizeButtonHovered.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ConsoleWindow.instance.frame.setState(Frame.ICONIFIED);
    }
}
