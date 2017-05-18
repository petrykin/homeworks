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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        if (Double.compare(engine.power, power) != 0) return false;
        if (!manufacturer.equals(engine.manufacturer)) return false;
        return model.equals(engine.model);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = manufacturer.hashCode();
        result = 31 * result + model.hashCode();
        temp = Double.doubleToLongBits(power);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "engine's model = " + getModel() + "\n" +
                "engine's power = " + getPower() + "\n";
    }
}
