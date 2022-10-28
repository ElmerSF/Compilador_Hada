/*
UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
Basado en los ejemplos compartidos en la Tutoría en esta clase se verifican los toquen y las expresiones
 */
package hada;

import java.util.StringTokenizer;

public class Analisis {

    
    int num;
    String reporte="";
    Read_Archivo txt = new Read_Archivo();
    Errores error = new Errores();
    String falla = "", No_soportada="";
    int cuenta_errores = 0;
    int procedure = 0, begin =0, end =0,ada =0;
    String identificadores ="", elemento ="";
    public String AnalizaTexto(String TxtLinea) {

        StringTokenizer segmentos = new StringTokenizer(TxtLinea);
        int cuenta = 0;
        String Expresion = new String();
        boolean TokenClasificado = false, comentario= false;
        String Respuesta = "";
        String copia="";
        

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
                                    case Reservada_Hada:      TokenClasificado = true; break;
                                    case Reservada_Ada:  No_soportada = No_soportada+ " [" + token; ada++;    TokenClasificado = true; break;
                                    case Cadena:         TokenClasificado = true; break;
                                   case Procedure:      procedure++; TokenClasificado = true; break;
                                    case Is:             TokenClasificado = true; break;
                                    case Begin:       begin++; TokenClasificado = true; break;
                                    case End:       end++; TokenClasificado = true; break;
                                    case Nombre_Archivo: TokenClasificado = true; break;                                  
                                    case Numero_Entero:  TokenClasificado = true; break;
                                    case Numero_Real:    TokenClasificado = true; break;
                                    case comentario:     TokenClasificado = true; comentario =true; break;
                                    case lista_variables: cuenta_errores++;  Respuesta = (falla = error.Asigna_Error(23) + " [" + token + "] "); TokenClasificado = true;  break;
                                    case Operadores:     TokenClasificado = true; break;
                                    case finlinea:       TokenClasificado = true; break;
                                    case Etiqueta:       cuenta_errores++;  reporte = reporte + (falla = error.Asigna_Error(16) + " [" + token + "] ");       TokenClasificado = true; break;  
                                    case Agrupacion:     TokenClasificado = true; break;
                                    default:             Respuesta = (token + " sin clasificar");  break;
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

                //Revisa las expresiones y en caso de una coincidencia indica un numero de error
                Boolean encontrado = false;
                for (TabladeExpresiones.Tipos comparaExpresiones : TabladeExpresiones.Tipos.values()) {
                    if (Expresion.toUpperCase().matches(comparaExpresiones.patron)) {
                        switch (comparaExpresiones) {
                            case Inicio:     
                              
                                if (Expresion.toUpperCase().contains("IS")){
                                  encontrado = true; 
                                  System.out.println("se definio PROCEDURE ---- IS correctamente");
                                  break;
                                }else{
                                    System.out.println(" se encontro!!!!!!"); cuenta_errores++; Respuesta = (falla = error.Asigna_Error(4) + " [" + TxtLinea + "] ");    encontrado = true; break;
                                }
                                
                                
                            case Inicio1:     cuenta_errores++; Respuesta = (falla = error.Asigna_Error(8) + " [" + TxtLinea + "] ");    encontrado = true; break;
                            case Inicio2:     cuenta_errores++; Respuesta = (falla = error.Asigna_Error(14) + " [" + TxtLinea + "] ");    encontrado = true; break;
                            case Inicio3:     cuenta_errores++; Respuesta = (falla = error.Asigna_Error(5) + " [" + TxtLinea + "] ");    encontrado = true; break;
                            case Inicio4:     cuenta_errores++; Respuesta = (falla = error.Asigna_Error(6) + " [" + TxtLinea + "] ");    encontrado = true; break;
//                            case Inicio5:     cuenta_errores++; Respuesta = (falla = error.Asigna_Error(7) + " [" + TxtLinea + "] ");    encontrado = true; break;
//                            case Inicio6:     cuenta_errores++; Respuesta = (falla = error.Asigna_Error(8) + " [" + TxtLinea + "] ");    encontrado = true; break;
                            case Definicion_variables: cuenta_errores++; Respuesta = (falla = error.Asigna_Error(24) + " [" + TxtLinea + "] ");    encontrado = true; break;
                            case Definicion_variables1: cuenta_errores++; Respuesta = (falla = error.Asigna_Error(25) + " [" + TxtLinea + "] ");    encontrado = true; break;
                            case Definicion_variables2: cuenta_errores++; Respuesta = (falla = error.Asigna_Error(26) + " [" + TxtLinea + "] ");    encontrado = true; break;
                            case Definicion_variables3: cuenta_errores++; Respuesta = (falla = error.Asigna_Error(27) + " [" + TxtLinea + "] ");    encontrado = true; break;
                            case Definicion_variables4: 
                                if ((Expresion.toUpperCase().contains("FLOAT"))||(Expresion.toUpperCase().contains("INTERGER"))||(Expresion.toUpperCase().contains("CARACTER")))
                                {
                                    encontrado = true; break;
                                }else{
                                cuenta_errores++; Respuesta = (falla = error.Asigna_Error(28) + " [" + TxtLinea + "] ");    encontrado = true; break;}
                            case Definicion_variables5:
                                
                                elemento =Expresion.substring(identificadores.length(), Expresion.indexOf(':'));
                              
                                if (identificadores.contains(elemento)){
                                   cuenta_errores++; Respuesta = (falla = error.Asigna_Error(29) + " [" + TxtLinea + "] ");    
                                  // System.out.println("ERROR identificador repetido"); 
                                   encontrado = true; break;
                               }else{
                                   identificadores = identificadores + elemento;
                                
                                //System.out.println(identificadores);
                                 encontrado = true; break;
                               }
                                
                            case Final:       encontrado = true; break;
                            case Comentario:  encontrado = true; break;
                            case Etiqueta1:   cuenta_errores++; Respuesta = (falla = error.Asigna_Error(9) + " [" + TxtLinea + "] ");    encontrado = true; break;
                            case Etiqueta2:   cuenta_errores++; Respuesta = (falla = error.Asigna_Error(10) + " [" + TxtLinea + "] ");   encontrado = true; break;
                            case Suma:        cuenta_errores++; Respuesta = (falla = error.Asigna_Error(11) + " [" + TxtLinea + "] ");   encontrado = true; break;
                            //case Constante_numerica_entera: num = Integer.parseInt(Expresion); Respuesta = (Respuesta + Validanum(num)); encontrado = true; break;
                            case Resta:       encontrado = true; break;
                            case Multiplica:  encontrado = true; break;
                            case final_linea: encontrado = true; break;
                            case Reservado:   cuenta_errores++; Respuesta = (falla = error.Asigna_Error(14) + " [" + TxtLinea + "] ");   encontrado = true;
                             //System.out.println("!!! Error Despues de PROCEDURE, BEGIN, IF, ELSE o FOR no debe llevar ; "+ TxtLinea);
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

    public String Validanum(int num) {
        String Respuesta_int = "";
        if (num > 32767) {
            cuenta_errores++;
            Respuesta_int = (falla = error.Asigna_Error(12) + " [" + num + "] ");
        } else {
            if (num < -32767) {
                cuenta_errores++;
                Respuesta_int = (falla = error.Asigna_Error(13) + " [" + num + "] ");
            } else {

                Respuesta_int = ("");
            }
        }
        return Respuesta_int;
    }
    
    

    public int valida_errores(String nomArchivo) {

        System.out.println("\n !!!!!!!! Se encontraron " + cuenta_errores + " Errores !!!!!!!!!!!!");
        if (cuenta_errores > 0) {
            String directoryName = System.getProperty("user.dir");
            System.out.println("\n !!!Es necesario que revise el archivo " + nomArchivo + "-errores.txt");
            System.out.println("\n También puede ver el Log de la herramienta llamado Hada_log.txt, ambos en la ruta: " + directoryName);

        } else {

        }
        return cuenta_errores;
    }
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
    }
        public String ada (){
            String mensaje="";
            if (ada>0){
                mensaje = "\n" + No_soportada + "] ¤{Advertencia instrucción no soportada por esta versión}¤";
            }
            ada =0;
            No_soportada ="";
            return mensaje;
        }
}
