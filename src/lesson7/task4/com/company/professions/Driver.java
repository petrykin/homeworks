package lesson7.task4.com.company.professions;

import lesson7.task1.Person;

public class Driver extends Person {
    private int workExperience;

    public Driver() {
    }

    public Driver(String fullName, int age) {
        super(fullName, age);
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public String toString() {
        return "Driver's name = " + getFullName() + "\n" +
                "Driver's experience = " + getWorkExperience() + " years\n";
    }
}
