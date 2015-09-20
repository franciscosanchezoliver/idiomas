import java.io.*;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PreguntaRespuesta {

	Map<String, String> entrevista = new HashMap<>();

	public void cargarPreguntas(String archivoEntrada) {

		Scanner entrada = new Scanner(System.in);
		String cadena;
		// StringTokenizer tokenizer=null;
		// BufferedReader in = null;
		String pregunta = "", respuesta = "";

		try {
			Scanner s = new Scanner(new File(archivoEntrada));
			while (s.hasNextLine()) {
				String line = s.nextLine();
				String[] items = line.split("-");
				if (!items[0].trim().equals("") && !items[1].trim().equals("")) {
					pregunta = items[0];
					respuesta = items[1];
					this.entrevista.put(pregunta, respuesta);
				}
			}
			s.close();
		} catch (IOException e) {
			System.out.println("El error es el siguiente: " + e);
		}
	} // Fin cargarPreguntas
	
	public String[] getSiguientePregunta(){
		String[] vector = new String [2];
		
		// Get a random entry from the HashMap.
		Object[] maptoArray = this.entrevista.keySet().toArray();
		Object key = maptoArray[new Random().nextInt(maptoArray.length)];
		vector[0]= (String) key;
		vector[1]= this.entrevista.get(key);
		return vector;
	} //Fin getSiguientePregunta
	
	public void escribirNuevaFrase (String[]nuevaPregResp, String directorioEntrada){
		FileWriter fichero = null;
		try {
			fichero = new FileWriter(new File(directorioEntrada), true);
			fichero.write("\n" + nuevaPregResp[0] + "-" + nuevaPregResp[1]);
			fichero.close();
		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	} //Fin escribirNuevaFrase
	
} // Fin clase