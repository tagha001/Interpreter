package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.Tuple;
import de.taniya.schemeinterpreter.VarStore;

import java.util.List;

public class prozedurCons extends Prozedur{
    public prozedurCons(VarStore varStore) {
        super(varStore);
    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        return new DatenTypen(new Tuple<>(parameter.get(0), parameter.get(1)));
    }
}
