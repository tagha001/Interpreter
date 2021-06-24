package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.Knotten;
import de.taniya.schemeinterpreter.VarStore;

import java.util.ArrayList;
import java.util.List;
import java.math.*;

public class prozedurRound extends Prozedur{
    public prozedurRound(VarStore varStore) {
        super(varStore);
    }



    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        return new DatenTypen(Math.round(parameter.get(0).getNumber()));
    }
}
