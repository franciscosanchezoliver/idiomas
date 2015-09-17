import java.io.*;
import java.util.*;

public class PreguntaRespuesta {

	Map<String, String> entrevista = new HashMap<>();

	public void cargarPreguntas(String archivoEntrada){
		String cadena;
		StringTokenizer tokenizer=null;
		BufferedReader in = null;
		String pregunta = "", respuesta= "";
		
		try{
			in = new BufferedReader(new FileReader(archivoEntrada));
		    while((cadena = in.readLine()) != null){
		    	tokenizer = new StringTokenizer(cadena, "-");
		    	pregunta = tokenizer.nextToken();
		    	respuesta = tokenizer.nextToken();
		    	this.entrevista.put(pregunta, respuesta);
		    }
		    in.close();
		}catch (IOException e){
			System.out.println(e);
		}
	} //Fin cargarPreguntas
	
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
			fichero.write(nuevaPregResp[0] + "-" + nuevaPregResp[1] + "\n");
			fichero.close();
		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	} //Fin escribirNuevaFrase
	
} // Fin clase