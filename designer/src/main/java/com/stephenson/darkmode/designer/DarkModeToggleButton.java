package com.stephenson.darkmode.designer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DarkModeToggleButton extends JToggleButton {

    public DarkModeToggleButton() {
        super("Dark Mode");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DarkModeManager.toggleDarkMode();
            }
        });
    }
}
