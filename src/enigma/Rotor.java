package enigma;

/**
 * Represents a single Enigma rotor.
 * Handles forward and backward character encoding as well as rotor stepping.
 */
public class Rotor {
    private final String wiring;
    private final char notch;
    private int position;

    public Rotor(String wiring, char notch, char initialPosition) {
        this.wiring = wiring;
        this.notch = notch;
        this.position = initialPosition - 'A';
    }

    public void step() {
        position = (position + 1) % 26;
    }

    public boolean atNotch() {
        return getPositionChar() == notch;
    }

    public char encodeForward(char c) {
        int inputIndex = (c - 'A' + position) % 26;
        char wiredChar = wiring.charAt(inputIndex);
        int outputIndex = (wiredChar - 'A' - position + 26) % 26;
        return (char) ('A' + outputIndex);
    }

    public char encodeBackward(char c) {
        int shiftedIndex = (c - 'A' + position + 26) % 26;
        int indexInWiring = wiring.indexOf((char) ('A' + shiftedIndex));
        int outputIndex = (indexInWiring - position + 26) % 26;
        return (char) ('A' + outputIndex);
    }

    public char getPositionChar() {
        return (char) ('A' + position);
    }

    public void setPosition(char c) {
        this.position = c - 'A';
    }
}
