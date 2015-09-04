/* Directivas JFlex */

package minic;
import static minic.Token.*;
import java_cup.runtime.*;

%%
/* Expresiones Regulares */

%class AnalizadorLexico
%unicode
%cup
%line
%column

Entero = [0-9]+
Espacio = [\s]
TipoVariable = int|char|string
NombreVariable = [a-zA-Z][[a-zA-Z]|[0-9]|"_"]*
Coma = ,
ConstChar = '[a-zA-Z]'
ConstStr = \"[ [a-zA-Z]|[0-9]|[\s] ]*\"
If = if 
ParamentroScanf = \""%"d\" | \""%"c\" | \""%"s\" | \""%"i\"
Else = else
While = while
AND = &
For = for
True = true
False = false
Printf = printf
Scanf = scanf
Main = main
Return = return
CorcheteIzquierdo = "["
CorcheteDerecho = "]"
LlaveIzquierda = "{" 
LlaveDerecha = "}"
ParentesisIzquierdo = "("
ParentesisDerecho = ")"
Igual = "="
OperadorAritmeticoIgual = ("+="|"-="|"*="|"/=")
OperadorSuma = "+"
OperadorResta = "-"
OperadorMultiplicacion = "*"
OperadorDivision = "/"
OperadorIncrementoDecremento = ("++"|"--")
OperadorRelacional = (">"|">="|"<"|"<="|"=="|"!=")
OperadorLogico = ("||"|"&&")
ComentarioUnaLinea = "//" ~[^*] | "//" "*"+ 
ComentarioMultiLinea = "/*" [^*] ~"*/" | "/*" "*"+ "*/" 
PuntoYComa = ;

%%

{TipoVariable} {return new Symbol(sym.tipoVariable, new Token("TipoVariable", yytext(), yyline + 1, yycolumn + 1));}
{AND} {return new Symbol(sym.and, new Token("AND", yytext(), yyline + 1, yycolumn + 1));}
{ParamentroScanf} {return new Symbol(sym.parametroScanf, new Token("ParamentroScanf", yytext(), yyline + 1, yycolumn + 1));}
{Coma} {return new Symbol(sym.coma, new Token("Coma", yytext(), yyline + 1, yycolumn + 1));}
{True} {return new Symbol(sym.TRUE, new Token("True", yytext(), yyline + 1, yycolumn + 1));}
{False} {return new Symbol(sym.FALSE, new Token("False", yytext(), yyline + 1, yycolumn + 1));}
{If} {return new Symbol(sym.IF, new Token("If", yytext(), yyline + 1, yycolumn + 1));}
{Else} {return new Symbol(sym.ELSE, new Token("Else", yytext(), yyline + 1, yycolumn + 1));}
{While} {return new Symbol(sym.WHILE, new Token("While", yytext(), yyline + 1, yycolumn + 1));}
{For} {return new Symbol(sym.FOR, new Token("For", yytext(), yyline + 1, yycolumn + 1));}
{Printf} {return new Symbol(sym.printf, new Token("Printf", yytext(), yyline + 1, yycolumn + 1));}
{Scanf} {return new Symbol(sym.scanf, new Token("Scanf", yytext(), yyline + 1, yycolumn + 1));}
{Main} {return new Symbol(sym.MAIN, new Token("Main", yytext(), yyline + 1, yycolumn + 1));}
{Return} {return new Symbol(sym.RETURN, new Token("Return", yytext(), yyline + 1, yycolumn + 1));}
{CorcheteIzquierdo} {return new Symbol(sym.corcheteIzquierdo, new Token("CorcheteIzquierdo", yytext(), yyline + 1, yycolumn + 1));}
{CorcheteDerecho} {return new Symbol(sym.corcheteDerecho, new Token("CorcheteDerecho", yytext(), yyline + 1, yycolumn + 1));}
{LlaveIzquierda} {return new Symbol(sym.llaveIzquierda, new Token("LlaveIzquierda", yytext(), yyline + 1, yycolumn + 1));}
{LlaveDerecha} {return new Symbol(sym.llaveDerecha, new Token("LlaveDerecha", yytext(), yyline + 1, yycolumn + 1));}
{NombreVariable} {return new Symbol(sym.nombreVariable, new Token("NombreVariable", yytext(), yyline + 1, yycolumn + 1));}
{ConstChar} {return new Symbol(sym.constChar, new Token("ConstChar", yytext(), yyline + 1, yycolumn + 1));}
{ConstStr} {return new Symbol(sym.constStr, new Token("ConstStr", yytext(), yyline + 1, yycolumn + 1));}
{ParentesisIzquierdo} {return new Symbol(sym.parentesisIzquierdo, new Token("ParentesisIzquierdo", yytext(), yyline + 1, yycolumn + 1));}
{ParentesisDerecho} {return new Symbol(sym.parentesisDerecho, new Token("ParentesisDerecho", yytext(), yyline + 1, yycolumn + 1));}
{Igual} {return new Symbol(sym.igual, new Token("Igual", yytext(), yyline + 1, yycolumn + 1));}
{OperadorAritmeticoIgual} {return new Symbol(sym.operadorAritmeticoIgual, new Token("OperadorAritmeticoIgual", yytext(), yyline + 1, yycolumn + 1));}
{OperadorSuma} {return new Symbol(sym.operadorSuma, new Token("OperadorSuma", yytext(), yyline + 1, yycolumn + 1));}
{OperadorResta} {return new Symbol(sym.operadorResta, new Token("OperadorResta", yytext(), yyline + 1, yycolumn + 1));}
{OperadorMultiplicacion} {return new Symbol(sym.operadorMultiplicacion, new Token("OperadorMultiplicacion", yytext(), yyline + 1, yycolumn + 1));}
{OperadorDivision} {return new Symbol(sym.operadorDivision, new Token("OperadorDivision", yytext(), yyline + 1, yycolumn + 1));}
{OperadorIncrementoDecremento} {return new Symbol(sym.operadorIncrementoDecremento, new Token("OperadorIncrementoDecremento", yytext(), yyline + 1, yycolumn + 1));}
{OperadorRelacional} {return new Symbol(sym.operadorRelacional, new Token("OperadorRelacional", yytext(), yyline + 1, yycolumn + 1));}
{OperadorLogico} {return new Symbol(sym.operadorLogico, new Token("OperadorLogico", yytext(), yyline + 1, yycolumn + 1));}
{Entero} {return new Symbol(sym.entero, new Token("Entero", yytext(), yyline + 1, yycolumn + 1));}
{ComentarioUnaLinea} {/* ignore */}
{ComentarioMultiLinea} {/* ignore */}
{Espacio} {/* ignore */}
{PuntoYComa} {return new Symbol(sym.puntoYComa, new Token("PuntoYComa", yytext(), yyline + 1, yycolumn + 1));}
[^] {System.out.println("Illegal character <"+ yytext()+">, linea: " + (yyline+1) + ", columna: " + (yycolumn+1));}