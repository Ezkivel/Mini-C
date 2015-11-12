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
    public igual _igual;
    public corcheteIzquierdo _corIz;
    public corcheteDerecho _corDER;
    public llaveIzquierda _llIz;
    public llaveDerecha _llDer;
    public InicializacionArreglo _inicializacionArreglo;
    // public ListaVariablesComa _listaVariablesComa;
    private Tipo _tipo;
    private ListaVariables _listaVariables;
    /*
     public ListaVariables(Variable v, ListaVariablesComa _listaVariablesComa) {
     this._variable = v;
     this._listaVariablesComa = _listaVariablesComa;
     }

     public ListaVariables(nombreVariable nv, igual i, OperacionAritmetica oa, ListaVariablesComa _listaVariablesComa) {
     this._nombreVariable = nv;
     this._igual = i;
     this._operacionAritmetica = oa;
     this._listaVariablesComa = _listaVariablesComa;
     }

     public ListaVariables(nombreVariable nv, igual i, constChar csC, ListaVariablesComa _listaVariablesComa) {
     this._nombreVariable = nv;
     this._igual = i;
     this._constChar = csC;
     this._listaVariablesComa = _listaVariablesComa;
     }

     public ListaVariables(nombreVariable nv, igual i, constStr csS, ListaVariablesComa _listaVariablesComa) {
     this._nombreVariable = nv;
     this._igual = i;
     this._constStr = csS;
     this._listaVariablesComa = _listaVariablesComa;
     }

     public ListaVariables(nombreVariable nv, corcheteIzquierdo corIz, OperacionAritmetica o, corcheteDerecho corDer, igual i, llaveIzquierda llIz, InicializacionArreglo iA, llaveDerecha llDER, ListaVariablesComa _listaVariablesComa) {
     this._nombreVariable = nv;
     this._corIz = corIz;
     this._operacionAritmetica = o;
     this._corDER = corDer;
     this._igual = i;
     this._llIz = llIz;
     this._inicializacionArreglo = iA;
     this._llDer = llDER;
     this._listaVariablesComa = _listaVariablesComa;
     }

     public ListaVariables(nombreVariable nv, corcheteIzquierdo corIz, corcheteDerecho corDer, igual i, llaveIzquierda llIz, InicializacionArreglo iA, llaveDerecha llDER, ListaVariablesComa _listaVariablesComa) {
     this._nombreVariable = nv;
     this._corIz = corIz;
     this._corDER = corDer;
     this._igual = i;
     this._llIz = llIz;
     this._inicializacionArreglo = iA;
     this._llDer = llDER;
     this._listaVariablesComa = _listaVariablesComa;
     }
     */

    public ListaVariables(Variable v) {
        this._variable = v;
    }

    public ListaVariables(nombreVariable nv, igual i, OperacionAritmetica oa) {
        this._nombreVariable = nv;
        this._igual = i;
        this._operacionAritmetica = oa;
    }

    public ListaVariables(nombreVariable nv, igual i, constChar csC) {
        this._nombreVariable = nv;
        this._igual = i;
        this._constChar = csC;
    }

    public ListaVariables(nombreVariable nv, igual i, constStr csS) {
        this._nombreVariable = nv;
        this._igual = i;
        this._constStr = csS;
    }

    public ListaVariables(nombreVariable nv, corcheteIzquierdo corIz, OperacionAritmetica o, corcheteDerecho corDer, igual i, llaveIzquierda llIz, InicializacionArreglo iA, llaveDerecha llDER) {
        this._nombreVariable = nv;
        this._corIz = corIz;
        this._operacionAritmetica = o;
        this._corDER = corDer;
        this._igual = i;
        this._llIz = llIz;
        this._inicializacionArreglo = iA;
        this._llDer = llDER;
    }

    public ListaVariables(nombreVariable nv, corcheteIzquierdo corIz, corcheteDerecho corDer, igual i, llaveIzquierda llIz, InicializacionArreglo iA, llaveDerecha llDER) {
        this._nombreVariable = nv;
        this._corIz = corIz;
        this._corDER = corDer;
        this._igual = i;
        this._llIz = llIz;
        this._inicializacionArreglo = iA;
        this._llDer = llDER;
    }

    public Tipo getTipo() {
        return _tipo;
    }

    public void setTipo(Tipo _tipo) {
        this._tipo = _tipo;
    }

    public nombreVariable getNombreVariable() {
        return _nombreVariable;
    }

    public void setNombreVariable(nombreVariable _nombreVariable) {
        this._nombreVariable = _nombreVariable;
    }

}
