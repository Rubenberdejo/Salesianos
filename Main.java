package titanic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ruta del fichero con el nombre");
		String ruta = entrada.nextLine();
		File fichero = new File (ruta);
		
		try {
			Scanner f = new Scanner(fichero);
			int contPasajeros = 0;
			int contMujeres = 0;
			int contHombres = 0;
			int contHombresMuertos = 0;
			int contMujeresMuertas = 0;
			
			while (f.hasNextLine()) {
				String pasajero = f.nextLine();
				String[] datos = pasajero.split(",");
				String superviviente = datos[1];
				String sexo = datos[5];
				
				if (contPasajeros != 0) {
					
					if (sexo.equals("female")) {
						contMujeres++;
						
						if (superviviente.equals("0")) {
							contMujeresMuertas++;
						}
					} else {
						contHombres++;
						
						if (superviviente.equals("0")) {
							contHombresMuertos++;
						}
					}
				}
				contPasajeros++;
			}
			f.close();
			
			double porcHombres = (contHombresMuertos * 100) / contHombres;
			double porcMujeres = (contMujeresMuertas * 100) / contMujeres;
			System.out.println("Número total de pasajeros del Titanic: " + (contPasajeros - 1));
			System.out.println("Número total de hombres: " + contHombres);
			System.out.println("Número total de mujeres: " + contMujeres);
			System.out.println("Número total de hombres muertos: " + contHombresMuertos);
			System.out.println("Número total de mujeres muertas: " + contMujeresMuertas);
			System.out.println("Porcentaje de hombres muertos: " + porcHombres + " %");
			System.out.println("Porcentaje de mujeres muertas: " + porcMujeres + " %");
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido leer el fichero");
			e.printStackTrace();
		}
	}
}
