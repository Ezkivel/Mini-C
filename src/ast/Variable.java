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
public class Variable {

    public nombreVariable i;
    public ElementoDeUnArreglo ea;

    public Variable(nombreVariable i) {
        this.i = i;
    }

    public Variable(ElementoDeUnArreglo ea) {
        this.ea = ea;
    }

}
