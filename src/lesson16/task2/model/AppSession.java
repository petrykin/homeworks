package lesson16.task2.model;

import java.util.HashMap;
import java.util.Map;

public class AppSession {
    private Map<String, User> users;
    private User currentUser;
    private UserType type;
    private Category currentCategory;

    public AppSession() {
        currentUser = new User();
        type = UserType.GUEST;
        users = new HashMap<>();
        users.put(currentUser.getLogin(), currentUser);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public Category getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(Category currentCategory) {
        this.currentCategory = currentCategory;
    }

    public boolean isGuest() {
        return type.equals(UserType.GUEST);
    }

    public User newUser(String login, String password) {
        if (users.containsKey(login)) {
            currentUser = users.get(login);
        } else {
            currentUser = new User(login, password);
            users.put(login, currentUser);
        }
        type = currentUser.getLogin().equals("") ? UserType.GUEST : UserType.USER;
        return currentUser;
    }

    public String getCurrentUserName() {
        return type.equals(UserType.GUEST) ? "гость" : currentUser.getLogin();
    }
}
