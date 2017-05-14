package lesson7.task1;

public class PersonDemo {

    public static void printWayInfo(int wayTime) {
        if (wayTime < 60) {
            System.out.println("The walking continued for " + wayTime + " seconds.\n");
        } else if (3600 > wayTime && wayTime >= 60) {
            System.out.println("The walking continued for " + (wayTime / 60) + " minutes.\n");
        } else if (wayTime >= 3600) {
            System.out.println("The walking continued for " + (wayTime / 3600) + " hours.\n");
        }
    }

    public static void demo(Person person, Location currentLocation, Location destinationLocation, double speed) throws InterruptedException {
        person.talk();
        person.setCurrentLocation(currentLocation);
        Thread.sleep(1000);
        System.out.println(person.getFullName() + " is going to walk.");
        Thread.sleep(1000);
        int wayTime = person.move(destinationLocation, speed);
        printWayInfo(wayTime);
    }

    public static void main(String[] args) {
        Location currentLocation = new Location(49.993230, 36.231891);
        Location destinationLocation = new Location(49.992881, 36.231457);

        try {
            demo(new Person(), currentLocation, destinationLocation, 3);
            demo(new Person("Jenna", 20), currentLocation, destinationLocation, 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
