package lesson9.task2;

import lesson7.task4.com.company.details.Engine;
import lesson7.task4.com.company.professions.Driver;
import lesson7.task4.com.company.vehicles.Car;

public class Lorry extends Car{
    private int carryWeight;

    public Lorry(String modelName, String modelClass, double weight, Driver driver, Engine engine, int carryWeight) {
        super(modelName, modelClass, weight, driver, engine);
        this.carryWeight = carryWeight;
    }

    public int getLoadCarrying() {
        return carryWeight;
    }

    @Override
    public String toString() {
        return super.toString() +
                "carryWeight = " + carryWeight + " tonne\n";
    }
}
