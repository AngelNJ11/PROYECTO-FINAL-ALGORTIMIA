package arreglos;

import java.util.ArrayList;

import clases.ClaseGenero;



public class ArreGeneros {

	

	private ArrayList <ClaseGenero> genero;

	public ArreGeneros() {
		
		genero = new ArrayList <ClaseGenero> ();
		adicionar(new ClaseGenero("GEN01", "Pop", 1987, true));
		adicionar(new ClaseGenero("GEN02", "Reggue", 1970, true));
		adicionar(new ClaseGenero("GEN03", "Regeton", 1860, true));
		adicionar(new ClaseGenero("GEN04", "Electro", 1950, true));
		adicionar(new ClaseGenero("GEN05", "Lofi", 2010, true));
		adicionar(new ClaseGenero("GEN06", "Rock", 1960, true));

	}
	
	public void adicionar(ClaseGenero x) {
		
		genero.add(x);
	}
	
	public int tamanio() {
		return genero.size();
	}
	
	public ClaseGenero obtener(int i) {
		return genero.get(i);
	}
	
	public void eliminar(ClaseGenero x){
		genero.remove(x);
	}
	
	public ClaseGenero buscacod(String codigo){
		for(ClaseGenero genero : genero){
			if(genero.getIdGenero().equals(codigo)){
				return genero;
			}
		}
		return null;
	}
	
	
	public String generarCodigoCorrelativo(String codigoAnterior) {
		if (tamanio() == 0) {
			return "GEN01";
		}else {
			String codigo = codigoAnterior.substring(2);
		    int correlativo = Integer.parseInt(codigo) + 1; 
		    String nuevoCodigo = "GEN" + String.format("%02d", correlativo); 
		    return nuevoCodigo;
		}
	}
}
