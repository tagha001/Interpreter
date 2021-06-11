package de.taniya.schemeinterpreter;

import java.util.HashMap;
import java.util.Map;

public class varStore {
    private Map<String, datenTypen> varMap = new HashMap<>();
    private varStore parent;

    public varStore(){

    }

    public varStore(varStore varStore){
        parent = varStore;
    }

    public void addVar(String name, datenTypen value){
        varMap.put(name, value);
    }
    public datenTypen findVar(String name){
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
