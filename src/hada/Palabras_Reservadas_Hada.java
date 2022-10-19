/*
 * UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
En esta clase se listan las palabras reservadas del lenguaje HADA
 */
package hada;

import java.util.ArrayList;

/**
  *para incluir más palabras por favor agregarlas de la siguiente manera
 * Reservadas_Hada.add("Palabra_que_se_agrega");
 */
public class Palabras_Reservadas_Hada {
    
    static final public String lista (){
        String palabras =""; 
        String letraCapital;
        String restoLetra;
        
        ArrayList<String> Reservadas_Hada = new ArrayList<String>();
    
    Reservadas_Hada.add("begin");
Reservadas_Hada.add("character");
Reservadas_Hada.add("else");
Reservadas_Hada.add("end");
Reservadas_Hada.add("float");
Reservadas_Hada.add("for");
Reservadas_Hada.add("get");
Reservadas_Hada.add("if");
Reservadas_Hada.add("in");
Reservadas_Hada.add("integer");
Reservadas_Hada.add("is");
Reservadas_Hada.add("loop");
Reservadas_Hada.add("new_line");
Reservadas_Hada.add("null");
Reservadas_Hada.add("procedure");
Reservadas_Hada.add("put");
Reservadas_Hada.add("skip_line");
Reservadas_Hada.add("then");

//Obtiene todas palabras del arreglo en mayúsculas
        for (int i = 0; i < Reservadas_Hada.size() ; i++) {
          palabras = (palabras+Reservadas_Hada.get(i).toUpperCase()+"|");
         
       }
        
        
        //Obtiene todas las palabras del arreglo con la primera letra masyúscula
        for (int i = 0; i < Reservadas_Hada.size() ; i++) {
           letraCapital =  ""+Reservadas_Hada.get(i).toUpperCase().charAt(0);
           restoLetra = Reservadas_Hada.get(i).substring(1).toLowerCase();
          palabras = (palabras+letraCapital+restoLetra+"|");
         
       }
        
        //Obtiene todas las palabras del arreglo en minúscula
        for (int i = 0; i < Reservadas_Hada.size() ; i++) {
          if((i+1) < Reservadas_Hada.size()){
            palabras = (palabras+Reservadas_Hada.get(i)+"|");
          }else{
               palabras = (palabras+Reservadas_Hada.get(i)+"");
          }
          
       }
        System.out.println(palabras);
        
        return palabras;
        
    }
}
