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
	
	public int tamano() {
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
	
	public String correlativ(int codigo){
		String cod = "PIQ" + String.format("%02d", codigo);
		return cod;
	}
}