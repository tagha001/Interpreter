package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.VarStore;

import java.util.List;

public class prozedurMinus extends Prozedur{
    public prozedurMinus(VarStore varStore) {
        super(varStore);
    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {

        double minus = parameter.get(0).getNumber();
        for (int i=1; i<parameter.size(); i++){
            minus = minus - parameter.get(i).getNumber();
        }
        return new DatenTypen(minus);
    }
}
