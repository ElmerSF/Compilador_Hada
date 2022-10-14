/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author cchac
 */
public class Analisis {
    int num;
    
    Read_Archivo txt = new Read_Archivo();
    
    public void leerArchivo(String NombArch)
    {
        String linea;
        int contador=1;
        BufferedReader br;
        
        try {
            br = new BufferedReader(new FileReader(NombArch));
            
            while ((linea= br.readLine())!=null) //Lectura del archivo por l�nea
            {
                AnalizaTexto(linea);
                        }
            
        } catch (FileNotFoundException ex)
        {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex){
          System.out.println("Archivo no encontrado o no se pudo abrir");
        }
        
    }
    
    
    public String AnalizaTexto(String TxtLinea)
    {
        
        StringTokenizer segmentos = new StringTokenizer( TxtLinea  );
        int cuenta=0;
        String Expresion= new String();
        boolean TokenClasificado= false;
        String Respuesta ="";
        
        if (TxtLinea.isEmpty())
        {
            Respuesta = " ";
        }
        else
        {
        if (TxtLinea.length()>80)
        {
            Respuesta =("1");
        }else{
            
                while (segmentos.hasMoreTokens())
        {
            String token = segmentos.nextToken();
                        
            //=======================Verificar los tokens=================================
            
            for (TabladeSimbolos.Tipos comparaTOKENS : TabladeSimbolos.Tipos.values())
            {
                
                if (TokenClasificado)
                {
                    TokenClasificado = false; 
                    break; 
                }
                if (token.matches(comparaTOKENS.patron))
                {
                    switch (comparaTOKENS)
                    {
                        case Reservada:
                            
                          //  txt.escribir(token + " Es una palabra reservada");
                          //  Respuesta = (token +" Es una palabra reservada");
                            TokenClasificado =true;
                            break;
                        case Inicio:
                            
                           // txt.escribir(token + " Es una palabra reservada de INICIO");
                          //  Respuesta = (token +" Es una palabra reservada");
                            TokenClasificado =true;
                            break;
                        case Nombre_Archivo:
                            
                          //  txt.escribir(token + " Es una nombre de archivo valido");
                          //  Respuesta = (token +" Es una palabra reservada");
                            TokenClasificado =true;
                            break;    
                        case Numero_Entero:
                            txt.escribir(token + " Es un número Entero");
                            TokenClasificado =true;
                            break;
                        case Numero_Real:
                            txt.escribir(token + " Es un número Real");
                            TokenClasificado =true;
                            break;
                        case Palabra:
                           // System.out.println(token + " Es un identificador de usuario");
                            //txt.escribir(token +" Es una palabra");
                            TokenClasificado =true;
                            break;
                        case Operadores:
                           // System.out.println(token + " Es un operador relacional");
                            txt.escribir(token +" Es un operador relacional");
                            TokenClasificado =true;
                            break;
                         case finlinea:
                            //System.out.println(token + " Es un nombre");
                            txt.escribir( token +" caracter fin de linea");
                            TokenClasificado =true;
                            break;   
                         case Agrupacion:
                            //System.out.println(token + " Es un nombre");
                            txt.escribir( token +" caracter de agrupación");
                            TokenClasificado =true;
                            break;  
                            default:
                            txt.escribir( token +" sin clasificar");
                            break;
                    }
                }
            
            }
            if (cuenta==0)
                Expresion=Expresion+token;
            else
                Expresion=Expresion+" "+token;
            cuenta++;
        }   
           
        
        
        //=======================Verificar las expresiones =================================
        //System.out.println("Expresion --->> "+Expresion);
    
        Boolean encontrado=false;
        for (TabladeExpresiones.Tipos comparaExpresiones : TabladeExpresiones.Tipos.values())
        {
            if (Expresion.matches(comparaExpresiones.patron))
            {
                switch (comparaExpresiones)
                {
                    case Inicio:
                        //System.out.println(Expresion+" --> Es una instrucci�n de inicio");
                        Respuesta =(" --> Error falta palabra Reservada PROCEDURE en la declaración inicial");
                        encontrado=true;
                        break;
                    case Inicio1:
                        //System.out.println(Expresion+" --> Es una instrucci�n de inicio");
                        Respuesta =(TxtLinea +" --> Error hay caracteres antes de la instrucción de inicio, si es un comentario falta --");
                        encontrado=true;
                        break;    
                    case Inicio2:
                        //System.out.println(Expresion+" --> Es una instrucci�n de inicio");
                        Respuesta =(TxtLinea +" --> Error Identificador de programa no valido o falta palabra Reservada IS en la declaración inicial");
                        encontrado=true;
                        break;  
                    case Inicio3:
                        //System.out.println(Expresion+" --> Es una instrucci�n de inicio");
                        Respuesta =(TxtLinea +" --> Error Identificador de programa no valido ");
                        encontrado=true;
                        break;    
                    case Final:
                        //System.out.println(Expresion+" --> Es una instrucci�n de final");
                        Respuesta =(" --> Es una instrucción de final");
                        encontrado=true;
                        break;
                    case Comentario:
                        
                         Respuesta =(TxtLinea +" --> Es una linea de comentario");
                        encontrado=true;
                        break;
                     case Etiqueta1:
                        Respuesta =(TxtLinea +" --> Eror falta >> de cierre de Etiqueta");
                        encontrado=true;
                        break;
                    case Etiqueta2:
                        Respuesta =(TxtLinea +" --> Eror falta << de apertura de Etiqueta");
                        encontrado=true;
                        break;    
                    
                    case Suma:
                       //System.out.println(Expresion+" --> Es una suma correcta!");
                       Respuesta =(TxtLinea+" --> Falta ; en la expresión de suma ");
                        encontrado=true;
                        break;
                    case Constante_numerica_entera:
                        num = Integer.parseInt(Expresion);
                        
                        Respuesta = Validanum(num);
                        encontrado=true;
                        break;
                        
                    case Resta:
                        //System.out.println(Expresion+" --> Es una resta correcta!");
                        Respuesta =(" --> Es una resta correcta!");
                        encontrado=true;
                        break;                    
                    case Multiplica:
                        //System.out.println(Expresion+" --> Es una multiplicaci�n correcta!");
                        Respuesta =(" --> Es una resta correcta!");
                        encontrado=true;
                        break;
                    
                    case final_linea:
                        //System.out.println(Expresion+" --> Es una multiplicaci�n correcta!");
                        Respuesta =(" --> fin linea");
                        encontrado=true;
                        break;    
                    default:
                        //System.out.println(Expresion+"---> Expresi�n no encontrada!!");
                        Respuesta =(" ok");
                }           
            }
        }
        if (encontrado==false)
        {
            Respuesta =(" ok");
         
        } 
        }
        }
       return Respuesta;
    }
    public String Validanum (int num){
     String respuesta ="";
        if (num>32767)
        {respuesta = (num + " >>Es mayor al rango");
                
                }else{
            if (num<-32767)
            {respuesta = (num + " >>Es menor al rango");
                
            }else{
            respuesta = (num + " >>Esta dentro del rango");
            }
                }
        return respuesta;  
    }
}
