package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bagci on 10/27/17.
 */
public class Nucleotide {

    private Character letter;
    private static List<Character> alphabet = new ArrayList<>(Arrays.asList('A', 'C', 'G', 'T'));

    public Nucleotide(char letter) {
        if (Character.isLowerCase(letter)) {
            letter = Character.toUpperCase(letter);
        }
        if (alphabet.contains(letter)) {
            this.letter = new Character(letter);
        } else {
            this.letter = alphabet.get((int) (Math.random() * alphabet.size()));
        }
    }

    public Nucleotide getReverseComplement() {
        switch (this.letter){
            case 'A':
                return new Nucleotide('T');
            case 'C':
                return new Nucleotide('G');
            case 'G':
                return new Nucleotide('C');
            case 'T':
                return new Nucleotide('A');
        }
        return null;
    }

    @Override
    public String toString() {
        return this.letter.toString();
    }

}
