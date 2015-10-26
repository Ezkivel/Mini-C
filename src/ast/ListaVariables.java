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

    public Variable _variable;
    public nombreVariable _nombreVariable;
    public OperacionAritmetica _operacionAritmetica;
    public constChar _constChar;
    public constStr _constStr;
    public ListaVariablesComa _listaVariablesComa;
    public igual _igual;
    public corcheteIzquierdo _corIz;
    public corcheteDerecho _corDER;
    public llaveIzquierda _llIz;
    public llaveDerecha _llDer;
    public InicializacionArreglo _inicializacionArreglo;

    public ListaVariables(Variable v, ListaVariablesComa lvc) {
        this._variable = v;
        this._listaVariablesComa = lvc;
    }

    public ListaVariables(nombreVariable nv, igual i, OperacionAritmetica oa, ListaVariablesComa lvc) {
        this._nombreVariable = nv;
        this._igual = i;
        this._operacionAritmetica = oa;
        this._listaVariablesComa = lvc;
    }

    public ListaVariables(nombreVariable nv, igual i, constChar csC, ListaVariablesComa lv) {
        this._nombreVariable = nv;
        this._igual = i;
        this._constChar = csC;
        this._listaVariablesComa = lv;
    }

    public ListaVariables(nombreVariable nv, igual i, constStr csS, ListaVariablesComa lv) {
        this._nombreVariable = nv;
        this._igual = i;
        this._constStr = csS;
        this._listaVariablesComa = lv;
    }

    public ListaVariables(nombreVariable nv, corcheteIzquierdo corIz, OperacionAritmetica o, corcheteDerecho corDer, igual i, llaveIzquierda llIz, InicializacionArreglo iA, llaveDerecha llDER, ListaVariablesComa lv) {
        this._nombreVariable = nv;
        this._corIz = corIz;
        this._operacionAritmetica = o;
        this._corDER = corDer;
        this._igual = i;
        this._llIz = llIz;
        this._inicializacionArreglo = iA;
        this._llDer = llDER;
        this._listaVariablesComa = lv;
    }
    
     public ListaVariables(nombreVariable nv, corcheteIzquierdo corIz, corcheteDerecho corDer, igual i, llaveIzquierda llIz, InicializacionArreglo iA, llaveDerecha llDER, ListaVariablesComa lv) {
        this._nombreVariable = nv;
        this._corIz = corIz;
        this._corDER = corDer;
        this._igual = i;
        this._llIz = llIz;
        this._inicializacionArreglo = iA;
        this._llDer = llDER;
        this._listaVariablesComa = lv;
    }

}
