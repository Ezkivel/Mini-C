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
public class Codigo {

    public DeclaracionVariables dv;
    public AsignacionVariable av;
    public IncrementarDecrementarVariable id;
    public Printf printf;
    public Scanf scanf;
    public While w;
    public If i;
    public For fr;
    public LlamadoAFuncion llf;
    public RETURN r;
    public OperacionAritmetica oa;
    public constChar cc;
    public constStr cs;

    public Codigo c;

    public Codigo(DeclaracionVariables dv, Codigo c) {
        this.dv = dv;
        this.c = c;
    }

    public Codigo(AsignacionVariable av, Codigo c) {
        this.av = av;
        this.c = c;
    }

    public Codigo(IncrementarDecrementarVariable id, Codigo c) {
        this.id = id;
        this.c = c;
    }

    public Codigo(Printf printf, Codigo c) {
        this.c = c;
        this.printf = printf;
    }

    public Codigo(Scanf scanf, Codigo c) {
        this.c = c;
        this.scanf = scanf;
    }

    public Codigo(While w, Codigo c) {
        this.w = w;
        this.c = c;
    }

    public Codigo(If i, Codigo c) {
        this.i = i;
        this.c = c;
    }

    public Codigo(For fr, Codigo c) {
        this.fr = fr;
        this.c = c;
    }

    public Codigo(LlamadoAFuncion llf, Codigo c) {
        this.llf = llf;
        this.c = c;
    }

    public Codigo(RETURN r, OperacionAritmetica oa, Codigo c) {
        this.r = r;
        this.oa = oa;
        this.c = c;
    }

    public Codigo(RETURN r, constChar cc, Codigo c) {
        this.r = r;
        this.cc = cc;
        this.c = c;
    }

    public Codigo(RETURN r, constStr cs, Codigo c) {
        this.r = r;
        this.cs = cs;
        this.c = c;
    }

    public Codigo(Codigo c) {
        this.c = c;
    }

    public Codigo() {
    }
    

}
