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
public class ListaTipos_Variable {

    private Tipo _tipo;
    private String nombre;
    private int ambito;
    private Object contenido;

    public ListaTipos_Variable(Tipo _tipo, String nombre, int ambito) {
        this._tipo = _tipo;
        this.nombre = nombre;
        this.ambito = ambito;
    }

    public Tipo getTipo() {
        return _tipo;
    }

    public void setTipo(Tipo _tipo) {
        this._tipo = _tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAmbito() {
        return ambito;
    }

    public void setAmbito(int ambito) {
        this.ambito = ambito;
    }

}
