/*
UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
 */
package hada;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class HADA {
        
   
    public static void main(String[] args) {
        //Creamos un archivo llamado Hada_log para revisión de la herramienta
        String bitacora= "Hada_log.txt";
        File log; //para poder manipular el archivo
        FileWriter escribir;//para poder llenar los datos
        PrintWriter reglon;//para agregar un nuevo reglon con información
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //formato para el Log
        String Archivo="";
       
            //realiza una instancia de la clase analisis.
        
            
            
                       
          try {
          log = new File(bitacora);
          escribir = new FileWriter(log, true);
          reglon = new PrintWriter(escribir);
             
                
                if (args.length>0)
                {
                   Archivo=args[0];
                   reglon.println("> "+dtf.format(LocalDateTime.now())+" ***** 01 AVISO se recibe Archivo parámetro " + Archivo + " OK");
                    System.out.println("El archivo a analizar es " + Archivo );
                    Read_Archivo lectura = new Read_Archivo();
                    lectura.leerArchivo(Archivo, bitacora, dtf);
                    
                } else {
                    reglon.println("> "+dtf.format(LocalDateTime.now())+" ERROR No se recibió archivo parámetro ");
                    System.out.println("No se indicó nombre de archivo a analizar!");
                }
            reglon.close();
            escribir.close();
            
           } catch (IOException ex) {
           System.out.println("ERROR No se logro guardar el log" + ex);
                
           }
           
    }
    
}
