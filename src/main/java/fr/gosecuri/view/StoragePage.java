package fr.gosecuri.view;
import javax.swing.JPanel;
import javax.swing.JButton;

public class StoragePage extends JPanel {
    private final int buttonWidth = 100;
    private final int buttonHeight = 40;
    private final String buttonName = "Revenir";
    protected JButton button;

    public StoragePage() {
        button = new JButton(buttonName);
        button.setBounds(50, 50, buttonWidth, buttonHeight);

        add(button);
    }
}
