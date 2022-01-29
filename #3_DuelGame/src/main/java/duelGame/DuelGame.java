package duelGame;

import data.MainMenuOptionsEnum;
import utils.PrintStreamLogger;

import java.util.Scanner;

import static data.MainMenuOptionsEnum.EXIT;
import static data.MainMenuOptionsEnum.fromNumber;

public class DuelGame extends GameDisplay {
    static Scanner scanner = new Scanner(System.in);

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
            int input = getIntValue();
            menuChoice = fromNumber(input);

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
                    log("Wrong option chosen.");
                    printer.singleDisplay("No such option.\n");
                }
            }
        } while (!menuChoice.equals(EXIT));
    }

    private void displayMenu() {
        for (MainMenuOptionsEnum option : MainMenuOptionsEnum.values()) {
            printer.singleDisplay(option.toString());
        }
    }

    private static int getIntValue() {
        int integer = 0;

        if (scanner.hasNextInt()) {
            integer = scanner.nextInt();
        }
        scanner.nextLine();
        return integer;
    }

}
