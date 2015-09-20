import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Ventana extends JFrame{

	private JFrame ventanaForm;
	private PreguntaRespuesta pregResp = new PreguntaRespuesta();
	File fichero = null;

	/**
	 * Create the application.
	 */
	public Ventana() {
		super();
		initialize();
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
		JPanel pesta�a3 = new JPanel();
		JPanel pestana4 = new JPanel();

		pesta�a1.setLayout(null); //Que me deje poner los componentes donde desee
		pesta�a2.setLayout(null);
		pesta�a3.setLayout(null);
		pestana4.setLayout(null);
 
		//--------------------------------------------------------
		JTextPane rutaArchivo = new JTextPane();
		rutaArchivo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		rutaArchivo.setEditable(false);
		JScrollPane scrollRutaArchivo = new JScrollPane(rutaArchivo, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollRutaArchivo.setSize(351, 48);
		scrollRutaArchivo.setLocation(21, 25);
//		pesta�a1.add(rutaArchivo);
		pesta�a1.add(scrollRutaArchivo);
		
		//--------------------------------------------------------
        JButton btnSeleccionar = new JButton("Seleccionar...");
        btnSeleccionar.setBounds(382, 25, 107, 48);
        pesta�a1.add(btnSeleccionar);
        btnSeleccionar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		
        		JFileChooser fc=new JFileChooser(); //Creamos el objeto JFileChooser
        		
        		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); //Indicamos lo que podemos seleccionar
        		 
        		//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
        		int seleccion = fc.showOpenDialog(pesta�a1);
        		 
        		//Si el usuario, pincha en aceptar
        		if(seleccion==JFileChooser.APPROVE_OPTION){
        		 
        		//Seleccionamos el fichero
        		fichero=fc.getSelectedFile();
        		pregResp.cargarPreguntas(fichero.getPath());
        		rutaArchivo.setText(fichero.getPath());

        		panelDePesta�as.addTab("PRACTICAR", null, pesta�a2, null);
        		panelDePesta�as.addTab("INSERTAR FRASE", null, pesta�a3, null);
        		panelDePesta�as.addTab("INFORMACION", null, pestana4, null);
        		
        		}
        	}
        });
		
		//----------------------------------------------
		JTextPane textoRespuesta = new JTextPane();
		textoRespuesta.setText("RESPUESTA EN INGLES");
		textoRespuesta.setEditable(false);
		textoRespuesta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		textoRespuesta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textoRespuesta.setBounds(10, 146, 498, 69);
//		ventanaForm.getContentPane().add(textoRespuesta);
		pesta�a2.add(textoRespuesta);
		
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
		pesta�a2.add(botonEscuchar);
				
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
		pesta�a2.add(botonTraducir);
		
		//---------------------------------------------
		JTextPane textoPregunta = new JTextPane();
		textoPregunta.setText("PREGUNTA EN ESPA�OL");
		textoPregunta.setEditable(false);
		textoPregunta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textoPregunta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		textoPregunta.setBounds(10, 11, 498, 69);
//		ventanaForm.getContentPane().add(textoPregunta);
		pesta�a2.add(textoPregunta);

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
		pesta�a2.add(botonNext);
		
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
		pesta�a3.add(barraLateralTxtEspa�ol);
		
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
		pesta�a3.add(barraLateralTxtIngles);
		
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
					pregResp.escribirNuevaFrase(vector, fichero.getPath());
//					pregResp.cargarPreguntas(directorioEntrada);
					JOptionPane.showMessageDialog(null,	"Insertado correctamente");
					insertarTxtEnIngles.setText("");
					insertarTxtEnEspa�ol.setText("");
				}
			}
		});
		botonGuardar.setBounds(199, 208, 116, 41);
		pesta�a3.add(botonGuardar);

		//--------------------------------------------
		JTextPane textoInformacion = new JTextPane();
		textoInformacion.setEditable(false);
		textoInformacion.setText("Realizado por:\n-> Francisco Sanchez Oliver\n-> Natalia Paula Calabria Rodr�guez");
		textoInformacion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		textoInformacion.setBounds(10, 11, 498, 78);
		textoInformacion.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pestana4.add(textoInformacion);
		
		//--------------------------------------------
		JTextPane textRecordatorio = new JTextPane();
		textRecordatorio.setEditable(false);
		textRecordatorio.setText(recordatorio());
		textRecordatorio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		textRecordatorio.setBounds(21, 84, 468, 180);
		pesta�a1.add(textRecordatorio);
		
		//-------------------------------------------
		panelDePesta�as.addTab("ABRIR ARCHIVO", null, pesta�a1, null);
		
	} //Fin initialize()
	
	
	private String recordatorio() {
		return "Recuerda:\n" + "-> 1. El archivo tiene que ser .txt\n" + 
					"-> 2. No debe tener saltos de l�nea en blanco ni al final del archivo ni al principio.\n" + 
					"-> 3. El formato es:\n(Frase en espa�ol) - (Frase en ingl�s)\nEs importante el gui�n entre las frases.\n" +
					"\t\t�QUE LO DISFRUTES!";
	}

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