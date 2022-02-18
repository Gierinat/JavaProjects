package game.model;

public enum CharacterClassEnum {

    WARRIOR("Warrior", 1),
    MAGE("Mage", 2);

    private final String label;
    private final int number;

    CharacterClassEnum(String label, int number) {
        this.label = label;
        this.number = number;
    }

    public static CharacterClassEnum fromNumber(int number) throws NullPointerException {
        for (CharacterClassEnum option : CharacterClassEnum.values()) {
            if (option.number == number) {
                return option;
            }
        }
        throw new NullPointerException("No such option for: " + CharacterClassEnum.class.getSimpleName());
    }

    @Override
    public String toString() {
        return label;
    }

    public String toStringWithNumber() {
        return number +
                ". " +
                label;
    }
}
