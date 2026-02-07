package com.stephenson.darkmode.designer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DarkModePainter {

    private static final Color DARK_BG = new Color(41, 49, 52);
    private static final Color LIGHT_BG = Color.WHITE;
    private static final Color DARK_FG = Color.WHITE;
    private static final Color LIGHT_FG = Color.BLACK;

    private static final List<JComponent> registeredComponents = new ArrayList<>();

    public static void registerComponent(JComponent comp) {
        registeredComponents.add(comp);
    }

    public static List<JComponent> getAllRegisteredComponents() {
        return registeredComponents;
    }

    public static void paintComponent(JComponent comp, boolean darkMode) {
        if (darkMode) {
            comp.setBackground(DARK_BG);
            comp.setForeground(DARK_FG);
        } else {
            comp.setBackground(LIGHT_BG);
            comp.setForeground(LIGHT_FG);
        }
        comp.repaint();
    }
}
