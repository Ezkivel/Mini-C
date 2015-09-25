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

    public Tipo t;
    public nombreVariable i;
    public FuncionesParametros fp;
    public Codigo c;
    public Funciones f;

    public Funciones(Tipo t, nombreVariable i, FuncionesParametros fp, Codigo c, Funciones f) {
        this.t = t;
        this.i = i;
        this.fp = fp;
        this.c = c;
        this.f = f;
    }

}
