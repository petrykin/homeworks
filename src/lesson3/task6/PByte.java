package lesson3.task6;

public class PByte implements Primitive {
    private byte aByte;

    public PByte(byte aByte) {
        this.aByte = aByte;
    }

    @Override
    public void printCastingResults() {
        short byte2Short = aByte;
        char byte2Char = (char) aByte;
        int byte2Int = aByte;
        long byte2Long = aByte;
        float byte2Float = aByte;
        double byte2Double = aByte;

        System.out.println("Base type is byte: b = " + aByte);
        System.out.println("From byte to byte:     castedByte   =        b ---> " + aByte);
        System.out.println("From byte to short:    castedShort  =        b ---> " + byte2Short);
        System.out.println("From byte to char:     castedChar   = (char) b ---> " + byte2Char + "(" + aByte + ")");
        System.out.println("From byte to int:      castedInt    =        b ---> " + byte2Int);
        System.out.println("From byte to long:     castedLong   =        b ---> " + byte2Long);
        System.out.println("From byte to float:    castedFloat  =        b ---> " + byte2Float);
        System.out.println("From byte to double:   castedDouble =        b ---> " + byte2Double);
        System.out.println("From byte to boolean:  Can't be casted to boolean type!\n");
    }
}
