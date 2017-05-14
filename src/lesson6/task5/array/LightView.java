package lesson6.task5.array;

import java.util.Scanner;

public class LightView {
    private ArrayController controller;

    public enum Mode {BLINK, SHIFT, CHECK, SETUP}

    public LightView() {
        this.controller = new ArrayController(this);
    }

    private int getUserNextInt() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            printReadIntErrorMessage();
            scanner.next();
        }
        return scanner.nextInt();
    }

    private String getUserNextLine() {
        return new Scanner(System.in).nextLine();
    }

    private void printChooseDialog() {
        System.out.println("\nCHOOSE MODE, PLEASE:");
        System.out.println("1 - set light state");
        System.out.println("2 - blinking");
        System.out.println("3 - shifting");
        System.out.println("4 - check lamps");
        System.out.println("\n0 - exit");
    }

    public void printCurrentState(String state) {
        System.out.println(toGraphicalView(state));
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printLampState(String lampOrderedNumber, boolean isSwitchedOn) {
        if (isSwitchedOn) {
            System.out.println(lampOrderedNumber + " lamp is turned on - " + '\u263C');
        } else {
            System.out.println(lampOrderedNumber + " lamp is turned off - " + '\u2688');
        }
    }

    public void printModeDescription(Mode mode) {
        switch (mode) {
            case SETUP:
                System.out.println("THERE IS LIGHTS VIEW NOW:");
                break;
            case BLINK:
                System.out.println("BLINKING MODE HAS SWITCHED ON");
                break;
            case SHIFT:
                System.out.println("SHIFTING MODE HAS SWITCHED ON");
                break;
            case CHECK:
                System.out.println("LAMPS STATE:");

        }
    }

    public void printModeErrorMessage() {
        System.out.println("You've entered incorrect mode");
    }

    public void printPositionErrorMessage(String incorrectPosition) {
        System.out.println('<' + incorrectPosition + '>' + " isn't a correct lamp position.");
    }

    public void printReadIntErrorMessage() {
        System.out.println("You've entered incorrect number, it must be integer. Try again:");
    }

    public void requestUserMode() {
        printChooseDialog();
        try {
            switch (Integer.parseInt(new Scanner(System.in).next())) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Enter initial state of lights, please:");
                    controller.startSetupMode(getUserNextInt());
                    break;
                case 2:
                    System.out.println("Enter duration, please:");
                    controller.startBlinkMode(getUserNextInt());
                    break;
                case 3:
                    System.out.println("Enter duration, please:");
                    controller.startShiftMode(getUserNextInt());
                    break;
                case 4:
                    System.out.println("Enter lights numbers, please:");
                    controller.startCheckMode(getUserNextLine());
                    break;
                default:
                    printModeErrorMessage();
            }
        } catch (NumberFormatException e) {
            printModeErrorMessage();
        }
    }

    private String toGraphicalView(String currentState) {
        String graphicalView = "";
        for (int i = 0; i < 32; i++) {
            switch (currentState.charAt(i)) {
                case '1':
                    graphicalView += '\u263C';
                    break;
                case '0':
                    graphicalView += '\u2688';
                    break;
            }
            if (i < currentState.length() - 1) {
                graphicalView += '\u2014';
            }
        }
        return graphicalView;
    }
}
