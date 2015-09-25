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
class While {

    public Condicion c;
    public Codigo cc;

    public While(Condicion c, Codigo cc) {
        this.c = c;
        this.cc = cc;
    }

}
