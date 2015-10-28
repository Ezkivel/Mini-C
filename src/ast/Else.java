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
public class Else {

    public parentesisIzquierdo _parIz;
    public Condicion _condicion;
    public parentesisDerecho _parDer;
    public llaveIzquierda _llIz;
    public Codigo _codigo;
    public llaveDerecha _llDer;
    public Else _else;

    public Else(parentesisIzquierdo _parIz, Condicion _condicion, parentesisDerecho _parDer, llaveIzquierda _llIz, Codigo _codigo, llaveDerecha _llDer, Else _else) {
        this._parIz = _parIz;
        this._condicion = _condicion;
        this._parDer = _parDer;
        this._llIz = _llIz;
        this._codigo = _codigo;
        this._llDer = _llDer;
        this._else = _else;
    }

    public Else(llaveIzquierda _llIz, Codigo _codigo, llaveDerecha _llDer) {
        this._llIz = _llIz;
        this._codigo = _codigo;
        this._llDer = _llDer;

    }

    public Else(parentesisDerecho _parDer, llaveIzquierda _llIz, Codigo _codigo, llaveDerecha _llDer, Else _else) {
        this._parDer = _parDer;
        this._llIz = _llIz;
        this._codigo = _codigo;
        this._llDer = _llDer;
        this._else = _else;
    }

}
