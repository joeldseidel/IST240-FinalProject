package main.forms.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Extension of button specifically for navigation
 */
public class JNavButton extends JButton {
    JFrame sender;
    Class target;
    /**
     * Default constructor
     * @param sender parent frame
     * @param target target navigation frame class
     */
    public JNavButton(JFrame sender, Class target, String text){
        this.sender = sender;
        this.target = target;
        this.setText(text);
        this.addActionListener(new NavButtonActionListener());
    }

    /**
     * Navigation button listener - perform the navigation action
     */
    private class NavButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sender.setVisible(false);
            try {
                //Fancy code to convert a class reference to a JFrame object and immediately set it visible
                JFrame.class.cast(target.newInstance()).setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}