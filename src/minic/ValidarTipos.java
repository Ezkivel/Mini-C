/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minic;

import ast.ArrayTipo;
import ast.CharTipo;
import ast.IntegerTipo;
import ast.OperacionAritmetica;
import ast.StringTipo;
import ast.constChar;
import ast.constStr;
import ast.entero;
import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class ValidarTipos {
    ///validar los tipos

    private Vector<_ListaTipos> lista;

    public ValidarTipos(Vector<_ListaTipos> lista) {
        this.lista = lista;
        validar_funciones();
    }

    public void validar_funciones() {

        for (int i = 0; i < lista.size(); i++) {
            if (lista.elementAt(i).getTipo() instanceof CharTipo) {
                if (!(lista.elementAt(i).getContenidoChar() instanceof constChar)) {
                    System.err.println("ERROR TIPO SE ESPERABA UN CHAR");
                }
            } else if (lista.elementAt(i).getTipo() instanceof ArrayTipo) {

            } else if (lista.elementAt(i).getTipo() instanceof StringTipo) {
                if (!(lista.elementAt(i).getContenidoStr() instanceof constStr)) {
                    System.err.println("ERROR TIPO SE ESPERABA UN STRING");
                }
            } else if (lista.elementAt(i).getTipo() instanceof IntegerTipo) {
                 if (!(lista.elementAt(i).getContenidoArit()._operacionAritmetica2._operacionAritmetica3._entero instanceof entero)) {
                    System.err.println("ERROR TIPO SE ESPERABA UN ENTERO");
                }else if (!(lista.elementAt(i).getContenidoArit()._operacionAritmetica2._operacionAritmetica3._llamadoAFuncion._nombreVariable._nombreVariable == "hola") ){
                    
                }
            }
        }

    }

}
