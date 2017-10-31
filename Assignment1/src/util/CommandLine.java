package util;

import io.FastaElement;
import io.FastaFile;
import model.*;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by bagci on 10/30/17.
 */
public class CommandLine {

    static FastaFile fasta;

    public static void parseArgs(String[] args) throws FileNotFoundException {
        File fastaFile = new File(args[0]);
        if(!fastaFile.exists() || !fastaFile.canRead()) {
            throw new FileNotFoundException("input fasta file: " + args[0] + "do not exist or is not readable");
        }
        fasta = new FastaFile(fastaFile, true);

    }

    public static void translateAllFrames() {
        while(fasta.hasNext) {
            FastaElement fe = fasta.next();
//            System.out.println( fe.getSequence().getClass());
            NucleotideSequence seq = (NucleotideSequence) fe.getSequence();
            for(int i = 1; i <= 3; i++) {
                AminoAcidSequence aa = Translator.translate(seq, i);
                System.out.println("5'3' Frame" + i);
                System.out.println(aa.toString().replaceAll("(.{60})", "$1\n"));
            }
            for(int i = -1; i >= -3; i--) {
                AminoAcidSequence aa = Translator.translate(seq, i);
                System.out.println("3'5' Frame" + (i*-1));
                System.out.println(aa.toString().replaceAll("(.{60})", "$1\n"));
            }
        }
    }
}
