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
public abstract class OperacionAritmetica {

    public OperacionAritmetica o1;
    public OperacionAritmetica2 o2;

    public OperacionAritmetica(OperacionAritmetica o1, OperacionAritmetica2 o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    public OperacionAritmetica(OperacionAritmetica2 o2) {
        this.o2 = o2;
    }

    public OperacionAritmetica getO1() {
        return o1;
    }

    public OperacionAritmetica2 getO2() {
        return o2;
    }

    public void setO1(OperacionAritmetica o1) {
        this.o1 = o1;
    }

    public void setO2(OperacionAritmetica2 o2) {
        this.o2 = o2;
    }

}
