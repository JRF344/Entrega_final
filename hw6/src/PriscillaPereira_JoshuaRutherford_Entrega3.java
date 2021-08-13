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

public class PriscillaPereira_JoshuaRutherford_Entrega3 {

  static BufferedReader in = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static PrintStream out = System.out;
  private static int[] puntajeFinal;

  public static void main(String[] args) throws Exception {
    out.println("Escriba la cantidad de paises participantes");
    
    //FUNCTIONAL VARIABLES
    int cantidadPaises = Integer.parseInt(in.readLine());
    int menuOption = 0;

    //GLOBAL VARIABLES
    int[] medallasOro = new int [cantidadPaises];
    int[] medallasPlata = new int [cantidadPaises];
    int[] medallasBronce = new int [cantidadPaises];
    int i = 1;
    int j = 1;
    int mejor = 0;
    puntajeFinal = new int[cantidadPaises];
    String[] puntajeString = new String[cantidadPaises];
    String[] nombrePais = new String[cantidadPaises];

    //MENU OPTIONS
  out.println("Juegos Olímpicos de Tokio 2020" + "\n" + "Menu Principal");
    menuOption = leerRangosEnteros(1, 7);

    switch (menuOption) {
      case 1:
        //REGISTRAR INFORMACION
        j = 1;

        while (j <= cantidadPaises) {

          System.out.println("Ingrese el nombre del Pais " + i);
          nombrePais[j] = in.readLine();

          MedallasOro(medallasOro, j);

          MedallasPlata(medallasPlata, j);

          MedallasBronce(medallasBronce, j);

          puntajeFinal[j] = (int) ((medallasOro[j] * 3) + (medallasPlata[j] * 2) + medallasBronce[j]);

          if (puntajeFinal[cantidadPaises] > mejor) {
            mejor = puntajeFinal[cantidadPaises];
            puntajeString[cantidadPaises] = nombrePais[cantidadPaises];
          }
          j++;
        }
        break;
      case 2:
        //IMPRIMIR PUNTAJE TOTAL

        while (i <= cantidadPaises) {
          System.out.println("La puntacion de " + i + ": " + nombrePais[cantidadPaises] + " es " + puntajeFinal[cantidadPaises]);
        }
        break;
      case 3:
        //IMPRIMIR PAIS CON MAS MEDALLAS DE PLATA- Working on it 




        break;
      case 4:
        //IMPRIMIR PROMEDIO MEDALLAS DE BRONCE
        break;
      case 5:
        //IMPRIMRIR MEDALLERO INFORMATIVO
        System.out.println("La cantidad de medallas de Oro: " + medallasOro);
        System.out.println("La cantidad de medallas de Plata: " + medallasPlata);
        System.out.println("La cantidad de medallas de Bronce: " + medallasBronce);
        break;
      case 6:
        //MAYOR A MENOR & IMPRIMIR
        break;
      case 7:
        //MAYOR A MENOR & IMPRIMIR
        break;
      default:
        out.println("ERR");
        break;
    }
  }

  // METHODS

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
        out.println(String.format("Valor fuera del rango válido [%d - %d]",inferior,superior));
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
