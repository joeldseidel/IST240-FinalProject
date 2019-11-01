package main.forms;

import main.forms.components.JNavButton;
import main.forms.components.JNavigationPanel;

import javax.swing.*;

public class InstructionsForm extends JFrame {
    private final int FORM_HEIGHT = 500, FORM_WIDTH = 500;
    public InstructionsForm(){
        initForm();
    }
    /**
     * Generic JFrame set up
     */
    private void initForm(){
        this.setSize(FORM_WIDTH, FORM_HEIGHT);
        this.setTitle("Instructions");
        initNavigation();
    }

    /**
     * Create and initialize the default navigation panel
     */
    private void initNavigation(){
        //Create nav panel and corresponding buttons
        JNavigationPanel navPanel = new JNavigationPanel(new JNavButton[] {
                new JNavButton(this, IntroForm.class, "Main Menu")
        });
        this.add(navPanel);
    }
}
