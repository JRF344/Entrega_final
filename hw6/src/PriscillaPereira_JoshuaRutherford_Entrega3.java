/*CHECKLIST
-GUARDAR ARREGLO PARA CADA PAIS
-REGISTRAR NOMBRE ORO PLATA Y BRONCE
-CALCULAR PUNTOS EN PUNTAJETOTAL
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

  public static void main(String[] args) throws Exception {
    out.println("Escriba la cantidad de paises participantes");
    int cantidadPaises = Integer.parseInt(in.readLine());
    int menuOption = 0;
    menuOption = leerRangosEnteros(1, 8);
    switch (menuOption) {
      case 1:
        // REGISTRAR INFORMACION
        int i = 1;
        int j = 1;
        int mejor = 0;
        int[] puntajeFinal = new int[i];

        while (j <= cantidadPaises) {
          int medallasOro = 0;
          int medallasPlata = 0;
          int medallasBronce = 0;

          System.out.println("Ingrese el nombre del Pais " + i);
          String[] nombrePais = new String[i];

          medallasOro = MedallasOro(medallasOro);
          medallasPlata = MedallasPlata(medallasPlata);
          medallasBronce = MedallasBronce(medallasBronce);

          puntajeFinal[i] =
            (int) ((medallasOro * 3) + (medallasPlata * 2) + medallasBronce);

          if (puntajeFinal[i] > mejor) {
            mejor = puntajeFinal[i];
            puntajeString[i] = nombrePais;
          }
          i++;
        }
        break;
      case 2:
        //IMPRIMIR PUNTAJE TOTAL

        while (i <= cantidadPaises) {
          System.out.println(
            "La puntacion de " +
            i +
            ": " +
            nombrePais[i] +
            " es " +
            puntajeFinal[i]
          );
        }
        break;
      case 3:
        //IMPRIMIR PAIS CON MAS MEDALLAS DE PLATA
        break;
      case 4:
        //IMPRIMIR PROMEDIO MEDALLAS DE BRONCE
        break;
      case 5:
        //IMPRIMRIR MEDALLERO INFORMATIVO
        System.out.println("La cantidad de medallas de Oro: " + medallasOro);
        System.out.println(
          "La cantidad de medallas de Plata: " + medallasPlata
        );
        System.out.println(
          "La cantidad de medallas de Bronce: " + medallasBronce
        );
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

  // FUNCIONES
  private static int MedallasBronce(int medallasBronce) throws IOException {
    System.out.println("Ingrese la cantidad de medallas de Bronce");
    int bronceActual = Integer.parseInt(in.readLine());
    medallasBronce += bronceActual;
    return medallasBronce;
  }

  private static int MedallasPlata(int medallasPlata) throws IOException {
    System.out.println("Ingrese la cantidad de medallas de Plata");
    int plataActual = Integer.parseInt(in.readLine());
    medallasPlata += plataActual;
    return medallasPlata;
  }

  private static int MedallasOro(int medallasOro) throws IOException {
    System.out.println("Ingrese la cantidad de medallas de Oro");
    int oroActual = Integer.parseInt(in.readLine());
    medallasOro += oroActual;
    return medallasOro;
  }

  static int leerRangosEnteros(int inferior, int superior) {
    int resultado = 0;

    do {
      resultado = leerEntero();
      if (resultado < inferior || resultado > superior) {
        out.println(
          String.format(
            "Valor fuera del rango válido [%d - %d]",
            inferior,
            superior
          )
        );
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
