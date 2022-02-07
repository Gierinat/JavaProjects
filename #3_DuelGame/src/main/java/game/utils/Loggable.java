package game.utils;

import java.io.PrintStream;

public interface Loggable {

    void log(String message, String objectToString, String objectHash);

    PrintStream getPrintStream();

}
