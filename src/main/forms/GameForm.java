package main.forms;

import main.forms.components.*;

import javax.swing.*;

/**
 * Represents a generic game form
 * Since all of the game forms will be essentially the same - this will contain helper methods
 */
public class GameForm extends JFrame {
    private String name;
    private final int FORM_HEIGHT = 500, FORM_WIDTH = 500;

    /**
     * Default constructor for generic game form
     * @param name name of game
     */
    public GameForm(String name){
        this.name = name;
        initForm();
    }

    /**
     * Generic JFrame set up
     */
    private void initForm(){
        this.setSize(FORM_WIDTH, FORM_HEIGHT);
        this.setTitle("Game: " + this.name);
        initNavigation();
    }

    /**
     * Create and initialize the default navigation panel
     */
    private void initNavigation(){
        //Create nav panel and corresponding buttons
        JNavigationPanel navPanel = new JNavigationPanel(new JNavButton[] {
                new JNavButton(this, InstructionsForm.class, "View Help"),
                new JNavButton(this, IntroForm.class, "Main Menu")
        });
        this.add(navPanel);
    }
}