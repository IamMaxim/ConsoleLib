package ru.iammaxim.GUIlib.ToolbarButtons;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by maxim on 24.08.2016.
 */
public class CloseButton extends ToolbarButton {
    public CloseButton() {
        super();
        try {
            button = ImageIO.read(getClass().getResource("/data/images/buttons/closeButton.png"));
            hoveredButton = ImageIO.read(getClass().getResource("/data/images/buttons/closeButtonHovered.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
