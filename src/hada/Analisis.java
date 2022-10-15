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
    
    Read_Archivo txt = new Read_Archivo();
    
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
                
                   if(token.length()>20){
                      //txt.escribir(token +"!!! Error sobre pasa los 20 caracteres");
                            //TokenClasificado =true;
                            //break;
                }else{
                       
                          
                if (token.matches(comparaTOKENS.patron))
                {
                 
                    switch (comparaTOKENS)
                    {
                        case Reservada:
                            TokenClasificado =true;
                            break;
                       
                        case Procedure:
                        TokenClasificado =true;
                            break;
                        
                        case Is:
                        TokenClasificado =true;
                            break;    
                        
                        case Nombre_Archivo:
                        TokenClasificado =true;
                            break;    
                        
                        case Numero_Entero:
                        TokenClasificado =true;
                            break;
                        
                        case Numero_Real:
                            TokenClasificado =true;
                            break;

                        case Palabra:
                          TokenClasificado =true;
                            break;
                            
                        case Operadores:
                          
                            TokenClasificado =true;
                            break;
                        
                        case finlinea:
                           TokenClasificado =true;
                            break;   
                        
                        case Agrupacion:
                            TokenClasificado =true;
                            break;  
                        
                        default:
                            Respuesta =( token +" sin clasificar");
                            break;
                    }
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
                        Respuesta =(Respuesta+"\n --> Error falta palabra Reservada PROCEDURE en la declaración inicial");
                        encontrado=true;
                        break;
                    
                    case Inicio1:
                        Respuesta =(Respuesta+"\n--> Error hay caracteres antes de la instrucción de inicio, si es un comentario falta --");
                        encontrado=true;
                        break;    
                    
                    case Inicio2:
                        Respuesta =(Respuesta+"\n --> Error falta palabra Reservada IS en la declaración inicial");
                        encontrado=true;
                        break;  
                    
                    case Inicio3:
                        Respuesta =(Respuesta+"\n !!!Error Nombre de Identificador Empieza con _");
                        encontrado=true;
                        break;    
                    
                    case Inicio4:
                        Respuesta =(Respuesta+"\n !!!Error Nombre de Identificador Termina con _");
                        encontrado=true;
                        break;    
                    
                    case Inicio5:
                    
                        Respuesta =(TxtLinea +" !!!Error Nombre de Identificador Contiene caracteres no permitidos");
                        encontrado=true;
                        break;    
                    
                    case Inicio6:
                        Respuesta =(Respuesta+"\n !!!Error Nombre de Identifcador Empieza con un número");
                        encontrado=true;
                        break;    
                    
                    case Final:
                        
                        //Respuesta =(Respuesta+"\n --> Es una instrucción de final");
                        encontrado=true;
                        break;
                    case Comentario:
                        
                        //Respuesta =(Respuesta+"\n --> Es una linea de comentario");
                        encontrado=true;
                        break;
                    
                    case Etiqueta1:
                        Respuesta =(Respuesta+"\n --> Eror falta >> de cierre de Etiqueta");
                        encontrado=true;
                        break;
                    
                    case Etiqueta2:
                        Respuesta =(Respuesta+"\n --> Eror falta << de apertura de Etiqueta");
                        encontrado=true;
                        break;    
                    
                    case Suma:
                        Respuesta =(Respuesta+"\n --> Falta ; en la expresión de suma ");
                        encontrado=true;
                        break;
                    
                    case Constante_numerica_entera:
                    
                        num = Integer.parseInt(Expresion);
                        
                        Respuesta =(Respuesta+ "\n"+ Validanum(num));
                        encontrado=true;
                        break;
                        
                    case Resta:
                        
                        encontrado=true;
                        break;                    
                    
                    case Multiplica:
                    
                        encontrado=true;
                        break;
                    
                    case final_linea:
                    
                    
                        encontrado=true;
                        break;    
                    default:
                    
                        Respuesta =(Respuesta+"\n ok");
                }           
            }
        }
        if (encontrado==false)
        {
            Respuesta =(Respuesta+" ");
         
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
            respuesta = (num + " ");
            }
                }
        return respuesta;  
    }
}
