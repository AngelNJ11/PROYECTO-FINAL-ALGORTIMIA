package arreglos;

import java.util.ArrayList;

import clases.ClasePiqueo;

public class ArrePiqueos {

	
	private ArrayList <ClasePiqueo> piqueo;

	public ArrePiqueos() {
		
		piqueo = new ArrayList <ClasePiqueo> ();
	}
	
	public void adicionar(ClasePiqueo x) {
		
		piqueo.add(x);
	}
	
	public int tamano() {
		return piqueo.size();
	}
	
	public ClasePiqueo obtener(int i) {
		return piqueo.get(i);
	}
}