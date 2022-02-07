package game.duelGame;

import game.MainMenuOptionsEnum;
import game.utils.Logger;
import game.utils.Printer;
import game.utils.Receiver;

public class DuelGame extends GameBase {

    public DuelGame(Logger logger, Printer printer, Receiver input) {
        super(logger, printer, input);
    }

    public void run() {
        log("Game Started.");
        printer.printTitle("Welcome to Duel Game!!!");

        MainMenuOptionsEnum menuChoice;
        do {
            printer.printTitle("Duel Game Main Menu");
            displayMenu();

            int inputChoice = input.receive(1, MainMenuOptionsEnum.values().length);
            menuChoice = MainMenuOptionsEnum.fromNumber(inputChoice);

            switch (menuChoice) {
                case NEW_GAME: {
                    log("New Game chosen.");
                    new Duel(printer, input, logger).run();
                    break;
                }
                case EXIT: {
                    log("Exit chosen.");
                    break;
                }
                default: {
                    log("Not implemented option chosen.");
                    printer.printLine("Option not yet implemented.\n");
                }
            }
        } while (!menuChoice.equals(MainMenuOptionsEnum.EXIT));
    }

    private void displayMenu() {
        for (MainMenuOptionsEnum option : MainMenuOptionsEnum.values()) {
            printer.printLine(option.toString());
        }
    }

}
