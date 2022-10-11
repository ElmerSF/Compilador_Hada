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
        Variables_Globales var = new Variables_Globales();
   
    public static void main(String[] args) {
        Variables_Globales var = new Variables_Globales();
        //Creamos un archivo llamado Hada_log para revisión de la herramienta
        var.setBitacora("Hada_log.txt");
        var.setDtf(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")); //formato para el Log
        String Archivo="";
                   
                       
          try {
          
          var.setLog(new File(var.getBitacora()));
          
          var.setEscribirlog(new FileWriter(var.getLog(), true));
          var.setReglonlog(new PrintWriter(var.getEscribirlog()));
          
             
                
                if (args.length>0)
                {
                   Archivo=args[0];
                   var.setArchivo(Archivo);
                   var.getReglonlog().println("> "+var.getDtf().format(LocalDateTime.now())+ " ***** 01 AVISO se recibe Archivo parámetro " + var.getArchivo() + " OK");
                    System.out.println("El archivo a analizar es " + Archivo );
                    Read_Archivo lectura = new Read_Archivo();
                    
                    lectura.leerArchivo(var.getArchivo(), var.getBitacora(), var.getDtf());
                    
                } else {
                   var.getReglonlog().println("> "+var.getDtf().format(LocalDateTime.now())+" ERROR No se recibió archivo parámetro ");
                    System.out.println("No se indicó nombre de archivo a analizar!");
                }
            var.getReglonlog().close();
            var.getEscribirlog().close();
            
           } catch (IOException ex) {
           System.out.println("ERROR No se logro guardar el log" + ex);
                
           }
           
    }
    
}
