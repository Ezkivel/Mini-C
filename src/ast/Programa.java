/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author Gabriel
 */
public class Programa {

    public DeclaracionFuncion df;
    public MainClass m;
    public Programa p;

    public Programa() {

    }

    public Programa(MainClass m) {
        this.m = m;
    }

    public Programa(DeclaracionFuncion df, Programa p) {
        this.df = df;
        this.p = p;
    }

}
