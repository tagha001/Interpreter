package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.Knotten;
import de.taniya.schemeinterpreter.Tuple;
import de.taniya.schemeinterpreter.VarStore;

import java.util.List;

public class prozedurList extends Prozedur{
    public prozedurList(VarStore varStore) {
        super(varStore);
    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        if (parameter.isEmpty()){
            return new DatenTypen();
        }
        else {
            return new DatenTypen(new Tuple<>(parameter.remove(0), executeRumpf(parameter)));
        }
    }
}
