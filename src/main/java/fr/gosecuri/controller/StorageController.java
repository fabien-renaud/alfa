package fr.gosecuri.controller;

import fr.gosecuri.view.StoragePage;

public class StorageController {
    private StoragePage storagePage;

    public StorageController(StoragePage storagePage) {
        this.storagePage = storagePage;
    }

    public StoragePage getStoragePage() {
        return storagePage;
    }
    public void setStoragePage(StoragePage storagePage) {
        this.storagePage = storagePage;
    }
}
