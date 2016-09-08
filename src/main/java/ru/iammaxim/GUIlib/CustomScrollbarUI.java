package ru.iammaxim.GUIlib;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

/**
 * Created by maxim on 24.08.2016.
 */
public class CustomScrollbarUI extends BasicScrollBarUI {
    private static final Color bgColor = new Color(50, 50, 50), fgColor = new Color(100, 100, 100);
    private static final JButton button = new JButton() {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(0, 0);
        }
    };

    @Override
    public Dimension getPreferredSize(JComponent c) {
        Dimension dim = super.getPreferredSize(c);
        dim.width = 16;
        return dim;
    }

    public static ComponentUI createUI(JComponent c) {
        return new CustomScrollbarUI();
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.translate(trackBounds.x, trackBounds.y);
        g.setColor(bgColor);
        g.fillRoundRect(0, 0, trackBounds.width-1, trackBounds.height-1, 5, 5);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return button;
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return button;
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        g.translate(thumbBounds.x, thumbBounds.y);
        g.setColor(fgColor);
        g.fillRoundRect(0, 0, thumbBounds.width, thumbBounds.height, 3, 3);
    }
}
