package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bagci on 10/27/17.
 */
public class AminoAcid {

    private Character letter;
    private static List<Character> alphabet = new ArrayList<>(
            Arrays.asList('A', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'Y', '*'));

    public AminoAcid(char letter) {
        if (Character.isLowerCase(letter)) {
            letter = Character.toUpperCase(letter);
        }
        if (alphabet.contains(letter)) {
            this.letter = new Character(letter);
        } else {
            this.letter = alphabet.get((int) (Math.random() * alphabet.size()));
        }
    }

    @Override
    public String toString() {
        return this.letter.toString();
    }

}
