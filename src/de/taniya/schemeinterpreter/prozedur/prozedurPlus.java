package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.VarStore;

import java.util.List;

public class prozedurPlus extends Prozedur{

    public prozedurPlus(VarStore varStore) {
        super(varStore);
    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        double sum = 0;
        for(int i=0; i< parameter.size();i++){
            sum = sum + parameter.get(i).getNumber();
        }
        return new DatenTypen(sum);
    }
}
