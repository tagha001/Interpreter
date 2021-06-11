package de.taniya.schemeinterpreter.prozedur;

import de.taniya.schemeinterpreter.Knotten;
import de.taniya.schemeinterpreter.datenTypen;

import java.util.List;

public class schemeProzedur extends Prozedur {

    private Knotten prozedurRumpf;

    public schemeProzedur(List<String> parameter, Knotten prozedurRumpf) {
        super(parameter);
        this.prozedurRumpf = prozedurRumpf;
    }

    @Override
    public datenTypen executeRumpf(List<datenTypen> parameter) {
        return null;
    }
}
