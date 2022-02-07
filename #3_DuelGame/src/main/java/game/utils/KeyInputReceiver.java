package game.utils;

import java.util.Scanner;

public class KeyInputReceiver implements Inputable {
    static Scanner scanner = new Scanner(System.in);
    Loggable logger;

    public KeyInputReceiver(Loggable logger) {
        this.logger = logger;
    }

    @Override
    public String getInput() {
        String input = scanner.nextLine();
        logger.log("User input: \"" + input + "\"", this.toString(), String.valueOf(this.hashCode()));
        return input;
    }

    @Override
    public int getIntValue() {
        int integer = 0;
        String input = scanner.nextLine();
        logger.log("User input: \"" + input + "\"", this.toString(), String.valueOf(this.hashCode()));

        try {
            integer = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            logger.log(e.getMessage(), this.toString(), String.valueOf(this.hashCode()));
            e.printStackTrace(logger.getPrintStream());
        }

        return integer;
    }
}
