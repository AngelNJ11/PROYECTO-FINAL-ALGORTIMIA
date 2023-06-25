package arreglos;

import java.util.ArrayList;

import clases.ClaseCliente;



public class ArreCliente {

	
	private ArrayList<ClaseCliente> cliente;

	public ArreCliente(){
		cliente = new ArrayList<ClaseCliente>();
		adicionar(new ClaseCliente("CLI001", "Arue", "Palma", "Casavarde", "Atahualpa 270", null, null, "S", "945628356", "72081959", 4));
		adicionar(new ClaseCliente("CLI002", "Angel", "Navarro", "", "Sol de la molina 415", null, null, "C", "945634456", "71131959", 3));
		adicionar(new ClaseCliente("CLI003", "Alejo", "", "", "Barranco", null, null, "D", "945628356", "72081959", 4));
	}
	
	public void adicionar(ClaseCliente x){
		cliente.add(x);
	}
	
	public int tamanio(){
		return cliente.size();
	}
	
	public ClaseCliente obtener(int posicion){
		return cliente.get(posicion);
	}
	
	public void eliminar(ClaseCliente x){
		cliente.remove(x);
	}
	
	public ClaseCliente buscaID(String codigo){
		for(ClaseCliente cliente : cliente){
			if(cliente.getIdCliente().equals(codigo)){
				return cliente;
			}
		}
		return null;
	}
	

	
	public String generarCodigoCorrelativo(String codigoAnterior) {
		if (tamanio() == 0) {
			return "CLI001";
		}else {
			String codigo = codigoAnterior.substring(3);
		    int correlativo = Integer.parseInt(codigo) + 1; 
		    String nuevoCodigo = "CLI" + String.format("%03d", correlativo); 
		    return nuevoCodigo;
		}
	}
}
