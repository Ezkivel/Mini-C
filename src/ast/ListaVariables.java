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
    public corcheteIzquierdo corIz;
    public corcheteDerecho corDER;
    public llaveIzquierda llIz;
    public llaveDerecha llDER;
    public InicializacionArreglo iA;

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
        this.lvc = lv;
    }

    public ListaVariables(nombreVariable nv, igual i, constStr csS, ListaVariablesComa lv) {
        this.nv = nv;
        this.i = i;
        this.csS = csS;
        this.lvc = lv;
    }

    public ListaVariables(nombreVariable nv, corcheteIzquierdo corIz, OperacionAritmetica o, corcheteDerecho corDer, igual i, llaveIzquierda llIz, InicializacionArreglo iA, llaveDerecha llDER, ListaVariablesComa lv) {
        this.nv = nv;
        this.corIz = corIz;
        this.oa = o;
        this.corDER = corDer;
        this.i = i;
        this.llIz = llIz;
        this.iA = iA;
        this.llDER = llDER;
        this.lvc = lv;
    }

}
