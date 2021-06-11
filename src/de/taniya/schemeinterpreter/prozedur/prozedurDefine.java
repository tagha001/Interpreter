package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.Knotten;
import de.taniya.schemeinterpreter.datenTypen;
import de.taniya.schemeinterpreter.varStore;

import java.util.ArrayList;
import java.util.List;

public class prozedurDefine extends Prozedur{

    @Override
    public datenTypen execute(Knotten knotten, varStore varStore){
        List<String> prozedurParam = new ArrayList<>();
        for (int i=0; i< knotten.getKind().get(1).getKind().size(); i++){
            prozedurParam.add(knotten.getKind().get(1).getKind().get(i).getToken().var.getString());
        }
        String prozedurName = prozedurParam.get(0);
        prozedurParam.remove(0);

        schemeProzedur scheme = new schemeProzedur(prozedurParam, knotten.getKind().get(2));
        varStore.addVar(prozedurName, new datenTypen(scheme));
        return new datenTypen();
    }

    @Override
    public datenTypen executeRumpf(List<datenTypen> parameter) {
        return null;
    }
}
