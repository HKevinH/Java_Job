/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gameoflife;
import java.util.Random;
/**
 *
 * @author Kevin Lopez
 */
public class GameofLife {

    final static int FILL = 12;
    final static int COLL = 12;
    final static int GENERACION = 1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Declarar e inicializar el mundo en la generación 0
        int[][] mundo0 = generarMundoAleatorio(FILL, COLL);
        imprimirMundo(mundo0);

        // Obtener el mundo en la generación 1 aplicando las reglas del juego
        int[][] mundo1 = siguienteGeneracion(mundo0);
        imprimirMundo(mundo1);
    
    }
    

    public static int[][] generarMundoAleatorio(int filas, int columnas) {
        int[][] mundo = new int[filas][columnas];
        Random random = new Random();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                mundo[i][j] = random.nextInt(2);
            }
        }

        return mundo;
    }
    
        public static int[][] siguienteGeneracion(int[][] mundo) {
        int filas = mundo.length;
        int columnas = mundo[0].length;
        int[][] nuevoMundo = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int vecinos = contarVecinosVivos(mundo, i, j);

                if (mundo[i][j] == 1 && (vecinos == 2 || vecinos == 3)) {
                    nuevoMundo[i][j] = 1;
                } else if (mundo[i][j] == 0 && vecinos == 3) {
                    nuevoMundo[i][j] = 1;
                }
            }
        }

        return nuevoMundo;
    }

    public static int contarVecinosVivos(int[][] mundo, int fila, int columna) {
        int filas = mundo.length;
        int columnas = mundo[0].length;
        int contador = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int filaVecino = fila + i;
                int columnaVecino = columna + j;

                // Verificar que la celda vecina no esté fuera de los límites del mundo
                if (filaVecino >= 0 && filaVecino < filas && columnaVecino >= 0 && columnaVecino < columnas) {
                    // Verificar que la celda vecina no sea la celda actual
                    if (i != 0 || j != 0) {
                        contador += mundo[filaVecino][columnaVecino];
                    }
                }
            }
        }

        return contador;
    }
 
    public static void imprimirMundo(int[][] mundo) {
        System.out.println("Generacion " + GENERACION + ":");
        for (int i = 0; i < mundo.length; i++) {
            for (int j = 0; j < mundo[0].length; j++) {
                if (mundo[i][j] == 1) {
                    System.out.print("| 1 |");
                } else {
                    System.out.print("| 0 |");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
