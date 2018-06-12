package Paquete;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Pelota extends JPanel implements Runnable{

	int x= getWidth()/2;
	Thread pelota;
	public Pelota() {
		super();
		pelota = new Thread(this);
		pelota.start();
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(Color.BLACK);
		g.drawOval(x, getHeight()/2, 30, 30);
	}

	@Override
	public void run() {
		try {
			while(true) {
				System.out.print("");
				while(x<getWidth()-40) {
					Thread.sleep(10);
					x = x + 10;
					repaint();
				}
				while(x>0) {
					Thread.sleep(10);
					x = x - 10;
					repaint();
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
