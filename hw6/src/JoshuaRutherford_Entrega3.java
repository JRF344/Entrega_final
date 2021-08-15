/*CHECKLIST
-GUARDAR ARREGLO PARA CADA PAIS [X]
-REGISTRAR NOMBRE ORO PLATA Y BRONCE [X]
-CALCULAR PUNTOS EN PUNTAJETOTAL [X]
-IMPRIMIR PUNTAJETOTAL COMO TABLA
-IMPRIMIR PAIS CON MAYOR CANTIDAD DE PLATA
-IMPRIMIR PROMEDIO DE MEDALLAS DE BRONCE
-"MEDALLERO INFORMATIVO"
-ARREGLO PUNTAJETOTALOBTENIDO = PUNTAJES DE MAYOR A MENOR
-ARREGLO PAISESORDENADO = NOMBRES DE PAISES SEGUN PUNTAJETOTALOBTENIDO
-IMPRIMIR PUNTAJETOTALOBTENIDO Y PAISESORDENADO EN UNA TABLA
-SALIR
*/

import java.io.*;

public class JoshuaRutherford_Entrega3 {

  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintStream out = System.out;

  public static void main(String[] args) throws Exception {
    out.println("Escriba la cantidad de paises participantes");

    // FUNCTIONAL VARIABLES
    int cantidadPaises = leerEntero();
    int menuOption = 0;
    boolean exitMenu = false;

    // GLOBAL VARIABLES
    int[] medallasOro = new int[cantidadPaises];
    int[] medallasPlata = new int[cantidadPaises];
    int[] medallasBronce = new int[cantidadPaises];
    int j = 0;
    int mejor = 0;
    int[] puntajeFinal = new int[cantidadPaises];
    String[] puntajeString = new String[cantidadPaises];
    String[] nombrePais = new String[cantidadPaises];

    // MENU OPTIONS

    while (exitMenu == false) {
      TopBar();


      /**
       * Checklist by menu options
       * 
       * 1) Registrar Informacion                     DONE
       * 2) Puntaje Total                         NOT DONE
       * 3) Cantidad mayor de Medallas de Bronce  NOT DONE
       * 4) Promedio de Medallas de Bronce        NOT DONE
       * 5) Medallero Informativo                 NOT DONE
       * 6) Posiciones Actuales                   NOT DONE
       * 7) Salir                                     DONE
       */

      out.println(
        "1) Registrar Informacion" + "\n" +
        "2) Puntaje Total" + "\n" +
        "3) Mayor Cantidad de Medallas de Plata" + "\n" +
        "4) Promedio de Medallas de Bronce" + "\n" +
        "5) Medallero Informativo" + "\n" +
        "6) Posiciones Actuales" + "\n" +
        "7) Salir"
        );

      menuOption = leerRangosEnteros(1, 7);

      switch (menuOption) {
        case 1:
          // REGISTRAR INFORMACION
          j = 0;

          while (j < cantidadPaises) {

            System.out.println("Ingrese el nombre del Pais " + (j + 1));
            nombrePais[j] = in.readLine();

            MedallasOro(medallasOro, j);
            MedallasPlata(medallasPlata, j);
            MedallasBronce(medallasBronce, j);

            PuntajeFinal(medallasOro, medallasPlata, medallasBronce, j, puntajeFinal);

            if (puntajeFinal[j] > mejor) {
              mejor = puntajeFinal[j];
              puntajeString[j] = nombrePais[j];
            }
            j++;
          }
          break;
        case 2:
          // IMPRIMIR PUNTAJE TOTAL
          j = 0;

          while (j < cantidadPaises) {
            System.out.println("La puntacion de " + nombrePais[j] + " es: " + puntajeFinal[j]);
            j++;
          }
          break;
        case 3:
          // IMPRIMIR PAIS CON MAS MEDALLAS DE PLATA

          break;
        case 4:
          // IMPRIMIR PROMEDIO MEDALLAS DE BRONCE
          break;
        case 5:
          // IMPRIMRIR MEDALLERO INFORMATIVO
          j = 0;

          
          System.out.println("Pais" + "Medallas de oro" + "Medallas de plata" + "Medallas de bronce");

          while (j < cantidadPaises) {

            System.out.println("La cantidad de medallas de Oro: " + medallasOro[j]);
            System.out.println("La cantidad de medallas de Plata: " + medallasPlata[j]);
            System.out.println("La cantidad de medallas de Bronce: " + medallasBronce[j]);
            j++;
          }
          break;
        case 6:
          // MAYOR A MENOR & IMPRIMIR
          break;
        case 7:
          // EXIT PROGRAM
          exitMenu = true;
          break;
        default:
          out.println("ERR");
          break;
      }
    }
  }

  // METHODS

  private static void TopBar() {
    out.println("\n" + "Juegos Olímpicos de Tokio 2020" + "\n" + "Menu Principal");
  }

  private static void PuntajeFinal(int[] medallasOro, int[] medallasPlata, int[] medallasBronce, int j,
      int[] puntajeFinal) {
    puntajeFinal[j] = (int) ((medallasOro[j] * 3) + (medallasPlata[j] * 2) + medallasBronce[j]);
  }

  private static void MedallasBronce(int[] medallasBronce, int j) {
    System.out.println("Ingrese la cantidad de medallas de Bronce");
    int bronceActual = leerEntero();
    medallasBronce[j] += bronceActual;
  }

  private static void MedallasPlata(int[] medallasPlata, int j) {
    System.out.println("Ingrese la cantidad de medallas de Plata");
    int plataActual = leerEntero();
    medallasPlata[j] += plataActual;
  }

  private static void MedallasOro(int[] medallasOro, int j) {
    System.out.println("Ingrese la cantidad de medallas de Oro");
    int oroActual = leerEntero();
    medallasOro[j] += oroActual;
  }

  static int leerRangosEnteros(int inferior, int superior) {
    int resultado = 0;

    do {
      resultado = leerEntero();
      if (resultado < inferior || resultado > superior) {
        out.println(String.format("Valor fuera del rango válido [%d - %d]", inferior, superior));
        out.print("Digite otro valor: ");
      }
    } while (!(inferior <= resultado && resultado <= superior));

    return resultado;
  }

  static int leerEntero() {
    int resultado = 0;
    boolean bandera = false;

    do {
      try {
        resultado = Integer.parseInt(in.readLine());
        bandera = false;
      } catch (Exception e) {
        bandera = true;
        out.println("Usted no digito un entero, intente de nuevo por favor!");
      }
    } while (bandera);

    return resultado;
  }
}
