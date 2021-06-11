package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.datenTypen;

import java.util.List;

public class prozedurMinus extends Prozedur{
    @Override
    public datenTypen executeRumpf(List<datenTypen> parameter) {

        double minus = parameter.get(0).getNumber();
        for (int i=1; i<parameter.size(); i++){
            minus = minus - parameter.get(i).getNumber();
        }
        return new datenTypen(minus);
    }
}
