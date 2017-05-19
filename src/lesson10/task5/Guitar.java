package lesson10.task5;

public class Guitar implements Instrument {
    private int cordNumber;

    public int getCordNumber() {
        return cordNumber;
    }

    public void setCordNumber(int cordNumber) {
        this.cordNumber = cordNumber;
    }

    @Override
    public void play() {
        System.out.println("Играет гитара");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guitar)) return false;

        Guitar guitar = (Guitar) o;

        return cordNumber == guitar.cordNumber;
    }

    @Override
    public int hashCode() {
        return cordNumber;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "cordNumber=" + cordNumber +
                '}';
    }
}
