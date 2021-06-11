package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.Auswertung;
import de.taniya.schemeinterpreter.Knotten;
import de.taniya.schemeinterpreter.datenTypen;
import de.taniya.schemeinterpreter.varStore;

import java.util.List;

public class prozedurLet extends Prozedur{
    @Override
    public datenTypen execute(Knotten knotten, varStore varStore) {
        varStore store = new varStore(varStore);
        for (Knotten temp : knotten.getKind().get(1).getKind()) {
            store.addVar(temp.getKind().get(0).getToken().var.getString(), Auswertung.auswertung(temp.getKind().get(1), varStore));
        }
        return Auswertung.auswertung(knotten.getKind().get(2), store);

    }

    @Override
    public datenTypen executeRumpf(List<datenTypen> parameter) {
        return null;
    }
}
