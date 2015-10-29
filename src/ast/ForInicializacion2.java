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
public class ForInicializacion2 {

    public Variable _variable;
    public operadorAritmeticoIgual _operadorAritmeticoIgual;
    public igual _igual;
    public OperacionAritmetica _operacionAritmetica;
    public constChar _constChar;
    public constStr _constStr;
    public ForInicializacionComa _forInicializacionComa;

    public ForInicializacion2(Variable _variable, igual _igual, OperacionAritmetica _operacionAritmetica, ForInicializacionComa _forInicializacionComa) {
        this._variable = _variable;
        this._igual = _igual;
        this._operacionAritmetica = _operacionAritmetica;
        this._forInicializacionComa = _forInicializacionComa;
    }

    public ForInicializacion2(Variable _variable, operadorAritmeticoIgual _operadorAritmeticoIgual, OperacionAritmetica _operacionAritmetica, ForInicializacionComa _forInicializacionComa) {
        this._variable = _variable;
        this._operadorAritmeticoIgual = _operadorAritmeticoIgual;
        this._operacionAritmetica = _operacionAritmetica;
        this._forInicializacionComa = _forInicializacionComa;
    }

    public ForInicializacion2(Variable _variable, igual _igual, constChar _constChar, ForInicializacionComa _forInicializacionComa) {
        this._variable = _variable;
        this._igual = _igual;
        this._constChar = _constChar;
        this._forInicializacionComa = _forInicializacionComa;
    }

    public ForInicializacion2(Variable _variable, igual _igual, constStr _constStr, ForInicializacionComa _forInicializacionComa) {
        this._variable = _variable;
        this._igual = _igual;
        this._constStr = _constStr;
        this._forInicializacionComa = _forInicializacionComa;
    }

}


