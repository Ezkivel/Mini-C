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
    public OperacionAritmetica _operacionAritmetica;
    public AsignacionVariableComa _asignacionVariableComa;
    public operadorAritmeticoIgual _operadorAritmeticoIgual;
    public constChar _constChar;
    public constStr _constStr;

    public AsignacionVariable(Variable v, OperacionAritmetica oa, AsignacionVariableComa avc) {
        this._variable = v;
        this._operacionAritmetica = oa;
        this._asignacionVariableComa = avc;
    }

    public AsignacionVariable(Variable v, OperacionAritmetica oa, AsignacionVariableComa avc, operadorAritmeticoIgual oi) {
        this._variable = v;
        this._operacionAritmetica = oa;
        this._asignacionVariableComa = avc;
        this._operadorAritmeticoIgual = oi;
    }

    public AsignacionVariable(Variable v, AsignacionVariableComa avc, constChar cstC) {
        this._variable = v;
        this._asignacionVariableComa = avc;
        this._constChar = cstC;
    }

    public AsignacionVariable(Variable v, AsignacionVariableComa avc, constStr cstS) {
        this._variable = v;
        this._asignacionVariableComa = avc;
        this._constStr = cstS;
    }

    public AsignacionVariable() {
    }

}
