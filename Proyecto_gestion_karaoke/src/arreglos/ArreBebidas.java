package arreglos;

import java.util.ArrayList;

import clases.ClaseBebida;
import clases.ClaseUsuarios;


public class ArreBebidas {

	
	private ArrayList <ClaseBebida> bebida;

	public ArreBebidas() {
		
		bebida = new ArrayList <ClaseBebida> ();
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
	
	public ClaseBebida buscacod(String codigo){
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
