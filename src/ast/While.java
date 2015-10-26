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
public class While {

    public Condicion _condicion;
    public Codigo _codigo;

    public While(Condicion c, Codigo cc) {
        this._condicion = c;
        this._codigo = cc;
    }

}
