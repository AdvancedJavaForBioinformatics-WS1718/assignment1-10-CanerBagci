/*
 * Copyright (c) $2017.
 */

package io;

import model.AminoAcidSequence;
import model.NucleotideSequence;
import model.Sequence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by bagci on 11/24/16.
 */
public class FastaElement {
    private String header;
    private Sequence sequence;
    private boolean isNucl;

    public FastaElement(String header, String sequence, boolean isNucl) {
        this.header = header;
        this.isNucl = isNucl;
        if(this.isNucl)
            this.sequence = new NucleotideSequence(sequence);
        else
            this.sequence = new AminoAcidSequence(sequence);
    }

    public FastaElement(String header, boolean isNucl){
        this.header = header;
        this.isNucl = isNucl;
        if(this.isNucl)
            this.sequence = new NucleotideSequence();
        else
            this.sequence = new AminoAcidSequence();
    }

    public void setSequence(String seq) {
        if(this.isNucl){
            this.sequence = new NucleotideSequence(seq);
        }else {
            this.sequence = new AminoAcidSequence(seq);
        }
    }

    public String getHeader() {
        return header;
    }

    public Sequence getSequence() {
        return sequence;
    }

    public void writeToFile(File path){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
            bw.write(this.toString());
            bw.newLine();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString(){
        String ret = "";
        ret += ">" + this.header;
        ret += "\n";
        ret += this.sequence.toString();
        return ret;
    }


}
