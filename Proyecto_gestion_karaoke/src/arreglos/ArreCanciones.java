package arreglos;

import java.util.ArrayList;

import clases.ClaseCancion;
import clases.ClasePiqueo;

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
	
	public ClaseCancion buscacod(String codigo){
		for(ClaseCancion cancion : cancion){
			if(cancion.getIdCancion().equals(codigo)){
				return cancion;
			}
		}
		return null;
	}
	
	
	
}
