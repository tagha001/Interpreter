package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.Auswertung;
import de.taniya.schemeinterpreter.Knotten;
import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.VarStore;

import java.util.ArrayList;
import java.util.List;

public abstract class Prozedur {

    protected List<String> parameterNamen;
    protected VarStore varStore;

    public Prozedur(VarStore varStore) {
        this.parameterNamen = new ArrayList<>();
        this.varStore = new VarStore(varStore);
    }
    public Prozedur(List<String> parameterNamen, VarStore varStore){
        this.parameterNamen = parameterNamen;
        this.varStore = new VarStore(varStore);
    }

    public DatenTypen execute(Knotten knotten, VarStore varStore){
        List<DatenTypen> parameterList = new ArrayList<>();

        for (int i=1; i<knotten.getKind().size(); i++){
            parameterList.add(Auswertung.auswertung(knotten.getKind().get(i), varStore));
        }

        return executeRumpf(parameterList);
    }

    public abstract DatenTypen executeRumpf(List<DatenTypen> parameter);



}
