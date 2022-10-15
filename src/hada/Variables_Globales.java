/*
 UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
Clase con variables
 */
package hada;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;


public class Variables_Globales {
    String archivo;
    String bitacora;
    DateTimeFormatter dtf;
    File log, errores;
    FileWriter escribirlog;
    FileWriter escribirerror;
    PrintWriter reglonlog;
    PrintWriter reglonerror;

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getBitacora() {
        return bitacora;
    }

    public void setBitacora(String bitacora) {
        this.bitacora = bitacora;
    }

    public DateTimeFormatter getDtf() {
        return dtf;
    }

    public void setDtf(DateTimeFormatter dtf) {
        this.dtf = dtf;
    }

    public File getLog() {
        return log;
    }

    public void setLog(File log) {
        this.log = log;
    }

    public File getErrores() {
        return errores;
    }

    public void setErrores(File errores) {
        this.errores = errores;
    }

    public FileWriter getEscribirlog() {
        return escribirlog;
    }

    public void setEscribirlog(FileWriter escribirlog) {
        this.escribirlog = escribirlog;
    }

    public FileWriter getEscribirerror() {
        return escribirerror;
    }

    public void setEscribirerror(FileWriter escribirerror) {
        this.escribirerror = escribirerror;
    }

    public PrintWriter getReglonlog() {
        return reglonlog;
    }

    public void setReglonlog(PrintWriter reglonlog) {
        this.reglonlog = reglonlog;
    }

    public PrintWriter getReglonerror() {
        return reglonerror;
    }

    public void setReglonerror(PrintWriter reglonerror) {
        this.reglonerror = reglonerror;
    }
}
