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
    private constChar contenidoChar;
    private constStr contenidoStr;
    private OperacionAritmetica contenidoArit;

    public ListaTipos_Variable(Tipo _tipo, String nombre, int ambito) {
        this._tipo = _tipo;
        this.nombre = nombre;
        this.ambito = ambito;
    }

    public ListaTipos_Variable(Tipo _tipo, String nombre, int ambito, constChar contenidoChar) {
        this._tipo = _tipo;
        this.nombre = nombre;
        this.ambito = ambito;
        this.contenidoChar = contenidoChar;
    }

    public ListaTipos_Variable(Tipo _tipo, String nombre, int ambito, constStr contenidoStr) {
        this._tipo = _tipo;
        this.nombre = nombre;
        this.ambito = ambito;
        this.contenidoStr = contenidoStr;
    }

    public ListaTipos_Variable(Tipo _tipo, String nombre, int ambito, OperacionAritmetica contenidoArit) {
        this._tipo = _tipo;
        this.nombre = nombre;
        this.ambito = ambito;
        this.contenidoArit = contenidoArit;
    }

    public constChar getContenidoChar() {
        return contenidoChar;
    }

    public constStr getContenidoStr() {
        return contenidoStr;
    }

    public OperacionAritmetica getContenidoArit() {
        return contenidoArit;
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
