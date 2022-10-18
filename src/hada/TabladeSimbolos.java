/*
 UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
Tabla de los Simbolos según los lineamientos del lenguaje HADA
 */
package hada;


public class TabladeSimbolos {

    enum Tipos {
        Procedure("PROCEDURE|procedure|Procedure"),
        Reservada("(SUMA|RESTA|MULTIPLICA|DIVIDE|PROGRAMA|ADA.TEXT_IO|begin)"),
        Is("IS|is"),
        //Palabra ("[A-Z|a-z]{1,}"),
        num("[0-9]"),
        //alfanum("["+letras+"|"+num+"]"),
       // caracter ("[!|\"|#|$|%|‰|&|'|(|)|*|+|,|-|.|/||:|;|<|<|=|>|>|?|@||[|\\|]|^|_|`||{|||}|~||¡|¢|£|¤|¥|¦|§|¨|©|ª|«|¬|­|®|¯|°|±|²|³|´|µ|¶|·|¸|¹|º|»|¼|½|¾|⅛|⅜|⅝|⅞|¿|À|Á|Â|Ã|Ä|Å|Æ|Ç|È|É|Ê|Ë|Ì|Í|Î|Ï|Ð|Ñ|Ò|Ó|Ô|Õ|Ö|×|Ø|Ù|Ú|Û|Ü|Ý|Þ|ß|à|á|â|ã|ä|å|æ|ç|è|é|ê|ë|ì|í|î|ï|ð|ñ|ò|ó|ô|õ|ö|÷|ø|ù|ú|û|ü|ý|þ|ÿ|€|≠|≤|≥|√|Ω|↑|↓|←|→|↔|№|▲|►|▼|◄|■|□|▪|▫|●|○|◊]*"),
       // Nombre_Archivo("["+letras+"]*["+letras+"|_]*["+letras+"]*"),
        Nombre_Archivo("([A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,})"),
        Palabra ("[^A-Z|a-z]*{1,}[0-9|_]*{1,}][A-Z|a-z]{1,}"),
        Operadores("[\\*|/|+|-]{1,}"),
        Cadena("(([\"])([' '|\n|\t]|[^\"].{0,})([\"]))"),
        Numero_Entero("[0-9]*|[' '][0-9]*|[0-9]*[' ']|[+|-][0-9]*"),
        Numero_Real("[0-9]*[.][0-9]*"),
        finlinea("(;)"),
        
        Etiqueta("([<<]{1,})([A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,})([>>]{1,}[;])"),
        Agrupacion("[(|)]{1,}");
        

        public final String patron;

        Tipos(String s) {
            this.patron = s;
        }
    }

}
