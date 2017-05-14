package lesson3.task6;

public class PFloat implements Primitive {
    private float aFloat;

    public PFloat(float aFloat) {
        this.aFloat = aFloat;
    }

    @Override
    public void printCastingResults() {
        byte float2Byte = (byte) aFloat;
        short float2Short = (short) aFloat;
        char float2Char = (char) aFloat;
        int float2Int = (int) aFloat;
        long float2Long = (long) aFloat;
        double float2Double = aFloat;

        System.out.println("Base type is float: f = " + aFloat);
        System.out.println("From float to byte:    castedByte   = (byte) f ---> " + float2Byte);
        System.out.println("From float to short:   castedShort  = (short)f ---> " + float2Short);
        System.out.println("From float to char:    castedChar   = (char) f ---> " + float2Char + "(" + (int) float2Char + ")");
        System.out.println("From float to int:     castedInt    = (int)  f ---> " + float2Int);
        System.out.println("From float to long:    castedLong   = (long) f ---> " + float2Long);
        System.out.println("From float to float:   castedFloat  =        f ---> " + aFloat);
        System.out.println("From float to double:  castedDouble =        f ---> " + float2Double);
        System.out.println("From float to boolean: Can't be casted to boolean type!\n");
    }
}
