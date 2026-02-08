package com.stephenson.darkmode.designer;

import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.inductiveautomation.ignition.designer.model.DesignerContext;
import com.jidesoft.action.CommandBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.List;

public class DesignerDarkModeDesignerHook extends AbstractDesignerModuleHook {


    @Override
    public void startup(DesignerContext context, LicenseState activationState) {
        DarkModeManager.getInstance().recordOriginalLookAndFeel();
        System.out.println("DesignerDarkModeDesignerHook started.");
    }


    @Override
    public List<CommandBar> getModuleToolbars() {

        AbstractAction toggleAction = new AbstractAction("Dark Mode") {
            @Override
            public void actionPerformed(ActionEvent e) {
                DarkModeManager.getInstance().toggleDarkMode();  // APPLY Dark Mode
            }
        };

        // Create a CommandBar (JIDE toolbar)
        CommandBar toolbar = new CommandBar("Dark Mode Toolbar");
        toolbar.setOrientation(SwingConstants.HORIZONTAL);  // horizontal toolbar
        toolbar.add(toggleAction);

        return Collections.singletonList(toolbar);
    }
}
