package de.taniya.schemeinterpreter;

import de.taniya.schemeinterpreter.prozedur.*;

import java.util.List;
import java.util.Scanner;

public class Interpreter {
    public static void repl(){

        Scanner myInput = new Scanner(System.in);
        while (true) {
            String input = myInput.nextLine();
            if (input.equals("Exit")) {
                return;
            } else {
                tokendef test = new tokendef();
                List list = test.load(input);
                Knotten knotten = tokendef.gruppierung(list, 0, list.size());
                varStore varStore = new varStore();
                varStore.addVar("+", new datenTypen(new prozedurPlus()));
                varStore.addVar("-", new datenTypen(new prozedurMinus()));
                varStore.addVar("*", new datenTypen(new prozedurMal()));
                varStore.addVar("/", new datenTypen(new prozedurGeteilt()));
                System.out.println(Auswertung.auswertung(knotten, varStore));
            }
        }
    }


    public static void main(String args[]){
        tokendef test = new tokendef();
        List list = test.load("(let ((a (+ 5 6))) (* a a))");
        //List list = test.load("(+ 5 6 (* 5 2))");
        // List list = test.load("(define (func x y) (* x y))");
        Knotten knotten = tokendef.gruppierung(list,0, list.size());
        //repl();

        System.out.println(list);
        System.out.println(knotten);
        varStore varStore = new varStore();
        varStore.addVar("+", new datenTypen(new prozedurPlus()));
        varStore.addVar("-", new datenTypen(new prozedurMinus()));
        varStore.addVar("*", new datenTypen(new prozedurMal()));
        varStore.addVar("/", new datenTypen(new prozedurGeteilt()));
        varStore.addVar("define", new datenTypen(new prozedurDefine()));
        varStore.addVar("let", new datenTypen(new prozedurLet()));
        System.out.println(Auswertung.auswertung(knotten, varStore));

    }
}
