package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.VarStore;

import java.util.List;

public class prozedurGeteilt extends Prozedur{

    public prozedurGeteilt(VarStore varStore) {
        super(varStore);
    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {

        double geteilte = parameter.get(0).getNumber();
        for (int i=1; i<parameter.size(); i++){
            geteilte = geteilte/parameter.get(i).getNumber();
        }
        return new DatenTypen(geteilte);

    }
}
