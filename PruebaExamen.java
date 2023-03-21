package mockExamen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PruebaExamen {
	public static void main(String [] args) {
		leerFichero();
		
	}
	private static void leerFichero() {
		File titanic = new File(".\\src\\mockExamen\\titanic.csv");
		int numHombres = 0;
		int numMujeres = 0;
		int numHFallecidos = 0;
		int numMFallecidas = 0;
		try {
			Scanner reader = new Scanner(titanic);
			reader.nextLine();
			while(reader.hasNextLine()) {
				String datos[] = reader.nextLine().split(",");
				if(datos[5].equals("male")) {
					numHombres++;
					if(datos[1].equals("0")) {
						numHFallecidos++;
					}
				}
				else {
					numMujeres++;
					if(datos[1].equals("0")) {
						numMFallecidas++;
					}
				}
				
				
			}
			mostrarDatos(numHombres, numMujeres, numHFallecidos, numMFallecidas);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void mostrarDatos(int numH, int numM, int numHF, int numMF) {
		System.out.println("Numero de personas: "+(numH + numM)+"\nNumero de hombres: "
				+numH+"\nNumero de hombres fallecidos: "+numHF+"\nNumero de mujeres: "
				+numM+"\nNumero de mujeres fallecidas: "+numMF+"\nPorcentaje de"
						+ " hombres fallecidos: "+(numHF*100/numH)+"%\nPorcentaje de"
								+ " mujeres fallecidas: "+(numMF*100/numM)+"%");
	}
}
