package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.VarStore;

import java.util.List;

public class prozedurGleich extends Prozedur{
    public prozedurGleich(VarStore varStore) {
        super(varStore);
    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        for (int i=0; i < (parameter.size()-1); i++){
            if ((parameter.get(i).getNumber() < parameter.get(i+1).getNumber()) ||
                    (parameter.get(i).getNumber() > parameter.get(i).getNumber())){
                return new DatenTypen(false);
            }
        }
        return new DatenTypen(true);
    }
}
