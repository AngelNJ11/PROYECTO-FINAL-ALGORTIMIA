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
import clases.ClaseCancion;

public class ArreCanciones {

	
	private ArrayList <ClaseCancion> cancion;

	public ArreCanciones() {	
		cancion = new ArrayList <ClaseCancion> ();
		cargarCancion();
	}
	
	public void adicionar(ClaseCancion nuevoCliente, boolean graba){
		cancion.add(nuevoCliente);
		if(graba)
			grabarCancion();
	}	
	public int tamanio() {
		return cancion.size();
	}
	
	public ClaseCancion obtener(int i) {
		return cancion.get(i);
	}
	
	public void eliminar(ClaseCancion x){
		cancion.remove(x);
		grabarCancion();
	}
	
	
	public ClaseCancion buscaID(String codigo){
		for(ClaseCancion cancion : cancion){
			if(cancion.getIdCancion().equals(codigo)){
				return cancion;
			}
		}
		return null;
	}
	
	public String generarCodigoCorrelativo(String codigoAnterior) {
		if (tamanio() == 0) {
			return "CAN0001";
		}else {
			String codigo = codigoAnterior.substring(3);
		    int correlativo = Integer.parseInt(codigo) + 1; 
		    String nuevoCodigo = "CAN" + String.format("%04d", correlativo); 
		    return nuevoCodigo;
		}
	}
	
	public void actualizarArchivo() {
		grabarCancion();
	}
	
	private void grabarCancion(){
		try{
			PrintWriter pw;
			String linea;
			ClaseCancion cancion;
			pw = new PrintWriter(new FileWriter("canciones.txt"));
			for(int i=0; i<tamanio(); i++) {
				cancion = obtener(i);
				String dato1 = cancion.getIdCancion() + ";";
				String dato2 = cancion.getNombre() + ";";
				String dato3 = cancion.getArtista().getNombreArtistico() + ";";
				String dato4 = cancion.getAlbum() + ";";
				String dato5 = cancion.getFechaRegistro() + ";";
				String dato6 = cancion.getNumeroReproduciones() + ";";
				String dato7 = cancion.isEstado() + ";";
				linea = dato1 + dato2 + dato3 + dato4 + dato5 + dato6 + dato7;
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
			
		}
	}

	private void cargarCancion() {
		try {
			BufferedReader br;
			String linea;
			String[] datos;
			ClaseCancion cancion;
			
			br = new BufferedReader(new FileReader("canciones.txt"));
			while ((linea = br.readLine()) != null) {
				datos = linea.split(";");
				
				String idCancion =(datos[0].trim());
				String nombre =(datos[1].trim());
				String nombreArtista = (datos[2].trim());
				ArreArtistas arreartista = new ArreArtistas();
				ClaseArtista artista = arreartista.buscarPorNombre(nombreArtista);
				String album = (datos[3].trim());
				Date fechaRegistro = fechaComoDate(datos[4].trim());
				int numeroRepro = Integer.parseInt(datos[5].trim());
				boolean estado = Boolean.parseBoolean(datos[6]);
				
				cancion = new ClaseCancion(idCancion, nombre, artista, album, (java.sql.Date) fechaRegistro, numeroRepro, estado);
				adicionar(cancion, false);
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
	

