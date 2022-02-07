package game.utils;

import java.util.Scanner;

public class InputReceiver implements Receiver {

    final private Scanner scanner = new Scanner(System.in);
    final private Logger logger;
    final private InputValidator validator;

    public InputReceiver(Logger logger, InputValidator validator) {
        this.logger = logger;
        this.validator = validator;
    }


    @Override
    public String receive() {
        return scanner.nextLine();
    }

    @Override
    public int receive(int rangeFrom, int rangeTo) {

        String input;
        do {
            input = scanner.nextLine();
            logger.log("User input: \"" + input + "\"", this.toString(), String.valueOf(this.hashCode()));
        } while (!validator.validNumber(input, rangeFrom, rangeTo));

        return Integer.parseInt(input);
    }
}
