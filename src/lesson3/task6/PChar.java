package lesson3.task6;

public class PChar implements Primitive {
    private char aChar;

    public PChar(char aChar) {
        this.aChar = aChar;
    }

    @Override
    public void printCastingResults() {
        byte char2Byte = (byte) aChar;
        short char2Short = (short) aChar;
        int char2Int = aChar;
        long char2Long = aChar;
        float char2Float = aChar;
        double char2Double = aChar;

        System.out.println("Base type is char: ch = " + aChar);
        System.out.println("From char to byte:     castedByte   = (byte) ch ---> " + char2Byte);
        System.out.println("From char to short:    castedShort  = (short)ch ---> " + char2Short);
        System.out.println("From char to char:     castedChar   =        ch ---> " + aChar + "(" + ((int) aChar) + ")");
        System.out.println("From char to int:      castedInt    =        ch ---> " + char2Int);
        System.out.println("From char to long:     castedLong   =        ch ---> " + char2Long);
        System.out.println("From char to float:    castedFloat  =        ch ---> " + char2Float);
        System.out.println("From char to double:   castedDouble =        ch ---> " + char2Double);
        System.out.println("From char to boolean:  Can't be casted to boolean type!\n");
    }
}
