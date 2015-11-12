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
public class InicializacionArreglo {

    public OperacionAritmetica _operacionAritmetica;
    public constChar _constChar;
    public constStr _constStr;
    public InicializacionArregloComa _inicializacionArregloComa;
    private Tipo tipo;

    public InicializacionArreglo(OperacionAritmetica _operacionAritmetica, InicializacionArregloComa _inicializacionArregloComa) {
        this._operacionAritmetica = _operacionAritmetica;
        this._inicializacionArregloComa = _inicializacionArregloComa;
    }

    public InicializacionArreglo(constChar _constChar, InicializacionArregloComa _inicializacionArregloComa) {
        this._constChar = _constChar;
        this._inicializacionArregloComa = _inicializacionArregloComa;
    }

    public InicializacionArreglo(constStr _constStr, InicializacionArregloComa _inicializacionArregloComa) {
        this._constStr = _constStr;
        this._inicializacionArregloComa = _inicializacionArregloComa;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
