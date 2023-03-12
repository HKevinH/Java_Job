import java.util.Random;
import java.util.Scanner;

public class GameofLife 
{
	static int fila, columna, numerodemundos; 
	public static int[][] GenerandoMundo(int filas, int columnas)
	{
		// Se declara la matriz
		int mundo[][] = new int[filas][columnas];
		Random rd = new Random();
		for (int i = 0; i < filas; i++)
		{
			for (int j = 0; j < columnas; j++)
			{
				mundo[i][j] = rd.nextInt(2);
			}
		}
		return mundo;
		
	}
	
    private static void mostrarMundo(int[][] mundo) {
        for (int[] fila : mundo) {
            for (int celula : fila) {
                System.out.print("|"+ celula + "|");
            }
            System.out.println();
        }
    }
    
    private static boolean estaViva(int[][] mundo, int fila, int columna) {
        int vecinosVivos = 0;
        int inicioFila = Math.max(0, fila - 1);
        int finFila = Math.min(mundo.length - 1, fila + 1);
        int inicioColumna = Math.max(0, columna - 1);
        int finColumna = Math.min(mundo[0].length - 1, columna + 1);
        
        for (int i = inicioFila; i <= finFila; i++) {
            for (int j = inicioColumna; j <= finColumna; j++) {
                if (i == fila && j == columna) {
                    continue;
                }

                vecinosVivos += mundo[i][j];
            }
        }

        if (mundo[fila][columna] == 1) {
            return vecinosVivos == 2 || vecinosVivos == 3;
        } else {
            return vecinosVivos == 3;
        }
    }
    
    private static int[][] calcularSiguienteGeneracion(int[][] mundo) {
        int siguienteGeneracion[][] = new int[mundo.length][mundo[0].length];

        for (int i = 0; i < mundo.length; i++) {
            for (int j = 0; j < mundo[0].length; j++) {
                siguienteGeneracion[i][j] = estaViva(mundo, i, j) ? 1 : 0;
            }
        }

        return siguienteGeneracion;
    }
    
    public static void main(String[] args) {
    	Scanner sd = new Scanner(System.in);
    	int opcion = 0;
    	//Hare dos bucles un for para manejar las veces que quiera generar generacion y otro para las 
    	System.out.println(" _____________________");
    	System.out.println(" |JUEGO DE LA VIDA!!!!|");
        System.out.println(" _____________________\n");
    	System.out.println(" |    OPCIONES	  |");
    	System.out.println(" |PRESIONA EL NUMERO DE LA OPCION QUE DESEES|");
    	System.out.println(" |1|GENERAR MUNDOS HASTA QUE LA CELULA MUERA|");
    	System.out.println(" |2|GENERAR UNA CANTIDAD EXACTA DE MUNDOS|");
    	System.out.println(" |SELECIONA UNA OPCION VALIDA:|");
    	
    	opcion = sd.nextInt();
        
    	switch(opcion)
    	{
    	case 1:
        	System.out.println("\nIngresa El Numero de Filas:");
        	fila = sd.nextInt();
        	System.out.println("\nIngresa El Numero de Columnas:");
        	columna = sd.nextInt();
        	int [][]mundoUsado = GenerandoMundo(fila, columna);
        	while(true || opcion == 1)
        	{
        		mostrarMundo(mundoUsado);
                System.out.println("Presione Enter para avanzar a la siguiente generacion.");
                sd.nextLine();
                
                int[][] siguienteGeneracion = calcularSiguienteGeneracion(mundoUsado);
                mundoUsado = siguienteGeneracion;
        	}
    		break;
    	case 2:
        	System.out.println("\nIngresa El Numero de Filas:");
        	fila = sd.nextInt();
        	System.out.println("\nIngresa El Numero de Columnas:");
        	columna = sd.nextInt();
        	System.out.println("Ingresa El Numero de Mundos:");
        	int [][]mundoUsadoo = GenerandoMundo(fila, columna);
        	
        	numerodemundos = sd.nextInt();
        	int contador = 0;
            for (int i = 0; i < numerodemundos; i++) {
            	contador++;
                System.out.println("Mundo #" + contador);
                mostrarMundo(mundoUsadoo);
                System.out.println("Presione Enter para avanzar a la siguiente generacion.");
                sd.nextLine();
                int[][] siguienteGeneracion = calcularSiguienteGeneracion(mundoUsadoo);
                mundoUsado = siguienteGeneracion;
            }
        	System.out.println("Termina El Ciclo");
            break;
    	}
      }
}
