package utils;

public class ConsolePrinter implements Printer {
    @Override
    public void simpleDisplay(String singleString) {
        System.out.println(singleString);
    }

    @Override
    public void sideBySideDisplay() {

    }
}
