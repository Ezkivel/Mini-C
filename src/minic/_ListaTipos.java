/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minic;

import ast.*;
import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class _ListaTipos {

    private Tipo _tipo;
    private String nombre;
    private int ambito;
    private Vector<Tipo> _parametros;
    private RETURN _return;

    public _ListaTipos(Tipo _tipo, String nombre, int ambito) {
        this._tipo = _tipo;
        this.nombre = nombre;
        this.ambito = ambito;
    }

    public _ListaTipos(Tipo _tipo_retorno, String nombre, Vector<Tipo> _parametros) {
        this._tipo = _tipo_retorno;
        this.nombre = nombre;
        this._parametros = _parametros;
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

    public Vector<Tipo> getParametros() {
        return _parametros;
    }

    public void setParametros(Vector<Tipo> _parametros) {
        this._parametros = _parametros;
    }

    public RETURN getReturn() {
        return _return;
    }

    public void setReturn(RETURN _return) {
        this._return = _return;
    }

    @Override
    public String toString() {
        return "_ListaTipos{" + "_tipo=" + getTipo() + ", nombre=" + getNombre() + ", ambito=" + getAmbito() + ", _parametros=" + _parametros + ", _return=" + _return + '}';
    }

}
