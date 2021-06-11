package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.datenTypen;

import java.util.List;

public class prozedurGeteilt extends Prozedur{

    @Override
    public datenTypen executeRumpf(List<datenTypen> parameter) {

        double geteilte = parameter.get(0).getNumber();
        for (int i=1; i<parameter.size(); i++){
            geteilte = geteilte/parameter.get(i).getNumber();
        }
        return new datenTypen(geteilte);

    }
}
