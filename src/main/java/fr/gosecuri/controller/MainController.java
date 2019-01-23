package fr.gosecuri.controller;

import fr.gosecuri.view.MainPage;

public class MainController {
    private MainPage mainPage;

    public MainController(MainPage mainPage) {
        this.mainPage = mainPage;

        AddActionListener();
    }

    private void AddActionListener() {
        mainPage.getStoragePage().getSwitchButton().addActionListener((e) -> SwitchToPage("Authentication"));
        mainPage.getAuthenticationPage().getSwitchButton().addActionListener((e) -> SwitchToPage("Storage"));
    }

    private void SwitchToPage(String pageName) {
        // Check name page authenticity
        if(pageName.equals("Authentication") || pageName.equals("Storage")) {
            // Switch page
            mainPage.setPageName(pageName);
            mainPage.getMainFrame().setTitle(pageName);
            mainPage.getLayout().show(mainPage.getMainPanel(), pageName);
        }
    }

    public MainPage getMainPage() {
        return mainPage;
    }
    public void setMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }
}
