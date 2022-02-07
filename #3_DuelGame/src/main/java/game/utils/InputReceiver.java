package game.utils;

import java.util.Scanner;

public class InputReceiver implements Receiver {

    final static Scanner scanner = new Scanner(System.in);
    Logger logger;

    public InputReceiver(Logger logger) {
        this.logger = logger;
    }

    @Override
    public int receive() {
        int integer = 0;
        String input = scanner.nextLine();
        logger.log("User input: \"" + input + "\"", this.toString(), String.valueOf(this.hashCode()));

        try {
            integer = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            logger.log(e.getMessage(), this.toString(), String.valueOf(this.hashCode()));
            e.printStackTrace(logger.getPrintStream());
        }

        return integer;
    }
}
