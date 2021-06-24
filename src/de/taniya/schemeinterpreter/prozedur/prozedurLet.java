package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.Auswertung;
import de.taniya.schemeinterpreter.Knotten;
import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.VarStore;

import java.util.List;

public class prozedurLet extends Prozedur{
    public prozedurLet(VarStore varStore) {
        super(varStore);
    }

    @Override
    public DatenTypen execute(Knotten knotten, VarStore varStore) {
        VarStore store = new VarStore(varStore);
        for (Knotten temp : knotten.getKind().get(1).getKind()) {
            store.addVar(temp.getKind().get(0).getToken().var.getString(), Auswertung.auswertung(temp.getKind().get(1), varStore));
        }
        return Auswertung.auswertung(knotten.getKind().get(2), store);

    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        return null;
    }
}
