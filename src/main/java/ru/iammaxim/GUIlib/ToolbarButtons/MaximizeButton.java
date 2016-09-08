package ru.iammaxim.GUIlib.ToolbarButtons;

import ru.iammaxim.GUIlib.Console;
import ru.iammaxim.GUIlib.ConsoleWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

/**
 * Created by maxim on 25.08.2016.
 */
public class MaximizeButton extends ToolbarButton implements ActionListener {
    public MaximizeButton() {
        super();
        try {
            button = ImageIO.read(getClass().getResource("/data/images/buttons/maximizeButton.png"));
            hoveredButton = ImageIO.read(getClass().getResource("/data/images/buttons/maximizeButtonHovered.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = ConsoleWindow.instance.frame;
        if ((frame.getExtendedState() & JFrame.MAXIMIZED_BOTH) == 0) {
            ConsoleWindow.instance.maximize();
        } else {
            ConsoleWindow.instance.unmaximize();
        }
    }
}
