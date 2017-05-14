package lesson3.task6;

public class PDouble implements Primitive {
    private double aDouble;

    public PDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    @Override
    public void printCastingResults() {
        byte double2Byte = (byte) aDouble;
        short double2Short = (short) aDouble;
        char double2Char = (char) aDouble;
        int double2Int = (int) aDouble;
        long double2Long = (long) aDouble;
        float double2Float = (float) aDouble;

        System.out.println("Base type is double: d = " + aDouble);
        System.out.println("From double to byte:   castedByte   = (byte) d ---> " + double2Byte);
        System.out.println("From double to short:  castedShort  = (short)d ---> " + double2Short);
        System.out.println("From double to char:   castedChar   = (char) d ---> " + double2Char + "(" + (int) double2Char + ")");
        System.out.println("From double to int:    castedInt    = (int)  d ---> " + double2Int);
        System.out.println("From double to long:   castedLong   = (long) d ---> " + double2Long);
        System.out.println("From double to float:  castedFloat  = (float)d ---> " + double2Float);
        System.out.println("From double to double: castedDouble =        d ---> " + aDouble);
        System.out.println("From double to boolean: Can't be casted to boolean type!\n");
    }
}
