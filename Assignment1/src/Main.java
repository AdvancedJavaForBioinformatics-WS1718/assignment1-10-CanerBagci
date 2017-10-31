import model.AminoAcid;
import model.Nucleotide;
import model.NucleotideSequence;
import model.Translator;
import util.CommandLine;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bagci on 10/27/17.
 */
public class Main {

    public static void main(String[] args) {


        try {
            CommandLine.parseArgs(args);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        CommandLine.translateAllFrames();

    }
}
