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

    public Tipo t;
    public nombreVariable i;
    public DeclaracionFuncionParametros p;
    public parentesisIzquierdo parIz;
    public parentesisDerecho parDer;
    public puntoYComa puntoComa;
    public VOID _void;

    public DeclaracionFuncion(Tipo t, nombreVariable i, parentesisIzquierdo parIz, DeclaracionFuncionParametros p, parentesisDerecho parDer, puntoYComa punto_coma) {
        this.t = t;
        this.i = i;
        this.parIz = parIz;
        this.p = p;
        this.parDer = parDer;
        this.puntoComa = punto_coma;
    }
    
    
    public DeclaracionFuncion(VOID _void, nombreVariable i, parentesisIzquierdo parIz, DeclaracionFuncionParametros p, parentesisDerecho parDer, puntoYComa punto_coma) {
        this._void = _void;
        this.i = i;
        this.parIz = parIz;
        this.p = p;
        this.parDer = parDer;
        this.puntoComa = punto_coma;
    }


}
