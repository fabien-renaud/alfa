package fr.gosecuri.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage {
    private JFrame mainFrame;
    private String pageName = "Storage";
    private int frameWidth = 800;
    private int frameHeight = 600;

    private JPanel mainPanel;
    private AuthenticationPage authenticationPage = new AuthenticationPage();
    private StoragePage storagePage = new StoragePage();

    private CardLayout cl = new CardLayout(2,2);

    public MainPage() {
        mainFrame = new JFrame(pageName);
        mainPanel = new JPanel(cl);

        mainPanel.add(authenticationPage, "Authentication");
        mainPanel.add(storagePage, "Storage");

        ActionListener al = new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                if (pageName.equals("Authentication")) {
                    pageName = "Storage";
                } else if (pageName.equals("Storage")) {
                    pageName = "Authentication";
                }
                mainFrame.setTitle(pageName);
                cl.show(mainPanel, pageName);
            }
        };

        storagePage.button.addActionListener(al);
        authenticationPage.button.addActionListener(al);

        cl.show(mainPanel, pageName);
        mainFrame.setSize(frameWidth, frameHeight);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
}
