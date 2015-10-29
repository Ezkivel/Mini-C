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
public class ForActualizacion {

    public Variable _variable;
    public operadorAritmeticoIgual _operadorAritmeticoIgual;
    public operadorIncrementoDecremento _operadorIncrementoDecremento;
    public igual _igual;
    public OperacionAritmetica _operacionAritmetica;
    public constChar _constChar;
    public constStr _constStr;
    public ForActualizacionComa _forActualizacionComa;

    /*
    
     for_actualizacion ::= variable:v igual operacion_aritmetica:o for_actualizacion_coma:fac {:   RESULT = new ForActualizacion(v, new igual(), o, fac);    :}
     | variable operadorAritmeticoIgual operacion_aritmetica for_actualizacion_coma
     | variable igual constChar for_actualizacion_coma
     | variable igual constStr for_actualizacion_coma
     | variable operadorIncrementoDecremento for_actualizacion_coma
     | operadorIncrementoDecremento variable for_actualizacion_coma;

     */
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

    public ForActualizacion(operadorIncrementoDecremento _operadorIncrementoDecremento, Variable _variable, ForActualizacionComa _forActualizacionComa) {
       this._operadorIncrementoDecremento = _operadorIncrementoDecremento;
        this._variable = _variable;
        this._forActualizacionComa = _forActualizacionComa;
    }

    public ForActualizacion(Variable _variable, operadorIncrementoDecremento _operadorIncrementoDecremento, ForActualizacionComa _forActualizacionComa) {
        this._variable = _variable;
        this._operadorIncrementoDecremento = _operadorIncrementoDecremento;
        this._forActualizacionComa = _forActualizacionComa;
    }

}
