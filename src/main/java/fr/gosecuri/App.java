package fr.gosecuri;

import fr.gosecuri.controller.AuthenticationController;
import fr.gosecuri.controller.MainController;
import fr.gosecuri.controller.StorageController;
import fr.gosecuri.view.AuthenticationPage;
import fr.gosecuri.view.MainPage;
import fr.gosecuri.view.StoragePage;

public class App {
    public static void main(String... args) {
        // Views instantiations
        AuthenticationPage authenticationPage = new AuthenticationPage();
        StoragePage storagePage = new StoragePage();
        MainPage mainPage = new MainPage(authenticationPage, storagePage);

        // Controllers instantiations
        AuthenticationController authenticationController = new AuthenticationController(authenticationPage);
        StorageController storageController = new StorageController(storagePage);
        MainController mainController = new MainController(mainPage);
    }
}
