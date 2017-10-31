package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bagci on 10/27/17.
 */
public class NucleotideSequence extends Sequence {

    public NucleotideSequence(){
        this.seq = new ArrayList<Nucleotide>();
    }

    public NucleotideSequence(List<Nucleotide> seq){
        this.seq = seq;
    }

    public NucleotideSequence(String sequence) {
        this.seq = new ArrayList<Nucleotide>();
        for(Character letter : sequence.toCharArray()) {
            Nucleotide nucl = new Nucleotide(letter);
            this.seq.add(nucl);
        }
    }

    public void append(Nucleotide nucl) {
        this.seq.add(nucl);
    }

    /**
     *
     * @param frame : valid values: -3, -2, -1, 1, 2, 3
     */
    public List<NucleotideSequence> getTriplets(int frame) {
        List<NucleotideSequence> triplets = new ArrayList<>();
        if(frame < 0 && frame > -4) {
            frame *= -1;
            NucleotideSequence reverseComplement = getReverseComplement();
            for(int i = frame - 1; i < reverseComplement.seq.size() - 2; i = i+3) {
                triplets.add(new NucleotideSequence(reverseComplement.getSeq().subList(i, i+3)));
            }
        }else{
            for(int i = frame - 1; i < this.seq.size() - 2; i = i+3) {
                triplets.add(new NucleotideSequence(this.getSeq().subList(i, i+3)));
            }
        }
        return triplets;
    }

    public NucleotideSequence getReverseComplement() {
        NucleotideSequence result = new NucleotideSequence();
        for(int i = this.seq.size() - 1; i >= 0; i--) {
            Nucleotide nucl = (Nucleotide) this.seq.get(i);
            result.append(nucl.getReverseComplement());
        }
        return result;
    }

    @Override
    public List<Nucleotide> getSeq() {
        return this.seq;
    }
}
