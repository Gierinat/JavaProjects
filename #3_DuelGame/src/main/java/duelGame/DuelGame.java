package duelGame;

import data.MainMenuOptionsEnum;
import utils.PrintStreamLogger;

import static data.MainMenuOptionsEnum.EXIT;
import static data.MainMenuOptionsEnum.fromNumber;

public class DuelGame extends GameDisplay {
    public DuelGame(String[] options) {
        if (options.length > 0) {
            if ("-logDEBUG".equals(options[0])) {
                this.logLevel = "DEBUG";
            } else {
                this.logLevel = "INFO";
            }
        } else this.logLevel = "INFO";

        logger = new PrintStreamLogger(logLevel, logPrintStream);
    }


    public void run() {
        log("Game Started.");

        MainMenuOptionsEnum menuChoice;
        do {
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
                case NEW_GAME: {
                    log("New Game chosen.");
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
