package arreglos;

import java.util.ArrayList;

import clases.ClaseBebida;


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
}
