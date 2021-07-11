package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.*;

import java.util.ArrayList;
import java.util.List;

public class prozedurDefine extends Prozedur{

    public prozedurDefine(VarStore varStore) {
        super(varStore);
    }

    @Override
    public DatenTypen execute(Knotten knotten, VarStore varStore){
        if (knotten.getKind().get(1).getToken().tokentyp == Token.Tokentyp.gruppe){
            List<String> prozedurParam = new ArrayList<>();
            for (int i=0; i< knotten.getKind().get(1).getKind().size(); i++){
                prozedurParam.add(knotten.getKind().get(1).getKind().get(i).getToken().var.getString());
            }
            String prozedurName = prozedurParam.get(0);
            prozedurParam.remove(0);

            schemeProzedur scheme = new schemeProzedur(prozedurParam, knotten.getKind().get(2), varStore);
            varStore.addVar(prozedurName, new DatenTypen(scheme));
            return new DatenTypen();
        }
        else {
            String name = knotten.getKind().get(1).getToken().var.getString();
            DatenTypen value = Auswertung.auswertung(knotten.getKind().get(2), varStore);
            varStore.addVar(name, value);
            return new DatenTypen();

        }

    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        return null;
    }
}
