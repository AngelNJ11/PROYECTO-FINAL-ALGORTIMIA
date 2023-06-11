package arreglos;

import java.util.ArrayList;

import clases.ClaseCancion;

public class ArreCanciones {

	
	private ArrayList <ClaseCancion> cancion;

	public ArreCanciones() {
		
		cancion = new ArrayList <ClaseCancion> ();
	}
	
	public void adicionar(ClaseCancion x) {
		
		cancion.add(x);
	}
	
	public int tamano() {
		return cancion.size();
	}
	
	public ClaseCancion obtener(int i) {
		return cancion.get(i);
	}
	
	
	
}
