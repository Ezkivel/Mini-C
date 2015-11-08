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
public class Printf extends Codigo{

    public parentesisIzquierdo _parIz;
    public constStr _constStr;
    public coma _coma;
    public OperacionAritmetica _operacionAritmetica;
    public parentesisDerecho _parDer;
    public puntoYComa _puntoYComa;

    public Printf(parentesisIzquierdo _parIz, constStr _constStr, coma _coma, OperacionAritmetica _operacionAritmetica, parentesisDerecho _parDer, puntoYComa _puntoYComa) {
        this._parIz = _parIz;
        this._constStr = _constStr;
        this._coma = _coma;
        this._operacionAritmetica = _operacionAritmetica;
        this._parDer = _parDer;
        this._puntoYComa = _puntoYComa;
    }

    public Printf(parentesisIzquierdo _parIz, constStr _constStr, parentesisDerecho _parDer, puntoYComa _puntoYComa) {
        this._parIz = _parIz;
        this._constStr = _constStr;
        this._parDer = _parDer;
        this._puntoYComa = _puntoYComa;
    }

}
