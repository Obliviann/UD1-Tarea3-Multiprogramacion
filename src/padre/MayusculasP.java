package padre;

import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class MayusculasP {
	public static void main(String args[]) throws IOException {
		
		//1. creamos un proceso hijo a través de su jar ejecutable
		ProcessBuilder pb = new ProcessBuilder("java", "-jar", "./lib/Mayusuclas.jar");
		Process p = pb.start();//lanza un IOException
		
		//2. el padre lee líneas de su entrada estándar (Scanner)
		String stdinPadre = new Scanner(System.in).nextLine(); 
		
		//3. CONECTAMOS EL PADRE AL HIJO, y almacenamos los chars del stoud del hijo
		BufferedReader brHijo = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		//2.1 enviamos el flujo de su stadin al stdin del hijo (utilizando el OutputStream del hijo)
		PrintWriter pwHijo = new PrintWriter(p.getOutputStream());
	
		while  (!stdinPadre.contentEquals("fin")) {
			//4. el padre imprime en pantalla lo que recibe del hijo a través de su inputStream
			pwHijo.println(stdinPadre);
			//vaciamos el buffer de salida escribiendo su contenido
			pwHijo.flush();
			//imprimimos los números aleatorios que genera el hijo
			System.out.println("mayus: "+brHijo.readLine());
			stdinPadre = new Scanner(System.in).nextLine();
		}
	}

}
