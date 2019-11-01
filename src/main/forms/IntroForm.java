package main.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main menu form
 * @author Joel Seidel
 */
public class IntroForm extends JFrame {
    //Form element declaration
    private JLabel title, menuInstructions;
    //Form menu elements array
    private JMenuOption[] menuOptions;
    //Form menu target array - parallel with menu options
    private JFrame[] gameFrames = new JFrame[] {new GameForm("Game 1"), new GameForm("Game 2"), new GameForm("Game 3"), new InstructionsForm()};
    //Default size of the form
    private static int FRAME_WIDTH = 500, FRAME_HEIGHT = 500;

    /**
     * Default constructor for the main menu frame
     */
    public IntroForm(){
        initFormControls();
    }

    /**
     * Initialize the controls of the forms
     */
    private void initFormControls(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.title = new JLabel("IST240 Final Project");
        this.menuInstructions = new JLabel("Select a game from the list below");
        this.menuOptions = new JMenuOption[] {
                new JMenuOption("Game 1", 0, this),
                new JMenuOption("Game 2", 1, this),
                new JMenuOption("Game 3", 2, this),
                new JMenuOption("Instructions", 3, this)
        };
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        JPanel formPanel = new JPanel();
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.add(title);
        headerPanel.add(menuInstructions);
        JPanel menuPanel = new JPanel();
        for(JMenuOption menuOption : menuOptions){
            menuPanel.add(menuOption);
        }
        formPanel.add(headerPanel);
        formPanel.add(menuPanel);
        this.add(formPanel);
    }

    /**
     * Overridden JButton to contain a menu index for a form
     */
    private class JMenuOption extends JButton {
        private int menuIndex;

        /**
         * Default constructor for JMenuOption
         * @param label button text
         * @param menuIndex menu index this button represents
         */
        JMenuOption(String label, int menuIndex, JFrame parent){
            super(label);
            this.menuIndex = menuIndex;
            this.addActionListener(new menuOptionClickHandler(parent));
        }

        /**
         * Getter for the menu index
         * @return menu index number
         */
        public int getMenuIndex(){
            return this.menuIndex;
        }
    }

    /**
     * Menu option click listener - open the form in the parallel array at the same index as the menu option
     */
    private class menuOptionClickHandler implements ActionListener {
        private JFrame parent;
        menuOptionClickHandler(JFrame parent){
            super();
            this.parent = parent;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            parent.setVisible(false);
            //Get parallel index form and display
            gameFrames[((JMenuOption)e.getSource()).getMenuIndex()].setVisible(true);
        }
    }
}