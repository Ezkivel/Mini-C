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
public class Funciones {

    public Tipo _tipo;
    public Void _void;
    public nombreVariable _nombreVariable;
    public parentesisIzquierdo _parIz;
    public FuncionesParametros _funcionesParametros;
    public parentesisDerecho _parDer;
    public llaveIzquierda llIz;
    public Codigo _codigo;
    public llaveDerecha _llaDer;
    public Funciones _funciones;

    public Funciones(Tipo _tipo, nombreVariable _nombreVariable, parentesisIzquierdo _parIz, FuncionesParametros _funcionesParametros, parentesisDerecho _parDer, llaveIzquierda llIz, Codigo _codigo, llaveDerecha _llaDer, Funciones _funciones) {
        this._tipo = _tipo;
        this._nombreVariable = _nombreVariable;
        this._parIz = _parIz;
        this._funcionesParametros = _funcionesParametros;
        this._parDer = _parDer;
        this.llIz = llIz;
        this._codigo = _codigo;
        this._llaDer = _llaDer;
        this._funciones = _funciones;
    }

    public Funciones(Void _void, nombreVariable _nombreVariable, parentesisIzquierdo _parIz, FuncionesParametros _funcionesParametros, parentesisDerecho _parDer, llaveIzquierda llIz, Codigo _codigo, llaveDerecha _llaDer, Funciones _funciones) {
        this._void = _void;
        this._nombreVariable = _nombreVariable;
        this._parIz = _parIz;
        this._funcionesParametros = _funcionesParametros;
        this._parDer = _parDer;
        this.llIz = llIz;
        this._codigo = _codigo;
        this._llaDer = _llaDer;
        this._funciones = _funciones;
    }

    public Funciones(Tipo _tipo, parentesisDerecho _parDer, llaveIzquierda llIz, Codigo _codigo, llaveDerecha _llaDer, Funciones _funciones) {
        this._tipo = _tipo;
        this._parDer = _parDer;
        this.llIz = llIz;
        this._codigo = _codigo;
        this._llaDer = _llaDer;
        this._funciones = _funciones;
    }

    public Funciones(Void _void, parentesisDerecho _parDer, llaveIzquierda llIz, Codigo _codigo, llaveDerecha _llaDer, Funciones _funciones) {
        this._void = _void;
        this._parDer = _parDer;
        this.llIz = llIz;
        this._codigo = _codigo;
        this._llaDer = _llaDer;
        this._funciones = _funciones;
    }
    
    

}
