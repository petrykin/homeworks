package lesson6.task5.binary;

import java.util.HashSet;
import java.util.Set;

public class BinaryController {
    private BinaryLight light;
    private LightView view;

    public BinaryController(LightView view) {
        this.light = new BinaryLight();
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
        String s = Integer.toBinaryString(light.getCurrentState());
        return getBinaryPrefix(s.length()) + s;
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
        light.setCurrentState(initialState);
        view.printCurrentState(getCurrentState());
    }

    public void startShiftMode(int duration) {
        view.printModeDescription(LightView.Mode.SHIFT);
        int signBitMask = Integer.reverse(1);
        while (duration-- > 0) {
            light.shift();
            view.printCurrentState(getCurrentState());
        }
    }
}
