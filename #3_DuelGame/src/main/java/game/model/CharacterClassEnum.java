package game.model;

public enum CharacterClassEnum {

    WARRIOR("Warrior", 1),
    MAGE("Mage", 2);

    private final String label;
    private final int index;

    CharacterClassEnum(String label, int index) {
        this.label = label;
        this.index = index;
    }

    public static CharacterClassEnum fromNumber(int number) throws IllegalArgumentException {
        for (CharacterClassEnum option : CharacterClassEnum.values()) {
            if (option.index == number) {
                return option;
            }
        }
        throw new IllegalArgumentException("No such option for: " + CharacterClassEnum.class.getSimpleName());
    }

    @Override
    public String toString() {
        return label;
    }

    public String toStringWithNumber() {
        return index +
                ". " +
                label;
    }
}
