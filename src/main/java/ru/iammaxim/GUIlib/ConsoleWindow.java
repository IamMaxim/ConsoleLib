package ru.iammaxim.GUIlib;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by maxim on 24.08.2016.
 */
public class ConsoleWindow {
    public static ConsoleWindow instance;
    public static String title = "Console";
    public Console console;
    public JFrame frame;
    public Out out;
    public Rectangle lastBounds;
    private Point lastLoc;
    public boolean isMaximized = false;

    public ConsoleWindow() {
    }

    public static ConsoleWindow create() {
        instance = new ConsoleWindow();
        instance.init();
        return instance;
    }

    public void init() {
        UIManager.put("ScrollBarUI", "ru.iammaxim.GUIlib.CustomScrollbarUI");
        frame = new JFrame(title);
        frame.setContentPane((console = new Console()).panel);
        frame.setUndecorated(true);
        frame.setSize(800, 600);
        Dimension dim = frame.getSize();
        frame.setShape(new RoundRectangle2D.Double(0, 0, dim.width, dim.height, 8, 8));
        frame.setVisible(true);
        out = new Out(System.out, console);
        System.setOut(out);
        System.setIn(new StringInputStream(console));
    }

    public void maximize() {
        DisplayMode mode = frame.getGraphicsConfiguration().getDevice().getDisplayMode();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());
        lastBounds = frame.getBounds();
        lastLoc = frame.getLocationOnScreen();
        frame.setMaximizedBounds(new Rectangle(mode.getWidth(), mode.getHeight() - insets.bottom));
        frame.setShape(new Rectangle2D.Double(0, 0, mode.getWidth(), mode.getHeight() - insets.bottom));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        isMaximized = true;
    }

    public void unmaximize() {
        frame.setShape(new RoundRectangle2D.Double(0, 0, lastBounds.width, lastBounds.height, 8, 8));
        frame.setBounds(lastBounds);
        frame.setExtendedState(frame.getExtendedState() | JFrame.NORMAL);
        isMaximized = false;
    }

    public static void main(String[] args) {
        instance = new ConsoleWindow();
        instance.init();
    }

    public void stop() {
        System.exit(0);
    }
}
