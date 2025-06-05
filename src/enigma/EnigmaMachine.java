package enigma;

/**
 * Core Enigma machine.
 * Wires together rotors, reflector, and plugboard to encrypt messages.
 */
public class EnigmaMachine {
    private final Rotor[] rotors;
    private final Reflector reflector;
    private final Plugboard plugboard;

    public EnigmaMachine(Rotor[] rotors, Reflector reflector, Plugboard plugboard) {
        this.rotors = rotors;
        this.reflector = reflector;
        this.plugboard = plugboard;
    }

    public String encrypt(String message) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toUpperCase().toCharArray()) {
            if (c < 'A' || c > 'Z') continue;

            stepRotors();

            c = plugboard.swap(c);
            c = rotors[2].encodeForward(c);
            c = rotors[1].encodeForward(c);
            c = rotors[0].encodeForward(c);

            c = reflector.reflect(c);

            c = rotors[0].encodeBackward(c);
            c = rotors[1].encodeBackward(c);
            c = rotors[2].encodeBackward(c);
            c = plugboard.swap(c);

            result.append(c);
        }

        return result.toString();
    }

    private void stepRotors() {
        rotors[2].step();
        if (rotors[2].atNotch()) rotors[1].step();
        if (rotors[1].atNotch()) rotors[0].step();
    }
}
