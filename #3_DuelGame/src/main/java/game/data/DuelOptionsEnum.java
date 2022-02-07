package game.data;

public enum DuelOptionsEnum {

    SET_PLAYER_1("Set Player 1", 1),
    SET_PLAYER_2("Set Player 2", 2),
    START_DUEL("Start Duel", 3),
    BACK("Back", 4);

    private final String label;
    private final int number;

    DuelOptionsEnum(String label, int number) {
        this.label = label;
        this.number = number;
    }

    public static DuelOptionsEnum fromNumber(int number) throws NullPointerException {
        for (DuelOptionsEnum option : DuelOptionsEnum.values()) {
            if (option.number == number) {
                return option;
            }
        }
        throw new NullPointerException("No such option for: " + DuelOptionsEnum.class.getSimpleName());
    }

    @Override
    public String toString() {
        return number +
                ". " +
                label;
    }
}
