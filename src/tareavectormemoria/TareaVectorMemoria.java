package tareavectormemoria;

import static tareavectormemoria.Metodos.*;

public class TareaVectorMemoria {
    public static int posicionInicialEnMemoria;
    
    public static void main(String[] args) {

        posicionInicialEnMemoria = 0;
        boolean vectorRellenado = false;
        
        int cantidadFilas = inputInt("Ingrese la cantidad de filas");
        int cantidadColumnas = inputInt("Ingrese la cantidad de columnas");

        int vectorMemoria[] = new int[posicionInicialEnMemoria + cantidadFilas * cantidadColumnas];

        while (true) {
            menu();
            byte eleccion = inputByte("Ingrese la opcion que desea elegir");
            System.out.println("-------------");
            switch (eleccion) {
                case 0:
                    break;
                    
                case 1:
                    if(!vectorRellenado){
                        vectorMemoria = rellenarVector(cantidadFilas, cantidadColumnas,  vectorMemoria);
                        vectorRellenado = true;
                    } else {
                        mostrarError("El vector ya ha sido rellenado");
                    }
                   break;
                   
                default:
                    System.out.println("Opción no válida");               
            }
            System.out.println("-------------");
            if(eleccion == 0 ){
                break;
            }
            imprimirVector(vectorMemoria);
            System.out.println(sumatoriaColumna(0,  cantidadFilas, cantidadColumnas, vectorMemoria));

        }

    }
}
