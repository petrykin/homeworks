package lesson3.task6;

public class PLong implements Primitive {
    private long aLong;

    public PLong(long aLong) {
        this.aLong = aLong;
    }

    @Override
    public void printCastingResults() {
        byte long2Byte = (byte) aLong;
        short long2Short = (short) aLong;
        char long2Char = (char) aLong;
        int long2Int = (int) aLong;
        float long2Float = aLong;
        double long2Double = aLong;

        System.out.println("Base type is long: l = " + aLong);
        System.out.println("From long to byte:     castedByte   = (byte) l ---> " + long2Byte);
        System.out.println("From long to short:    castedShort  = (short)l ---> " + long2Short);
        System.out.println("From long to char:     castedChar   = (char) l ---> " + long2Char + "(" + (int) long2Char + ")");
        System.out.println("From long to int:      castedInt    = (int)  l ---> " + long2Int);
        System.out.println("From long to long:     castedLong   =        l ---> " + aLong);
        System.out.println("From long to float:    castedFloat  =        l ---> " + long2Float);
        System.out.println("From long to double:   castedDouble =        l ---> " + long2Double);
        System.out.println("From long to boolean:  Can't be casted to boolean type!\n");
    }
}
