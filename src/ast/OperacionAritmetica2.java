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
public abstract class OperacionAritmetica2 extends OperacionAritmetica {

    public OperacionAritmetica3 o3;

    public OperacionAritmetica2(OperacionAritmetica o1, OperacionAritmetica2 o2, OperacionAritmetica3 o3) {
        super(o1, o2);
        super.o1 = o2;
        this.o3 = o3;
    }

    public OperacionAritmetica2(OperacionAritmetica2 o2, OperacionAritmetica3 o3) {
        super(o2);
        this.o3 = o3;
    }

}
