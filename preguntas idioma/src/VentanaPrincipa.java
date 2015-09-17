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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaPrincipa {

	private JFrame frame;
	JLabel labelPreg = null;
	JLabel labelResp = null;
	
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelPregunta = new JLabel("PREGUNTA EN ESPAÑOL");
		labelPregunta.setBounds(35, 21, 362, 69);
		frame.getContentPane().add(labelPregunta);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("Hola");
			}
		});
		btnCheck.setBounds(160, 101, 89, 23);
		frame.getContentPane().add(btnCheck);
		
		JLabel labelRespuesta = new JLabel("RESPUESTA EN INGLÉS");
		labelRespuesta.setBounds(35, 154, 362, 57);
		frame.getContentPane().add(labelRespuesta);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(308, 227, 89, 23);
		frame.getContentPane().add(btnNext);
	}
}
