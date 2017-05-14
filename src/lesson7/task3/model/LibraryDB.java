package lesson7.task3.model;

import java.util.HashMap;

public class LibraryDB {
    private HashMap<Integer, User> usrMap;
    private static int userID;

    public LibraryDB() {
        usrMap = new HashMap<>();
    }

    public boolean addUser(User user) {
        if (!usrMap.containsValue(user)) {
            usrMap.put(++userID, user);
            return true;
        } else {
            return false;
        }
    }

    public User getUser(int id) {
        if (usrMap.containsKey(id)) {
            return usrMap.get(id);
        } else {
            return null;
        }
    }
}
