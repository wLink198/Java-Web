package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Feedback {
    public int userId;
    public String feedback;
    public User user;
    HashMap<String, String> errors = new HashMap<>();

    public Feedback() {
    }

    public Feedback(int userId, String feedback, User user) {
        this.userId = userId;
        this.feedback = feedback;
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isValid() {
        checkError();
        return this.errors.size() == 0;
    }

    public void checkError() {
        if (this.feedback == null || this.feedback.length() == 0) {
            this.errors.put("fb", "cannot null");
        }
        else if (this.feedback.length() < 2 || this.feedback.length() > 20) {
            this.errors.put("fb", "fb: 2~20 ok");
        }
    }

    public HashMap<String, String> getError() {
        return this.errors;
    }
}
