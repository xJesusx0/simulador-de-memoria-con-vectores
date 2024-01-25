package tareavectormemoria;

import java.util.Scanner;
import static tareavectormemoria.TareaVectorMemoria.posicionInicialEnMemoria;

public class Metodos {
    public static void imprimirVector(int[] vector) {
        String resultado = "";
        for (int i = 0; i < vector.length; i++) {
            resultado += (vector[i] + "\t");
        }
        System.out.println(resultado);
    }
    
    public static int[] rellenarVector(int cantidadFilas,int cantidadColumnas,int[] vector){
        for (int i = 0; i < cantidadFilas; i++) {
            for (int j = 0; j < cantidadColumnas; j++) {
                vector[posicionInicialEnMemoria + cantidadColumnas * i + j] = inputInt("Ingrese el valor en la fila: " + i + " columna: " + j);
            }
        }
        return vector;
    }
    
    public static int obtenerElemento(int i,int j,int cantidadColumnas,int[]vector){
        return vector[posicionInicialEnMemoria + cantidadColumnas*i+j];
    }
    
    public static void mostrarError(String mensaje){
        System.out.println("Error: " + mensaje);
    }  
    public static String input(String mensaje){ 
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
    public static int inputInt(String mensaje){
        while(true){
        String entrada = input(mensaje);
        
            try {
                return Integer.parseInt(entrada);
                
            } catch (NumberFormatException e) {
                mostrarError("Entrada invalida, intenelo denuevo");

            }
        }
    }
    public static double inputDouble(String mensaje){
        while(true){
        String entrada = input(mensaje);
        
            try {
                return Double.parseDouble(entrada);
                
            } catch (NumberFormatException e) {
                mostrarError("Entrada invalida, intentelo denuevo");

            }
        }
    }
    public static byte inputByte(String mensaje){
        while(true){
        String entrada = input(mensaje);
        
            try {
                return Byte.valueOf(entrada);
                
            } catch (NumberFormatException e) {
                mostrarError("Entrada invalida, intentelo denuevo");

            }
        }
    }
    
    public static int sumatoriaColumna(int j, int cantidadFilas,int cantidadColumnas,int[]vector){
        int sumatoria = 0;
        for (int i = 0 ; i < cantidadFilas ; i++){
            sumatoria += obtenerElemento(i, j, cantidadColumnas, vector);
        }
        return sumatoria;
    }
    
    public static void menu(){
        System.out.println("-------------");
        System.out.println("0 - Salir");
        System.out.println("1 - Rellenar matriz");
        System.out.println("2 - Mostrar memoria");
        System.out.println("3 - Mostrar matriz");
        System.out.println("4 - Identificar la columna que mas suma");
    }
    
    public static void imprimirMatriz(int[] vector,int cantidadFilas,int cantidadColumnas){
       String men = "";
        for (int i = 0; i < cantidadFilas; i++) {
            for (int j = 0; j < cantidadColumnas; j++) {
                men += (obtenerElemento(i, j, cantidadColumnas, vector)+ "\t"); 
            }
            men += "\n";
        }
         System.out.println(men);
    }
}
