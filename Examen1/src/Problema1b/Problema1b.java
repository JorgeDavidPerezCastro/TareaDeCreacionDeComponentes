package Problema1b;
import java.awt.Container;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Problema1.Problema1;
public class Problema1b extends JFrame implements ActionListener {
	
	public JTextField velocidadcuadro;
	public JTextField distanciacuadro;
	public JTextField tiempocuadro;
	private int contador = 0;
	
	public double getvelocidadcuadro(){
		return Integer.parseInt(velocidadcuadro.getText());
	}
	
	public double getdistanciacuadro(){
		return Integer.parseInt(distanciacuadro.getText());
	}
	
	public double gettiempocuadro(){
		return Integer.parseInt(tiempocuadro.getText());
	}
	
	private JRadioButton velocidadcampo;
	private JRadioButton distanciacampo;
	private JRadioButton tiempocampo;
	
	 public Problema1b(){
		 super("Ventana problema 1");
			Container contenedorprincipal = this.getContentPane();
			contenedorprincipal.setLayout(new GridBagLayout());
			GridBagConstraints restricciones = new GridBagConstraints();
			
			JLabel velocidadtxt = new JLabel("Elige una de las opciones: ");
			restricciones.gridx = 0;
			restricciones.gridy = 0;
			contenedorprincipal.add(velocidadtxt,restricciones);
			
			JPanel contenedorbotones = new JPanel();
			contenedorbotones.setLayout(new GridLayout(0,1));
			
			velocidadcampo = new JRadioButton("Calcular velocidad");
			velocidadcampo.setMnemonic(KeyEvent.VK_B);
			velocidadcampo.setActionCommand("velocidad");

			distanciacampo = new JRadioButton("Calcular distancia");
			distanciacampo.setMnemonic(KeyEvent.VK_C);
			distanciacampo.setActionCommand("distancia");
			
			tiempocampo = new JRadioButton("Calcular tiempo");
			tiempocampo.setMnemonic(KeyEvent.VK_D);
			tiempocampo.setActionCommand("tiempo");
			
			ButtonGroup opciones = new ButtonGroup();
			opciones.add(velocidadcampo);
			opciones.add(distanciacampo);
			opciones.add(tiempocampo);
			
			contenedorbotones.add(velocidadcampo);
			contenedorbotones.add(distanciacampo);
			contenedorbotones.add(tiempocampo);
			
			restricciones.gridx = 1;
			restricciones.gridy = 0;
			restricciones.ipadx = 0;
			restricciones.ipady = 150;
			
			contenedorprincipal.add(contenedorbotones,restricciones);
			
			JButton aceptar = new JButton("Aceptar");
			restricciones.gridx = 1;
			restricciones.gridy = 1;
			restricciones.ipadx = 100;
			restricciones.ipady = 0;
			contenedorprincipal.add(aceptar,restricciones);
			aceptar.setActionCommand("Aceptar");
			aceptar.addActionListener(this);

	}

