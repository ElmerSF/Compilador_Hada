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

/**
 *
 * @author elmer
 */
public class Read_Archivo {
    Variables_Globales var = new Variables_Globales();
    
    
    public void leerArchivo(String Arhivo, String log, DateTimeFormatter dtf)
    {
        var.setArchivo(Arhivo);
        var.setBitacora(log);
        var.setDtf(dtf);
        
        String nomArchivo ="";
        String linea;
        int contador=1;
     
        
        BufferedReader br;
        
        try {
        
        String Respuesta ="";
        var.setLog(new File(var.getBitacora()));
        var.setEscribirlog(new FileWriter(var.getLog(), true));
        var.setReglonlog(new PrintWriter(var.getEscribirlog()));
        
       
        nomArchivo = var.getArchivo().substring(0, var.getArchivo().indexOf('.'));
        var.setErrores(new File (nomArchivo+"-errores.txt"));
        var.setEscribirerror(new FileWriter(var.getErrores(), true));
        var.setReglonerror(new PrintWriter(var.getEscribirerror()));
        
            
            br = new BufferedReader(new FileReader(var.getArchivo()));
            var.getReglonlog().println("> "+var.getDtf().format(LocalDateTime.now())+" ***** 02 INFORMACIÓN se comienza lectura de archivo "+var.getArchivo());
            Analisis revi = new Analisis();
            
            
            while ((linea= br.readLine())!=null) //Lectura del archivo por línea
            {
                
                if (contador<10)
                {
                    Respuesta =revi.AnalizaTexto(linea);
                var.getReglonerror().println("0000"+contador + " " + linea + " "+ escribir(Respuesta) );
                       // System.out.println(contador + " " + linea + " "+Respuesta );
                
                        contador++;
                }
                else{
                if(contador<100){
                   Respuesta =revi.AnalizaTexto(linea);
                var.getReglonerror().println("000"+contador + " " + linea + " "+escribir(Respuesta) );
                        //System.out.println(contador + " " + linea + " "+Respuesta);
                        contador++;
                }
                else{
                if(contador<1000){
                  Respuesta =revi.AnalizaTexto(linea);
                var.getReglonerror().println("00"+contador + " " + linea + " "+escribir(Respuesta) );
                        //System.out.println(contador + " " + linea + " "+Respuesta);
                        contador++;
                }
                else{
                if(contador<10000){
                  Respuesta =revi.AnalizaTexto(linea);
                var.getReglonerror().println("0"+contador + " " + linea + " "+escribir(Respuesta) );
                        //System.out.println(contador + " " + linea + " "+Respuesta );
                        contador++;
                }
                else{
                Respuesta =revi.AnalizaTexto(linea);
               var.getReglonerror().println(contador + " " + linea + " "+escribir(Respuesta) );
                        //System.out.println(contador + " " + linea + " "+Respuesta );
                        contador++;
                
                }
                }
                }
                }
                
                
                        
                
                
                
                //AnalizaTexto(linea);
            
            }
                var.getReglonlog().println("> "+var.getDtf().format(LocalDateTime.now())+" ***** 03 SE termina lectura de archivo "+var.getArchivo());
                
               var.getReglonlog().close();
                var.getReglonerror().close();
                var.getEscribirerror().close();
                var.getEscribirlog().close();
               
            
        } catch (FileNotFoundException ex)
        {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex){
          System.out.println("Archivo no encontrado o no se pudo abrir");
        }
        
    }
    
   
    public String escribir ( String txt)
    {
        switch (txt) {
            case "1":
                txt = txt + " error la cadena supera los 80 caracteres permitidos";
                break;
            
        }
        System.out.print(txt+ "$ ");
        return txt;
    }
   
}
