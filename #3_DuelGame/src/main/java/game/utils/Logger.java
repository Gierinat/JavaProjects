package game.utils;

import java.io.PrintStream;

public interface Logger {

    void log(String message, String objectToString, String objectHash);

    PrintStream getPrintStream();

}
