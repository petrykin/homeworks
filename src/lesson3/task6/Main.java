package lesson3.task6;

public class Main {
    public static void main(String[] args) {
        new TypeCastingTable().printCastingResults();

        byte aByte = 74;
        new PByte(aByte).printCastingResults();

        short aShort = 300;
        new PShort(aShort).printCastingResults();

        char aChar = '\u2764';
        new PChar(aChar).printCastingResults();

        int anInt = -75000;
        new PInt(anInt).printCastingResults();

        long aLong = 123456789L;
        new PLong(aLong).printCastingResults();

        float aFloat = 175.6543f;
        new PFloat(aFloat).printCastingResults();

        double aDouble = -455.5865465656565654654654;
        new PDouble(aDouble).printCastingResults();
    }
}
