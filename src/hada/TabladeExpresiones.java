/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hada;
//("[*|/|+|-]"
/**
 *("[*|/|+|-]"
 * @author cchac
 */
public class TabladeExpresiones {
    
    
    enum Tipos {
        
        Comentario("([--]+.{0,})"),
        Inicio("(([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20})[' '](IS|is))"),
        Inicio1("(([^\\--][a-zA-Z|0-9|' '|-|!|\\\"|#|$|%|_|&|/|(|)|=|?|¡|-|.|°|<|>|\\*]*|[' '|\\t|\\n])[' '](PROCEDURE|procedure|Procedure)[' ']([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20})[' '](IS|is))|((\\-[a-zA-Z|0-9|' '|-|!|\\\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>|\\*]*|[' '|\\t|\\n])[' '](PROCEDURE|procedure|Procedure)[' ']([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20})[' '](IS|is))"),
        Inicio2("((PROCEDURE|procedure|Procedure)[' ']([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20}))|((\\--[a-zA-Z|0-9|' '|-|!|\\\"|#|$|%|_|&|/|(|)|=|?|¡|-|.|°|<|>|\\*]*|[' '|\\t|\\n])(PROCEDURE|procedure|Procedure)[' ']([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20}))"),
        Inicio3("((PROCEDURE|procedure|Procedure)[' ']([_]{1,20}.{1,20})[' '](IS|is))"),//EMPIEZA
        Inicio4("((PROCEDURE|procedure|Procedure)[' '](.{1,20}[_]{1,20})[' '](IS|is|Is))"), //TERMINA
        Inicio5("((PROCEDURE|procedure|Procedure)[' '](.{0,20}[-|!|\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>]{1,20}.{0,20})[' '](IS|is|Is))"),//CARACTER
        Inicio6 ("((PROCEDURE|procedure|Procedure)[' ']([0-9]{1,20}.{0,20})[' '](IS|is|Is))"),//NUMERO




        Etiqueta1("([\\<<]{1,})([a-zA-Z|0-9|' '|-|!|\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>|\\*].{0,})([^\\>>])"),
        Etiqueta2("([^\\<<])([a-zA-Z|0-9|' '|-|!|\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>|\\*].{0,})([\\>>]{1,})"),
        Final("(fin del programa)"),
        Suma("([[0-9|' '0-9|0-9' ']*\\+[0-9|' '0-9]*]*|[[(0-9|(' '0-9|(0-9' ']*\\+[0-9|' '0-9)|0-9' '))]*]*)([^;])"),
         Resta("[0-9]*\\-[0-9]*"),
         
         
        Constante_numerica_entera("[0-9]*|[' '][0-9]*|[0-9]*[' ']|[+|-][0-9]*"),
       
        final_linea(";"),
        Multiplica("[0-9]*\\s+(MULTIPLICA|MULTI|X)+\\s[0-9]*");
        
        public final String patron;
        Tipos(String s){
            
            this.patron =s;
             
        }        
    }
    
}
