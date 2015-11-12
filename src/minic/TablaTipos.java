/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minic;

import ast.ArrayTipo;

import ast.DeclaracionVariable;
import ast.If;
import ast.InicializacionArreglo;
import ast.OperacionAritmetica;
import ast.Programa;
import ast.constChar;
import ast.constStr;
import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class TablaTipos {

    private Vector<_ListaTipos> lista_varibles;
    private Vector<ListaTipos_Funciones> lista_funcones;
    private Programa programa;
    private ListaTipos lista;

    public TablaTipos(ListaTipos lista, Programa programa) {
        this.lista_varibles = new Vector();
        this.lista = lista;
        this.programa = programa;
        llenar_tabla_variables();
    }

    public Programa getPrograma() {
        return programa;
    }

    public void llenar_tabla_variables() {

        Programa pro = getPrograma();

        for (int i = 0; i < getPrograma()._mainClass._codigos.size(); i++) {
            System.out.println(getPrograma()._mainClass._codigos.elementAt(i));
            if(getPrograma()._mainClass._codigos.elementAt(i) instanceof If){
                for ( int j = 0; j < ((If)getPrograma()._mainClass._codigos.elementAt(i))._codigos.size(); j++)
                {
                   // System.out.println(((If)getPrograma()._mainClass._codigos.elementAt(i))._codigos.elementAt(j));
                }
            }
        }

        try {

            int n = lista.list.size();
            for (int i = 0; i < n; i++) {
                DeclaracionVariable d = lista.list.elementAt(i);
                int in = d._declaracionVariables.size();

                for (int j = 0; j < in; j++) {
                    if (d._declaracionVariables.elementAt(j)._inicializacionArreglo instanceof InicializacionArreglo) {
                        if (d._declaracionVariables.elementAt(j)._constChar instanceof constChar) {
                            lista_varibles.add(new _ListaTipos(new ArrayTipo(100, d._tipo), d._declaracionVariables.elementAt(j)._nombreVariable._nombreVariable, 0, d._declaracionVariables.elementAt(j)._constChar));
                        } else if (d._declaracionVariables.elementAt(j)._constStr instanceof constStr) {
                            lista_varibles.add(new _ListaTipos(new ArrayTipo(100, d._tipo), d._declaracionVariables.elementAt(j)._nombreVariable._nombreVariable, 0, d._declaracionVariables.elementAt(j)._constStr));
                        } else if (d._declaracionVariables.elementAt(j)._operacionAritmetica instanceof OperacionAritmetica) {
                            lista_varibles.add(new _ListaTipos(new ArrayTipo(100, d._tipo), d._declaracionVariables.elementAt(j)._nombreVariable._nombreVariable, 0, d._declaracionVariables.elementAt(j)._operacionAritmetica));
                        }

                    } else {
                        if (d._declaracionVariables.elementAt(j)._constChar instanceof constChar) {
                            lista_varibles.add(new _ListaTipos(d._tipo, d._declaracionVariables.elementAt(j)._nombreVariable._nombreVariable, 0, d._declaracionVariables.elementAt(j)._constChar));
                        } else if (d._declaracionVariables.elementAt(j)._constStr instanceof constStr) {
                            lista_varibles.add(new _ListaTipos(d._tipo, d._declaracionVariables.elementAt(j)._nombreVariable._nombreVariable, 0, d._declaracionVariables.elementAt(j)._constStr));
                        } else if (d._declaracionVariables.elementAt(j)._operacionAritmetica instanceof OperacionAritmetica) {
                            lista_varibles.add(new _ListaTipos(d._tipo, d._declaracionVariables.elementAt(j)._nombreVariable._nombreVariable, 0, d._declaracionVariables.elementAt(j)._operacionAritmetica));
                        }
                    }

                }

            }
        } catch (Exception e) {

        }
    }

    public Vector<_ListaTipos> getLista_varibles() {
        return lista_varibles;
    }

    public Vector<ListaTipos_Funciones> getLista_funcones() {
        return lista_funcones;
    }

    public void llenar_tabla_funciones() {

    }

    public void print() {
        int n = lista_varibles.size();
        for (int i = 0; i < n; i++) {
            if (lista_varibles.elementAt(i).getContenidoChar() instanceof constChar) {
                System.out.println(lista_varibles.elementAt(i).getTipo().getClass().getName() + " " + lista_varibles.elementAt(i).getNombre() + " " + lista_varibles.elementAt(i).getAmbito() + " " + lista_varibles.elementAt(i).getContenidoChar()._constChar);
            } else if (lista_varibles.elementAt(i).getContenidoStr() instanceof constStr) {
                System.out.println(lista_varibles.elementAt(i).getTipo().getClass().getName() + " " + lista_varibles.elementAt(i).getNombre() + " " + lista_varibles.elementAt(i).getAmbito() + " " + lista_varibles.elementAt(i).getContenidoStr()._constStr);
            } else if (lista_varibles.elementAt(i).getContenidoArit() instanceof OperacionAritmetica) {
                System.out.println(lista_varibles.elementAt(i).getTipo().getClass().getName() + " " + lista_varibles.elementAt(i).getNombre() + " " + lista_varibles.elementAt(i).getAmbito() + " " + lista_varibles.elementAt(i).getContenidoArit());
            }
        }
    }

}
