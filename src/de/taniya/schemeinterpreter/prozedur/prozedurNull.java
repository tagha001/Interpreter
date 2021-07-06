package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.VarStore;

import java.util.List;

public class prozedurNull extends Prozedur{
    public prozedurNull(VarStore varStore) {
        super(varStore);
    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        return new DatenTypen(parameter.get(0).isEmpty());
    }
}
