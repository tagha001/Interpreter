package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.Auswertung;
import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.Knotten;
import de.taniya.schemeinterpreter.VarStore;

import java.util.List;

public class prozedurSet extends Prozedur{
    public prozedurSet(VarStore varStore) {
        super(varStore);
    }

    public DatenTypen execute(Knotten knotten, VarStore varStore){
        DatenTypen var = varStore.findVar(knotten.getKind().get(1).getToken().var.getString());
        if (var != null){
            DatenTypen temp = Auswertung.auswertung(knotten.getKind().get(2), varStore);
            var.set(temp);
        }
        return null;
    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        return null;
    }
}
