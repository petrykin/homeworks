package lesson6.task5.binary;

public class BinaryLight {
    private int currentState;

    public BinaryLight() {
        currentState = 0b00000000_11111111_00000000_11111111;
    }

    public void blink() {
        currentState = ~currentState;
    }

    public int getCurrentState() {
        return currentState;
    }

    public boolean isSwitchedOn(int position) {
        int positionMask = 1 << (position - 1);
        return (currentState & positionMask) == positionMask;
    }

    public void setCurrentState(int initialState) {
        currentState = initialState;
    }

    public void shift() {
        int signBitMask = Integer.reverse(1);
        switch (currentState & 1) {
            case 0:
                currentState >>>= 1;
                break;
            case 1:
                currentState = (currentState >>> 1) | signBitMask;
        }
    }
}
