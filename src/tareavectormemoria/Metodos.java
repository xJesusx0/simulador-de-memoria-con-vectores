package tareavectormemoria;

import java.util.Scanner;
import static tareavectormemoria.TareaVectorMemoria.posicionInicialEnMemoria;

public class Metodos {

    public static void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }

    public static String input(String mensaje) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println(mensaje);
            String UserInput = input.nextLine();

            if (!UserInput.trim().isEmpty()) {
                return UserInput;

            } else {
                mostrarError("La entrada esta vacia, intentelo denuevo");
            }
        }
    }

    public static int inputIntPositivo(String mensaje) {
        while (true) {
            String entrada = input(mensaje);

            try {
                int numero = Integer.parseInt(entrada);

                if (numero > 0) {
                    return numero;
                } else {
                    mostrarError("Ingrese un número mayor a 0, inténtelo de nuevo");
                }

            } catch (NumberFormatException e) {
                mostrarError("Entrada inválida, inténtelo de nuevo");
            }
        }
    }

    public static int inputInt(String mensaje) {
        while (true) {
            String entrada = input(mensaje);

            try {
                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {
                mostrarError("Entrada invalida, intenelo denuevo");

            }
        }
    }

    public static double inputDouble(String mensaje) {
        while (true) {
            String entrada = input(mensaje);

            try {
                return Double.parseDouble(entrada);

            } catch (NumberFormatException e) {
                mostrarError("Entrada invalida, intentelo denuevo");

            }
        }
    }

    public static byte inputByte(String mensaje) {
        while (true) {
            String entrada = input(mensaje);
            try {
                return Byte.valueOf(entrada);

            } catch (NumberFormatException e) {
                mostrarError("Entrada invalida, intentelo denuevo");
            }
        }
    }

    public static void imprimirVector(int[] vector) {
        String resultado = "";
        for (int i = 0; i < vector.length; i++) {
            resultado += (vector[i] + "\t");
        }
        System.out.println(resultado);
    }

    public static int[] rellenarVector(int[] vector, int cantidadFilas, int cantidadColumnas) {
        for (int i = 0; i < cantidadFilas; i++) {
            for (int j = 0; j < cantidadColumnas; j++) {
                vector[posicionInicialEnMemoria + cantidadColumnas * i + j] = inputInt("Ingrese el valor en la fila: " + i + " columna: " + j);
            }
        }
        return vector;
    }

    public static int obtenerElemento(int[] vector, int i, int j, int cantidadColumnas) {
        return vector[posicionInicialEnMemoria + cantidadColumnas * i + j];
    }

    public static int sumatoriaColumna(int[] vector, int j, int cantidadFilas, int cantidadColumnas) {
        int sumatoria = 0;
        for (int i = 0; i < cantidadFilas; i++) {
            sumatoria += obtenerElemento(vector, i, j, cantidadColumnas);
        }
        return sumatoria;
    }

    public static void menu() {
        System.out.println("-------------");
        System.out.println("0 - Salir");
        System.out.println("1 - Rellenar matriz");
        System.out.println("2 - Mostrar vector");
        System.out.println("3 - Mostrar matriz");
        System.out.println("4 - Ver todas las sumatorias");
        System.out.println("5 - Ver la sumatoria mayor");
        System.out.println("6 - Ver la sumatoria menor");
        System.out.println("7 - Seleccionar 2 elementos de la matriz y compararlos");
    }

    public static void imprimirMatriz(int[] vector, int cantidadFilas, int cantidadColumnas) {
        String men = "";
        for (int i = 0; i < cantidadFilas; i++) {
            for (int j = 0; j < cantidadColumnas; j++) {
                men += (obtenerElemento(vector, i, j, cantidadColumnas) + "\t");
            }
            men += "\n";
        }
        System.out.println(men);
    }

    public static int[] obtenerSumatorias(int[] vector, int cantidadFilas, int cantidadColumnas) {
        int sumatorias[] = new int[cantidadColumnas];
        for (int j = 0; j < cantidadColumnas; j++) {
            sumatorias[j] = sumatoriaColumna(vector, j, cantidadFilas, cantidadColumnas);

        }
        return sumatorias;
    }

    public static int[] obtenerMayor(int[] vector) {
        int mayor = vector[0];
        int indice = 0;
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] > mayor) {
                indice = i;
                mayor = vector[i];
            }
        }
        int datos[] = {mayor, indice};
        return datos;
    }

    public static int[] obtenerMenor(int[] vector) {
        int menor = vector[0];
        int indice = 0;
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < menor) {
                indice = i;
                menor = vector[i];
            }
        }
        int datos[] = {menor, indice};
        return datos;
    }
}
