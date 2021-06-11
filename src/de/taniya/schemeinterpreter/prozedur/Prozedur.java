package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.Auswertung;
import de.taniya.schemeinterpreter.Knotten;
import de.taniya.schemeinterpreter.datenTypen;
import de.taniya.schemeinterpreter.varStore;

import java.util.ArrayList;
import java.util.List;

public abstract class Prozedur {

    private List<String> parameter;

    public Prozedur() { this.parameter = new ArrayList<>(); }
    public Prozedur(List<String> parameter){
        this.parameter = parameter;
    }

    public datenTypen execute(Knotten knotten, varStore varStore){
        List<datenTypen> parameterList = new ArrayList<>();

        for (int i=1; i<knotten.getKind().size(); i++){
            parameterList.add(Auswertung.auswertung(knotten.getKind().get(i), varStore));
        }

        return executeRumpf(parameterList);
    }

    public abstract datenTypen executeRumpf(List<datenTypen> parameter);



}
