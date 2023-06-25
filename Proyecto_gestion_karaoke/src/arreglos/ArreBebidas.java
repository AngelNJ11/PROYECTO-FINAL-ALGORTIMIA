package arreglos;

import java.util.ArrayList;

import clases.ClaseBebida;


public class ArreBebidas {

	
	private ArrayList <ClaseBebida> bebida;

	public ArreBebidas() {
		
		bebida = new ArrayList <ClaseBebida> ();
		adicionar(new ClaseBebida("BEB001", "cerveza Pilsen", 0, "Pilsen", 8.5, true));
		adicionar(new ClaseBebida("BEB002", "cerveza Qusquena", 0, "Qusquena", 10.5, true));
		adicionar(new ClaseBebida("BEB003", "Limonada", 5, null, 7.5, true));
		adicionar(new ClaseBebida("BEB004", "Smothie de fresa", 4, "", 12.5, true));
	}
	
	public void adicionar(ClaseBebida x) {
		bebida.add(x);
	}
	
	public int tamanio() {
		return bebida.size();
	}
	
	public ClaseBebida obtener(int i) {
		return bebida.get(i);
	}
	
	public void eliminar(ClaseBebida x){
		bebida.remove(x);
	}
	
	public ClaseBebida buscaID(String codigo){
		for(ClaseBebida bebida : bebida){
			if(bebida.getIdBebida().equals(codigo)){
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
