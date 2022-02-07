package game.data;

public enum MainMenuOptionsEnum {

    NEW_GAME("New Duel", 1),
    SETTINGS("Settings", 2),
    SCORES("Scores", 3),
    CREDITS("Credits", 4),
    EXIT("Exit", 5);

    private final String label;
    private final int number;

    MainMenuOptionsEnum(String label, int number) {
        this.label = label;
        this.number = number;
    }

    @Override
    public String toString() {
        return number +
                ". " +
                label;
    }

    public static MainMenuOptionsEnum fromNumber(int number) throws NullPointerException {
        for (MainMenuOptionsEnum option : MainMenuOptionsEnum.values()) {
            if (option.number == number) {
                return option;
            }
        }
        throw new NullPointerException("No such option for: " + MainMenuOptionsEnum.class.getSimpleName());
    }
}
