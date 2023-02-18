/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package triqui;
import java.util.Scanner;
/**
 *
 * @author Kevin Lopez
 */
public class Triqui {
    
    // Declaramos Variables Stacticas y tipo de datos
    static final byte TABLERO = 3, NUM_JUGADORES = 2, GANADOR = 1;
    static final char tablero[][]= new char[3][3], MARCA_O = 'O', MARCA_X = 'X';
    static final char MARCA_VACIA = ' ';
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Clase Main
        Scanner teclado = new Scanner(System.in);
        boolean Gano = false, ganador = false;
        //La Funcion
        int a, b;
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║                                      ║");
        System.out.println("║    Bienvenido al juego de Triqui     ║");
        System.out.println("║                                      ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        printLmTablero(tablero);
        while(Gano == false)
        {
                System.out.println("Jugada X");
                System.out.println("Introduce La Fila Numero: ");
                a = teclado.nextInt();
                System.out.println("Introduce La Columna Numero: ");
                b = teclado.nextInt();
                if (a < 0 || a > 3 || b < 0 || b > 3)
                {
                    System.out.println("Error, Filas o Colummnas estan fuera del rango Verifica Fila " + a + " Columna " + b);
                }
                tablero[a-1][b-1] = MARCA_X;
                   
                //Tablero
                printTablero(tablero);
        
                if(VerificarSiHayGanador(tablero, MARCA_X))
                {
                    System.out.println("El Ganador Es " + MARCA_X);
                    Gano = true;
                    break;
                }
            

                // Jugador 2do
                System.out.println("Jugador O");
                System.out.println("Introduce La Fila Numero: ");
                a = teclado.nextInt();
                System.out.println("Introduce La Columna Numero: ");
                b = teclado.nextInt();

                if (tablero[a-1][b-1] == MARCA_X) {
                   
                   System.out.println("Esta casilla ya esta marcada, por favor elige otra.");     
               }
                    //Tablero
                    tablero[a-1][b-1] = MARCA_O;
                    printTablero(tablero);
                    
                    if(VerificarSiHayGanador(tablero, MARCA_O))
                    {
                    System.out.println("El Ganador Es " + MARCA_O);
                    Gano = true;
                    break;
                    }
        }
                System.out.println("Se rompe El Ciclo");
        if( Gano == false)
        {
            System.out.println("Hubo Empate");
        }
    }
    
    private static void printLmTablero(char[][] tablero)
    {
        int a, b;
        for( a = 0; a < TABLERO; a++)
        {
            for(b = 0; b < TABLERO; b ++)
            {
                tablero[a][b] = MARCA_VACIA;
            }
        }
    }   

    private static void printTablero(char tablero[][]) 
    {
        int a = 0, b = 0;
    for (a = 0; a < TABLERO; a++) {
        System.out.println("-------------");
        System.out.print("|");
        for (b = 0; b < TABLERO; b++) {
            System.out.print(" " + tablero[a][b] + " |");
        }
        System.out.println();
    }
    System.out.println("-------------");
    }

    private static boolean VerificarSiHayGanador(char[][] tablero, char MARCA_X) 
    {
        int a;
        boolean sa = false;
        //Ganador por Columna
        for (a = 0; a < TABLERO; a++) {
        if (tablero[0][a] == MARCA_X && tablero[1][a] == MARCA_X && tablero[2][a] == MARCA_X) {
            sa = true;
        }
        //Ganador Por Fila
        else if (tablero[a][0] == MARCA_X && tablero[a][1] == MARCA_X && tablero[a][2] == MARCA_X) {
            sa = true;
        }
         //Verificar Por Diagonal
        else if (tablero[0][0] == MARCA_X && tablero[1][1] == MARCA_X && tablero[2][2] == MARCA_X) {
            sa = true;
        }
        
        else if (tablero[0][2] == MARCA_X && tablero[1][1] == MARCA_X && tablero[2][0] == MARCA_X) {
            sa = true;
        }
    }
        return sa;
    }
}
