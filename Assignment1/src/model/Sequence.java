package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bagci on 10/27/17.
 */
public abstract class Sequence {

    protected List seq;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < seq.size(); i++){
            sb.append(seq.get(i).toString());
        }
        return sb.toString();
    }

    public abstract List getSeq();
}
