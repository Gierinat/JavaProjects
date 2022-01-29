package utils;

import java.util.Scanner;

public class KeyInputReceiver implements Inputable {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public String getInput() {
        return scanner.nextLine();
    }

    @Override
    public int getIntValue() {
        int integer = 0;

        if (scanner.hasNextInt()) {
            integer = scanner.nextInt();
        }
        scanner.nextLine();
        return integer;
    }
}
