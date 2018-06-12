package Paquete;

import java.util.EventListener;
import java.util.EventObject;
import java.util.Vector;

public class Radio {
	private Vector radioListeners = new Vector();
	private double radio;
	
	public Radio() {
		radio = 0;
	}
	
	public class RadioEvent extends EventObject{
		protected double anteRadio, nuevoRadio;
		public RadioEvent(Object fuente, double anteRadio, double nuevoRadio) {
			super(fuente);
			this.anteRadio = anteRadio;
			this.nuevoRadio = nuevoRadio;
		}
		
		public double getAnteRadio() {
			return anteRadio;
		}
		public double getNuevoRadio() {
			return nuevoRadio;
		}
	}
	
	public interface RadioListener extends EventListener{
		public void enteradoRadioCambiado(EventObject e);
	}
	
	public void setRadio(double nuevoRadio) {
		double anteRadio=radio;
		radio = nuevoRadio;
		if(anteRadio!=nuevoRadio) {
			RadioEvent event = new RadioEvent(this,anteRadio,nuevoRadio);
			notificarCambio(event);
		}
	}
	
	public double getRadio() {
		return radio;
	}
	
	public synchronized void addRadioListener(RadioListener listener) {
		radioListeners.addElement(listener);
	}
	
	public synchronized void removeRadioListener(RadioListener listener) {
		radioListeners.removeElement(listener);
	}
	
	public void notificarCambio(RadioEvent event) {
		Vector lista;
	    synchronized(this){
	        lista=(Vector)radioListeners.clone();
	    }
	    for(int i=0; i<lista.size(); i++){
	        RadioListener listener=(RadioListener)lista.elementAt(i);
	        listener.enteradoRadioCambiado(event);
	    }
	}
}
