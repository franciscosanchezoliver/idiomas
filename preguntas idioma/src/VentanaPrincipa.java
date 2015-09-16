import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextPane;


public class VentanaPrincipa {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipa window = new VentanaPrincipa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipa() {
		initialize();
		mostrarPregunta();
		
	}

	private void mostrarPregunta() {
		// TODO Auto-generated method stub
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
						System.out.println(preguntaRespuesta.getRespuestas().get(valor));
						scan.nextLine();
					
					} catch (Exception e) {
						System.out.println("Francisco le come el chichi a Natalia");
					}
				}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(35, 21, 362, 69);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(160, 101, 89, 23);
		frame.getContentPane().add(btnCheck);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(35, 154, 362, 57);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(308, 227, 89, 23);
		frame.getContentPane().add(btnNext);
	}
}
