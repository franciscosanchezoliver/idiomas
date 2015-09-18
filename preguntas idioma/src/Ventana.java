import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.io.File;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Ventana extends JFrame{

	private JFrame ventanaForm;
	private PreguntaRespuesta pregResp = new PreguntaRespuesta();

	private String directorioEntrada = System.getProperty("user.dir")
			+ File.separator + "src" + File.separator + "PregResp";


	/**
	 * Create the application.
	 */
	public Ventana() {
		super();
		initialize();
		this.pregResp.cargarPreguntas(this.directorioEntrada);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//---------------------------------------------
		ventanaForm = new JFrame();
		ventanaForm.setResizable(false);
		ventanaForm.setTitle("PROGRAMILLA GUAY");
		ventanaForm.setBounds(100, 100, 529, 342);
		ventanaForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaForm.getContentPane().setLayout(null);
		paintComponents(getGraphics());
				
		//---------------------------------------------
		JTabbedPane panelDePesta�as = new JTabbedPane(JTabbedPane.TOP);
		panelDePesta�as.setBounds(0, 0, 523, 314);
		ventanaForm.getContentPane().add(panelDePesta�as);
		
		JPanel pesta�a1 = new JPanel(); 
		JPanel pesta�a2 = new JPanel(); 
		
		pesta�a1.setLayout(null); //Que me deje poner los componentes donde desee
		pesta�a2.setLayout(null);
		
		//----------------------------------------------
		JTextPane textoRespuesta = new JTextPane();
		textoRespuesta.setText("RESPUESTA EN INGLES");
		textoRespuesta.setEditable(false);
		textoRespuesta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		textoRespuesta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textoRespuesta.setBounds(10, 146, 498, 69);
//		ventanaForm.getContentPane().add(textoRespuesta);
		pesta�a1.add(textoRespuesta);
		
		//---------------------------------------------	
		JButton botonEscuchar = new JButton(new ImageIcon("src/altavoz2.png"));
		botonEscuchar.setVisible(false);
		botonEscuchar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					FreeTTS freeTTS = new FreeTTS(textoRespuesta.getText());
					freeTTS.speak();
			}
		});
		botonEscuchar.setBounds(379, 238, 41, 37);
		pesta�a1.add(botonEscuchar);
				
		//----------------------------------------------
		JButton botonTraducir = new JButton("Traducir");
		botonTraducir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textoRespuesta.setVisible(true);
				botonEscuchar.setVisible(true);
			}
		});
		botonTraducir.setBounds(206, 91, 94, 44);
//		ventanaForm.getContentPane().add(botonTraducir);
		pesta�a1.add(botonTraducir);
		
		//---------------------------------------------
		JTextPane textoPregunta = new JTextPane();
		textoPregunta.setText("PREGUNTA EN ESPA�OL");
		textoPregunta.setEditable(false);
		textoPregunta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textoPregunta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		textoPregunta.setBounds(10, 11, 498, 69);
//		ventanaForm.getContentPane().add(textoPregunta);
		pesta�a1.add(textoPregunta);

		//----------------------------------------------
		JButton botonNext = new JButton("Next");
		botonNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String vector[] = pregResp.getSiguientePregunta();
				textoPregunta.setText(vector[0]);
				textoRespuesta.setText(vector[1]);
				textoRespuesta.setVisible(false);
				botonEscuchar.setVisible(false);
			}
		});
		botonNext.setBounds(430, 238, 78, 37);
//		ventanaForm.getContentPane().add(botonNext);
		pesta�a1.add(botonNext);
		
		//---------------------------------------------
		JTextArea insertarTxtEnEspa�ol = new JTextArea();
		insertarTxtEnEspa�ol.setLineWrap(true);
		JScrollPane barraLateralTxtEspa�ol = new JScrollPane(insertarTxtEnEspa�ol, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		barraLateralTxtEspa�ol.setSize(498, 76);
		barraLateralTxtEspa�ol.setLocation(10, 11);
		insertarTxtEnEspa�ol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insertarTxtEnEspa�ol.setText("");
			}
		});
		insertarTxtEnEspa�ol.setText("Escriba el texto en espa�ol");
		insertarTxtEnEspa�ol.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		insertarTxtEnEspa�ol.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		pesta�a2.add(barraLateralTxtEspa�ol);
		
		//---------------------------------------------
		JTextArea insertarTxtEnIngles = new JTextArea();
		insertarTxtEnIngles.setLineWrap(true);
		JScrollPane barraLateralTxtIngles = new JScrollPane(insertarTxtEnIngles,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		barraLateralTxtIngles.setSize(498, 76);
		barraLateralTxtIngles.setLocation(10, 107);
		
		insertarTxtEnIngles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insertarTxtEnIngles.setText("");
			}
		});
		insertarTxtEnIngles.setText("Escriba la traduccion al ingles");
		insertarTxtEnIngles.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		insertarTxtEnIngles.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		pesta�a2.add(barraLateralTxtIngles);
		
		//--------------------------------------------
		JButton botonGuardar = new JButton("GUARDAR");
		botonGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String[] vector = new String[2];
				vector[0] = insertarTxtEnEspa�ol.getText();
				vector[1] = insertarTxtEnIngles.getText();

				if (vector[0].equals("") || vector[1].equals("")) {
					JOptionPane.showMessageDialog(null,	"Escriba una frase y su traducci�n, por favor.");
					insertarTxtEnEspa�ol.setText("Escriba el texto en espa�ol");
					insertarTxtEnIngles.setText("Escriba la traduccion al ingles");
				} else {
					pregResp.escribirNuevaFrase(vector, directorioEntrada);
					pregResp.cargarPreguntas(directorioEntrada);
					JOptionPane.showMessageDialog(null,	"Insertado correctamente");
					insertarTxtEnIngles.setText("");
					insertarTxtEnEspa�ol.setText("");
				}
			}
		});
		botonGuardar.setBounds(199, 208, 116, 41);
		pesta�a2.add(botonGuardar);

		//--------------------------------------------
		panelDePesta�as.addTab("PRACTICAR", null, pesta�a1, null);
		panelDePesta�as.addTab("INSERTAR FRASE", null, pesta�a2, null);
		
	} //Fin initialize()
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.ventanaForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} //Fin main
} //Fin clase