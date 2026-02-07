package com.stephenson.darkmode.designer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DarkModeManager {

    private static boolean darkModeEnabled = false;

    public static boolean isDarkMode() {
        return darkModeEnabled;
    }

    public static void toggleDarkMode() {
        darkModeEnabled = !darkModeEnabled;
        applyThemeToAll();
    }

    private static void applyThemeToAll() {
        // Apply dark/light theme to all registered module components
        List<JComponent> components = DarkModePainter.getAllRegisteredComponents();
        for (JComponent comp : components) {
            DarkModePainter.paintComponent(comp, darkModeEnabled);
        }
    }
}
