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

    private boolean darkModeEnabled = false;

    @Override
    public void startup(DesignerContext context, LicenseState activationState) {
        DarkModeManager.getInstance().recordOriginalLookAndFeel();
    }


    @Override
    public List<CommandBar> getModuleToolbars() {

        AbstractAction toggleAction = new AbstractAction("Dark Mode") {
            @Override
            public void actionPerformed(ActionEvent e) {
                darkModeEnabled = !darkModeEnabled;
                System.out.println("Dark Mode toggled: " + darkModeEnabled);

            }
        };

        // Create a CommandBar (JIDE toolbar)
        CommandBar toolbar = new CommandBar("Dark Mode Toolbar");
        toolbar.setOrientation(SwingConstants.HORIZONTAL);  // horizontal toolbar
        toolbar.add(toggleAction);

        // Return the list of toolbars your module contributes
        return Collections.singletonList(toolbar);
    }
}
