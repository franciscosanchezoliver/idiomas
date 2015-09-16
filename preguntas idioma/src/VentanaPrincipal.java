import java.awt.*;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{

	public VentanaPrincipal(){
		super("Programa principal");
		
		setLayout(new FlowLayout());
		Button botonSiguiente = new Button("Next");
		
		add(botonSiguiente);
		
		setSize(400,300);
		setVisible(true);
		
	}
	
	public static void main(String[]args){
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
	}
}
