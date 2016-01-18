/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import minic.Token;

/**
 *
 * @author Gabriel
 */
public class ForActualizacion {

    public Variable _variable;
    public operadorAritmeticoIgual _operadorAritmeticoIgual;
    public Token _operadorIncrementoDecremento;
    public igual _igual;
    public OperacionAritmetica _operacionAritmetica;
    public constChar _constChar;
    public constStr _constStr;
    public ForActualizacionComa _forActualizacionComa;

    public ForActualizacion(Variable _variable, igual _igual, OperacionAritmetica _operacionAritmetica, ForActualizacionComa _forActualizacionComa) {
        this._variable = _variable;
        this._igual = _igual;
        this._operacionAritmetica = _operacionAritmetica;
        this._forActualizacionComa = _forActualizacionComa;
    }

    public ForActualizacion(Variable _variable, operadorAritmeticoIgual _operadorAritmeticoIgual, OperacionAritmetica _operacionAritmetica, ForActualizacionComa _forActualizacionComa) {
        this._variable = _variable;
        this._operadorAritmeticoIgual = _operadorAritmeticoIgual;
        this._operacionAritmetica = _operacionAritmetica;
        this._forActualizacionComa = _forActualizacionComa;
    }

    public ForActualizacion(Variable _variable, igual _igual, constChar _constChar, ForActualizacionComa _forActualizacionComa) {
        this._variable = _variable;
        this._igual = _igual;
        this._constChar = _constChar;
        this._forActualizacionComa = _forActualizacionComa;
    }

    public ForActualizacion(Variable _variable, igual _igual, constStr _constStr, ForActualizacionComa _forActualizacionComa) {
        this._variable = _variable;
        this._igual = _igual;
        this._constStr = _constStr;
        this._forActualizacionComa = _forActualizacionComa;
    }

    public ForActualizacion(Token _operadorIncrementoDecremento, Variable _variable, ForActualizacionComa _forActualizacionComa) {
        this._operadorIncrementoDecremento = _operadorIncrementoDecremento;
        this._variable = _variable;
        this._forActualizacionComa = _forActualizacionComa;
    }

    public ForActualizacion(Variable _variable, Token _operadorIncrementoDecremento, ForActualizacionComa _forActualizacionComa) {
        this._variable = _variable;
        this._operadorIncrementoDecremento = _operadorIncrementoDecremento;
        this._forActualizacionComa = _forActualizacionComa;
    }

}
