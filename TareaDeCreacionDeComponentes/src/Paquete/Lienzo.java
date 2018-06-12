package Paquete;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.sql.Statement;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Lienzo extends JComponent{
	private int coordXOrig = 200;
	private int coordYOrig = 150;
	public int circuloX1;
	public int circuloY1;
	public int circuloX2 = 0;
	public int circuloY2 = 0;
	public boolean condicionSiApretoBoton = false;
	
	public void setCoordXOrig(int coordXOrig){
		this.coordXOrig = coordXOrig;
	}
	
	public void setCoordYOrig(int coordYOrig){
		this.coordYOrig = coordYOrig;
	}
	
	public Lienzo() {
		super();
		this.setPreferredSize(new Dimension(800,400));
		movimientoRaton oyenteRaton = new movimientoRaton();
		this.addMouseListener(oyenteRaton);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		coordXOrig = (int)((this.getWidth() )/2);
		coordYOrig = (int)((this.getHeight() )/2);
		
		g.setColor(Color.GREEN);
		
		g.drawLine(0, coordYOrig, this.getWidth()-1, coordYOrig);
		
		int XActual = coordXOrig;
		
		int numValores = (int)(coordXOrig/40) + 1;
		XActual = coordXOrig - numValores * 40;
		
		for(int valor = 0 - numValores;valor<=((this.getWidth() / 2)/40);valor++){
			
			g.drawLine(XActual , coordYOrig -5,XActual , coordYOrig + 5);
			
		
		    g.drawString("" + valor, XActual - 10, coordYOrig + 20);
			
			XActual += 40;
			
			}
		
		g.drawLine(coordXOrig, 0, coordXOrig, this.getHeight());
		
		
		int YActual = coordYOrig;
		
		numValores = (int)(coordYOrig/40)+1;
		YActual = coordYOrig - numValores *40;
		int contnumeros = 8;
		
		for(int valor = 0 - numValores;valor<=((this.getHeight() / 2)/40);valor++){
			
		g.drawLine(coordXOrig - 5 , YActual , coordXOrig + 5, YActual);
			
		g.drawString("" + contnumeros, coordXOrig + 10, YActual - 5);
			
		contnumeros -= 1;
		
		YActual += 40;
			
		}
		
		if(condicionSiApretoBoton == true) {
		graficarCirculo(g);
		}
	}
	
	public void graficarCirculo(Graphics g) {
		
		
		g.setColor(Color.RED);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		
		int largo = Math.abs(circuloX2 - circuloX1);
		int alto = Math.abs(circuloY2 - circuloY1);
		
		double radio = Math.sqrt(Math.pow(largo, 2)+Math.pow(alto,2));

		Ellipse2D.Double circulo = new Ellipse2D.Double(circuloX1 - radio, circuloY1 - radio, radio*2, radio*2);
		
		String cadenaCentro = "(" + circuloX1 + "," + circuloY1 + ")" ;
		
		ObjetosInteresados objeto1 = new ObjetosInteresados();
		Radio radioCirculo = new Radio();
		radioCirculo.addRadioListener(objeto1);
		radioCirculo.setRadio(radio);
		
		
		ConectarBD con = new ConectarBD();
		con.insert(cadenaCentro, radio);
		
		g2.draw(circulo);
		
	}
	
	public class movimientoRaton extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			if(SwingUtilities.isLeftMouseButton(e)) {
				circuloX1 = e.getX();
				circuloY1= e.getY();
				System.out.println(circuloX1 + "," + circuloY1);
				condicionSiApretoBoton = true;
				
			}
			if(SwingUtilities.isRightMouseButton(e)) {
				circuloX2 = e.getX();
				circuloY2 = e.getY();
				System.out.println(circuloX2 + "," + circuloY2);
				repaint();
			}
		}
		
	}

}
