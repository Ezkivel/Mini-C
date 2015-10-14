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

    public ListaVariables(Variable v) {
        this.v = v;
    }

    public ListaVariables(nombreVariable nv, OperacionAritmetica oa) {
        this.nv = nv;
        this.oa = oa;
    }

    public ListaVariables(nombreVariable nv, constChar csC) {
        this.nv = nv;
        this.csC = csC;
    }

    public ListaVariables(nombreVariable nv, constStr csS) {
        this.nv = nv;
        this.csS = csS;
    }
}
