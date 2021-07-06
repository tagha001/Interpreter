package de.taniya.schemeinterpreter;

import de.taniya.schemeinterpreter.prozedur.Prozedur;

public class DatenTypen {
    private Double number;
    private String string;
    private Boolean bool;
    private Prozedur prozedur;
    private Tuple<DatenTypen, DatenTypen> tuple;

    public DatenTypen(double number){
        this.number = number;
    }

    public DatenTypen(String string){
        this.string = string;
    }

    public DatenTypen(Boolean bool){
        this.bool = bool;
    }

    public DatenTypen(Prozedur prozedur){
        this.prozedur = prozedur;
    }

    public DatenTypen(Tuple<DatenTypen, DatenTypen> tuple){ this.tuple = tuple; }

    public DatenTypen() {

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

    public Tuple<DatenTypen, DatenTypen> getTuple(){
        if (tuple != null)
            return tuple;
        throw new RuntimeException("Is not a Tuple!");
    }

    public boolean isNumber(){
        return this.number != null;
    }

    public boolean isString(){
        return this.string != null;
    }

    public boolean isBoolean(){
        return this.bool != null;
    }

    public boolean isTuple() { return  this.tuple != null; }

    public boolean isProzedur() { return this.prozedur != null; }

    public boolean isEmpty() { return !isString() && !isNumber() && !isBoolean() && !isTuple() && !isProzedur(); }


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
        if (this.tuple != null){
            return this.tuple.toString();
        }
        return "no data stored";
    }
}
