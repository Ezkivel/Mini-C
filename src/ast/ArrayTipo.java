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
public class ArrayTipo extends Tipo {

    public Tipo tipo;
    public int tamano;

    public ArrayTipo(int tamano, Tipo tipo) {
        this.tipo = tipo;
        this.tamano = tamano;
    }

}
