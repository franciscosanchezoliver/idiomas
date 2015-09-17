import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Ventana {

	private JFrame frame;
	private HashMap componentMap;

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
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setName("labelRespuesta");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel_1.setBounds(10, 163, 414, 76);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.setName("botonCheck");
		btnNewButton.setBounds(94, 99, 99, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cargarSiguientePregunta();
			}

			private void cargarSiguientePregunta() {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_1.setName("botonNext");
		btnNewButton_1.setBounds(225, 98, 99, 38);
		frame.getContentPane().add(btnNewButton_1);
	}
}
