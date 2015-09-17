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
	
} // Fin clase