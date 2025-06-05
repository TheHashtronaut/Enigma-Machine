# Enigma Machine Emulator (Java)

### Overview:
This is a modular Java-based simulation of the WWII-era Enigma Machine.
Built using clean object-oriented principles and SOLID design.

### Components:
- `Rotor`: simulates the rotating scrambling wheels
- `Reflector`: bounces signal back through rotors
- `Plugboard`: swaps character pairs (customizable)
- `EnigmaMachine`: orchestrates signal flow
- `Main`: CLI for encryption

### How it works:
Input → Plugboard → Rotor3 → Rotor2 → Rotor1 → Reflector → Rotor1 ← Rotor2 ← Rotor3 ← Plugboard ← Output

Rotors step automatically like in real Enigma.

### To Run:
- Compile all files in `src/enigma`
- Run `Main.java`
- Type a message in uppercase A-Z
