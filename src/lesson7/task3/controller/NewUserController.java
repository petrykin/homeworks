package lesson7.task3.controller;

import lesson7.task3.gui.LibraryChoiceFrame;
import lesson7.task3.model.LibraryDB;
import lesson7.task3.model.User;

import java.time.LocalDate;

public class NewUserController {
    private LibraryDB dataBase;
    private User user;
    private LibraryChoiceFrame libraryChoiceFrame;

    public NewUserController(LibraryChoiceFrame libraryChoiceFrame) {
        this.dataBase = new LibraryDB();
        this.libraryChoiceFrame = libraryChoiceFrame;
    }

    public void addUserToDB(String surName, String name, String fatherName, String birthDayString) {
        String[] bd = birthDayString.split("/");
        user = new User(surName, name, fatherName, LocalDate.of(Integer.parseInt(bd[2]), Integer.parseInt(bd[1]), Integer.parseInt(bd[0])));
        dataBase.addUser(user);
    }

    public void setUserData(String id, String faculty, String phoneNumber) {
        user.setFaculty(faculty);
        user.setPhoneNumber(phoneNumber);
        user.setLibraryCardNumber(Integer.parseInt(id));
    }

    public void printInfo() {
        StringBuilder info = new StringBuilder();
        info.append(user.getLibraryCardNumber());
        info.append("  ");
        info.append(user.getSurName());
        info.append("  ");
        info.append(user.getName());
        info.append("  ");
        info.append(user.getFatherName());
        info.append("  ");
        info.append(user.getBirthDay());
        info.append("  ");
        info.append(user.getFaculty());
        info.append("  ");
        info.append(user.getPhoneNumber());
        info.append("\n");
        libraryChoiceFrame.setNewInfo(info.toString());
    }
}
