package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.VarStore;

import java.util.List;

public class prozedurMal extends Prozedur{

    public prozedurMal(VarStore varStore) {
        super(varStore);
    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {

        double mal = 1;
        for (int i=0; i<parameter.size();i++){
            mal = mal * parameter.get(i).getNumber();
        }
        return new DatenTypen(mal);
    }
}
