package de.taniya.schemeinterpreter;

import de.taniya.schemeinterpreter.prozedur.Prozedur;

public class datenTypen {
    private Double number;
    private String string;
    private Boolean bool;
    private Prozedur prozedur;

    public datenTypen(double number){
        this.number = number;
    }

    public datenTypen(String string){
        this.string = string;
    }

    public datenTypen(Boolean bool){
        this.bool = bool;
    }

    public datenTypen(Prozedur prozedur){
        this.prozedur = prozedur;
    }

    public datenTypen() {

    }

    public double getNumber() {
        if (number!= null)
            return number;
        throw new RuntimeException("Is not a Number!");
    }

    public String getString() {
        if(string != null)
            return string;
        throw new RuntimeException("Is not a String!");
    }

    public Boolean getBool() {
        if (bool != null)
            return bool;
        throw new RuntimeException("Is not a Boolean!");
    }

    public Prozedur getProzedur() {
        if (prozedur != null)
            return prozedur;
        throw new RuntimeException("Is not a de.taniya.schemeinterpreter.prozedur.Prozedur!");
    }

    @Override
    public String toString() {
        if (this.number != null) {
            return this.getNumber() + "";
        }
        if (this.string != null) {
            return this.getString();
        }
        if (this.bool != null) {
            return this.bool + "";
        }
        if (this.prozedur != null) {
            return "prozedur";
        }
        return "no data stored";
    }
}
