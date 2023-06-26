package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import clases.ClaseArtista;
import clases.ClaseGenero;


public class ArreArtistas {

	
	private ArrayList <ClaseArtista> artista;

	public ArreArtistas() {
		
		artista = new ArrayList <ClaseArtista> ();
		cargarArtista();

	}
	
	public void adicionar(ClaseArtista x) {
		artista.add(x);
		grabarArtista();
	}
	
	public int tamanio() {
		return artista.size();
	}
	
	public ClaseArtista obtener(int i) {
		return artista.get(i);
	}
	
	public void eliminar(ClaseArtista x){
		artista.remove(x);
		grabarArtista();
	}
	
	public ClaseArtista buscaID(String codigo){
		for(ClaseArtista bebida : artista){
			if(bebida.getIdArtista().equals(codigo)){
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
	
	private void grabarArtista(){
		try{
			PrintWriter pw;
			String linea;
			ClaseArtista x;
			pw = new PrintWriter(new FileWriter("artista.txt"));
			for(int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getIdArtista() + ";" +
						x.getNombreArtistico() + ";" +
						x.getFechaRegistro() + ";" +
						x.getGenero() + ";" +
						x.isEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
			
		}
	}
	
	private void cargarArtista() {
		try {
			BufferedReader br;
			String linea;
			String [] datos;
			ClaseArtista artista;
			ArreGeneros aregen =  new ArreGeneros();
			br = new BufferedReader(new FileReader("piqueos.txt"));
			while ((linea=br.readLine()) != null) {
				datos = linea.split(";");
				String idArtista =(datos[0].trim());
				String nombre =(datos[1].trim());
				Date fecha = fechaComoDate(datos[2].trim());
				String idGenero = datos[3];
				ClaseGenero genero = aregen.buscaID(idGenero);
				boolean estado = Boolean.parseBoolean(datos[4]);
				artista =  new ClaseArtista(idArtista, nombre,  (java.sql.Date) fecha, genero, estado);
				adicionar(artista);
			}
			br.close();	
		}
		catch (Exception e) {
			
		}
	}
	
	
	
	public Date fechaComoDate(String datos) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		Date fechaComoDate = null;
		try {
			fechaComoDate = formatter.parse(datos);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaComoDate;
	}
}
