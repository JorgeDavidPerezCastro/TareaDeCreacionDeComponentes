package Paquete;

import java.util.EventObject;

import Paquete.Radio.RadioEvent;
import Paquete.Radio.RadioListener;

public class ObjetosInteresados implements RadioListener{
	
	public ObjetosInteresados() {
		
	}
	
	@Override
	public void enteradoRadioCambiado(EventObject e) {
		if(e instanceof RadioEvent) {
			RadioEvent event = (RadioEvent)e;
			System.out.println("El radio es: " + event.getNuevoRadio());
		}
	}
}
