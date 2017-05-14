package lesson3.task6;

public class PInt implements Primitive {
    private int anInt;

    public PInt(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public void printCastingResults() {
        byte int2Byte = (byte) anInt;
        short int2Short = (short) anInt;
        char int2Char = (char) anInt;
        long int2Long = anInt;
        float int2Float = anInt;
        double int2Double = anInt;

        System.out.println("Base type is int: i = " + anInt);
        System.out.println("From int to byte:      castedByte   = (byte) i ---> " + int2Byte);
        System.out.println("From int to short:     castedShort  = (short)i ---> " + int2Short);
        System.out.println("From int to char:      castedChar   = (char) i ---> " + int2Char + "(" + (int) int2Char + ")");
        System.out.println("From int to int:       castedInt    =        i ---> " + anInt);
        System.out.println("From int to long:      castedLong   =        i ---> " + int2Long);
        System.out.println("From int to float:     castedFloat  =        i ---> " + int2Float);
        System.out.println("From int to double:    castedDouble =        i ---> " + int2Double);
        System.out.println("From int to boolean:   Can't be casted to boolean type!\n");
    }
}
