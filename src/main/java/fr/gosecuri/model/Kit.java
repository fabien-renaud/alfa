package fr.gosecuri.model;

import fr.gosecuri.config.Firebase;

public class Kit extends Firebase {
    public String name;

    public Integer quantity = 1;

    public Kit() {}

    public Kit(String name) {
        this.name = name;

        //this.quantity = Integer.parseInt(this.get(name));
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void operationItem(Integer number, String operation) {
        try {
            if (number > 0) {
                if (operation == "add") {
                    quantity += number;
                } else {

                    if (quantity >= number) {
                        quantity -= number;
                    } else {
                        throw new Exception("Quantité négative !");
                    }

                }

                store(name, quantity);
            } else {
                throw new Exception("Quantité doit être supérieur à 0 !");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addItem(Integer number) {
        operationItem(number, "add");
    }

    public void takeItem(Integer number) {
        operationItem(number, "take");
    }
}
