package hijo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//el hijo leerá el texto por su entrada estándar (se lo manda el padre), 

public class Mayusculas {
											//thrown by the readLine()
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();

		//mientras lo que le mande el padre no esté vacío
		while(!s.equals("")) {
			//3. lo transformará y lo imprimirá por su salida estandar
			System.out.println(s.toUpperCase());
			s = br.readLine();
		}
	}
}
