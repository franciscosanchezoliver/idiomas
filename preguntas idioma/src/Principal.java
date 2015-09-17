import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Principal {

	private static String directorioEntrada = System.getProperty("user.dir") + File.separator + "src"
						+ File.separator + "PregResp";

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreguntaRespuesta preguntaRespuesta = new PreguntaRespuesta();
		preguntaRespuesta.cargarPreguntas(directorioEntrada);
		preguntaRespuesta.getSiguientePregunta();
	}

}
