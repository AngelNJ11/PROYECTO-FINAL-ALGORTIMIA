package arreglos;

import java.util.ArrayList;

import clases.ClaseCancion;
import clases.ClasePiqueo;

public class ArreCanciones {

	
	private ArrayList <ClaseCancion> cancion;

	public ArreCanciones() {	
		cancion = new ArrayList <ClaseCancion> ();
		adicionar(new ClaseCancion(null, null, null, null, null, 0, false));
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
	
	public String correlativ(String codigo) {
		String can = "CAN" + String.format("%03d", codigo);
		return can;
	}
	
	
	
}
