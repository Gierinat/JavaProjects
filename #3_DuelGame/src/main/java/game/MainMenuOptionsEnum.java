package game;

public enum MainMenuOptionsEnum {

    NEW_GAME("New Duel", 1),
    SETTINGS("Settings", 2),
    SCORES("Scores", 3),
    CREDITS("Credits", 4),
    EXIT("Exit", 5);

    private final String label;
    private final int index;

    MainMenuOptionsEnum(String label, int index) {
        this.label = label;
        this.index = index;
    }

    @Override
    public String toString() {
        return index +
                ". " +
                label;
    }

    public static MainMenuOptionsEnum fromNumber(int number) throws IllegalArgumentException {
        for (MainMenuOptionsEnum option : MainMenuOptionsEnum.values()) {
            if (option.index == number) {
                return option;
            }
        }
        throw new IllegalArgumentException("No such option for: " + MainMenuOptionsEnum.class.getSimpleName());
    }
}
