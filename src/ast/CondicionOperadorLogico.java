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
public class CondicionOperadorLogico {

    public operadorLogico _operadorLogico;
    public Condicion _condicion;

    public CondicionOperadorLogico(operadorLogico _operadorLogico, Condicion _condicion) {
        this._operadorLogico = _operadorLogico;
        this._condicion = _condicion;
    }
}
