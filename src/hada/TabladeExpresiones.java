/*
 UNED Informática Compiladores 3307
Estudiante Elmer Eduardo Salazar Flores 3-0426-0158
III Cuatrimestre 2022
Tabla de las expresiones según los lineamientos del lenguaje HADA
 */
package hada;

public class TabladeExpresiones {

    public enum Tipos {

        Comentario("([--]+.{0,})"),
        Inicio("[' ']{0,}(PROCEDURE)[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[A-Z|0-9]{0,}[' ']{0,}"),
        Inicio1("[' ']{0,}(PROCEDURE)[' ']{0,}[0-9]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[A-Z|0-9]{0,}[' ']{0,}"),//NUMERO
        Inicio2("[' ']{0,}(PROCEDURE)}[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[A-Z|0-9]{0,}[' ']{0,}[;]{1,}[' ']{0,}"),
        Inicio3("[' ']{0,}(PROCEDURE)[' ']{0,}[_]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[A-Z|0-9]{0,}[' ']{0,}"),//EMPIEZA
        Inicio4("[' ']{0,}(PROCEDURE)[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[_]{1,}[' ']{0,}[A-Z|0-9]{0,}[' ']{0,}"), //TERMINA
        Nombre_Arhivo_caracter("[' ']{0,}[^A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[:]{1,}[' ']{0,}[A-Z|a-z]{0,}[' ']{0,}[;]{0,}[' ']{0,}"),
        Nombre_Archiv_caracter_mitad("[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[-|#|!]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[:]{1,}[' ']{0,}[A-Z|a-z]{0,}[' ']{0,}[;]{0,}[' ']{0,}"),
        Nombre_Archiv_caracter_mitad2("[' ']{0,}[A-Z|a-z]{1,}[-|#|!]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[:]{1,}[' ']{0,}[A-Z|a-z]{0,}[' ']{0,}[;]{0,}[' ']{0,}"),
        Nombre_Archiv_caracter_final("[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[-|#|!|_]{1,}[' ']{0,}[:]{1,}[' ']{0,}[A-Z|a-z]{0,}[' ']{0,}[;]{0,}[' ']{0,}"),
        Nombre_Archivo_num("[' ']{0,}[0-9]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[:]{1,}[' ']{0,}[A-Z|a-z]{0,}[' ']{0,}[;]{0,}[' ']{0,}"),
        Reservado("([' ']{0,})([ELSE|IF|FOR]{1,}[a-zA-Z|0-9|' ']{0,}[;])"),
        Begin("[' ']{0,}(BEGIN)[' ']{0,}[;][' ']{0,}"),
        Definicion_variables_Correcta("[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}([:]{1,})[' ']{0,}(INTEGER|FLOAT|float|CHARACTER)[' ']{0,}([;]{1})([' ']{0,})"),
  
