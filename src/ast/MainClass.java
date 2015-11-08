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
public class MainClass {

    public Tipo _tipo;
    public MainClass _main;
    public parentesisIzquierdo _parIz;
    public parentesisDerecho _parDer;
    public llaveIzquierda _llIz;
    public Codigos _codigos;
    public llaveDerecha _llDer;
    public Funciones _funciones;
    public String Main;

    public MainClass() {
        this.Main = "Main";
    }

    public MainClass(Tipo p, MainClass main, parentesisIzquierdo parIz, parentesisDerecho parDer, llaveIzquierda llIz, Codigos cs, llaveDerecha llDer, Funciones fun) {
        this._tipo = p;
        this._main = main;
        this._parIz = parIz;
        this._parDer = parDer;
        this._llIz = llIz;
        this._codigos = cs;
        this._llDer = llDer;
        this._funciones = fun;
    }

}
