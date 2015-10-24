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

    public Tipo p;
    public MainClass main;
    public parentesisIzquierdo parIz;
    public parentesisDerecho parDer;
    public llaveIzquierda llIz;
    public Codigo cs;
    public llaveDerecha llDer;
    public Funciones fun;
    public String Main;

    public MainClass() {
        this.Main = "Main";
    }

    public MainClass(Tipo p, MainClass main, parentesisIzquierdo parIz, parentesisDerecho parDer, llaveIzquierda llIz, Codigo cs, llaveDerecha llDer, Funciones fun) {
        this.p = p;
        this.main = main;
        this.parIz = parIz;
        this.parDer = parDer;
        this.llIz = llIz;
        this.cs = cs;
        this.llDer = llDer;
        this.fun = fun;
    }

}
