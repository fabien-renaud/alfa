package fr.gosecuri.view2;

import fr.gosecuri.controller.MainController;
import fr.gosecuri.view2.AuthenticationPage;
import fr.gosecuri.view2.StoragePage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class MainPage {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private String pageName = "Storage";
    private int frameWidth = 800;
    private int frameHeight = 600;

    private MainController controller;
    private AuthenticationPage authenticationPage;
    private StoragePage storagePage;

    private CardLayout cl = new CardLayout(2,2);

    public MainPage() {
        this.mainFrame = new JFrame(pageName);
        this.mainPanel = new JPanel(cl);

        this.controller = new MainController();
        this.authenticationPage = new AuthenticationPage();
        this.storagePage = new StoragePage();

        mainPanel.add(authenticationPage, "Authentication");
        mainPanel.add(storagePage, "Storage");

        // Ajout des event

        cl.show(mainPanel, pageName);
        mainFrame.setSize(frameWidth, frameHeight);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
}


//    ActionListener al = new ActionListener(){
//        public void actionPerformed(ActionEvent ae) {
//            if (pageName.equals("Authentication")) {
//                pageName = "Storage";
//            } else if (pageName.equals("Storage")) {
//                pageName = "Authentication";
//            }
//            mainFrame.setTitle(pageName);
//            cl.show(mainPanel, pageName);
//        }
//    };
//
//        storagePage.button.addActionListener(al);
//                authenticationPage.button.addActionListener(al);