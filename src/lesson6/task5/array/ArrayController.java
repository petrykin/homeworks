package lesson6.task5.array;

import java.util.HashSet;
import java.util.Set;

public class ArrayController {
    private ArrayLight light;
    private LightView view;

    public ArrayController(LightView view) {
        this.light = new ArrayLight();
        this.view = view;
    }

    private String getBinaryPrefix(int length) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 32 - length; i++) {
            s.append('0');
        }
        return s.toString();
    }

    private Set<Integer> getCorrectPositionsList(String userInput) {
        Set<Integer> positions = new HashSet<>();
        for (String s : userInput.split(" ")) {
            try {
                int position = Integer.parseInt(s);
                if (isExistingLampPosition(position)) {
                    positions.add(position);
                } else {
                    view.printPositionErrorMessage(s);
                }
            } catch (NumberFormatException e) {
                view.printPositionErrorMessage(s);
            }
        }
        return positions;
    }

    private String getCurrentState() {
        return light.getCurrentState();
    }

    private String getOrderedNumber(int position) {
        String suffix = "th";
        if (position != 11 && position != 12 && position != 13) {
            switch (position % 10) {
                case 1:
                    suffix = "st";
                    break;
                case 2:
                    suffix = "nd";
                    break;
                case 3:
                    suffix = "rd";
                    break;
            }
        }
        return position + suffix;
    }

    private boolean isExistingLampPosition(int position) {
        return 33 > position && position > 0;
    }

    public void startBlinkMode(int duration) {
        view.printModeDescription(LightView.Mode.BLINK);
        while (duration-- > 0) {
            light.blink();
            view.printCurrentState(getCurrentState());
        }
    }

    public void startCheckMode(String userInput) {
        view.printModeDescription(LightView.Mode.CHECK);
        for (int position : getCorrectPositionsList(userInput)) {
            view.printLampState(getOrderedNumber(position), light.isSwitchedOn(position));
        }
    }

    public void startSetupMode(int initialState) {
        view.printModeDescription(LightView.Mode.SETUP);
        light.setCurrentState(intToBinaryArray(initialState));
        view.printCurrentState(getCurrentState());
    }

    public void startShiftMode(int duration) {
        view.printModeDescription(LightView.Mode.SHIFT);
        while (duration-- > 0) {
            light.shift();
            view.printCurrentState(getCurrentState());
        }
    }

    public int[] intToBinaryArray(int source) {
        int[] result = new int[ArrayLight.NUMBER_OF_LIGHTS];
        String s = Integer.toBinaryString(source);
        s = getBinaryPrefix(s.length()) + s;
        for (int i = 0; i < ArrayLight.NUMBER_OF_LIGHTS; i++) {
            switch (s.charAt(i)) {
                case '0':
                    result[i] = 0;
                    break;
                case '1':
                    result[i] = 1;
            }
        }
        return result;
    }
}