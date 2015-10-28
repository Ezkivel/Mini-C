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
public class For {

    public parentesisIzquierdo _parIz;
    public ForInicializacion _forInicializacion;
    public puntoYComa _puntoYComa1;
    public Condicion _condicion;
    public puntoYComa __puntoYComa2;
    public ForActualizacion _forActualizacion;
    public parentesisDerecho _parDer;
    public llaveIzquierda _llIz;
    public Codigo _codigo;
    public llaveDerecha llDer;

    public For(parentesisIzquierdo _parIz, ForInicializacion _forInicializacion, puntoYComa _puntoYComa1, Condicion _condicion, puntoYComa __puntoYComa2, ForActualizacion _forActualizacion, parentesisDerecho _parDer, llaveIzquierda _llIz, Codigo _codigo, llaveDerecha llDer) {
        this._parIz = _parIz;
        this._forInicializacion = _forInicializacion;
        this._puntoYComa1 = _puntoYComa1;
        this._condicion = _condicion;
        this.__puntoYComa2 = __puntoYComa2;
        this._forActualizacion = _forActualizacion;
        this._parDer = _parDer;
        this._llIz = _llIz;
        this._codigo = _codigo;
        this.llDer = llDer;
    }

    public For(parentesisIzquierdo _parIz, puntoYComa _puntoYComa1, Condicion _condicion, puntoYComa __puntoYComa2, ForActualizacion _forActualizacion, parentesisDerecho _parDer, llaveIzquierda _llIz, Codigo _codigo, llaveDerecha llDer) {
        this._parIz = _parIz;
        this._puntoYComa1 = _puntoYComa1;
        this._condicion = _condicion;
        this.__puntoYComa2 = __puntoYComa2;
        this._forActualizacion = _forActualizacion;
        this._parDer = _parDer;
        this._llIz = _llIz;
        this._codigo = _codigo;
        this.llDer = llDer;
    }

    public For(parentesisIzquierdo _parIz, ForInicializacion _forInicializacion, puntoYComa _puntoYComa1, Condicion _condicion, puntoYComa __puntoYComa2, parentesisDerecho _parDer, llaveIzquierda _llIz, Codigo _codigo, llaveDerecha llDer) {
        this._parIz = _parIz;
        this._forInicializacion = _forInicializacion;
        this._puntoYComa1 = _puntoYComa1;
        this._condicion = _condicion;
        this.__puntoYComa2 = __puntoYComa2;
        this._parDer = _parDer;
        this._llIz = _llIz;
        this._codigo = _codigo;
        this.llDer = llDer;
    }

    public For(parentesisIzquierdo _parIz, puntoYComa _puntoYComa1, Condicion _condicion, puntoYComa __puntoYComa2, parentesisDerecho _parDer, llaveIzquierda _llIz, Codigo _codigo, llaveDerecha llDer) {
        this._parIz = _parIz;
        this._puntoYComa1 = _puntoYComa1;
        this._condicion = _condicion;
        this.__puntoYComa2 = __puntoYComa2;
        this._parDer = _parDer;
        this._llIz = _llIz;
        this._codigo = _codigo;
        this.llDer = llDer;
    }

}
/*
 
 
 | FOR parentesisIzquierdo puntoYComa puntoYComa parentesisDerecho llaveIzquierda codigo llaveDerecha
 | FOR error parentesisDerecho llaveIzquierda codigo llaveDerecha;
 */
