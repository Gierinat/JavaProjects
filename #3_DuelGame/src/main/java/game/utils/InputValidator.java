package game.utils;

public class InputValidator {

    private final Logger logger;
    private final Printer printer;

    public InputValidator(Logger logger, Printer printer) {
        this.logger = logger;
        this.printer = printer;
    }

    public boolean validNumber(String input, int rangeFrom, int rangeTo) {

        int integerInput;
        try {
            integerInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            logger.log(e.getMessage(), this.toString(), String.valueOf(this.hashCode()));
            e.printStackTrace(logger.getPrintStream());
            printer.printLine("Please input a correct number.");
            return false;
        }
        if (integerInput >= rangeFrom && integerInput <= rangeTo) {
            return true;
        }
        logger.log("Please input a correct number.", this.toString(), String.valueOf(this.hashCode()));
        printer.printLine("Please input a correct number.");
        return false;
    }
}
