package entity;

import java.util.HashMap;

public class Phone {
    public String name;
    public String brand;
    public int price;
    public String description;
    HashMap<String, String> errors = new HashMap<>();

    public Phone(String name, String brand, int price, String description) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public Phone() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValid() {
        checkError();
        return this.errors.size() == 0;
    }

    public void checkError() {
        if (this.name == null || this.name.length() == 0) {
            this.errors.put("name", "cannot null");
        }
        if (this.brand == null || this.brand.length() == 0) {
            this.errors.put("brand", "cannot null");
        }
        if (this.price < 1) {
            this.errors.put("price", "cannot null");
        }
        if (this.description == null || this.description.length() == 0) {
            this.errors.put("description", "cannot null");
        }
    }

    public HashMap<String, String> getError() {
        return this.errors;
    }
}
