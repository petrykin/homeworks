package lesson3.task6;

public class PShort implements Primitive {
    private short aShort;

    public PShort(short aShort) {
        this.aShort = aShort;
    }

    @Override
    public void printCastingResults() {
        byte short2Byte = (byte) aShort;
        char short2Char = (char) aShort;
        int short2Int = aShort;
        long short2Long = aShort;
        float short2Float = aShort;
        double short2Double = aShort;

        System.out.println("Base type is short: sh = " + aShort);
        System.out.println("From short to byte:    castedByte   = (byte) sh ---> " + short2Byte);
        System.out.println("From short to short:   castedShort  =        sh ---> " + aShort);
        System.out.println("From short to char:    castedChar   = (char) sh ---> " + short2Char + "(" + aShort + ")");
        System.out.println("From short to int:     castedInt    =        sh ---> " + short2Int);
        System.out.println("From short to long:    castedLong   =        sh ---> " + short2Long);
        System.out.println("From short to float:   castedFloat  =        sh ---> " + short2Float);
        System.out.println("From short to double:  castedDouble =        sh ---> " + short2Double);
        System.out.println("From short to boolean: Can't be casted to boolean type!\n");
    }
}
