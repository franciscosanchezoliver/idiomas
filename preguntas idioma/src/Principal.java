import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//asdasdfasdfsadf
		
		PreguntaRespuesta preguntaRespuesta = new PreguntaRespuesta();
		preguntaRespuesta.cargarPreguntas();
		preguntaRespuesta.cargarRespuestas();

		while (true == true) {
			Random r1 = new Random();
			int valor = r1.nextInt(preguntaRespuesta.getPreguntas().size());
			System.out.println(valor);

			System.out.print("-" + preguntaRespuesta.getPreguntas().get(valor));
			try {
				Scanner scan = new Scanner(System.in);
				scan.nextLine();
				System.out
						.println(preguntaRespuesta.getRespuestas().get(valor));
				scan.nextLine();

			} catch (Exception e) {
			}

		}
	}

}
