/*
 UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
Tabla de las expresiones según los lineamientos del lenguaje HADA
 */
package hada;

public class TabladeExpresiones {

    enum Tipos {

        Comentario("([--]+.{0,})"),
        Inicio("(([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20})[' '](IS|is))"),
        Inicio1("(([^\\--][a-zA-Z|0-9|' '|-|!|\\\"|#|$|%|_|&|/|(|)|=|?|¡|-|.|°|<|>|\\*]*|[' '|\\t|\\n])[' '](PROCEDURE|procedure|Procedure)[' ']([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20})[' '](IS|is))|((\\-[a-zA-Z|0-9|' '|-|!|\\\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>|\\*]*|[' '|\\t|\\n])[' '](PROCEDURE|procedure|Procedure)[' ']([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20})[' '](IS|is))"),
        Inicio2("((PROCEDURE|procedure|Procedure)[' ']([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20}))|((\\--[a-zA-Z|0-9|' '|-|!|\\\"|#|$|%|_|&|/|(|)|=|?|¡|-|.|°|<|>|\\*]*|[' '|\\t|\\n])(PROCEDURE|procedure|Procedure)[' ']([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20}))"),
        Inicio3("((PROCEDURE|procedure|Procedure)[' ']([_]{1,20}.{1,20})[' '](IS|is))"),//EMPIEZA
        Inicio4("((PROCEDURE|procedure|Procedure)[' '](.{1,20}[_]{1,20})[' '](IS|is|Is))"), //TERMINA
        Inicio5("((PROCEDURE|procedure|Procedure)[' '](.{0,20}[-|!|\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>]{1,20}.{0,20})[' '](IS|is|Is))"),//CARACTER
        Inicio6("((PROCEDURE|procedure|Procedure)[' ']([0-9]{1,20}.{0,20})[' '](IS|is|Is))"),//NUMERO
        Reservado("^[PROCEDURE|procedure|Procedure|BEGIN|begin|Begin|if|IF|If|ELSE|else|Else|For|FOR|For]{1,}([' '|(|)|A-Z|a-z|0-9]{0,})[;]$"),
        Etiqueta1("([\\<<]{1,})([a-zA-Z|0-9|' '|-|!|\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>|\\*].{0,})([^\\>>])"),
        ///Etiqueta1("([\\<<]{1,})([a-zA-Z|0-9|' '|-|!|\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>|\\*].{0,})([^\\>>])"),
        Etiqueta2("([^\\<<])([a-zA-Z|0-9|' '|-|!|\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>|\\*].{0,})([\\>>]{1,})"),
        Final("(fin del programa)"),
        Suma("([[0-9|' '0-9|0-9' ']*\\+[0-9|' '0-9]*]*|[[(0-9|(' '0-9|(0-9' ']*\\+[0-9|' '0-9)|0-9' '))]*]*)([^;])"),
        Resta("[0-9]*\\-[0-9]*"),
        Constante_numerica_entera("[0-9]*|[' '][0-9]*|[0-9]*[' ']|[+|-][0-9]*"),
        final_linea(";"),
        Multiplica("[0-9]*\\s+(MULTIPLICA|MULTI|X)+\\s[0-9]*");

        public final String patron;

        Tipos(String s) {

            this.patron = s;

        }
    }

}
