package model;

import java.util.HashMap;
import java.util.List;

/**
 * Created by bagci on 10/30/17.
 */
public class Translator {

    private static final HashMap<String, AminoAcid> codonMap = new HashMap<String, AminoAcid>() {
        {
            put("GGT", new AminoAcid('G'));
            put("GGC", new AminoAcid('G'));
            put("GGA", new AminoAcid('G'));
            put("GGG", new AminoAcid('G'));

            put("GCT", new AminoAcid('A'));
            put("GCC", new AminoAcid('A'));
            put("GCA", new AminoAcid('A'));
            put("GCG", new AminoAcid('A'));

            put("GTT", new AminoAcid('V'));
            put("GTC", new AminoAcid('V'));
            put("GTA", new AminoAcid('V'));
            put("GTG", new AminoAcid('V'));

            put("TTA", new AminoAcid('L'));
            put("TTG", new AminoAcid('L'));
            put("CTT", new AminoAcid('L'));
            put("CTC", new AminoAcid('L'));
            put("CTA", new AminoAcid('L'));
            put("CTG", new AminoAcid('L'));

            put("ATT", new AminoAcid('I'));
            put("ATC", new AminoAcid('I'));
            put("ATA", new AminoAcid('I'));

            put("TCT", new AminoAcid('S'));
            put("TCC", new AminoAcid('S'));
            put("TCA", new AminoAcid('S'));
            put("TCG", new AminoAcid('S'));
            put("AGT", new AminoAcid('S'));
            put("AGC", new AminoAcid('S'));

            put("ACT", new AminoAcid('T'));
            put("ACC", new AminoAcid('T'));
            put("ACA", new AminoAcid('T'));
            put("ACG", new AminoAcid('T'));

            put("GAT", new AminoAcid('D'));
            put("GAC", new AminoAcid('D'));

            put("GAA", new AminoAcid('E'));
            put("GAG", new AminoAcid('E'));

            put("AAT", new AminoAcid('N'));
            put("AAC", new AminoAcid('N'));

            put("CAA", new AminoAcid('Q'));
            put("CAG", new AminoAcid('Q'));

            put("AAG", new AminoAcid('K'));
            put("AAA", new AminoAcid('K'));

            put("CGT", new AminoAcid('R'));
            put("CGC", new AminoAcid('R'));
            put("CGA", new AminoAcid('R'));
            put("CGG", new AminoAcid('R'));
            put("AGA", new AminoAcid('R'));
            put("AGG", new AminoAcid('R'));

            put("CAT", new AminoAcid('H'));
            put("CAC", new AminoAcid('H'));

            put("TTT", new AminoAcid('F'));
            put("TTC", new AminoAcid('F'));

            put("TGT", new AminoAcid('C'));
            put("TGC", new AminoAcid('C'));

            put("TGG", new AminoAcid('W'));

            put("TAT", new AminoAcid('Y'));
            put("TAC", new AminoAcid('Y'));

            put("ATG", new AminoAcid('M'));

            put("CCT", new AminoAcid('P'));
            put("CCC", new AminoAcid('P'));
            put("CCA", new AminoAcid('P'));
            put("CCG", new AminoAcid('P'));

            put("TAG", new AminoAcid('*'));
            put("TAA", new AminoAcid('*'));
            put("TGA", new AminoAcid('*'));
        }
    };

    private static AminoAcid translateCodon(String codon) {
        return codonMap.get(codon);
    }

    public static AminoAcidSequence translate(NucleotideSequence dnaSeq, int frame) {
        AminoAcidSequence aaSeq = new AminoAcidSequence();

        List<NucleotideSequence> triplets = dnaSeq.getTriplets(frame);
        for(NucleotideSequence triplet : triplets) {
            aaSeq.append(translateCodon(triplet.toString()));
        }

        return aaSeq;
    }



}
