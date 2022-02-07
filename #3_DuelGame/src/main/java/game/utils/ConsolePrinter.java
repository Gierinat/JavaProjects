package game.utils;

import java.io.PrintStream;

public class ConsolePrinter implements Printer {

    private final PrintStream printStream;

    public ConsolePrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void printLine(String singleString) {
        System.out.println(singleString);
    }

    @Override
    public void sideBySideDisplay() {
    }

    @Override
    public void printTitle(String title) {
        System.out.println("\n".repeat(5));
        System.out.println("-".repeat(80));
        System.out.println(title.toUpperCase());
        System.out.println("-".repeat(80));
    }
}
