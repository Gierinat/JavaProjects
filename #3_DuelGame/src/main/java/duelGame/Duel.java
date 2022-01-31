package duelGame;

import data.DuelOptionsEnum;
import utils.Inputable;
import utils.Loggable;
import utils.Printable;

import static data.DuelOptionsEnum.BACK;
import static data.DuelOptionsEnum.fromNumber;

public class Duel extends GameDisplay {

    Duel(Printable printer, Inputable input, Loggable logger) {
        this.printer = printer;
        this.input = input;
        this.logger = logger;
    }

    void run() {
        log("New Duel settings entered");


        DuelOptionsEnum menuChoice;
        do {
            printer.displayTitle("New Duel Settings");
            displayMenu();
            menuChoice = null;

            while (menuChoice == null) {
                try {
                    int inputChoice = input.getIntValue();
                    menuChoice = fromNumber(inputChoice);
                } catch (NullPointerException e) {
                    log(e.getMessage());
                    e.printStackTrace(logPrintStream);
                    printer.singleDisplay("No such option.\n");
                    displayMenu();
                }
            }

            switch (menuChoice) {
                case SET_PLAYER_1: {
                    log(".....");
                    break;
                }
                case BACK: {
                    log("Back chosen.");
                    break;
                }
                default: {
                    log("Not implemented option chosen.");
                    printer.singleDisplay("Option not yet implemented.\n");
                }
            }

        } while (!menuChoice.equals(BACK));
    }

    private void displayMenu() {
        for (DuelOptionsEnum option : DuelOptionsEnum.values()) {
            printer.singleDisplay(option.toString());
        }
    }
}
