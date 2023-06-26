package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.ClaseGenero;



public class ArreGeneros {

	private ArrayList <ClaseGenero> genero;

	public ArreGeneros() {
		genero = new ArrayList <ClaseGenero> ();
		cargarGenero();
	}
	
	public void adicionar(ClaseGenero x) {
		genero.add(x);
		grabarGenero();
	}
	
	public int tamanio() {
		return genero.size();
	}
	
	public ClaseGenero obtener(int i) {
		return genero.get(i);
	}
	
	public void eliminar(ClaseGenero x){
		genero.remove(x);
		grabarGenero();
	}
	
	public ClaseGenero buscaID(String codigo){
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
	
	public void actualizarArchivo() {
		grabarGenero();
	}
	
	private void grabarGenero(){
		try{
			PrintWriter pw;
			String linea;
			ClaseGenero genero;
			pw = new PrintWriter(new FileWriter("genero.txt"));
			for(int i=0; i<tamanio(); i++) {
				genero = obtener(i);
				String dato1 = genero.getIdGenero() + ";";
				String dato2 = genero.getDescripcion() + ";";
				String dato3 = genero.getEpoca() + ";";
				boolean dato4 = genero.isEstado();
				linea = dato1 + 
						dato2 + 
						dato3 + 
						dato4;
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
			
		}
	}
	private void cargarGenero() {
		try {
			BufferedReader br;
			String linea;
			String[] s;	
			String idGenero, descripcion;
			int epoca;
			boolean estado;
			br = new BufferedReader(new FileReader("genero.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				idGenero =(s[0].trim());
				descripcion =(s[1].trim());
				epoca=Integer.parseInt(s[2].trim());
				estado=Boolean.parseBoolean(s[3].trim());
				adicionar(new ClaseGenero(idGenero,descripcion,epoca,estado));
			}
			br.close();	
		}
		catch (Exception e) {
		}
	}
}
