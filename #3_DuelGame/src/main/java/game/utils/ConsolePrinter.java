package game.utils;

import game.model.Character;
import game.model.Player;

import java.io.PrintStream;
import java.util.List;

public class ConsolePrinter implements Printer {
    // TODO: 23.02.2022 Parametrize 80 chars screen length
    private final PrintStream printStream;

    public ConsolePrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void printLine(String singleString) {
        printStream.println(singleString);
    }

    @Override
    public void printPartLine(String partLine) {
        printStream.print(partLine);
    }

    @Override
    public void sideBySidePlayerDisplay(List<Player> players) {
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        int playersDistance = 80 - player1.toString().length() - player2.toString().length();

        printPartLine(player1.toString());
        printPartLine(" ".repeat(playersDistance));
        printPartLine(player2.toString());
        printLine("");

        for (int i = 0; i < 2; i++) {
            Character player1Character = player1.characters.get(i);
            Character player2Character = player2.characters.get(i);
            String characterOrdinal = i + 1 + ". ";
            int charactersDistance = 80 - characterOrdinal.length() * 2
                    - player1Character.toStringWithStats().length()
                    - player2Character.toStringWithStats().length();

            printPartLine((i + 1) + ". " + player1.characters.get(i).toStringWithStats());
            printPartLine(" ".repeat(charactersDistance));
            printPartLine((i + 1) + ". " + player2.characters.get(i).toStringWithStats());
            printLine("");
        }
    }

    @Override
    public void printTitle(String title) {
        printStream.println("\n".repeat(2));
        printStream.println("-".repeat(80));
        printStream.println(title.toUpperCase());
        printStream.println("-".repeat(80));
    }

    @Override
    public void printSubTitle(String subTitle) {
        printStream.println(subTitle);
        printStream.println("-".repeat(80));
    }

    @Override
    public void printDivider() {
        printStream.println("-".repeat(80));
    }
}
