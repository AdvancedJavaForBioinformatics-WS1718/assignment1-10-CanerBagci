/*
 * Copyright (c) $2017.
 */

package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by bagci on 11/24/16.
 */
public class FastaFile {
    private File file;
    private BufferedReader br;
    private String header;
    public boolean hasNext;
    public boolean isNucl;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FastaFile(File file, boolean isNucl) {
        this.file = file;
        this.isNucl = isNucl;
        try {
            if (this.file.exists())
                br = new BufferedReader(new FileReader(file));
            else
                br = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.header = null;
        hasNext = true;
    }

    public FastaElement next() {
        if (!hasNext)
            return null;
        FastaElement fe = null;
        String line;
        StringBuilder sequence = new StringBuilder();
        if (this.header != null) {
            fe = new FastaElement(header, isNucl);
        } else {
            try {
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.length() == 0 || line.startsWith("#"))
                        continue;
                    break;
                }
                if (line.startsWith(">")) {
                    fe = new FastaElement(line.substring(1), isNucl);
                } else {
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.length() == 0 || line.startsWith("#"))
                    continue;
                if (line.startsWith(">"))
                    break;
                sequence.append(line);
            }
            if (line != null)
                header = line.substring(1);
            else
                hasNext = false;
            fe.setSequence(sequence.toString());
            return fe;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<FastaElement> getAll() {
        ArrayList<FastaElement> ret = new ArrayList<>();

        while (this.hasNext) {
            ret.add(this.next());
        }

        return ret;
    }


}
