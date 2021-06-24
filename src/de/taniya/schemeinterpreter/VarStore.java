package de.taniya.schemeinterpreter;

import java.util.HashMap;
import java.util.Map;

public class VarStore {
    private Map<String, DatenTypen> varMap = new HashMap<>();
    private VarStore parent;

    public VarStore(){

    }

    public VarStore(VarStore varStore){
        parent = varStore;
    }

    public void addVar(String name, DatenTypen value){
        varMap.put(name, value);
    }
    public DatenTypen findVar(String name){
        if(varMap.containsKey(name)){
            return varMap.get(name);
        }
        else {
            if (parent != null) {
                return parent.findVar(name);
            }
        }
        return null;
    }

}
