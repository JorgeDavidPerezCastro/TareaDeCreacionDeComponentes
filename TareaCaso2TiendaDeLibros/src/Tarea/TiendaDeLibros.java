package Tarea;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class TiendaDeLibros extends JFrame{
	
	private PanelOpciones panelOpciones;
	private static PanelDetalleDelCatalogo panelDetalleDelCatalogo;
	private PanelDetalleDelCarritoDeCompras panelDetalleDelCarritoDeCompras;
	
	public TiendaDeLibros() throws Exception{
		
		setTitle("TiendaLibros");
		setSize(500,400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		panelOpciones = new PanelOpciones();
		add(panelOpciones,BorderLayout.NORTH);
		
		panelDetalleDelCatalogo = new PanelDetalleDelCatalogo();
		add(panelDetalleDelCatalogo,BorderLayout.CENTER);
		
		panelDetalleDelCarritoDeCompras = new PanelDetalleDelCarritoDeCompras();
		add(panelDetalleDelCarritoDeCompras,BorderLayout.SOUTH);
	}
	
	public class PanelOpciones extends JPanel implements ActionListener{		
		private JButton AdicionarBoton = new JButton("Adicionar libro");
		private JButton Opcion1 = new JButton("Opción 1");
		private JButton Opcion2 = new JButton("Opción 2");
		
		PanelOpciones(){
			setLayout(new GridLayout(1,3));
			setPreferredSize(new Dimension(0,20));
			
			add(AdicionarBoton);
			add(Opcion1);
			add(Opcion2);
			
			AdicionarBoton.setActionCommand("Adicionar");
			AdicionarBoton.addActionListener(this);
			
			Opcion1.setActionCommand("Opcion1");
			Opcion1.addActionListener(this);
			
			Opcion2.setActionCommand("Opcion2");
			Opcion2.addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			if(comando.equals("Adicionar")) {
				JOptionPane.showMessageDialog(this, "Adicionando libro", "Adicion del libro", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(comando.equals("Opcion1")) {
				JOptionPane.showMessageDialog(this, "Agregando Opción 1", "Opción 1", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(comando.equals("Opcion2")) {
				JOptionPane.showMessageDialog(this, "Agregando Opción 2", "Opción 2", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	public class PanelDetalleDelCatalogo extends JPanel implements ActionListener{

		PanelDetalleDelCatalogo(){
			setPreferredSize(new Dimension(0,300));
			TitledBorder borde = BorderFactory.createTitledBorder("Detalle del catálogo");
			borde.setTitleColor(Color.BLACK);
			setBorder(borde);
			
			DefaultTableModel dtm = new DefaultTableModel();
			
			Object[] columna1 = {"123-876-653","345-980-343","908-654-873","243-865-443","887-765-343"};
			dtm.addColumn("ISBN", columna1);
			
			String[] columna2= {"Algoritmica y Programación","Algoritmica y Programación","El Lenguaje UML","Usando JUnit","Programación en C#"};
			dtm.addColumn("Titulo",columna2);
			
			String[] columna3= {"$ 57 000,00","$ 75 000,00","$ 43 500,00","$ 63 092,00","$ 65 432,00"};
			dtm.addColumn("Precio",columna3);
			
			final JTable table = new JTable(dtm);
			
			table.setPreferredScrollableViewportSize(new Dimension(50, 100));
			JScrollPane scrollPane = new JScrollPane(table);
			setLayout(new BorderLayout());
			
			
			
			
			Container contenedorcantidad = new Container();
			contenedorcantidad.setLayout(new GridBagLayout());
			GridBagConstraints restricciones = new GridBagConstraints();
			
			JLabel cantidad = new JLabel("Cantidad");
			restricciones.gridx = 2;
			restricciones.gridy = 0;
			contenedorcantidad.add(cantidad,restricciones);
			
			JTextField cantidadcampo = new JTextField("3");
			restricciones.gridx = 2;
			restricciones.gridy = 1;
			restricciones.gridwidth = 2;
			restricciones.gridheight = 2;
			restricciones.ipadx = 100;
			restricciones.ipady = 1;
			contenedorcantidad.add(cantidadcampo, restricciones);
			
			JButton comprar = new JButton("Comprar");
			restricciones.gridx = 4;
			restricciones.gridy = 1;
			restricciones.gridwidth = 0;
			restricciones.gridheight = 0;
			restricciones.ipadx = 0;
			restricciones.ipady = 0;
			comprar.setActionCommand("Comprar");
			comprar.addActionListener(this);
			
			restricciones.insets.set (10,0,10,0);
			contenedorcantidad.add(comprar, restricciones);
			
			add(scrollPane,BorderLayout.NORTH);
			add(contenedorcantidad);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			
			if(comando.equals("Comprar")) {
				JOptionPane.showMessageDialog(this,"Comprando","Compra de libros",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	public class PanelDetalleDelCarritoDeCompras extends JPanel implements ActionListener{
		
		PanelDetalleDelCarritoDeCompras(){
			setPreferredSize(new Dimension(0,120));
			TitledBorder borde = BorderFactory.createTitledBorder("Detalle del carrito de compras");
			borde.setTitleColor(Color.BLACK);
			setBorder(borde);
			
			DefaultTableModel dtm = new DefaultTableModel();
			
			Object[] columna1 = {"908-654-873"};
			dtm.addColumn("ISBN", columna1);
			
			String[] columna2= {"El Lenguaje UML"};
			dtm.addColumn("Titulo",columna2);
			
			Object[] columna3= {new Integer(3)};
			dtm.addColumn("Cantidad",columna3);
			
			String[] columna4= {"$ 130 500,00"};
			dtm.addColumn("Subtotal", columna4);
			
			final JTable table = new JTable(dtm);
			
			table.setPreferredScrollableViewportSize(new Dimension(50, 50));
			JScrollPane scrollPane = new JScrollPane(table);
			setLayout(new BorderLayout());
			
			
			Container contenedortotal = new Container();
			contenedortotal.setLayout(new GridBagLayout());
			GridBagConstraints restricciones = new GridBagConstraints();
			
			JButton borrar = new JButton("Borrar");
			restricciones.gridx = 1;
			restricciones.gridy = 0;
			restricciones.ipadx = 100;
			restricciones.ipady = 0;
			restricciones.insets.set (0,0,0,130);
			contenedortotal.add(borrar,restricciones);
			
			JLabel total = new JLabel("Total");
			restricciones.gridx = 2;
			restricciones.gridy = 0;
			restricciones.ipadx = 0;
			restricciones.ipady = 0;
			restricciones.insets.set (0,0,0,0);
			contenedortotal.add(total,restricciones);
			
			JTextField totalnumeros = new JTextField("$ 130 500,00");
			totalnumeros.setEditable(false);
			restricciones.gridx = 3;
			restricciones.gridy = 0;
			restricciones.ipadx = 150;
			restricciones.ipady = 0;
			restricciones.insets.set (0,0,0,0);
			contenedortotal.add(totalnumeros,restricciones);
			
			add(scrollPane,BorderLayout.NORTH);
			add(contenedortotal,BorderLayout.CENTER);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

	public static void main(String[] args) throws Exception {
		TiendaDeLibros ventana = new TiendaDeLibros();
		ventana.setVisible(true);

	}

}
