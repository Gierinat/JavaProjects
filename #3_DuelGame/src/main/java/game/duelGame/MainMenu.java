package game.duelGame;

import game.MainMenuOptionsEnum;
import game.utils.Logger;
import game.utils.Printer;
import game.utils.Receiver;

public class MainMenu extends GameBase {

    public MainMenu(Logger logger, Printer printer, Receiver input) {
        super(logger, printer, input);
    }

    public void run() {
        log("Game Started.");
        printer.printTitle("Welcome to Duel Game!!!");

        MainMenuOptionsEnum menuChoice;
        do {
            printer.printTitle("Duel Game Main Menu");
            displayMenu();

            int inputChoice = receiver.receive(1, MainMenuOptionsEnum.values().length);
            menuChoice = MainMenuOptionsEnum.fromNumber(inputChoice);

            switch (menuChoice) {
                case NEW_GAME: {
                    log("New Game chosen.");
                    new DuelStarter(printer, receiver, logger).run();
                    break;
                }
                case EXIT: {
                    log("Exit chosen.");
                    break;
                }
                default: {
                    log("Not implemented option chosen.");
                    printer.printLine("No such option, please choose again.\n");
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
