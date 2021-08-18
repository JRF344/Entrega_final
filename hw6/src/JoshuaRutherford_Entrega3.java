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

    // FUNCTIONAL VARIABLES
    int cantidadPaises = 0;
    int menuOption = 0;
    boolean exitMenu = false;

    out.println("Escriba la cantidad de paises participantes");
    cantidadPaises = leerEntero();

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
       * 1) Iniciar Programa                            DONE
       * 2) Rwgistrar Medallas                          DONE
       * 3) Calcular Puntaje Total                      DONE
       * 4) Imprimir Puntaje Total                  NOT DONE
       * 5) Imprimir Pais con mas Medallas de Plata NOT DONE 
       * 6) Calcular e Imprimir Promedio de Bronce  NOT DONE
       * 7) Medallero Informativo                   NOT DONE
       * 8) Ordenar Puntajes de Mayor a Menor       NOT DONE
       * 9) Imprimir Puntajes de mayor a Menor      NOT DONE
       * 10) Salir                                      DONE
       */

      out.println(
        "1) Iniciar Programa" + "\n" +
        "2) Registrar Medallas" + "\n" +
        "3) Calcular Puntaje Total" + "\n" +
        "4) Imprimir Puntaje Total" + "\n" +
        "5) Imprimir Pais con mas Medallas de Plata" + "\n" +
        "6) Calcular e Imprimir Promedio de Bronce" + "\n" +
        "7) Medallero Informativo" + "\n" +
        "8) Ordenar Puntajes de Mayor a Menor" + "\n" +
        "9) Imprimir Puntajes de mayor a Menor" + "\n" +
        "10) Salir"
        );

      menuOption = leerRangosEnteros(1, 7);

      switch (menuOption) {
        case 1:
        
          // Iniciar Programa
          j = 0;

          while (j < cantidadPaises) {

            System.out.println("Ingrese el nombre del Pais " + (j + 1));
            nombrePais[j] = in.readLine();

            j++;
          }
          break;
        case 2:
          // Registrar Medallas
          j = 0;

          while (j < cantidadPaises) {

            MedallasOro(medallasOro, j);
            MedallasPlata(medallasPlata, j);
            MedallasBronce(medallasBronce, j);
            
            j++;
          }
          break;
        case 3:
          // Calcular Puntaje Total
          j = 0;

          while (j < cantidadPaises) {
            PuntajeFinal(medallasOro, medallasPlata, medallasBronce, j, puntajeFinal);
            
            if (medallasPlata[j] > mejor) {
              mejor = medallasPlata[j];
              puntajeString[j] = nombrePais[j];
            }

            j++;
          }
          break;
        case 4:
          // Imprimir Puntaje Total
          j = 0;
          
          TopBar();
          System.out.println("Tabla de Puntajes");
          System.out.println("Pais" + "PuntajeTotal");

          while (j < cantidadPaises) {

            System.out.println(nombrePais[j] + puntajeFinal[j]);
            
            j++;
          }
          break;
        case 5:
          // Imprimir Pais con mas Medallas de Plata
          j = 0;

          TopBar();
          System.out.println("Mayor Cantidad de Medallas de Plata");
          System.out.println(String.format("%-15s%15s%n" , "Pais" , "Medallas de Plata"));
          while (j < cantidadPaises) {
            System.out.println(String.format("|%-15s%15d|" , nombrePais[j] ,  medallasPlata[j]));
            j++;
          }
          break;
        case 6:
          // PROMEDIO DE BRONCE
          
          break;
        case 7:
        // MEDALLERO INFORMATIVO
        j = 0;
          TopBar();
          out.println("Medallero Informativo");
          out.print(String.format("%-15s%15s%15s%15s%n", "Pais" , "Medallas de oro" , "Medallas de plata" , "Medallas de bronce"));
          out.println();

          while (j < cantidadPaises) {
            out.print(String.format("%-15s%15d%15d%15d" , nombrePais[j] , medallasOro[j] , medallasPlata[j] , medallasBronce[j]));
            out.println();
          }
          
          break;
        case 8:
        break;
        case 9:
        break;
        case 10:
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
