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
public class AsignacionVariable {

    public Variable _variable;
    public igual _igual;
    public operadorAritmeticoIgual _operadorAritmeticoIgual;
    public OperacionAritmetica _operacionAritmetica;
    public constChar _constChar;
    public constStr _constStr;
    public AsignacionVariableComa _asignacionVariableComa;
    public puntoYComa _puntoYComa;

    public AsignacionVariable(Variable _variable, igual _igual, OperacionAritmetica _operacionAritmetica, AsignacionVariableComa _asignacionVariableComa) {
        this._variable = _variable;
        this._igual = _igual;
        this._operacionAritmetica = _operacionAritmetica;
        this._asignacionVariableComa = _asignacionVariableComa;
    }

    public AsignacionVariable(Variable _variable, operadorAritmeticoIgual _operadorAritmeticoIgual, OperacionAritmetica _operacionAritmetica, AsignacionVariableComa _asignacionVariableComa) {
        this._variable = _variable;
        this._operadorAritmeticoIgual = _operadorAritmeticoIgual;
        this._operacionAritmetica = _operacionAritmetica;
        this._asignacionVariableComa = _asignacionVariableComa;
    }

    public AsignacionVariable(Variable _variable, igual _igual, constChar _constChar, AsignacionVariableComa _asignacionVariableComa) {
        this._variable = _variable;
        this._igual = _igual;
        this._constChar = _constChar;
        this._asignacionVariableComa = _asignacionVariableComa;
    }

    public AsignacionVariable(Variable _variable, igual _igual, constStr _constStr, AsignacionVariableComa _asignacionVariableComa) {
        this._variable = _variable;
        this._igual = _igual;
        this._constStr = _constStr;
        this._asignacionVariableComa = _asignacionVariableComa;
    }

    public AsignacionVariable(puntoYComa _puntoYComa) {
        this._puntoYComa = _puntoYComa;
    }

}
