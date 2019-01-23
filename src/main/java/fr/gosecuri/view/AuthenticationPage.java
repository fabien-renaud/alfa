package fr.gosecuri.view2;

import javax.swing.*;

public class AuthenticationPage extends JPanel {
    private int buttonWidth = 100;
    private int buttonHeight = 40;
    private String buttonName = "S'identifier";
    private JButton button;

    public AuthenticationPage() {
        button = new JButton(buttonName);
        button.setBounds(50, 50, buttonWidth, buttonHeight);

        add(button);
    }

    public int getButtonWidth() {
        return buttonWidth;
    }

    public void setButtonWidth(int buttonWidth) {
        this.buttonWidth = buttonWidth;
    }

    public int getButtonHeight() {
        return buttonHeight;
    }

    public void setButtonHeight(int buttonHeight) {
        this.buttonHeight = buttonHeight;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }
}
