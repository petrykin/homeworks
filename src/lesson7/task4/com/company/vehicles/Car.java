package lesson7.task4.com.company.vehicles;

import lesson7.task4.com.company.details.Engine;
import lesson7.task4.com.company.professions.Driver;

public class Car {
    private String modelName;
    private String modelClass;
    private double weight;
    private Driver driver;
    private Engine engine;

    public Car(String modelName, String modelClass, double weight, Driver driver, Engine engine) {
        this.modelName = modelName;
        this.modelClass = modelClass;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelClass() {
        return modelClass;
    }

    public void setModelClass(String modelClass) {
        this.modelClass = modelClass;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        System.out.println("Поехали");
    }

    public void stop() {
        System.out.println("Останавливаемся");
    }

    public void turnRight() {
        System.out.println("Поворот направо");
    }

    public void turnLeft() {
        System.out.println("Поворот налево");
    }

    @Override
    public String toString() {
        return getDriver().toString() + getEngine().toString() +
                "car's model = '" + modelName + "\'\n" +
                "car's class = '" + modelClass + "\'\n" +
                "car's weight = " + weight + "\n";
    }
}
