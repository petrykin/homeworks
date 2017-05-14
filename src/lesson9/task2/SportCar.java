package lesson9.task2;

import lesson7.task4.com.company.details.Engine;
import lesson7.task4.com.company.professions.Driver;
import lesson7.task4.com.company.vehicles.Car;

public class SportCar extends Car{
    private double maxSpeed;

    public SportCar(String modelName, String modelClass, double weight, Driver driver, Engine engine, double maxSpeed) {
        super(modelName, modelClass, weight, driver, engine);
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return super.toString() +
                "maxSpeed = " + maxSpeed + " km/h\n";
    }
}
