/* Directivas JFlex */

package minic;
import static minic.Token.*;
import java_cup.runtime.*;

%%
/* Expresiones Regulares */

%class AnalizadorLexico
%unicode
%standalone
%line
%char
%column
%unicode

co = [\"]
Letra = [a-zA-Z]
Entero = [0-9]
Numero = [0-9]+
Espacio = [" "|\t\r\n]
CaracterEspecial = ("!"|"@"|"#"|"$"|"%"|"^"|"&"|"("|")"|"_"|"="|"+"|"-"|","|":"|"\\")
FinLinea = ;
Cadena= (({Letra}|{Entero}|{CaracterEspecial})+{Espacio}*({Letra}|{Entero}|{CaracterEspecial})*)+
Id = {Letra}({Letra}|{Entero}|"_")*

%%

{Id} {return new Token("Id", yytext(), yyline, yycolumn + 1);}
{CaracterEspecial} {return new Token("CaracterEspecial", yytext(), yyline, yycolumn + 1);}
{Numero} {return new Token("Numero", yytext(), yyline, yycolumn + 1);}
{FinLinea} {return new Token("FinLinea", yytext(), yyline, yycolumn + 1);}
{Espacio} {/* ignore */}

