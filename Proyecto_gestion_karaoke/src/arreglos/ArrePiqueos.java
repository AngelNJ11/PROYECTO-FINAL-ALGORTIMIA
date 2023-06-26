package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.ClasePiqueo;

public class ArrePiqueos {

	
	private ArrayList <ClasePiqueo> piqueo;

	public ArrePiqueos() {
		
		piqueo = new ArrayList <ClasePiqueo> ();
		cargarPiqueos();
	}
	
	public void adicionar(ClasePiqueo nuevoCliente, boolean graba){
		piqueo.add(nuevoCliente);
		if(graba)
			grabarPiqueos();
	}
	
	public int tamanio() {
		return piqueo.size();
	}
	
	public ClasePiqueo obtener(int i) {
		return piqueo.get(i);
	}
	
	public void eliminar(ClasePiqueo x){
		piqueo.remove(x);
		grabarPiqueos();
	}
	
	
	public ClasePiqueo buscaID(String codigo){
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
	
	public void actualizarArchivo() {
		grabarPiqueos();
	}
	
	private void grabarPiqueos(){
		try{
			PrintWriter pw;
			String linea;
			ClasePiqueo piqueo;
			pw = new PrintWriter(new FileWriter("piqueos.txt"));
			for(int i=0; i<tamanio(); i++) {
				piqueo = obtener(i);
				String dato1 = piqueo.getIdPiqueo() + ";";
				String dato2 = piqueo.getNombre() + ";";
				String dato3 = piqueo.getTipoPiqueo() + ";";
				String dato4 = piqueo.getPrecio() + ";";
				boolean dato5 = piqueo.isEstado();
				linea = dato1 + 
						dato2 + 
						dato3 + 
						dato4 + 
						dato5;
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
			
		}
	}
	private void cargarPiqueos() {
		try {
			BufferedReader br;
			String linea;
			String[] datos;
			ClasePiqueo piqueo;
			
			String idPiqueo, nombre;
			int tipoPiqueo;
			double precio;
			boolean estado;
			br = new BufferedReader(new FileReader("piqueos.txt"));
			while ((linea = br.readLine()) != null) {
				datos = linea.split(";");
				
				idPiqueo =(datos[0].trim());
				nombre =(datos[1].trim());
				tipoPiqueo=Integer.parseInt(datos[2].trim());
				precio=Double.parseDouble(datos[3].trim());
				estado=Boolean.parseBoolean(datos[4].trim());
				piqueo = new ClasePiqueo(idPiqueo, nombre, tipoPiqueo, precio, estado);
				adicionar(piqueo, false);
			}
			br.close();	
		}
		catch (Exception e) {
		}
	}
}