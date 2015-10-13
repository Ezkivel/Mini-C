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

    public DeclaracionFuncion(Tipo t, nombreVariable i, DeclaracionFuncionParametros p) {
        this.t = t;
        this.i = i;
        this.p = p;
    }


}
