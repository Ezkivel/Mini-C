package Mini.c
import java_cup.runtime.Symbol;

%%
/* Directivas JFlex */

%cupsym sym1
%cup
%public
%unicode
%ignorecase

%class AnalizadorLexico
%line
%char
%colummn
%unicode

co = [\"]
Letras = [a-zA-Z]
Enteros = [0-9]
Espacio = [" "|\t\r\n]
CharEsp = ("!"|"@"|"#"|"$"|"%"|"^"|"&"|"("|")"|"_"|"="|"+"|"-"|","|":"|"\\")
cadena= (({Letras}|{Enteros}|{CharEsp})+{Espacio}*({Letras}|{Enteros}|{CharEsp})*)+
id = {Letras}({Letras}|{Enteros}|"_")*

%%
/* Expresiones Regulares */
"<Configuration>" {return new Symbol(sym1 config, yycolumn, yyline + 1, yytext()); }


%%

