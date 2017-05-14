package lesson6.task5.array;

public class ArrayLight {
    private int[] currentState;
    public static final int NUMBER_OF_LIGHTS = 32;

    public ArrayLight() {
        currentState = new int[NUMBER_OF_LIGHTS];
        for (int i = 0; i < NUMBER_OF_LIGHTS; i++) {
            if (7 < i && i < 16 || i > 23) {
                currentState[i] = 1;
            }
        }
    }

    public void blink() {
        for (int i = 0; i < NUMBER_OF_LIGHTS; i++) {
            switch (currentState[i]) {
                case 0:
                    currentState[i] = 1;
                    break;
                case 1:
                    currentState[i] = 0;
            }
        }
    }

    public String getCurrentState() {
        return toString();
    }

    public boolean isSwitchedOn(int position) {
        return currentState[position] == 1;
    }

    public void setCurrentState(int[] initialState) {
        currentState = initialState;
    }

    public void shift() {
        int tmp = currentState[currentState.length - 1];
        System.arraycopy(currentState, 0, currentState, 1, currentState.length - 1);
        currentState[0] = tmp;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_LIGHTS; i++) {
            s.append(currentState[i]);
        }
        return s.toString();
    }
}
