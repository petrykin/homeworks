package lesson16.task2.model;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    public Map<String, String> getAll() {
        Map<String, String> users = new HashMap<>();
        String fileName = "/home/storm/Documents/uits/homeworks/src/lesson16/task2/model/db/users.db";
        try (
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr)
        ) {
            br.lines().forEach(s -> {
                String[] data = s.split(":");
                users.put(data[0], data[1]);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean insertEntity(User user) {
        if (!getAll().containsKey(user.getLogin())) {
            String fileName = "/home/storm/Documents/uits/homeworks/src/lesson16/task2/model/db/users.db";
            try (
                    FileWriter fw = new FileWriter(fileName, true);
                    BufferedWriter bw = new BufferedWriter(fw)
            ) {
                bw.append("\n" + user.getLogin() + ":" + user.getPassword());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }
}
