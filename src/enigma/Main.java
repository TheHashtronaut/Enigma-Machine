package enigma;

import java.util.Scanner;

/**
 * CLI to run the Enigma machine.
 */
public class Main {
    public static void main(String[] args) {
        Rotor rotor1 = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q', 'A');
        Rotor rotor2 = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E', 'A');
        Rotor rotor3 = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V', 'A');

        Reflector reflector = new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");
        Plugboard plugboard = new Plugboard();
        plugboard.addPair('A', 'M');
        plugboard.addPair('G', 'L');

        EnigmaMachine machine = new EnigmaMachine(
            new Rotor[] {rotor1, rotor2, rotor3}, reflector, plugboard
        );

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter message:");
        String input = scanner.nextLine();

        String encrypted = machine.encrypt(input);
        System.out.println("Encrypted: " + encrypted);

        scanner.close();
    }
}
