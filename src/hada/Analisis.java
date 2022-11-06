/*
UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
Basado en los ejemplos compartidos en la Tutoría en esta clase se verifican los toquen y las expresiones
 */
package hada;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Analisis {
//variables globales
    String reporte="";
    Read_Archivo txt = new Read_Archivo();
    Errores error = new Errores();
    String falla = "", No_soportada="", identificadores ="", elemento ="", LineaAnterior="";
    int cuenta_errores = 0, procedure = 0, begin =0, end =0,ada =0, ContadorLineas=0;
    boolean multilinea = false, PrimerToken = false, comaLinea = true;
    ArrayList<String> variables = new ArrayList<String>();
    boolean Seccion_variables = false;      
    
    public String AnalizaTexto(String TxtLinea) {
  
       
//     ArrayList<Integer> variables_integer = new ArrayList<Integer>();
//     ArrayList<Float> variables_float = new ArrayList<Float>();
//    ArrayList<Character> variables_character = new ArrayList<Character>();
        
        StringTokenizer segmentos = new StringTokenizer(TxtLinea);
        int cuenta = 0;
        String Expresion = new String();
        boolean TokenClasificado = false, comentario= false;
        String Respuesta = "";
        String copia="";
        
        if (TxtLinea.contains(";")){
                    comaLinea = false;
                    if(multilinea){
                        comaLinea = true;
                    }
                }else {
            comaLinea = true;
        }
        if (TxtLinea.isEmpty()) {
            Respuesta = " ";
        } else {
            if (TxtLinea.length() > 80) {
                cuenta_errores++;
                Respuesta = (falla = error.Asigna_Error(1) + " [" + TxtLinea + "] ");
            } else {

                while ((segmentos.hasMoreTokens())&&(comentario==false)) {
                    String token = segmentos.nextToken();
                    
                    
                    
                    //Revisa los token para clasificarlos 
                    for (TabladeSimbolos.Tipos comparaTOKENS : TabladeSimbolos.Tipos.values()) {

                        if (TokenClasificado) {
                            TokenClasificado = false;
                            break;

                        }

                        if ((token.length() > 20)&&(!token.contains(","))&&(!token.contains("--"))&&(!token.contains("+")&&!token.contains("-")&&!token.contains("/")&&!token.contains("*"))) {
                                 cuenta_errores++;
                                Respuesta = (falla = error.Asigna_Error(15) + " [" + TxtLinea + "] ");
                                TokenClasificado = true;
                                
                                
                        } else {
                                copia = token;
                            if ((copia.toUpperCase()).matches(comparaTOKENS.patron)) {

                                switch (comparaTOKENS) {
                                    case Reservada_Hada:  PrimerToken = true;    TokenClasificado = true; break;
                                    case Reservada_Ada:   PrimerToken = true; No_soportada = No_soportada+ " [" + token; ada++;    TokenClasificado = true; break;
                                    case Cadena:         TokenClasificado = true; break;
                                    case Procedure:      comaLinea = false; procedure++; TokenClasificado = true; break;
                                    case Is:             TokenClasificado = true; break;
                                    case Begin:      Seccion_variables=false;
                                        System.out.println(" terminamos sección de variables " + Seccion_variables + " " + token);
                                    begin++; TokenClasificado = true; break;
                                    case End:       end++; TokenClasificado = true; break;
                                    case Nombre_Archivo: variables.add(token); PrimerToken = true; TokenClasificado = true; break;                                  
                                    case Numero_Entero:  TokenClasificado = true; break;
                                    case Numero_Real:    TokenClasificado = true; break;
                                    case comentario:    comaLinea = false; TokenClasificado = true; comentario =true; break;
                                    case lista_variables: cuenta_errores++;  Respuesta = (falla = error.Asigna_Error(23) + " [" + token + "] "); TokenClasificado = true;  break;
                                    
                                    
                                    case Operadores:     TokenClasificado = true; break;
                                    case finlinea:       TokenClasificado = true; break;
                                    case Etiqueta:       cuenta_errores++;  reporte = reporte + (falla = error.Asigna_Error(16) + " [" + token + "] ");       TokenClasificado = true; break;  
                                    case Agrupacion:     TokenClasificado = true; break;
                                    default:             Respuesta = (" ");  break;
                                }
                            }
                        }

                    }
                    if (cuenta == 0) {
                        Expresion = Expresion + token;
                    } else {
                        Expresion = Expresion + " " + token;
                        //System.out.println(Expresion);
                    }
                    cuenta++;
                }
      //En esta sección vamos a validar declaraciones multilínea          
                if (PrimerToken && comaLinea){ //es un identificador, o palabra reserveda y no lleva coma
                    multilinea = true;
                    ContadorLineas++;
                    LineaAnterior = LineaAnterior + TxtLinea + "\n";
                   
                    
                    if (TxtLinea.contains(";")){
                        if (ContadorLineas>5){
                            cuenta_errores++; 
                            Respuesta = (falla = error.Asigna_Error(36) + " [" + LineaAnterior + "] "); 
                           // System.err.println("\n Error la linea " + LineaAnterior + " Supera 5 reglones sin \"; \" lo que es un error");
                            LineaAnterior = "";
                            multilinea = false;
                            ContadorLineas = 0;
                        }else {
                           // System.out.println("\n multilinea correcto " + LineaAnterior);
                            LineaAnterior = "";
                            multilinea = false;
                            ContadorLineas = 0;
                        }
                            
                    }
                        
                }


                
                //Revisa las expresiones y en caso de una coincidencia indica un numero de error
                Boolean encontrado = false;
                for (TabladeExpresiones.Tipos comparaExpresiones : TabladeExpresiones.Tipos.values()) {
                    if (Expresion.toUpperCase().matches(comparaExpresiones.patron)) {
                        switch (comparaExpresiones) {
                            case Inicio:     
                              
                                if (Expresion.toUpperCase().contains("IS")){
                                  encontrado = true; 
                                  //System.out.println("se definio PROCEDURE ---- IS correctamente ["+ Expresion+"] ");
                                  Seccion_variables = true;
                                    System.out.println("°°°°iniciamos sección de variables°°°° " + Seccion_variables + " "+ Expresion);
                                  break;
                                }else{
                                  cuenta_errores++; Respuesta = (falla = error.Asigna_Error(4) + " [" + TxtLinea + "] ");    encontrado = true; break;
                                }
                                
                                
                           case Inicio1:     cuenta_errores++; Respuesta = (falla = error.Asigna_Error(8) + " [" + TxtLinea + "] ");    encontrado = true; break;
                           case Inicio2:     cuenta_errores++; Respuesta = (falla = error.Asigna_Error(14) + " [" + TxtLinea + "] ");    encontrado = true; break;
                           case Inicio3:     cuenta_errores++; Respuesta = (falla = error.Asigna_Error(5) + " [" + TxtLinea + "] ");    encontrado = true; break;
                           case Inicio4:     cuenta_errores++; Respuesta = (falla = error.Asigna_Error(6) + " [" + TxtLinea + "] ");    encontrado = true; break;
//                            case Inicio5:     cuenta_errores++; Respuesta = (falla = error.Asigna_Error(7) + " [" + TxtLinea + "] ");    encontrado = true; break;
//                            case Inicio6:     cuenta_errores++; Respuesta = (falla = error.Asigna_Error(8) + " [" + TxtLinea + "] ");    encontrado = true; break;
                           
                           
                           
                           case Nombre_Archivo_num: cuenta_errores++;  Respuesta = (falla = error.Asigna_Error(30) + " [" + TxtLinea + "] "); TokenClasificado = true;  break;
                           case Nombre_Arhivo_caracter: cuenta_errores++;  Respuesta = (falla = error.Asigna_Error(31) + " [" + TxtLinea + "] "); TokenClasificado = true;  break;
                           case Nombre_Archiv_caracter_mitad: cuenta_errores++;  Respuesta = (falla = error.Asigna_Error(32) + " [" + TxtLinea + "] "); TokenClasificado = true;  break;
                           case Nombre_Archiv_caracter_mitad2: cuenta_errores++;  Respuesta = (falla = error.Asigna_Error(32) + " [" + TxtLinea + "] "); TokenClasificado = true;  break;
                           case Nombre_Archiv_caracter_final: cuenta_errores++;  Respuesta = (falla = error.Asigna_Error(33) + " [" + TxtLinea + "] "); TokenClasificado = true;  break;
                           
                           
                           //falta indicar el tipo de variable varias
                           case Definicion_variables: cuenta_errores++; Respuesta = (falla = error.Asigna_Error(24) + " [" + TxtLinea + "] ");    encontrado = true; break;
                           case Definicion_variables1, Definicion_variables9: cuenta_errores++; Respuesta = (falla = error.Asigna_Error(25) + " [" + TxtLinea + "] ");    encontrado = true; break;
                           case Definicion_variables2, Definicion_variables11: cuenta_errores++; Respuesta = (falla = error.Asigna_Error(26) + " [" + TxtLinea + "] ");    encontrado = true; break;
                           case Definicion_variables3, Definicion_variables12: cuenta_errores++; Respuesta = (falla = error.Asigna_Error(27) + " [" + TxtLinea + "] ");    encontrado = true; break;
                           case Definicion_variables_Correcta, Definicion_variables_Correcta_sola: 
                               System.out.println(" definición correcta " + TxtLinea);
                               if (Seccion_variables){
                               encontrado = true; break;
                           }else{
                                                       cuenta_errores++; Respuesta = (falla = error.Asigna_Error(37) + " [" + TxtLinea + "] "); 
                               encontrado = true; break;
                           }
                           case Definicion_variables4://, Definicion_variables16: 
                                if ((Expresion.toUpperCase().contains("FLOAT"))||(Expresion.toUpperCase().contains("INTERGER"))||(Expresion.toUpperCase().contains("CARACTER")))
                                {
                                    encontrado = true; break;
                                }else{
                                cuenta_errores++; Respuesta = (falla = error.Asigna_Error(28) + " [" + TxtLinea + "] ");    encontrado = true; break;}
                            case Definicion_variables5://, Definicion_variables_Correcta_sola:
                                elemento =Expresion.substring(identificadores.length(), Expresion.indexOf(':'));
                                if (identificadores.contains(elemento)){
                                   cuenta_errores++; Respuesta = (falla = error.Asigna_Error(29) + " [" + TxtLinea + "] ");    
                                  // System.out.println("ERROR identificador repetido"); 
                                   encontrado = true; break;
                               }else{
                                   identificadores = identificadores + elemento;
                                   System.out.println(" definición correcta " + TxtLinea);
                               if (Seccion_variables){
                               encontrado = true; break;
                           }else{
                                cuenta_errores++; Respuesta = (falla = error.Asigna_Error(37) + " [" + TxtLinea + "] "); 
                               encontrado = true; break;
                           }  
                                   
                               }
                                
                            case Definicion_variables7, Definicion_variables13: cuenta_errores++; Respuesta = (falla = error.Asigna_Error(34) + " [" + TxtLinea + "] ");    encontrado = true; break;
                            case Definicion_variables8, Definicion_variables14: cuenta_errores++; Respuesta = (falla = error.Asigna_Error(35) + " [" + TxtLinea + "] ");    encontrado = true; break;
                            
                            case Definicion_variables10:
                                if ((Expresion.toUpperCase().contains("INTEGER"))|(Expresion.toUpperCase().contains("FLOAT"))|(Expresion.toUpperCase().contains("CHARACTER")))
                                {
                                    encontrado = true; break;
                                }
                                else{
                                           cuenta_errores++; Respuesta = (falla = error.Asigna_Error(28) + " [" + TxtLinea + "] ");    encontrado = true; break;
                                }
                         
                            
                            case Final:       encontrado = true; break;
                            case Comentario:  encontrado = true; break;
                            case Etiqueta1:   cuenta_errores++; Respuesta = (falla = error.Asigna_Error(9) + " [" + TxtLinea + "] ");    encontrado = true; break;
                            case Etiqueta2:   cuenta_errores++; Respuesta = (falla = error.Asigna_Error(10) + " [" + TxtLinea + "] ");   encontrado = true; break;
                            case Suma:        cuenta_errores++; Respuesta = (falla = error.Asigna_Error(11) + " [" + TxtLinea + "] ");   encontrado = true; break;
                            case Resta:       encontrado = true; break;
                            case Multiplica:  encontrado = true; break;
                            case final_linea: encontrado = true; break;
                            case Reservado:   cuenta_errores++; Respuesta = (falla = error.Asigna_Error(14) + " [" + TxtLinea + "] ");   encontrado = true;
                             
                            break;
                            
 
                            default: Respuesta = (Respuesta + " ");
                        }
                    }
                }
                if (encontrado == false) {
                    Respuesta = (reporte +Respuesta + " ");

                }
            }
        }
        
        return reporte +Respuesta;
    }

    
    
    

    public int valida_errores(String nomArchivo) {
//        for (int i = 0; i < variables.size() ; i++) {
//            System.out.print(variables.get(i)+"\t");
//         
//       }
//       
        if (cuenta_errores > 0) {
             System.err.println("\n\t !!!!!!!!\033[31m Se encontraron " + cuenta_errores + " Errores \033[32m!!!!!!!!!!!!\n\n\u001B[0m");
            String directoryName = System.getProperty("user.dir");
            System.out.println("\033[33m !!!Es necesario que revise el archivo " + nomArchivo + "-errores.txt");
            System.out.println("\n También puede ver el Log de la herramienta llamado Hada_log.txt, ambos en la ruta: " + directoryName);

        } else {
            System.err.println("\n\t\033[32m !!!!!!!! No see encontraron Errores !!!!!!!!!!!!\n\n\u001B[0m");
        }
        return cuenta_errores;
    } //se revisa cuantos errores se han originado
    String palabras_reservadas(){
        String resultado ="";
        
        if (procedure>1){
            cuenta_errores++;
            resultado = (resultado +  error.Asigna_Error(17) + procedure + "] veces");
        }
        if (begin>1){
            cuenta_errores++;
            resultado = (resultado +  error.Asigna_Error(18) + begin + "] veces");
        }
        if (end>1){
            cuenta_errores++;
            resultado = (resultado +  error.Asigna_Error(19) + end + "] veces");
        }
        if (procedure==0){
            cuenta_errores++;
            resultado = (resultado +  error.Asigna_Error(20));
        }
        if (begin==0){
            cuenta_errores++;
            resultado = (resultado +  error.Asigna_Error(21));
        }
        if (end==0){
            cuenta_errores++;
            resultado = (resultado +  error.Asigna_Error(22));
        }
        return resultado;
    } // busca las palabras obligatorias en el texto
        public String ada (){
            String mensaje="";
            if (ada>0){
                mensaje = "\n" + No_soportada + "] ¤{Advertencia instrucción no soportada por esta versión}¤";
            }
            ada =0;
            No_soportada ="";
            return mensaje;
        } // Valida palabras reservadas de ADA que no estén en HADA
}