	public static void main(String[] args) {
		Problema1b ventana = new Problema1b();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(velocidadcampo.isSelected() && contador == 0) {
			contador = contador + 1;
			Container contenedorvelocidad = new Container();
			contenedorvelocidad.setLayout(new GridBagLayout());
			GridBagConstraints restriccionesvelocidad = new GridBagConstraints();
			
			JLabel distanciatxt = new JLabel("Distancia: ");
			restriccionesvelocidad.gridx = 0;
			restriccionesvelocidad.gridy = 0;
			restriccionesvelocidad.ipadx = 0;
			restriccionesvelocidad.ipady = 0;
			contenedorvelocidad.add(distanciatxt,restriccionesvelocidad);
			
			distanciacuadro = new JTextField();
			restriccionesvelocidad.gridx = 1;
			restriccionesvelocidad.gridy = 0;
			restriccionesvelocidad.ipadx = 200;
			restriccionesvelocidad.ipady = 10;
			contenedorvelocidad.add(distanciacuadro,restriccionesvelocidad);
			
			JLabel tiempotxt = new JLabel("Tiempo: ");
			restriccionesvelocidad.gridx = 0;
			restriccionesvelocidad.gridy = 1;
			restriccionesvelocidad.ipadx = 0;
			restriccionesvelocidad.ipady = 0;
			contenedorvelocidad.add(tiempotxt,restriccionesvelocidad);
			
			tiempocuadro = new JTextField();
			restriccionesvelocidad.gridx = 1;
			restriccionesvelocidad.gridy = 1;
			restriccionesvelocidad.ipadx = 200;
			restriccionesvelocidad.ipady = 10;
			contenedorvelocidad.add(tiempocuadro,restriccionesvelocidad);
			
			JButton calcular = new JButton("Calcular");
			restriccionesvelocidad.gridx = 1;
			restriccionesvelocidad.gridy = 3;
			restriccionesvelocidad.ipadx = 100;
			restriccionesvelocidad.ipady = 0;
			contenedorvelocidad.add(calcular,restriccionesvelocidad);
			calcular.setActionCommand("Calculandovelocidad");
			calcular.addActionListener(this);
			
			JOptionPane.showMessageDialog(this,contenedorvelocidad,"Calcular velocidad",JOptionPane.INFORMATION_MESSAGE);
		}
		if(distanciacampo.isSelected() && contador == 0) {
			contador = contador + 1;
			Container contenedordistancia = new Container();
			contenedordistancia.setLayout(new GridBagLayout());
			GridBagConstraints restriccionesdistancia = new GridBagConstraints();
			
			JLabel tiempotxt = new JLabel("Tiempo: ");
			restriccionesdistancia.gridx = 0;
			restriccionesdistancia.gridy = 0;
			restriccionesdistancia.ipadx = 0;
			restriccionesdistancia.ipady = 0;
			contenedordistancia.add(tiempotxt,restriccionesdistancia);
			
			tiempocuadro = new JTextField();
			restriccionesdistancia.gridx = 1;
			restriccionesdistancia.gridy = 0;
			restriccionesdistancia.ipadx = 200;
			restriccionesdistancia.ipady = 10;
			contenedordistancia.add(tiempocuadro,restriccionesdistancia);
			
			JLabel velocidadtxt = new JLabel("Velocidad: ");
			restriccionesdistancia.gridx = 0;
			restriccionesdistancia.gridy = 1;
			restriccionesdistancia.ipadx = 0;
			restriccionesdistancia.ipady = 0;
			contenedordistancia.add(velocidadtxt,restriccionesdistancia);
			
			velocidadcuadro = new JTextField();
			restriccionesdistancia.gridx = 1;
			restriccionesdistancia.gridy = 1;
			restriccionesdistancia.ipadx = 200;
			restriccionesdistancia.ipady = 10;
			contenedordistancia.add(velocidadcuadro,restriccionesdistancia);
			
			JButton calcular = new JButton("Calcular");
			restriccionesdistancia.gridx = 1;
			restriccionesdistancia.gridy = 3;
			restriccionesdistancia.ipadx = 100;
			restriccionesdistancia.ipady = 0;
			contenedordistancia.add(calcular,restriccionesdistancia);
			calcular.setActionCommand("Calculandodistancia");
			calcular.addActionListener(this);
			
			JOptionPane.showMessageDialog(this,contenedordistancia,"Calcular tiempo",JOptionPane.INFORMATION_MESSAGE);
		}
		if(tiempocampo.isSelected() && contador == 0) {
			contador = contador + 1;
			Container contenedortiempo = new Container();
			contenedortiempo.setLayout(new GridBagLayout());
			GridBagConstraints restriccionestiempo = new GridBagConstraints();
			
			JLabel distanciatxt = new JLabel("Distancia: ");
			restriccionestiempo.gridx = 0;
			restriccionestiempo.gridy = 0;
			restriccionestiempo.ipadx = 0;
			restriccionestiempo.ipady = 0;
			contenedortiempo.add(distanciatxt,restriccionestiempo);
			
			distanciacuadro = new JTextField();
			restriccionestiempo.gridx = 1;
			restriccionestiempo.gridy = 0;
			restriccionestiempo.ipadx = 200;
			restriccionestiempo.ipady = 10;
			contenedortiempo.add(distanciacuadro,restriccionestiempo);
			
			JLabel velocidadtxt = new JLabel("Velocidad: ");
			restriccionestiempo.gridx = 0;
			restriccionestiempo.gridy = 1;
			restriccionestiempo.ipadx = 0;
			restriccionestiempo.ipady = 0;
			contenedortiempo.add(velocidadtxt,restriccionestiempo);
			
			velocidadcuadro = new JTextField();
			restriccionestiempo.gridx = 1;
			restriccionestiempo.gridy = 1;
			restriccionestiempo.ipadx = 200;
			restriccionestiempo.ipady = 10;
			contenedortiempo.add(velocidadcuadro,restriccionestiempo);
			
			JButton calcular = new JButton("Calcular");
			restriccionestiempo.gridx = 1;
			restriccionestiempo.gridy = 3;
			restriccionestiempo.ipadx = 100;
			restriccionestiempo.ipady = 0;
			contenedortiempo.add(calcular,restriccionestiempo);
			calcular.setActionCommand("Calculandotiempo");
			calcular.addActionListener(this);
			
			JOptionPane.showMessageDialog(this,contenedortiempo,"Calcular tiempo",JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(comando.equals("Calculandovelocidad")) {
			try {
			double distancia = getdistanciacuadro();
			double tiempo = gettiempocuadro();
			double resultado = distancia/tiempo;
			JOptionPane.showMessageDialog(this, "El resultado es: " + resultado, "Resultado",JOptionPane.INFORMATION_MESSAGE);
			dispose();
			}
			catch(Exception i) {
				JOptionPane.showMessageDialog(this, "Ingrese valores","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(comando.equals("Calculandotiempo")) {
			try {
			double velocidad = getvelocidadcuadro();
			double distancia = getdistanciacuadro();
			double resultado = distancia/velocidad;
			JOptionPane.showMessageDialog(this, "El resultado es: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			}
			catch(Exception i) {
				JOptionPane.showMessageDialog(this, "Ingrese valores","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(comando.equals("Calculandodistancia")) {
			try {
				double velocidad = getvelocidadcuadro();
				double tiempo = gettiempocuadro();
				double resultado = tiempo*velocidad;
				JOptionPane.showMessageDialog(this, "El resultado es: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
				dispose();
				}
				catch(Exception i) {
					JOptionPane.showMessageDialog(this, "Ingrese valores","ERROR",JOptionPane.ERROR_MESSAGE);
				}
		}
		
	}

}
