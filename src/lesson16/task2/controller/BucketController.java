package lesson16.task2.controller;

import lesson16.task2.model.Bucket;
import lesson16.task2.model.User;

import java.io.*;

public class BucketController {
    public static boolean serializeBucket(User user) {
        String fileName = "/home/storm/Documents/uits/homeworks/src/lesson16/task2/serializes/" + user.getLogin() + "Bucket.ser";
        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream os = new ObjectOutputStream(fos)
        ) {
            os.writeObject(user.getBucket());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean deserializeBucket(User user) {
        String fileName = "/home/storm/Documents/uits/homeworks/src/lesson16/task2/serializes/" + user.getLogin() + "Bucket.ser";
        try (
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream is = new ObjectInputStream(fis)
        ) {
            user.setBucket((Bucket) is.readObject());
            return true;
        } catch (IOException | ClassNotFoundException e) {
            return false;
        }
    }
}
