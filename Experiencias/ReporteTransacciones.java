package Package;

import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReporteTransacciones {
	public void generarReporte(CuentaBancaria cuenta, boolean tieneTransacciones) throws HistorialVacioException, IOException{
		if(!tieneTransacciones) {
			throw new HistorialVacioException("Error: la cuenta no tiene transacciones.");
		}
		String nombreArchivo = "Reporte_" + cuenta.getTitular();
		try(PrintWriter out = new PrintWriter(nombreArchivo)){
			out.println("===REPORTE DE LAS TRANSACCIONES===");
			out.println("Titular: " + cuenta.getTitular());
			out.println("Saldo final: " + cuenta.getSaldo());
			System.out.println("Reporte guardado exitosamente en el archivo: " + nombreArchivo);
		}
	}
	
	public void leerReporte(String nombreArchivo) throws FileNotFoundException{
		File inFile = new File(nombreArchivo);
		try(Scanner in = new Scanner(inFile)){
			System.out.println("\n Leyendo archivo....");
			while(in.hasNextLine()) {
				System.out.println(in.nextLine());
	}
	
		}
	}
}
