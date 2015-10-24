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
public class ListaVariables {

    public Variable v;
    public nombreVariable nv;
    public OperacionAritmetica oa;
    public constChar csC;
    public constStr csS;
    public ListaVariablesComa lvc;
    public igual i;

    public ListaVariables(Variable v, ListaVariablesComa lvc) {
        this.v = v;
        this.lvc = lvc;
    }

    public ListaVariables(nombreVariable nv, igual i, OperacionAritmetica oa, ListaVariablesComa lvc) {
        this.nv = nv;
        this.i = i;
        this.oa = oa;
        this.lvc = lvc;
    }

    public ListaVariables(nombreVariable nv, igual i, constChar csC, ListaVariablesComa lv) {
        this.nv = nv;
        this.i = i;
        this.csC = csC;
        this.lvc = lvc;
    }

    public ListaVariables(nombreVariable nv, constStr csS) {
        this.nv = nv;
        this.csS = csS;
    }
}
