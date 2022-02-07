package game.duelGame;

import game.DuelOptionsEnum;
import game.utils.Receiver;
import game.utils.Logger;
import game.utils.Printer;

import static game.DuelOptionsEnum.BACK;
import static game.DuelOptionsEnum.fromNumber;

public class Duel extends GameBase {

    Duel(Printer printer, Receiver input, Logger logger) {
        super(logger, printer, input);
    }

    void run() {
        log("New Duel settings entered");


        DuelOptionsEnum menuChoice;
        do {
            printer.printTitle("New Duel Settings");
            displayMenu();
            menuChoice = null;

            while (menuChoice == null) {
                try {
                    int inputChoice = input.receive();
                    menuChoice = fromNumber(inputChoice);
                } catch (NullPointerException e) {
                    log(e.getMessage());
                    e.printStackTrace(logger.getPrintStream());
                    printer.printLine("No such option.\n");
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
                    printer.printLine("Option not yet implemented.\n");
                }
            }

        } while (!menuChoice.equals(BACK));
    }

    private void displayMenu() {
        for (DuelOptionsEnum option : DuelOptionsEnum.values()) {
            printer.printLine(option.toString());
        }
    }
}
