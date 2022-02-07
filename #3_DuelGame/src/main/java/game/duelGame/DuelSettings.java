package game.duelGame;

import game.DuelOptionsEnum;
import game.utils.Logger;
import game.utils.Printer;
import game.utils.Receiver;

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

            int inputChoice = input.receive(1, DuelOptionsEnum.values().length);
            menuChoice = fromNumber(inputChoice);

            switch (menuChoice) {
                case SET_PLAYER_1: {
                    log("Setting Player_1");
                    break;
                }
                case SET_PLAYER_2: {
                    log("Setting Player_2");
                    break;
                }
                case START_DUEL: {
                    log("Duel Started");
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
