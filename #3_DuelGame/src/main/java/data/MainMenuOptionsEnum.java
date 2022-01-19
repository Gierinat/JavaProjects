package data;

public enum MainMenuOptionsEnum {

    NEW_GAME("New Game", 1),
    SETTINGS("Settings", 2),
    SCORES("Scores", 3),
    CREDITS("Credits", 4),
    EXIT("Exit", 5);

    private String name;
    private int number;

    MainMenuOptionsEnum(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return number +
                ". " +
                name;
    }

    public static MainMenuOptionsEnum fromNumber(int number) {
        for(MainMenuOptionsEnum m : MainMenuOptionsEnum.values()) {
            if(m.number == number) {
                return m;
            }
        }
        return null;
    }
}
