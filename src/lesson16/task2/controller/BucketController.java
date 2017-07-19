package lesson16.task2.controller;

import lesson16.task2.model.Bucket;
import lesson16.task2.model.BucketDAO;
import lesson16.task2.model.User;

import java.io.*;

public class BucketController {
    public static boolean serializeBucket(User user, String serFileName) {
        try (FileOutputStream fos = new FileOutputStream(serFileName);
             ObjectOutputStream os = new ObjectOutputStream(fos)) {
            os.writeObject(user.getBucket());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean deserializeBucket(User user, String serFileName) {
        try (FileInputStream fis = new FileInputStream(serFileName);
             ObjectInputStream is = new ObjectInputStream(fis)) {
            user.setBucket((Bucket) is.readObject());
            return true;
        } catch (IOException | ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean serializeBucket(User user) {
        return BucketDAO.saveBucketState(user);
    }

    public static boolean deserializeBucket(User user) {
        return BucketDAO.restoreBucketState(user);
    }
}
