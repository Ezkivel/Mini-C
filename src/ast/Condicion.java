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
public class Condicion {

    public OperacionAritmetica _operacionAritmetica1;
    public OperacionAritmetica _operacionAritmetica2;
    public constChar _constChar;
    public constStr _constStr;
    public operadorRelacional _operadorRelacional;
    public parentesisIzquierdo _parentesisIzquierdo;
    public Condicion _condicion;
    public parentesisDerecho _parentesisDerecho;
    public CondicionOperadorLogico _condicionOperadorLogico;

    public Condicion(OperacionAritmetica _operacionAritmetica1, operadorRelacional _operadorRelacional, OperacionAritmetica _operacionAritmetica2, CondicionOperadorLogico _condicionOperadorLogico) {
        this._operacionAritmetica1 = _operacionAritmetica1;
        this._operadorRelacional = _operadorRelacional;
        this._operacionAritmetica2 = _operacionAritmetica2;
        this._condicionOperadorLogico = _condicionOperadorLogico;
    }

    public Condicion(OperacionAritmetica _operacionAritmetica1, operadorRelacional _operadorRelacional, constChar _constChar, CondicionOperadorLogico _condicionOperadorLogico) {
        this._operacionAritmetica1 = _operacionAritmetica1;
        this._operadorRelacional = _operadorRelacional;
        this._constChar = _constChar;
        this._condicionOperadorLogico = _condicionOperadorLogico;
    }

    public Condicion(OperacionAritmetica _operacionAritmetica1, operadorRelacional _operadorRelacional, constStr _constStr, CondicionOperadorLogico _condicionOperadorLogico) {
        this._operacionAritmetica1 = _operacionAritmetica1;
        this._operadorRelacional = _operadorRelacional;
        this._constStr = _constStr;
        this._condicionOperadorLogico = _condicionOperadorLogico;
    }

    public Condicion(constChar _constChar, operadorRelacional _operadorRelacional, OperacionAritmetica _operacionAritmetica1, CondicionOperadorLogico _condicionOperadorLogico) {
        this._operacionAritmetica1 = _operacionAritmetica1;
        this._constChar = _constChar;
        this._operadorRelacional = _operadorRelacional;
        this._condicionOperadorLogico = _condicionOperadorLogico;
    }

    public Condicion(constStr _constStr, operadorRelacional _operadorRelacional, OperacionAritmetica _operacionAritmetica1, CondicionOperadorLogico _condicionOperadorLogico) {
        this._operacionAritmetica1 = _operacionAritmetica1;
        this._constStr = _constStr;
        this._operadorRelacional = _operadorRelacional;
        this._condicionOperadorLogico = _condicionOperadorLogico;
    }

    public Condicion(parentesisIzquierdo _parentesisIzquierdo, Condicion _condicion, parentesisDerecho _parentesisDerecho, CondicionOperadorLogico _condicionOperadorLogico) {
        this._parentesisIzquierdo = _parentesisIzquierdo;
        this._condicion = _condicion;
        this._parentesisDerecho = _parentesisDerecho;
        this._condicionOperadorLogico = _condicionOperadorLogico;
    }

}
