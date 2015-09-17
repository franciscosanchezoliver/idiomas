import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.io.File;

public class Ventana extends JFrame{

	private JFrame ventanaForm;
	private PreguntaRespuesta pregResp = new PreguntaRespuesta();

	private String directorioEntrada = System.getProperty("user.dir")
			+ File.separator + "src" + File.separator + "PregResp";

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
	}

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
				
		//---------------------------------------------
		JTabbedPane panelDePestaņas = new JTabbedPane(JTabbedPane.TOP);
		panelDePestaņas.setBounds(0, -1, 523, 314);
		ventanaForm.getContentPane().add(panelDePestaņas);
		
		JPanel pestaņa1 = new JPanel(); 
		JPanel pestaņa2 = new JPanel(); 
		pestaņa1.setLayout(null);
		
		//----------------------------------------------
		JTextPane textoRespuesta = new JTextPane();
		textoRespuesta.setText("RESPUESTA EN INGLES");
		textoRespuesta.setEditable(false);
		textoRespuesta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		textoRespuesta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textoRespuesta.setBounds(10, 146, 498, 69);
//		ventanaForm.getContentPane().add(textoRespuesta);
		pestaņa1.add(textoRespuesta);
		
		//----------------------------------------------
		JButton botonTraducir = new JButton("Traducir");
		botonTraducir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textoRespuesta.setVisible(true);
			}
		});
		botonTraducir.setBounds(206, 91, 94, 44);
//		ventanaForm.getContentPane().add(botonTraducir);
		pestaņa1.add(botonTraducir);
		
		//---------------------------------------------
		JTextPane textoPregunta = new JTextPane();
		textoPregunta.setText("PREGUNTA EN ESPAŅOL");
		textoPregunta.setEditable(false);
		textoPregunta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textoPregunta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		textoPregunta.setBounds(10, 11, 498, 69);
//		ventanaForm.getContentPane().add(textoPregunta);
		pestaņa1.add(textoPregunta);

		//----------------------------------------------
		JButton botonNext = new JButton("Next");
		botonNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String vector[] = pregResp.getSiguientePregunta();
				textoPregunta.setText(vector[0]);
				textoRespuesta.setText(vector[1]);
				textoRespuesta.setVisible(false);
			}
		});
		botonNext.setBounds(430, 238, 78, 37);
//		ventanaForm.getContentPane().add(botonNext);
		pestaņa1.add(botonNext);
		
		//---------------------------------------------
		panelDePestaņas.addTab("PRACTICAR", null, pestaņa1, null);
		panelDePestaņas.addTab("INSERTAR FRASE", null, pestaņa2, null);

	} //Fin initialize()
} //Fin clase