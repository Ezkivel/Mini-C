/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class DeclaracionFuncionParametros {

    public Tipo t;
    public nombreVariable i;
    private Vector list;
    
    //falta el arreglo
    
    public DeclaracionFuncionParametros(Tipo t, nombreVariable i) {
        this.t = t;
        this.i = i;
    }

    public DeclaracionFuncionParametros(Tipo t) {
        this.t = t;
    }
    
    public DeclaracionFuncionParametros() {
    }

}
