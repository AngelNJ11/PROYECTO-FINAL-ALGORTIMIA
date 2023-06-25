package arreglos;

import java.util.ArrayList;

import clases.ClaseCancion;

public class ArreCanciones {

	
	private ArrayList <ClaseCancion> cancion;

	public ArreCanciones() {	
		cancion = new ArrayList <ClaseCancion> ();
		adicionar(new ClaseCancion("CAN0001", "BEBE", null, "Mis Manos", null, 0, true));
		adicionar(new ClaseCancion("CAN0002", "Mi primer Millon", null, "Caraluna", null, 0, true));
		adicionar(new ClaseCancion("CAN0003", "Los Caminos de la vida", null, "Los Rayos", null, 0, true));
		adicionar(new ClaseCancion("CAN0004", "Rayando el Sol", null, "Falta Amor", null, 0, true));
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
	
	public void eliminar(ClaseCancion x){
		cancion.remove(x);
	}
	
	
	public ClaseCancion buscaID(String codigo){
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
