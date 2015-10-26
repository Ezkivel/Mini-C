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
public class DeclaracionFuncion {

    public Tipo _tipo;
    public nombreVariable _nombreVariable;
    public DeclaracionFuncionParametros _declaracionFuncionParametros;
    public parentesisIzquierdo _parIz;
    public parentesisDerecho _parDer;
    public puntoYComa _puntoYComa;
    public VOID _void;

    public DeclaracionFuncion(Tipo t, nombreVariable i, parentesisIzquierdo parIz, DeclaracionFuncionParametros p, parentesisDerecho parDer, puntoYComa punto_coma) {
        this._tipo = t;
        this._nombreVariable = i;
        this._parIz = parIz;
        this._declaracionFuncionParametros = p;
        this._parDer = parDer;
        this._puntoYComa = punto_coma;
    }

    public DeclaracionFuncion(VOID _void, nombreVariable i, parentesisIzquierdo parIz, DeclaracionFuncionParametros p, parentesisDerecho parDer, puntoYComa punto_coma) {
        this._void = _void;
        this._nombreVariable = i;
        this._parIz = parIz;
        this._declaracionFuncionParametros = p;
        this._parDer = parDer;
        this._puntoYComa = punto_coma;
    }

    public DeclaracionFuncion(puntoYComa _puntoYComa) {
        this._puntoYComa = _puntoYComa;
    }

}
