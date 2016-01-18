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
public class IncrementarDecrementarVariable extends Codigo{

    public Variable _variable;
    public Token _operadorIncrementoDecremento;
    public puntoYComa _puntoYComa;

    public IncrementarDecrementarVariable(Variable _variable, Token _operadorIncrementoDecremento, puntoYComa _puntoYComa) {
        this._variable = _variable;
        this._operadorIncrementoDecremento = _operadorIncrementoDecremento;
        this._puntoYComa = _puntoYComa;
    }

    public IncrementarDecrementarVariable(Token _operadorIncrementoDecremento, Variable _variable, puntoYComa _puntoYComa) {
        this._variable = _variable;
        this._operadorIncrementoDecremento = _operadorIncrementoDecremento;
        this._puntoYComa = _puntoYComa;
    }

}
