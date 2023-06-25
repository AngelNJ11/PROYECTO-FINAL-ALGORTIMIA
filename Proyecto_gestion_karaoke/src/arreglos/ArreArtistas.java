package arreglos;

import java.util.ArrayList;

import clases.ClaseArtista;


public class ArreArtistas {

	
	private ArrayList <ClaseArtista> artista;

	public ArreArtistas() {
		
		artista = new ArrayList <ClaseArtista> ();
		adicionar(new ClaseArtista("ART001", "Camilo", null, null, true));
		adicionar(new ClaseArtista("ART002", "Bacilos", null, null, true));
		adicionar(new ClaseArtista("ART003", "Vicentico", null, null, true));
		adicionar(new ClaseArtista("ART004", "Mana", null, null, true));

	}
	
	public void adicionar(ClaseArtista x) {
		artista.add(x);
	}
	
	public int tamanio() {
		return artista.size();
	}
	
	public ClaseArtista obtener(int i) {
		return artista.get(i);
	}
	
	public void eliminar(ClaseArtista x){
		artista.remove(x);
	}
	
	public ClaseArtista buscaID(String codigo){
		for(ClaseArtista bebida : artista){
			if(bebida.getIdArtista().equals(codigo)){
				return bebida;
			}
		}
		return null;
	}
	

	public String generarCodigoCorrelativo(String codigoAnterior) {
		if (tamanio() == 0) {
			return "BEB001";
		}else {
			String codigo = codigoAnterior.substring(3);
		    int correlativo = Integer.parseInt(codigo) + 1; 
		    String nuevoCodigo = "BEB" + String.format("%03d", correlativo); 
		    return nuevoCodigo;
		}
	}
}
