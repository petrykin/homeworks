package lesson10.task5;

public class Caisse implements Instrument {
    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public  void play() {
        System.out.println("Играет барабан");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Caisse)) return false;

        Caisse caisse = (Caisse) o;

        return size != null ? size.equals(caisse.size) : caisse.size == null;
    }

    @Override
    public int hashCode() {
        return size != null ? size.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Caisse{" +
                "size='" + size + '\'' +
                '}';
    }
}
