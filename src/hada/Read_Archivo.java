/*
UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
En esta clase se realiza la lectura del arhivo y creación del arhivo de errores
 */
package hada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Read_Archivo {
    
    
    
    public void leerArchivo(String Archivo)
    {
        String Bitacora ="Hada_log.txt";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //formato para el Log
        File log, errores;
        FileWriter escribirlog, escribirerror;
        PrintWriter reglonlog, reglonerror;
       
       
        
        String nomArchivo ="";
        String linea;
        String pendiente ="";
        int contador=1;
     
        
        BufferedReader br;
        
        try {
        
        String Respuesta ="";
        log=new File(Bitacora);
        escribirlog = new FileWriter(log, true);
        reglonlog =new PrintWriter(escribirlog);
        
       
        nomArchivo = Archivo.substring(0, Archivo.indexOf('.')); //tomamos el arhivo y le eliminamos la extensión
        errores = new File(nomArchivo+"-errores.txt");
        escribirerror = new FileWriter(errores, true);
        reglonerror= new PrintWriter(escribirerror);
        
            
            br = new BufferedReader(new FileReader(Archivo));
            reglonlog.println("> "+dtf.format(LocalDateTime.now())+" ***** 02 INFORMACIÓN se comienza lectura de archivo "+Archivo);
            
            Analisis revi = new Analisis();
            
            
            while ((linea= br.readLine())!=null) //Lectura del archivo por línea
            {
            reglonlog.println("\t & {linea de lectura ["+contador+"] }");   
                      
                if (contador<8)
                {
                    
                    pendiente =(pendiente + " "+ revi.AnalizaTexto(linea));
                reglonerror.println("0000"+contador + " " + linea + " ");
                
                contador++;
                }
                else{
                 if(contador==8)   
                 {
                    Respuesta =(Respuesta +revi.AnalizaTexto(linea)); 
                    reglonerror.println("0000"+contador + " " + linea + " "+ pendiente+ Respuesta); 
                    contador++;
                 }else{
                     
                 
                if (contador<10)
                {
                    Respuesta =(Respuesta +revi.AnalizaTexto(linea)); 
                reglonerror.println("0000"+contador + " " + linea + " "+ Respuesta );
                       // System.out.println(contador + " " + linea + " "+Respuesta );
                
                        contador++;
                }
                else{
                if(contador<100){
                   Respuesta =revi.AnalizaTexto(linea);
                reglonerror.println("000"+contador + " " + linea + " "+Respuesta);
                        //System.out.println(contador + " " + linea + " "+Respuesta);
                        contador++;
                }
                else{
                if(contador<1000){
                  Respuesta =revi.AnalizaTexto(linea);
                reglonerror.println("00"+contador + " " + linea + " "+Respuesta );
                        //System.out.println(contador + " " + linea + " "+Respuesta);
                        contador++;
                }
                else{
                if(contador<10000){
                  Respuesta =revi.AnalizaTexto(linea);
                reglonerror.println("0"+contador + " " + linea + " "+Respuesta );
                        //System.out.println(contador + " " + linea + " "+Respuesta );
                        contador++;
                }
                else{
                Respuesta =revi.AnalizaTexto(linea);
               reglonerror.println(contador + " " + linea + " "+Respuesta );
                        //System.out.println(contador + " " + linea + " "+Respuesta );
                        contador++;
                
                }
                }
                }
                }
                }
                }
                        
                
                
                
                //AnalizaTexto(linea);
            
            }
                reglonlog.println("> "+dtf.format(LocalDateTime.now())+" ***** 03 SE termina lectura de archivo "+Archivo);
                
                reglonlog.close();
                reglonerror.close();
                escribirerror.close();
                escribirlog.close();
               
            
        } catch (FileNotFoundException ex)
        {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex){
          System.out.println("Archivo no encontrado o no se pudo abrir");
        }
        
    }
    
   
//    public String escribir ( String txt)
//    {
//        switch (txt) {
//            case "1":
//                txt = txt + " error la cadena supera los 80 caracteres permitidos";
//                break;
//            
//        }
//        System.out.print(txt+ " ");
//        return txt;
//    }
   
}
