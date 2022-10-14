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
        
        Inicio("(([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20})[' '](IS|is))"),
        Inicio1("(([^\\--][a-zA-Z|0-9|' '|-|!|\\\"|#|$|%|_|&|/|(|)|=|?|¡|-|.|°|<|>|\\*]*|[' '|\\t|\\n])[' '](PROCEDURE|procedure)[' ']([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20})[' '](IS|is))|((\\-[a-zA-Z|0-9|' '|-|!|\\\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>|\\*]*|[' '|\\t|\\n])[' '](PROCEDURE|procedure)[' ']([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20})[' '](IS|is))"),
        Inicio2("((PROCEDURE|procedure)[' ']([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20}))|((\\--[a-zA-Z|0-9|' '|-|!|\\\"|#|$|%|_|&|/|(|)|=|?|¡|-|.|°|<|>|\\*]*|[' '|\\t|\\n])(PROCEDURE|procedure)[' ']([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{1,20}))"),
        //Inicio3("((PROCEDURE|procedure)[' ']([0-9]*[A-Z|a-z]*[!|\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>|\\*]*)[' '](IS|is))|((PROCEDURE|procedure)[' ']([a-z|A-Z]*[!|\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>|\\*]+[a-z|A-Z]*)[' '](IS|is))|((PROCEDURE|procedure)[' ']([[A-Z|a-z]*[A-Z|a-z|0-9|_]*[A-Z|a-z|0-9]*]{21,})[' '](IS|is))"),
        Inicio3("(PROCEDURE|procedure)[' ']([0-9|_]{1,20}[°|\"|#|$|%|&|/|(|)|=|?|¡|\\*]{0,20}[_|°|\"|#|$|%|&|/|(|)|=|?|¡|\\*]{1,20})[' '](IS|is)"),

        Etiqueta1("([\\<<])([a-zA-Z|0-9|' '|-|!|\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>|\\*]*)([^\\>>])"),
        Etiqueta2("([^\\<<])([a-zA-Z|0-9|' '|-|!|\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>|\\*]*)([\\>>])"),
        Final("(fin del programa)"),
        Suma("([[0-9|' '0-9|0-9' ']*\\+[0-9|' '0-9]*]*|[[(0-9|(' '0-9|(0-9' ']*\\+[0-9|' '0-9)|0-9' '))]*]*)([^;])"),
         Resta("[0-9]*\\-[0-9]*"),
        Comentario("\\--[a-zA-Z|0-9|' '|-|!|\"|#|$|%|&|/|(|)|=|?|¡|-|.|°|<|>|\\*]*"), 
         
        Constante_numerica_entera("[0-9]*|[' '][0-9]*|[0-9]*[' ']|[+|-][0-9]*"),
       
        final_linea(";"),
        Multiplica("[0-9]*\\s+(MULTIPLICA|MULTI|X)+\\s[0-9]*");
        
        public final String patron;
        Tipos(String s){
            
            this.patron =s;
             
        }        
    }
    
}
