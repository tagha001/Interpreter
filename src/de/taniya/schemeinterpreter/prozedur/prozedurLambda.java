package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.Knotten;
import de.taniya.schemeinterpreter.VarStore;

import java.util.ArrayList;
import java.util.List;

public class prozedurLambda extends Prozedur{
    public prozedurLambda(VarStore varStore) {
        super(varStore);
    }

    @Override
    public DatenTypen execute(Knotten knotten, VarStore varStore){
        List<String> prozedurParam = new ArrayList<>();
        for (int i=0; i< knotten.getKind().get(1).getKind().size(); i++){
            prozedurParam.add(knotten.getKind().get(1).getKind().get(i).getToken().var.getString());
        }
        schemeProzedur scheme = new schemeProzedur(prozedurParam, knotten.getKind().get(2), varStore);
        return new DatenTypen(scheme);
    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        return null;
    }
}
