package Problema1;
import java.awt.Container;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Problema1 extends JFrame implements ActionListener{
	private JTextField velocidadcampo; 
	private JTextField distanciacampo;
	private JTextField tiempocampo;
	
	public int getvelocidadcampo(){
		return Integer.parseInt(velocidadcampo.getText());
	}
	
	public int getdistanciacampo(){
		return Integer.parseInt(distanciacampo.getText());
	}
	
	public int gettiempocampo(){
		return Integer.parseInt(tiempocampo.getText());
	}
	
	public Problema1(){
		super("Ventana problema 1");
		Container contenedorprincipal = this.getContentPane();
		contenedorprincipal.setLayout(new GridBagLayout());
		GridBagConstraints restricciones = new GridBagConstraints();
		
		JLabel informacion1txt = new JLabel("Para calcular el valor de Velocidad, Distancia y Tiempo. ");
		restricciones.gridx = 0;
		restricciones.gridy = 0;
		contenedorprincipal.add(informacion1txt,restricciones);
		
		JLabel informacion2txt = new JLabel("Deja vacio el cuadro del respectivo valor. ");
		restricciones.gridx = 1;
		restricciones.gridy = 0;
		contenedorprincipal.add(informacion2txt,restricciones);
		
		JLabel velocidadtxt = new JLabel("Velocidad: ");
		restricciones.gridx = 0;
		restricciones.gridy = 1;
		contenedorprincipal.add(velocidadtxt,restricciones);
		
		velocidadcampo = new JTextField();
		restricciones.gridx = 1;
		restricciones.gridy = 1;
		restricciones.ipadx = 200;
		restricciones.ipady = 10;
		contenedorprincipal.add(velocidadcampo,restricciones);
		
		JLabel distanciatxt = new JLabel("Distancia: ");
		restricciones.gridx = 0;
		restricciones.gridy = 2;
		restricciones.ipadx = 0;
		restricciones.ipady = 0;
		contenedorprincipal.add(distanciatxt,restricciones);
		
		distanciacampo = new JTextField();
		restricciones.gridx = 1;
		restricciones.gridy = 2;
		restricciones.ipadx = 200;
		restricciones.ipady = 10;
		contenedorprincipal.add(distanciacampo,restricciones);
		
		JLabel tiempotxt = new JLabel("Tiempo: ");
		restricciones.gridx = 0;
		restricciones.gridy = 3;
		restricciones.ipadx = 0;
		restricciones.ipady = 0;
		contenedorprincipal.add(tiempotxt,restricciones);
		
		tiempocampo = new JTextField();
		restricciones.gridx = 1;
		restricciones.gridy = 3;
		restricciones.ipadx = 200;
		restricciones.ipady = 10;
		contenedorprincipal.add(tiempocampo,restricciones);
		
		JButton calcular = new JButton("Calcular");
		restricciones.gridx = 1;
		restricciones.gridy = 4;
		restricciones.ipadx = 120;
		restricciones.ipady = 0;
		contenedorprincipal.add(calcular,restricciones);
		calcular.setActionCommand("Calculando");
		calcular.addActionListener(this);
		
		
		
	}
	
	public static void main(String[] args) {
		Problema1 ventana = new Problema1();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		boolean velocidadboolean = false;
		boolean distanciaboolean = false;
		boolean tiempoboolean = false;
		
		if (comando.equals("Calculando")){
			if(velocidadcampo.getText().contains("")){
				velocidadboolean = true;
			}
			if(distanciacampo.getText().contains("")){
				distanciaboolean = true;
			}
			if(tiempocampo.getText().contains("")){
				tiempoboolean = true;
			}
			
			if(velocidadboolean == true){
				double distancia = getdistanciacampo();
				double tiempo = gettiempocampo();
				double resultado = (distancia/tiempo);
				JOptionPane.showMessageDialog(this,"El resultado cuando no se conoce velocidad es: " + resultado, "Examen problema 1", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(distanciaboolean == true){
				double velocidad = getvelocidadcampo();
				double distancia = getdistanciacampo();
				double resultado = distancia/velocidad;
				JOptionPane.showMessageDialog(this, "El resultado cuando no se conoce tiempo es: " + resultado, "Examen problema 1", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(tiempoboolean == true){
				double velocidad = getvelocidadcampo();
				double tiempo = gettiempocampo();
				double resultado = velocidad*tiempo;
				JOptionPane.showMessageDialog(this, "El resultado cuando no se conoce distancia es: " + resultado, "Examen problema 1", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
	}

}
