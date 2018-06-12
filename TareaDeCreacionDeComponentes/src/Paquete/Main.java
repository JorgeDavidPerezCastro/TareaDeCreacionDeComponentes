package Paquete;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

public class Main extends JFrame implements Serializable{
	
	public Main(){
		super("Compás");
		Container principal = getContentPane();
		principal.setLayout(new BorderLayout());
		
		Lienzo lienzo = new Lienzo();
		JPanel panelderecha = new JPanel();
		JButton actualizar = new JButton("Actualizar");
		ConectarBD con = new ConectarBD();
		
		Container derecha = new Container();
		derecha.setLayout(new GridLayout(0,1));
		
		JTable tabla = con.creacionDeTabla();
		JScrollPane scroll = new JScrollPane(tabla);
		
		Pelota hilo = new Pelota();
		
		panelderecha.add(scroll);
		derecha.add(panelderecha);
		derecha.add(hilo);
		
		principal.add(lienzo,BorderLayout.CENTER);
		principal.add(derecha,BorderLayout.EAST);

	}

	
	
	public static void main(String[] args) {
		Main ventana = new Main();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(new Dimension(1000,600));
		ventana.setResizable(false);
		ventana.setVisible(true);
		JOptionPane.showMessageDialog(null, "Apreta click izquierdo dentro del plano cartesiano para poner el punto central, acto seguido apreta click derecho sobre el plano cartesiano otra vez para crear el circulo tipo compás");
	}

}	
   


