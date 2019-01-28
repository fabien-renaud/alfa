package fr.gosecuri.view;
import javax.swing.JPanel;
import javax.swing.JButton;

public class AuthenticationPage extends JPanel {
    private final int buttonWidth = 100;
    private final int buttonHeight = 40;
    private final String buttonName = "S'identifier";
    protected JButton button;

    public AuthenticationPage() {
        button = new JButton(buttonName);
        button.setBounds(50, 50, buttonWidth, buttonHeight);

        add(button);
    }
}
