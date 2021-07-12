package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.DatenTypen;
import de.taniya.schemeinterpreter.Knotten;
import de.taniya.schemeinterpreter.Tuple;
import de.taniya.schemeinterpreter.VarStore;

import java.util.List;

public class prozedurQuote extends Prozedur{
    public prozedurQuote(VarStore varStore) {
        super(varStore);
    }

    public DatenTypen execute(Knotten knotten, VarStore varStore){
      return makeList(knotten);
    }

    public DatenTypen makeList(Knotten knotten){

        if (knotten.getKind().isEmpty()){
                return knotten.getToken().var;
        }
        else {
            DatenTypen listenKopf = new DatenTypen();
            for (int i= knotten.getKind().size()-1; i>=0; i--){
                listenKopf = new DatenTypen(new Tuple<>(makeList(knotten.getKind().get(i)), listenKopf));
            }
            return listenKopf;
        }
    }

    @Override
    public DatenTypen executeRumpf(List<DatenTypen> parameter) {
        return null;
    }
}
