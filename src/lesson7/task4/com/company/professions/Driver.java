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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        if (!super.equals(o)) return false;

        Driver driver = (Driver) o;

        return workExperience == driver.workExperience;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + workExperience;
        return result;
    }

    @Override
    public String toString() {
        return "driver's name = " + getFullName() + "\n" +
                "driver's experience = " + getWorkExperience() + " years\n";
    }
}
