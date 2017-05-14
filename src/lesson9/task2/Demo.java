package lesson9.task2;

import lesson7.task4.com.company.details.Engine;
import lesson7.task4.com.company.professions.Driver;

public class Demo {
    public static void main(String[] args) {
        Driver lorryDriver = new Driver("Ivanov Petr Sidorovich", 40);
        lorryDriver.setWorkExperience(17);
        Engine lorryEngine = new Engine("Nissan", "VG30DET", 353.0);
        Lorry lorry = new Lorry("Nissan atlas","Truck",2515, lorryDriver, lorryEngine, 35);

        Driver sportDriver = new Driver("Tregub Nestor Mahnovich", 27);
        sportDriver.setWorkExperience(7);
        Engine sportEngine = new Engine("Nissan", "VR38DETT twin-turbo V6", 255.0);
        SportCar sportCar = new SportCar("Nissan GT-R","Sport car (S)",1740, sportDriver, sportEngine, 193.1);

        System.out.println("Lorry's info:");
        System.out.print(lorry);
        System.out.print(lorry.getEngine());
        System.out.println(lorry.getDriver());

        System.out.println("Sport car's info:");
        System.out.print(sportCar);
        System.out.print(sportCar.getEngine());
        System.out.println(sportCar.getDriver());
    }
}
