package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.datenTypen;

import java.util.List;

public class prozedurMal extends Prozedur{

    @Override
    public datenTypen executeRumpf(List<datenTypen> parameter) {

        double mal = 1;
        for (int i=0; i<parameter.size();i++){
            mal = mal * parameter.get(i).getNumber();
        }
        return new datenTypen(mal);
    }
}
