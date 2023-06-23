package arreglos;

import java.util.ArrayList;

import clases.ClaseBebida;
import clases.ClasePiqueo;

public class ArrePiqueos {

	
	private ArrayList <ClasePiqueo> piqueo;

	public ArrePiqueos() {
		
		piqueo = new ArrayList <ClasePiqueo> ();
	}
	
	public void adicionar(ClasePiqueo x) {
		
		piqueo.add(x);
	}
	
	public int tamanio() {
		return piqueo.size();
	}
	
	public ClasePiqueo obtener(int i) {
		return piqueo.get(i);
	}
	
	public ClasePiqueo buscacod(String codigo){
		for(ClasePiqueo piqueo : piqueo){
			if(piqueo.getIdPiqueo().equals(codigo)){
				return piqueo;
			}
		}
		return null;
	}
	
	public String generarCodigoCorrelativo(String codigoAnterior) {
		if (tamanio() == 0) {
			return "PIQ001";
		}else {
			String codigo = codigoAnterior.substring(3);
		    int correlativo = Integer.parseInt(codigo) + 1; 
		    String nuevoCodigo = "PIQ" + String.format("%03d", correlativo); 
		    return nuevoCodigo;
		}
	}
}