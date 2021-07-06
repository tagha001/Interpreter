package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.*;

import java.util.List;

public class prozedurLength extends Prozedur{
    public prozedurLength(VarStore varStore) {
        super(varStore);
    }


    //@Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        DatenTypen zeiger = parameter.get(0);
        for (int i=0; true; i++){
            if (zeiger.isTuple()){
                zeiger = zeiger.getTuple().y;
            }
            else {
                return new DatenTypen(i);
            }
        }

    }
}
