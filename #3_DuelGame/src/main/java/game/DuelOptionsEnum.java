package game;

public enum DuelOptionsEnum {

    SET_PLAYER_1("Set Player 1", 1),
    SET_PLAYER_2("Set Player 2", 2),
    START_DUEL("Start Duel", 3),
    BACK("Back", 4);

    private final String label;
    private final int index;

    DuelOptionsEnum(String label, int index) {
        this.label = label;
        this.index = index;
    }

    public static DuelOptionsEnum fromNumber(int number) throws IllegalArgumentException {
        for (DuelOptionsEnum option : DuelOptionsEnum.values()) {
            if (option.index == number) {
                return option;
            }
        }
        throw new IllegalArgumentException("No such option for: " + DuelOptionsEnum.class.getSimpleName());
    }

    @Override
    public String toString() {
        return index +
                ". " +
                label;
    }
}
