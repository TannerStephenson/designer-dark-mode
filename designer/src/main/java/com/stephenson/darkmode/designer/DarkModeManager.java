package com.stephenson.darkmode.designer;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;

public class DarkModeManager {

    private static final DarkModeManager INSTANCE = new DarkModeManager();

    private boolean darkModeEnabled = false;

    // This stores Ignition Designer’s actual default LAF
    private LookAndFeel originalLaf;

    private DarkModeManager() {}

    public static DarkModeManager getInstance() {
        return INSTANCE;
    }

    public void recordOriginalLookAndFeel() {
        if (originalLaf == null) {
            originalLaf = UIManager.getLookAndFeel();
            System.out.println("Captured original Designer LookAndFeel: " + originalLaf.getName());
        }
    }

    public void toggleDarkMode() {
        darkModeEnabled = !darkModeEnabled;

        try {
            if (darkModeEnabled) {
                FlatDarkLaf.setup();
                System.out.println("Applied FlatDarkLaf");
            } else {
                if (originalLaf != null) {
                    UIManager.setLookAndFeel(originalLaf);
                    System.out.println("Restored original Designer LookAndFeel");
                }
            }

            // Apply theme to all open windows
            for (Window w : Window.getWindows()) {
                SwingUtilities.updateComponentTreeUI(w);
                w.repaint();
            }

            System.out.println("Dark Mode toggled: " + darkModeEnabled);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isDarkModeEnabled() {
        return darkModeEnabled;
    }
}
