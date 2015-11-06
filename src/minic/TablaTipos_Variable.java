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
public class TablaTipos_Variable extends TablaTipos {

    private Tipo _tipo;
    private boolean parametro;
    private int direccion;

    public TablaTipos_Variable(Tipo _tipo, boolean parametro, int direccion, String _nombre, String _ambito) {
        super(_nombre, _ambito);
        this._tipo = _tipo;
        this.parametro = parametro;
        this.direccion = direccion;
    }

    public Tipo getTipo() {
        return _tipo;
    }

    public boolean isParametro() {
        return parametro;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

}
