package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.Auswertung;
import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.Knotten;
import de.taniya.schemeinterpreter.VarStore;

import java.util.List;

public class prozedurCond extends Prozedur{
    public prozedurCond(VarStore varStore) {
        super(varStore);
    }


    public DatenTypen execute(Knotten knotten, VarStore varStore){
        for (int i= 1; i < knotten.getKind().size(); i++){
            if (Auswertung.auswertung(knotten.getKind().get(i).getKind().get(0), varStore).getBool()){
                return Auswertung.auswertung(knotten.getKind().get(i).getKind().get(1), varStore);
            }
        }
        return null;
    }
    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        return null;
    }
}
