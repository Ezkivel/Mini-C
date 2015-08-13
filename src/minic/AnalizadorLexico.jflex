/* Directivas JFlex */

package minic;
import static minic.Token.*;

%%
/* Expresiones Regulares */

%class AnalizadorLexico
%unicode
%standalone
%line
%column

Letra = [a-zA-Z]
Palabra = [a-zA-Z]+
Entero = [0-9]+
CaracterEspecial = ("!"|"@"|"#"|"$"|"%"|"^"|"_"|"="|","|":")
Espacio = [\s]

TipoVariable = int|char|string
Variable = {Letra}({Letra}|{Entero}|"_")*
ConstChar = '[a-zA-Z]'
ConstStr = \"[ [a-zA-Z]|[0-9]|[\s] ]*\"
ParentesisIzquierdo = "("
ParentesisDerecho = ")"
OperadorAritmetico = ("+"|"-"|"*"|"/")
OperadorRelacional = (">"|">="|"<"|"<="|"=="|"!=")
ComentarioUnaLinea = [\/][\/][ [a-zA-Z]|[0-9] ]*
ComentarioMultiLinea = [\/][\*][ [a-zA-Z]|[0-9]|[\s] ]*[\*][\/]
FinLinea = ;

%%

{TipoVariable} {return new Token("TipoVariable", yytext(), yyline + 1, yycolumn + 1);}
{Variable} {return new Token("Variable", yytext(), yyline + 1, yycolumn + 1);}
{ConstChar} {return new Token("ConstChar", yytext(), yyline + 1, yycolumn + 1);}
{ConstStr} {return new Token("ConstStr", yytext(), yyline + 1, yycolumn + 1);}
{ParentesisIzquierdo} {return new Token("ParentesisIzquierdo", yytext(), yyline + 1, yycolumn + 1);}
{ParentesisDerecho} {return new Token("ParentesisDerecho", yytext(), yyline + 1, yycolumn + 1);}
{OperadorAritmetico} {return new Token("OperadorAritmetico", yytext(), yyline + 1, yycolumn + 1);}
{OperadorRelacional} {return new Token("OperadorRelacional", yytext(), yyline + 1, yycolumn + 1);}
{CaracterEspecial} {return new Token("CaracterEspecial", yytext(), yyline + 1, yycolumn + 1);}
{Entero} {return new Token("Entero", yytext(), yyline + 1, yycolumn + 1);}
{ComentarioUnaLinea} {/* ignore */}
{ComentarioMultiLinea} {/* ignore */}
{Espacio} {/* ignore */}
{FinLinea} {return new Token("FinLinea", yytext(), yyline + 1, yycolumn + 1);}

