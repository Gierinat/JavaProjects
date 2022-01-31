package duelGame;

import data.MainMenuOptionsEnum;
import utils.Loggable;

import static data.MainMenuOptionsEnum.EXIT;
import static data.MainMenuOptionsEnum.fromNumber;

public class DuelGame extends GameDisplay {

    public DuelGame(Loggable logger) {
        super(logger);
    }

    public void run() {
        log("Game Started.");
        printer.displayTitle("Welcome to Duel Game!!!");

        MainMenuOptionsEnum menuChoice;
        do {
            printer.displayTitle("Duel Game Main Menu");
            displayMenu();
            menuChoice = null;

            while (menuChoice == null) {
                try {
                    int inputChoice = input.getIntValue();
                    menuChoice = fromNumber(inputChoice);
                } catch (NullPointerException e) {
                    log(e.getMessage());
                    e.printStackTrace(logger.getPrintStream());
                    printer.singleDisplay("No such option.\n");
                    displayMenu();
                }
            }

            switch (menuChoice) {
                case NEW_GAME: {
                    log("New Game chosen.");
                    Duel duel = new Duel(printer, input, logger);
                    duel.run();
                    break;
                }
                case EXIT: {
                    log("Exit chosen.");
                    break;
                }
                default: {
                    log("Not implemented option chosen.");
                    printer.singleDisplay("Option not yet implemented.\n");
                }
            }
        } while (!menuChoice.equals(EXIT));
    }

    private void displayMenu() {
        for (MainMenuOptionsEnum option : MainMenuOptionsEnum.values()) {
            printer.singleDisplay(option.toString());
        }
    }

}
