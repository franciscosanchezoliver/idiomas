import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.io.File;
import java.util.HashMap;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Ventana {

	private JFrame frame;
	private HashMap componentMap;
	private PreguntaRespuesta pregResp = new PreguntaRespuesta();
	
	
	private String directorioEntrada = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "PregResp";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
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
	public Ventana() {
		initialize();
		createComponentMap();
		JLabel labelPregunta =  (JLabel) getComponentByName("labelPregunta");
		labelPregunta.setText("La Bar-Ba-Coa");
		this.pregResp.cargarPreguntas(this.directorioEntrada);
	}

	/**
	 * 
	 * Metodo: Crea el hashMap que contiene los componentes de la ventana
	 */
	private void createComponentMap() {
	       componentMap = new HashMap<String,Component>();
	        Component[] components = frame.getContentPane().getComponents();
	        
	        for (int i=0; i < components.length; i++) {
	                componentMap.put(components[i].getName(), components[i]);
	        }
	}
	
	/**
	 * 
	 * Metodo: recupera un componente en concreto
	 * @param Nombre del componente
	 * @return
	 */
	public Component getComponentByName(String name) {
        if (componentMap.containsKey(name)) {
                return (Component) componentMap.get(name);
        }
        else return null;
}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLabelPregunta = new JLabel("New label");
		lblLabelPregunta.setName("labelPregunta");
		lblLabelPregunta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblLabelPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabelPregunta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblLabelPregunta.setBounds(10, 11, 414, 76);
		frame.getContentPane().add(lblLabelPregunta);
		
		JLabel lblLabelRespuesta = new JLabel("New label");
		lblLabelRespuesta.setName("labelRespuesta");
		lblLabelRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabelRespuesta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblLabelRespuesta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblLabelRespuesta.setBounds(10, 163, 414, 76);
		frame.getContentPane().add(lblLabelRespuesta);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblLabelRespuesta.setVisible(true);
			}
		});
		btnNewButton.setName("botonCheck");
		btnNewButton.setBounds(94, 99, 99, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String vector[] = pregResp.getSiguientePregunta();
				lblLabelPregunta.setText(vector[0]);
				lblLabelRespuesta.setText(vector[1]);
				lblLabelRespuesta.setVisible(false);
			}

		});
		btnNewButton_1.setName("botonNext");
		btnNewButton_1.setBounds(225, 98, 99, 38);
		frame.getContentPane().add(btnNewButton_1);
	}
}
