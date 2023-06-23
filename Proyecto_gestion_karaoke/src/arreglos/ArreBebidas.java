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
	
	public int tamano() {
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
	
	public String correlativ(String codigo) {
		String beb = "BEB" + String.format("%02d", codigo);
		return beb;
	}
}
