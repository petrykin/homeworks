package lesson7.task4.com.company;

import lesson7.task4.com.company.details.Engine;
import lesson7.task4.com.company.professions.Driver;
import lesson7.task4.com.company.vehicles.Car;

public class Demo {
    public static void main(String[] args) {
        Driver driver = new Driver("Ivanov Petr Sidorovich", 54);
        driver.setWorkExperience(10);

        Engine engine = new Engine("Nissan", "VG30DET", 255.0);

        Car car = new Car("Nissan Leopard","Mid-size luxury car",1315, driver, engine);

        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();

        System.out.println(car);
    }
}
