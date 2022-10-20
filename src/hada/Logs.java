/*
 Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
En esta clase se realiza escritura de un archivo de LOG de la aplicación
 */
package hada;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
A pesar de no estar establecido como requerimiento se considera una importante herramienta para revisión del proceso
 */
public class Logs {
    String Bitacora = "Hada_log.txt";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //formato para el Log
        File log;
        FileWriter escribirlog;
        PrintWriter reglonlog;
    
    public void escribe_log(int indice, String Mensaje){
        try {
            log = new File(Bitacora);
            escribirlog = new FileWriter(log, true);
            reglonlog = new PrintWriter(escribirlog);
            switch (indice) {
                
                case 0 -> reglonlog.println("> " + dtf.format(LocalDateTime.now()) +"!!!! "+ Mensaje);
                case 1 -> {
                    reglonlog.println("**********************************************************************************");
                    reglonlog.println("***************  Log del Proyecto Compilador HADA               ******************");
                    reglonlog.println("Creado por el Estudiante: Elmer Eduardo Salazar Flores (3-0426-0158)");
                    reglonlog.println("UNED compiladores 03307");
                    reglonlog.println("Actualmente se está ejecuantando en el directorio " + Mensaje);
                    reglonlog.println("**********************************************************************************\n\n");}
                case 2 -> {
                    reglonlog.println("**********************************************************************************");
                    reglonlog.println("***************  Log del Proyecto Compilador HADA               ******************");
                    reglonlog.println("Creado por el Estudiante: Elmer Eduardo Salazar Flores (3-0426-0158)");
                    reglonlog.println("UNED compiladores 03307\n");
                    reglonlog.println("**********************************************************************************\n\n");
                    reglonlog.println("> " + dtf.format(LocalDateTime.now()) + " ERROR No se recibió archivo parámetro "+ Mensaje);}
                case 3 -> {reglonlog.println("> " + dtf.format(LocalDateTime.now()) + " ***** 01 AVISO se recibe Archivo parámetro " + Mensaje + " OK");}
                case 4 -> { reglonlog.println("> " + dtf.format(LocalDateTime.now()) + " ***** 02 INFORMACIÓN se comienza lectura de archivo " + Mensaje);}
                case 5 -> { reglonlog.println(Mensaje);}
                case 6 -> { reglonlog.println("> " + dtf.format(LocalDateTime.now()) + " >!!!AVISO Se encontraron "+Mensaje);}
                case 7 -> { reglonlog.println("\n> " + dtf.format(LocalDateTime.now()) + " ***** 03 INFORMACIÓN SE termina lectura de archivo ");}
                case 8 -> { reglonlog.println("> " + dtf.format(LocalDateTime.now()) + " ***** 04 AVISO Por los errores no se pasa a segunda fase de Compilación");
                            reglonlog.println("\n\n *************************FIN DE LOG ********************************** ");}
                case 9 -> { reglonlog.println("> " + dtf.format(LocalDateTime.now()) + " ***** 04 INFORMACIÓN se comienza generación de archivo para segunda fase de compilar Archivo nombre: " + Mensaje);}
                case 10 -> { reglonlog.println("> " + dtf.format(LocalDateTime.now()) + Mensaje + " Compilación de archivo");}
                case 11 -> { reglonlog.println("> " + dtf.format(LocalDateTime.now()) + Mensaje + " Ejecución comando dir");}
                case 12 -> { reglonlog.println("> " + dtf.format(LocalDateTime.now()) + " Ejecución programa" + Mensaje);}
                case 13 -> { reglonlog.println("> " + dtf.format(LocalDateTime.now()) + Mensaje + " Se ejecuto el programa");
                             reglonlog.println("\n\n *************************FIN DE LOG ********************************** ");}
                
                default -> throw new AssertionError();
            }
            reglonlog.close();
            escribirlog.close();
        } catch (Exception e) {
        }
    }
}
