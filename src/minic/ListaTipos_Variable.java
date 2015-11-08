/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minic;

import ast.*;

/**
 *
 * @author Gabriel
 */
public class ListaTipos_Variable extends ListaTipos {

    private Tipo _tipo;

    public ListaTipos_Variable(Tipo _tipo, String _nombre, int _ambito) {
        super(_nombre, _ambito);
        this._tipo = _tipo;

    }

    public Tipo getTipo() {
        return _tipo;
    }

}
