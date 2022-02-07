package game.utils;

public class ConsolePrinter implements Printable {
    @Override
    public void singleDisplay(String singleString) {
        System.out.println(singleString);
    }

    @Override
    public void sideBySideDisplay() {
    }

    @Override
    public void displayTitle(String title) {
        System.out.println("\n".repeat(5));
        System.out.println("-".repeat(80));
        System.out.println(title.toUpperCase());
        System.out.println("-".repeat(80));
    }
}
