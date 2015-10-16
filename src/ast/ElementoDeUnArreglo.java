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
public class ElementoDeUnArreglo {

    public nombreVariable nv;
    public OperacionAritmetica o;

    public ElementoDeUnArreglo(nombreVariable nv, OperacionAritmetica o) {
        this.nv = nv;
        this.o = o;
    }
}
