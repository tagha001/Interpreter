package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.datenTypen;

import java.util.List;

public class prozedurPlus extends Prozedur{

    @Override
    public datenTypen executeRumpf(List<datenTypen> parameter) {
        double sum = 0;
        for(int i=0; i< parameter.size();i++){
            sum = sum + parameter.get(i).getNumber();
        }
        return new datenTypen(sum);
    }
}
