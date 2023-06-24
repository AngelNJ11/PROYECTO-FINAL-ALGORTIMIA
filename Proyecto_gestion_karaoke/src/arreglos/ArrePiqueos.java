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
	
	public void adicionar(ClasePiqueo x) {
		piqueo.add(x);
		grabarPiqueos();
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
	
	public String correlativo(int codigo){
		String piq = "PIQ" + String.format("%03d", codigo);
		return piq;
	}
	public void eliminar(ClasePiqueo x){
		piqueo.remove(x);
		grabarPiqueos();
	}
	public void actualizarArchivo() {
		grabarPiqueos();
	}
	
	private void grabarPiqueos(){
		try{
			PrintWriter pw;
			String linea;
			ClasePiqueo x;
			pw = new PrintWriter(new FileWriter("piqueos.txt"));
			for(int i=0; i<tamano(); i++) {
				x = obtener(i);
				boolean estado = x.isEstado();
				linea = x.getIdPiqueo() + ";" +
						x.getNombre() + ";" +
						x.getTipoPiqueo() + ";" +
						x.getPrecio() + ";" +
						(estado ? "Habilitado" : "Inhabilitado");;
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
			String[] s;
			String idPiqueo, nombre;
			int tipoPiqueo;
			double precio;
			boolean estado;
			br = new BufferedReader(new FileReader("piqueos.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				idPiqueo =(s[0].trim());
				nombre =(s[1].trim());
				tipoPiqueo=Integer.parseInt(s[2].trim());
				precio=Double.parseDouble(s[3].trim());
				estado=Boolean.parseBoolean(s[4].trim());
				adicionar(new ClasePiqueo(idPiqueo, nombre, tipoPiqueo, precio, estado));
			}
			br.close();	
		}
		catch (Exception e) {
		}
	}
}