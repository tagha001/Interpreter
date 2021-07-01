package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.Knotten;
import de.taniya.schemeinterpreter.Token;
import de.taniya.schemeinterpreter.VarStore;

import java.util.List;

public class prozedurLength extends Prozedur{
    public prozedurLength(VarStore varStore) {
        super(varStore);
    }


    public DatenTypen execute(Knotten knotten, VarStore varStore){
        return null;
    }


    //@Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        return null;

    }
}
