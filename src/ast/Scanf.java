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
public class Scanf extends Codigo{

    public parentesisIzquierdo _parIz;
    public parametroScanf _parametroScanf;
    public coma _coma;
    public nombreVariable _nombreVariable;
    public ElementoDeUnArreglo _elementoDeUnArreglo;
    public parentesisDerecho _parDer;
    public puntoYComa _puntoYComa;

    public Scanf(parentesisIzquierdo _parIz, parametroScanf _parametroScanf, coma _coma, nombreVariable _nombreVariable, parentesisDerecho _parDer, puntoYComa _puntoYComa) {
        this._parIz = _parIz;
        this._parametroScanf = _parametroScanf;
        this._coma = _coma;
        this._nombreVariable = _nombreVariable;
        this._parDer = _parDer;
        this._puntoYComa = _puntoYComa;
    }

    public Scanf(parentesisIzquierdo _parIz, parametroScanf _parametroScanf, coma _coma, ElementoDeUnArreglo _elementoDeUnArreglo, parentesisDerecho _parDer, puntoYComa _puntoYComa) {
        this._parIz = _parIz;
        this._parametroScanf = _parametroScanf;
        this._coma = _coma;
        this._elementoDeUnArreglo = _elementoDeUnArreglo;
        this._parDer = _parDer;
        this._puntoYComa = _puntoYComa;
    }

}
