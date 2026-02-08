package com.stephenson.darkmode.designer;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class DarkModeUtils {

    public static void applyDarkMode(JFrame designerFrame, boolean enabled) {
        if (enabled) {
            FlatDarkLaf.setup();
        } else {
            FlatLightLaf.setup();
        }

        SwingUtilities.updateComponentTreeUI(designerFrame);
        designerFrame.repaint();
    }
}

