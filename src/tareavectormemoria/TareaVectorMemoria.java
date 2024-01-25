package tareavectormemoria;

import static tareavectormemoria.Metodos.*;

public class TareaVectorMemoria {
    public static int posicionInicialEnMemoria = 0;
    
    public static void main(String[] args) {

        boolean vectorRellenado = false;
        
        
        int cantidadFilas = inputTamaño("Ingrese la cantidad de filas");
        
        int cantidadColumnas = inputTamaño("Ingrese la cantidad de columnas");

        int vectorMemoria[] = new int[posicionInicialEnMemoria + cantidadFilas * cantidadColumnas];

        while (true) {
            menu();
            byte eleccion = inputByte("Ingrese la opcion que desea elegir");
            System.out.println("-------------");
            switch (eleccion) {
                case 0 -> {
                    
                }
                    
                case 1 -> {
                    if(!vectorRellenado){
                        vectorMemoria = rellenarVector(vectorMemoria,cantidadFilas, cantidadColumnas);
                        vectorRellenado = true;
                    } else {
                        mostrarError("El vector ya ha sido rellenado");
                    }
                }
                case 2 -> {
                    imprimirVector(vectorMemoria);
                }
                case 3 -> {
                    imprimirMatriz(vectorMemoria,cantidadFilas,cantidadColumnas);
                }
                case 4 ->{
                    if(vectorRellenado){
                        int[] sumatorias = obtenerSumatorias(vectorMemoria, cantidadFilas, cantidadColumnas);
                        imprimirVector(sumatorias);
                    } else {
                        mostrarError("El vector no ha sido rellenado");
                    }
                }
                case 5 ->{
                    if(vectorRellenado){
                        int[] sumatorias = obtenerSumatorias(vectorMemoria, cantidadFilas, cantidadColumnas);
                        //El resultado es un vector que contiene el elemento mayor y su indice
                        int resultado[] = obtenerMayor(sumatorias);
                        int elementoMayor = resultado[0];
                        int indice = resultado[1];
                        System.out.println("La sumatoria mayor fue de " + elementoMayor + " en la posicion " + indice);
                    } else {
                        mostrarError("El vector no ha sido rellenado");
                                       }
                }
                case 6 ->{
                    if(vectorRellenado){
                        int[] sumatorias = obtenerSumatorias(vectorMemoria, cantidadFilas, cantidadColumnas);
                        //El resultado es un vector que contiene el elemento mayor y su indice
                        int resultado[] = obtenerMenor(sumatorias);
                        int elementoMenor = resultado[0];
                        int indice = resultado[1];
                        System.out.println("La sumatoria menor fue de " + elementoMenor + " en la posicion " + indice);
                    } else {
                        mostrarError("El vector no ha sido rellenado");
                                       }
                }
                case 7 ->{
                    imprimirMatriz(vectorMemoria,cantidadFilas,cantidadColumnas);
                    System.out.println("--- Primer elemento ---");
                    int i1 = inputIntPositivo("Ingrese la posicion de la fila del primer elemento");
                    int j1 = inputIntPositivo("Ingrese la posicion de la columna del primer elemento");
                    
                    System.out.println("--- Segundo elemento ---");
                    int i2 = inputIntPositivo("Ingrese la posicion de la fila del segundo elemento");
                    int j2 = inputIntPositivo("Ingrese la posicion de la columna del segundo elemento");
                    
                    int elemento1 = obtenerElemento(vectorMemoria, i1, j1, cantidadColumnas);
                    int elemento2 = obtenerElemento(vectorMemoria, i2, j2, cantidadColumnas);
                 
                    comparar(elemento1,elemento2);
                }
                default -> System.out.println("Opción no válida");               
            }
                        
            if(eleccion == 0 ){
                break;
            }

        }
    }
}
