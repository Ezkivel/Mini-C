/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import minic.Token;

/**
 *
 * @author Gabriel
 */
public class operadorRelacional {
    public Token operador;

    public operadorRelacional(Token operador) {
        this.operador = operador;
    }
    
    public String getOperador() {
        return operador.getContenido();
    }

    public void setOperador(Token operador) {
        this.operador = operador;
    }
}
