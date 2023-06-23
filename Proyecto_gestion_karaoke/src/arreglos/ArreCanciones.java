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
	
	public int tamanio() {
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
	
	public String generarCodigoCorrelativo(String codigoAnterior) {
		if (tamanio() == 0) {
			return "CAN0001";
		}else {
			String codigo = codigoAnterior.substring(3);
		    int correlativo = Integer.parseInt(codigo) + 1; 
		    String nuevoCodigo = "CAN" + String.format("%04d", correlativo); 
		    return nuevoCodigo;
		}
	}
	
	
	
}
