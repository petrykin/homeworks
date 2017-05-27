package lesson7.task1;

import java.util.Locale;

public class Person {
    private String fullName;
    private int age;
    private Location currentLocation;

    public Person() {
        this("", 0);
    }

    public Person(String fullName) {
        this(fullName, 0);
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int move(Location destinationLocation, double speed) throws InterruptedException {
        double distance = Location.getDistance(currentLocation, destinationLocation);
        int wayTime = 0;
        while (distance > 0) {
            printLeftDistance(distance);
            Thread.sleep(1000);
            distance -= speed;
            wayTime++;
        }
        this.setCurrentLocation(destinationLocation);
        return wayTime;
    }

    private static void printLeftDistance(double distance) {
        System.out.printf(Locale.ROOT, "%d m left to destination point\n", (int) distance);
    }

    public void talk() {
        System.out.printf(Locale.ROOT, "Hello! My name is %s. I am %d years old.\n", this.fullName, this.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return fullName.equals(person.fullName);
    }

    @Override
    public int hashCode() {
        int result = fullName.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }
}
