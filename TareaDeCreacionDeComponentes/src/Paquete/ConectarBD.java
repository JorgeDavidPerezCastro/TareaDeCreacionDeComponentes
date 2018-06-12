package Paquete;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConectarBD implements java.io.Serializable{
	private Connection con;
	private Statement st;
	
	
	public ConectarBD(){
		try {
			//Se utiliza mysql-connector-java-8.0.11.jar
			Class.forName("com.mysql.cj.jdbc.Driver");
			setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/circulocompas?useTimezone=true&serverTimezone=UTC","root",""));
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e.getStackTrace());
		}	
	}

	public Connection getCon() {
		return con;
	}
	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	public Statement getSt() {
		return st;
	}
	
	public void setSt(Statement st) {
		this.st = st;
	}
	
	public void insert(String cadenaCentro, double radio) {
		try {
			Statement st = getSt();
			st = getCon().createStatement();
			st.execute("INSERT INTO circulo (fecha, hora, centro, radio) VALUES (CURDATE(), CURTIME(),'"+cadenaCentro+"',"+radio+")");
			creacionDeTabla();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Hubo un problema");
			}
	}
	
	public JTable creacionDeTabla(){
		JScrollPane scroll = new JScrollPane();
		JTable tabla = new JTable();
		try {
		Statement st1 =  getCon().createStatement();
		ResultSet rs = (ResultSet) st1.executeQuery("SELECT * FROM circulo");
		String[] columnas = {"fecha","hora","centro","radio"};
		String fecha, hora, centro, radio;
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(columnas);
		tabla.setModel(modelo);
		while(rs.next()) {
			fecha = rs.getString("fecha");
			hora = rs.getString("hora");
			centro = rs.getString("centro");
			radio = rs.getString("radio");
			modelo.addRow(new Object[] {fecha,hora,centro,radio});
		}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return tabla;
	}
}
