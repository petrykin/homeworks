package lesson7.task4.com.company.details;

public class Engine {
    private String manufacturer;
    private String model;
    private double power;

    public Engine(String manufacturer, String model, double power) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Engine model = " + getModel() + "\n" +
                "Engine power = " + getPower() + "\n";
    }
}
