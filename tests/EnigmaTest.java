package enigma;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Enigma machine components.
 */
public class EnigmaTest {

    @Test
    public void testRotorEncoding() {
        Rotor rotor = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q', 'A');
        assertEquals('E', rotor.encodeForward('A'));
        assertEquals('A', rotor.encodeBackward('E'));

        rotor.step();
        assertEquals('J', rotor.encodeForward('A'));
    }

    @Test
    public void testReflector() {
        Reflector reflector = new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");
        assertEquals('Y', reflector.reflect('A'));
        assertEquals('A', reflector.reflect('Y'));
    }

    @Test
    public void testPlugboardSwap() {
        Plugboard plugboard = new Plugboard();
        plugboard.addPair('A', 'Z');
        assertEquals('Z', plugboard.swap('A'));
        assertEquals('A', plugboard.swap('Z'));
        assertEquals('M', plugboard.swap('M'));
    }

    @Test
    public void testEnigmaEncryptDecrypt() {
        Rotor rotor1 = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q', 'A');
        Rotor rotor2 = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E', 'A');
        Rotor rotor3 = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V', 'A');

        Reflector reflector = new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");
        Plugboard plugboard = new Plugboard();
        plugboard.addPair('A', 'M');
        plugboard.addPair('G', 'L');

        EnigmaMachine machine1 = new EnigmaMachine(
            new Rotor[] {rotor1, rotor2, rotor3}, reflector, plugboard
        );

        String encrypted = machine1.encrypt("HELLOWORLD");

        Rotor rotor1B = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q', 'A');
        Rotor rotor2B = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E', 'A');
        Rotor rotor3B = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V', 'A');

        EnigmaMachine machine2 = new EnigmaMachine(
            new Rotor[] {rotor1B, rotor2B, rotor3B}, reflector, plugboard
        );

        String decrypted = machine2.encrypt(encrypted);
        assertEquals("HELLOWORLD", decrypted);
    }
}