        //       //varias variables identificador repetido
        Definicion_variables5("([' ']{0,})([[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]{1,})([,]{1,}[' ']{1,})([[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]{1,})([[,]{1,}[' ']{1,}[[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]]{0,})([' ']{0,})([:]{1})([' ']{0,})(INTEGER|FLOAT||float|CHARACTER)([' ']{0,})([;]{1})([' ']{0,})"),
        //       //varias variables sin tipo error 24
        Definicion_variables("([' ']{0,})([[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]{1,})([,]{1,}[' ']{1,})([[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]{1,})([[,]{1,}[' ']{1,}[[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]]{0,})([' ']{0,}[:]{1})([' ']{0,})"),
        //       //multiples variables de forma correcta
        Definicion_multiples_variables_Correcta("([' ']{0,})([[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]{1,})([,]{1,1}[' ']{1,})([[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]{1,})([[,]{1,1}[' ']{1,}[[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]]{1,})([' ']{0,}[:]{1})([' ']{0,})(INTEGER|FLOAT||float|CHARACTER)([' ']{0,})([;]{1})([' ']{0,})"),
        //       //varias variables falta ; error 25
        Definicion_variables1("([' ']{0,})([[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]{1,})([,]{1,}[' ']{1,})([[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]{1,})([[,]{1,}[' ']{1,}[[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]]{0,})([' ']{0,}[:]{1})([' ']{0,})(INTEGER|FLOAT||float|CHARACTER)([' ']{0,})"),
        //       //varias variables sobre coma al inicio error 26
        Definicion_variables2("([' ']{0,})([,]{1,})([' ']{0,})([[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]{1,})([,]{1,}[' ']{1,})([[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]{1,})([[,]{1,}[' ']{1,}[[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]]{0,})([' ']{0,}[:]{1})([' ']{0,})(INTEGER|FLOAT|float|CHARACTER)([' ']{0,})([;]{1})([' ']{0,})"),
        //        //varias variables sobra coma al final error 27
        Definicion_variables3("([' ']{0,})([[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]{1,})([,]{1,}[' ']{1,})([[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]{1,})([[,]{1,}[' ']{1,}[[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]]{0,})([' ']{0,}[,]{1,})([' ']{0,})([:]{1})([' ']{0,})(INTEGER|FLOAT|float|CHARACTER)([' ']{0,})([;]{1})([' ']{0,})"),
        //       //  varias variables no corresponde el tipo de variable
        Definicion_variables4("([' ']{0,})([[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]{1,})([,]{1,}[' ']{1,})([[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]{1,})([[,]{1,}[' ']{1,}[[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}]]{0,})([' ']{0,})([:]{1})([' ']{0,})([A-Z|a-z]*)([' ']{0,})([;]{1})([' ']{0,})"),
        //       //varias variables repetido ::
        Definicion_variables7("[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[:]{2,}[' ']{0,}(INTEGER|FLOAT|float|CHARACTER){0,}[' ']{0,}[;]{0,}[' ']{0,}"),
        //       //varias variables falta :
        Definicion_variables8("[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[^:][' ']{0,}(INTEGER|FLOAT|float|CHARACTER){1,}[' ']{0,}[;]{0,}[' ']{0,}"),
        //      //una sola falta ;
        Definicion_variables9("[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[:]{1,}[' ']{0,}(INTEGER|FLOAT|float|CHARACTER)[' ']{0,}"),
        //       //una sola que no tiene nada
        Definicion_variables10("[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[:]{1,}[' ']{0,}[A-Z]{1,}[' ']{0,}[;]{0,}[' ']{0,}"),
          //       //una sola coma al inicio suelta
        Definicion_variables11("[' ']{0,}([,]{1,})([' ']{0,})[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[:]{1,}[' ']{0,}(INTEGER|FLOAT|float|CHARACTER)[' ']{0,}([;]{1})([' ']{0,})"),
        //       //una sola coma al final suelta
        Definicion_variables12("[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}([,]{1,})([' ']{0,})[:]{1,}[' ']{0,}(INTEGER|FLOAT|float|CHARACTER)[' ']{0,}([;]{1})([' ']{0,})"),
        //       //una sola repetido ::
        Definicion_variables13("[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[:]{2,}[' ']{0,}(INTEGER|FLOAT|float|CHARACTER)[' ']{0,}([;]{1})([' ']{0,})"),
        //       //una sola falta :
        Definicion_variables14("[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[^:][' ']{0,}(INTEGER|FLOAT|float|CHARACTER)[' ']{0,}([;]{1})([' ']{0,})"),
        //       //una sola sin tipo
        Definicion_variables15("[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[:]{1,}[' ']{0,}([;]{1})([' ']{0,})"),
        //       // una sola que no corresponde a nada
        Definicion_variables16("[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[:]{1,}[' ']{0,}([A-Z|a-z]*)([' ']{0,})([;]{1})([' ']{0,})"),
        linea("[[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}][:=][' '|(|[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}|)][\n]{0,5}([;])"),
        //  Reservado( "{1,}[a-zA-Z|0-9|' ']{0,}[;]"),
        Etiqueta1("[' ']{0,}([<<]{1,})[' ']{0,}([A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,})[' ']{0,}([^>>]{1,})[' ']{0,}"),//SIN CIERRE
        Etiqueta_correcta("[' ']{0,}([<<]{1,})[' ']{0,}([A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,})[' ']{0,}([>>]{1,})[' ']{0,}"),
        Etiqueta2("[' ']{0,}([^<<]{1,})[' ']{0,}([A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,})[' ']{0,}([>>]{1,})[' ']{0,}"),// SIN APERTURA
        Etiqueta3("[' ']{0,}([<<]{1,})[' ']{0,}([A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[-|#|!|@]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,})[' ']{0,}([>>]{1,})[' ']{0,}"), //caracter
        Etiqueta5("[' ']{0,}([<<]{1,})[' ']{0,}([0-9]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,})[' ']{0,}([>>]{1,})[' ']{0,}"), //empieza con numero
        Etiqueta6("[' ']{0,}([<<]{1,})[' ']{0,}([_]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,})[' ']{0,}([>>]{1,})[' ']{0,}"), //empieza con _
        Etiqueta7("[' ']{0,}([<<]{1,})[' ']{0,}([A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[_]{1,})[' ']{0,}([>>]{1,})[' ']{0,}"), // termina con _
        Etiqueta8("[' ']{0,}([<]{1,}[' ']{1,}[<]{1,})[' ']{0,}([A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,})[' ']{0,}([>>]{1,})[' ']{0,}"),
        Etiqueta9("[' ']{0,}([<<]{1,})[' ']{0,}([A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,})[' ']{0,}([>]{1,}[' ']{1,}[>]{1,})[' ']{0,}"),
        Asignacion("[' ']{0,}([A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,})[' ']{0,}([:=]{1,})[' ']{0,}([a-z|A-Z|0-9]*{1,})[' ']{0,}([;]{1})[' ']{0,}"),
        Final("(fin del programa)"),
        END_mal("[' ']{0,}(END|end)[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}"),
        END("[' ']{0,}(END|end)[' ']{0,}[A-Z|a-z]{1,}[a-z|A-Z|0-9|_]*{0,}[a-z|A-Z|0-9]{1,}[' ']{0,}[;][' ']{0,}"),
        Suma("[0-9|' '0-9|0-9' ']{1,}\\+[\n]{5,}[0-9|' '0-9]{1,}[;]"),
        Resta("[0-9]*\\-[0-9]*"),
        Constante_numerica_entera("[0-9]*|[' '][0-9]*|[0-9]*[' ']|[+|-][0-9]*"),
        final_linea(";"),
        Multiplica("[0-9]*\\s+(MULTIPLICA|MULTI|X)+\\s[0-9]*");

        public final String patron;

        Tipos(String s) {

            this.patron = s;

        }
    }

}
