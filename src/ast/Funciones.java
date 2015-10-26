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
public class Funciones {

    public Tipo _tipo;
    public nombreVariable _nombreVariable;
    public FuncionesParametros _funcionesParametros;
    public Codigo _codigo;
    public Funciones _funciones;

    public Funciones(Tipo t, nombreVariable i, FuncionesParametros fp, Codigo c, Funciones f) {
        this._tipo = t;
        this._nombreVariable = i;
        this._funcionesParametros = fp;
        this._codigo = c;
        this._funciones = f;
    }

}
