/*
UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
Clase principal donde se inicia
 */
package hada;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class HADA {
       
   
    public static void main(String[] args) throws InterruptedException {
      
        //Creamos un archivo llamado Hada_log para revisión de la herramienta
        
        String Bitacora ="Hada_log.txt";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //formato para el Log
        File log;
        FileWriter escribirlog;
        PrintWriter reglonlog;
        String Archivo="";
                   
                       
          try {
          
              
          log = new File(Bitacora);
          escribirlog = new FileWriter(log, true);
          reglonlog = new PrintWriter(escribirlog);
          
             
               
                if (args.length>0)
                {
                   Archivo=(args[0]+"");
                   
                   String directoryName = System.getProperty("user.dir");
                   System.out.println("Estamos en la ubicación " +directoryName);
                   reglonlog.println("**********************************************************************************");
                   reglonlog.println("***************  Log del Proyecto Compilador HADA               ******************");
                   reglonlog.println("Creado por el Estudiante: Elmer Eduardo Salazar Flores (3-0426-0158)");
                   reglonlog.println("UNED compiladores 03307");
                   reglonlog.println("Actualmente se está ejecuantando en el directorio "+ directoryName);
                   reglonlog.println("**********************************************************************************\n\n");
                   
                   reglonlog.println("> "+dtf.format(LocalDateTime.now()) + " ***** 01 AVISO se recibe Archivo parámetro " + Archivo + " OK");
                   
                    reglonlog.close();
                    escribirlog.close();
                    System.out.println("\nEl archivo a analizar es " + Archivo );
                    System.out.println("Se genera automáticamente un arhivo de log llamado Hada_log.txt en la ruta " + directoryName );
                    System.out.println("Tambien se genera un archivo de errores basado en el archivo recibido\n\n" + Archivo );
                     
                    Read_Archivo lectura = new Read_Archivo();
                   lectura.leerArchivo(Archivo);
                   // reglonlog.println("> "+dtf.format(LocalDateTime.now()) + " ***** 01 AVISO se recibe Archivo parámetro " + Archivo + " OK");
                } else {
                   reglonlog.println("**********************************************************************************");
                   reglonlog.println("***************  Log del Proyecto Compilador HADA               ******************");
                   reglonlog.println("Creado por el Estudiante: Elmer Eduardo Salazar Flores (3-0426-0158)");
                   reglonlog.println("UNED compiladores 03307\n");
                   reglonlog.println("**********************************************************************************\n\n");
                   reglonlog.println("> "+dtf.format(LocalDateTime.now())+" ERROR No se recibió archivo parámetro ");
                   System.out.println("No se indicó nombre de archivo a analizar!");
                   System.out.println("Puede consultar el arhivo de Log Hada_log.txt");
                    reglonlog.close();
                    escribirlog.close();
                }
            
            
           } catch (IOException ex) {
           System.out.println("ERROR No se logro guardar el log" + ex);
                
           }
           
    }
    
}
