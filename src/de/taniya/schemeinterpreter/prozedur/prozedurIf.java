package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.Auswertung;
import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.Knotten;
import de.taniya.schemeinterpreter.VarStore;

import java.util.List;

public class prozedurIf extends Prozedur{
    public prozedurIf(VarStore varStore) {
        super(varStore);
    }


    public DatenTypen execute(Knotten knotten, VarStore varStore){
        if (Auswertung.auswertung(knotten.getKind().get(1), varStore).getBool()){
            return Auswertung.auswertung(knotten.getKind().get(2), varStore);
        }
        else if (knotten.getKind().size() == 4){
            return Auswertung.auswertung(knotten.getKind().get(3), varStore);
        }
        return null;
    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        return null;
    }
}
