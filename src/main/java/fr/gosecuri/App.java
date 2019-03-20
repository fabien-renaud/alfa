package fr.gosecuri;

import fr.gosecuri.controller.AuthenticationController;
import fr.gosecuri.controller.StorageController;
import fr.gosecuri.view.AuthenticationPage;
import fr.gosecuri.view.LoadingPage;
import fr.gosecuri.view.MainPage;
import fr.gosecuri.view.StoragePage;

public class App {
    public static void main(String... args) {
        // Views instantiations
        LoadingPage loadingPage = new LoadingPage();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        StoragePage storagePage = new StoragePage();
        MainPage mainPage = new MainPage(loadingPage, authenticationPage, storagePage);

        // Controllers instantiations
        StorageController storageController = new StorageController(storagePage, mainPage);
        AuthenticationController authenticationController = new AuthenticationController(storageController, authenticationPage, mainPage);
    }
}
