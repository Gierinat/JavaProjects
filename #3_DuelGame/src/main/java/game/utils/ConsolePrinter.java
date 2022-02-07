package game.utils;

import java.io.PrintStream;

public class ConsolePrinter implements Printer {

    private final PrintStream printStream;

    public ConsolePrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void printLine(String singleString) {
        printStream.println(singleString);
    }

    @Override
    public void sideBySideDisplay() {
    }

    @Override
    public void printTitle(String title) {
        printStream.println("\n".repeat(5));
        printStream.println("-".repeat(80));
        printStream.println(title.toUpperCase());
        printStream.println("-".repeat(80));
    }
}
