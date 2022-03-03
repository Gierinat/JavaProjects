package game.utils;

import game.model.Player;

import java.util.List;

public interface Printer {

    void printLine(String singleString);

    void printPartLine(String partLine);

    void sideBySidePlayerDisplay(List<Player> players);

    void printTitle(String title);

    void printSubTitle(String subTitle);

    void printDivider();
}
