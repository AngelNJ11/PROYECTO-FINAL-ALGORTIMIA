package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.ClaseBebida;


public class ArreBebidas {

	
	private ArrayList <ClaseBebida> bebida;

	public ArreBebidas() {
		
		bebida = new ArrayList <ClaseBebida> ();
		cargarBebidas();
	}
	
	public void adicionar(ClaseBebida x) {
		bebida.add(x);
		grabarBebida();
	}
	
	public int tamanio() {
		return bebida.size();
	}
	
	public ClaseBebida obtener(int i) {
		return bebida.get(i);
	}
	
	public void eliminar(ClaseBebida x){
		bebida.remove(x);
		grabarBebida();
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
	
	public void actualizarArchivo() {
		grabarBebida();
	}
	
	private void grabarBebida(){
		try{
			PrintWriter pw;
			String linea;
			ClaseBebida x;
			pw = new PrintWriter(new FileWriter("bebida.txt"));
			for(int i=0; i<tamanio(); i++){
				x = obtener(i);
				linea = x.getIdBebida() + ";" +
						x.getNombre() + ";" +
						x.getTipoBebida() + ";" +
						x.getMarca() + ";" +
						x.getPrecio() + ";" +
						x.isEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e){
			
		}
	}
	
	private void cargarBebidas(){
		try {
			BufferedReader br;
			String linea;
			String[] s;
			String idBebida, nombre, marca;
			int tipo;
			double precio;
			boolean estado;
			br = new BufferedReader(new FileReader("bebida.txt"));
			while ((linea=br.readLine()) !=null){
				s=linea.split(";");
				idBebida=(s[0].trim());
				nombre=(s[1].trim());
				tipo=Integer.parseInt(s[2].trim());
				marca=(s[3].trim());
				precio=Double.parseDouble(s[4].trim());
				estado=Boolean.parseBoolean(s[5].trim());
				adicionar(new ClaseBebida(idBebida,nombre,tipo,marca,precio,estado));
			}
			br.close();
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
