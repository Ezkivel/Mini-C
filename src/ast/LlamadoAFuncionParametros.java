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
public class LlamadoAFuncionParametros {

    public OperacionAritmetica _operacionAritmetica;
    public LlamadoAFuncionParametrosComa _llamadoAFuncionParametrosComa;
    public constChar _constChar;
    public constStr _constStr;

    public LlamadoAFuncionParametros(OperacionAritmetica _operacionAritmetica, LlamadoAFuncionParametrosComa _llamadoAFuncionParametrosComa) {
        this._operacionAritmetica = _operacionAritmetica;
        this._llamadoAFuncionParametrosComa = _llamadoAFuncionParametrosComa;
    }

    public LlamadoAFuncionParametros(constChar _constCha, LlamadoAFuncionParametrosComa _llamadoAFuncionParametrosComar) {
        this._llamadoAFuncionParametrosComa = _llamadoAFuncionParametrosComa;
        this._constChar = _constChar;
    }

    public LlamadoAFuncionParametros(constStr _constStr, LlamadoAFuncionParametrosComa _llamadoAFuncionParametrosComa) {
        this._llamadoAFuncionParametrosComa = _llamadoAFuncionParametrosComa;
        this._constStr = _constStr;
    }

}
