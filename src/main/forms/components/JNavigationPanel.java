package main.forms.components;

import main.forms.GameForm;

import javax.swing.*;

/**
 * Extension of JPanel to encapsulate navigation activities
 */
public class JNavigationPanel extends JPanel {
    JNavButton[] navButtons;
    /**
     * Default constructor to initialize navigation bar formatting
     * @param navButtons navigation buttons for panel
     */
    public JNavigationPanel(JNavButton[] navButtons){
        this.navButtons = navButtons;
        initNavPanel();
    }

    /**
     * Add all navigation buttons to the panel
     */
    private void initNavPanel() {
        for(JNavButton navButton : navButtons){
            this.add(navButton);
        }
    }
}