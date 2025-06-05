package enigma;

import java.util.HashMap;
import java.util.Map;

/**
 * Simulates the Enigma plugboard.
 * Swaps pairs of letters based on a configuration.
 */
public class Plugboard {
    private final Map<Character, Character> mapping = new HashMap<>();

    public void addPair(char a, char b) {
        mapping.put(a, b);
        mapping.put(b, a);
    }

    public char swap(char c) {
        return mapping.getOrDefault(c, c);
    }
}
