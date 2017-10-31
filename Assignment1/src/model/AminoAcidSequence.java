package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bagci on 10/27/17.
 */
public class AminoAcidSequence extends Sequence{

    public AminoAcidSequence(){
        this.seq = new ArrayList<AminoAcid>();
    }

    public AminoAcidSequence(List<AminoAcid> seq){
        this.seq = seq;
    }

    public AminoAcidSequence(String sequence) {
        this.seq = new ArrayList<AminoAcid>();
        for(Character letter : sequence.toCharArray()) {
            AminoAcid nucl = new AminoAcid(letter);
            this.seq.add(nucl);
        }
    }

    @Override
    public List<AminoAcid> getSeq() {
        return this.seq;
    }

    public void append(AminoAcid aa) {
        this.seq.add(aa);
    }

}
