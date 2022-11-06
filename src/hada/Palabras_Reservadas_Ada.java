/*
 * UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
En esta clase se listan las palabras reservadas del lenguaje ADA
 */
package hada;

import java.util.ArrayList;

/**
 *para incluir más palabras por favor agregarlas de la siguiente manera
 * Reservadas_Ada.add("Palabra_que_se_agrega");

 */
public class Palabras_Reservadas_Ada {
    
     public String lista (){
        String palabras =""; 
        String letraCapital;
        String restoLetra;
        
        ArrayList<String> Reservadas_Ada = new ArrayList<String>();
        Reservadas_Ada.add("abort");
        Reservadas_Ada.add("abs");
        Reservadas_Ada.add("abstract");
        Reservadas_Ada.add("accept");
        Reservadas_Ada.add("access");
        Reservadas_Ada.add("aliased");
        Reservadas_Ada.add("all");
        Reservadas_Ada.add("and");
        Reservadas_Ada.add("array");
        Reservadas_Ada.add("at");
        Reservadas_Ada.add("begin");
        Reservadas_Ada.add("body");
        Reservadas_Ada.add("case");
        Reservadas_Ada.add("constant");
        Reservadas_Ada.add("declare");
        Reservadas_Ada.add("delay");
        Reservadas_Ada.add("delta");
        Reservadas_Ada.add("digits");
        Reservadas_Ada.add("do");
        Reservadas_Ada.add("else");
        Reservadas_Ada.add("elsif");
        Reservadas_Ada.add("end");
        Reservadas_Ada.add("entry");
        Reservadas_Ada.add("exception");
        Reservadas_Ada.add("exit");
        Reservadas_Ada.add("for");
        Reservadas_Ada.add("function");
        Reservadas_Ada.add("generic");
        Reservadas_Ada.add("goto");
        Reservadas_Ada.add("goto");
        Reservadas_Ada.add("if");
        Reservadas_Ada.add("in");
        Reservadas_Ada.add("interface");
        Reservadas_Ada.add("is");
        Reservadas_Ada.add("limited");
        Reservadas_Ada.add("loop");
        Reservadas_Ada.add("mod");
        Reservadas_Ada.add("new");
        Reservadas_Ada.add("not");
        Reservadas_Ada.add("null");
        Reservadas_Ada.add("of");
        Reservadas_Ada.add("or");
        Reservadas_Ada.add("others");
        Reservadas_Ada.add("out");
        Reservadas_Ada.add("overriding");
        Reservadas_Ada.add("package");
        Reservadas_Ada.add("pragma");
        Reservadas_Ada.add("private");
        Reservadas_Ada.add("procedure");
        Reservadas_Ada.add("protected");
        Reservadas_Ada.add("raise");
        Reservadas_Ada.add("range");
        Reservadas_Ada.add("record");
        Reservadas_Ada.add("rem");
        Reservadas_Ada.add("renames");
        Reservadas_Ada.add("requeue");
        Reservadas_Ada.add("return");
        Reservadas_Ada.add("reverse");
        Reservadas_Ada.add("select");
        Reservadas_Ada.add("separate");
        Reservadas_Ada.add("subtype");
        Reservadas_Ada.add("synchronized");
        Reservadas_Ada.add("tagged");
        Reservadas_Ada.add("task");
        Reservadas_Ada.add("terminate");
        Reservadas_Ada.add("then type");
        Reservadas_Ada.add("until");
        Reservadas_Ada.add("use");
        Reservadas_Ada.add("while");
        Reservadas_Ada.add("with");
        Reservadas_Ada.add("xor");


        //Obtiene todas palabras del arreglo en mayúsculas
        for (int i = 0; i < Reservadas_Ada.size() ; i++) {
          palabras = (palabras+Reservadas_Ada.get(i).toUpperCase()+"|");
         
       }
        
        
        //Obtiene todas las palabras del arreglo con la primera letra masyúscula
        for (int i = 0; i < Reservadas_Ada.size() ; i++) {
           letraCapital =  ""+Reservadas_Ada.get(i).toUpperCase().charAt(0);
           restoLetra = Reservadas_Ada.get(i).substring(1).toLowerCase();
          palabras = (palabras+letraCapital+restoLetra+"|");
         
       }
        
        //Obtiene todas las palabras del arreglo en minúscula
        for (int i = 0; i < Reservadas_Ada.size() ; i++) {
          if((i+1) < Reservadas_Ada.size()){
            palabras = (palabras+Reservadas_Ada.get(i)+"|");
          }else{
               palabras = (palabras+Reservadas_Ada.get(i)+"");
          }
          
       }
        // si se necesita validar la lista de palabras se descomenta la siguiente línea
       // System.out.println(palabras); 
        
        return palabras;
        
    }
}
