package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    public String name;
    public String password;
    HashMap<String, ArrayList<String>> errors = new HashMap<>();

    public String getName() {
        return name;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public boolean isValid() {
        checkError();
        return this.errors.size() == 0;
    }

    public void checkError() {
        ArrayList<String> nameErrors;
        ArrayList<String> passErrors;
        nameErrors = this.errors.get("name");
        passErrors = this.errors.get("pass");
        if (nameErrors == null) {
            nameErrors = new ArrayList<>();
        }
        if (passErrors == null) {
            passErrors = new ArrayList<>();
        }

        if (this.name == null || this.name.length() == 0) {
            nameErrors.add("name cannot null");
        }
        if (this.name.length() < 2 || this.name.length() > 20) {
            nameErrors.add("name: 2~20 ok");
        }
        if (this.password == null || this.password.length() == 0) {
            passErrors.add("pass cannot null");
        }
        if (this.password.contains(" ")) {
            passErrors.add("pass cannot contain whitespace");
        }

        if (nameErrors.size() > 0) {
            this.errors.put("name", nameErrors);
        }
        if (passErrors.size() > 0) {
            this.errors.put("pass", passErrors);
        }
    }

    public HashMap<String, ArrayList<String>> getError() {
        return this.errors;
    }
}
