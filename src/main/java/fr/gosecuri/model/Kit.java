package fr.gosecuri.model;

import fr.gosecuri.config.Firebase;

public class Kit extends Firebase {
    public String name;

    public Integer quantity;

    public Kit() {}

    public Kit(String name) {
        this.name = name;

        this.quantity = Integer.parseInt(this.get(name));
    }
}
