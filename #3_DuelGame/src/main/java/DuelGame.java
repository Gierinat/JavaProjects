import data.MainMenuOptionsEnum;
import utils.ConsolePrinter;
import utils.Logger;
import utils.Printer;

import java.util.Scanner;

import static data.MainMenuOptionsEnum.*;

public class DuelGame {
    Logger logger;
    Printer printer = new ConsolePrinter();
    static Scanner scanner = new Scanner(System.in);
    private int input;
    private MainMenuOptionsEnum menuChoice;

    public void run() {
        logger.logClass();

        do {
            displayMenu();
            input = getIntValue();
            menuChoice = fromNumber(input);

            switch (menuChoice) {
                case NEW_GAME: {
                    break;
                }
                case EXIT: {
                    break;
                }
                default: {
                    printer.simpleDisplay("No such option.\n");
                }
            }
        } while (!menuChoice.equals(EXIT));
    }

    private void displayMenu() {
        for (MainMenuOptionsEnum option : MainMenuOptionsEnum.values()) {
            printer.simpleDisplay(option.toString());
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

    void setLogger(Logger logger) {
        this.logger = logger;
    }

}
