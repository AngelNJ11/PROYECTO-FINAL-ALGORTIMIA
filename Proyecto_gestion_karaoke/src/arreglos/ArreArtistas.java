package arreglos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import clases.ClaseArtista;
import clases.ClaseGenero;
import helpers.ManejoArchivos;

public class ArreArtistas {
	// Atributo privado
	private ArrayList<ClaseArtista> artistaList;
	private ManejoArchivos manejoArchivos;
	private String nombreArchivo;

	// Constructor
	public ArreArtistas() {
		artistaList = new ArrayList<ClaseArtista>();
		manejoArchivos = new ManejoArchivos();
		nombreArchivo = "artistas.txt";
		cargarArtistas();
	}

	public void adicionar(ClaseArtista nuevoUsuario, boolean graba) {
		artistaList.add(nuevoUsuario);
		if (graba)
			grabarArtista();
	}

	public int tamanio() {
		return artistaList.size();
	}

	public ClaseArtista obtener(int posicion) {
		return artistaList.get(posicion);
	}

	public ClaseArtista buscarPorCodigo(String codigo) {
		for (ClaseArtista artista : artistaList) {
			if (artista.getIdArtista().equals(codigo)) {
				return artista;
			}
		}
		return null;
	}

	public String ultimoCodigo() {
		int ultimoIndice = tamanio() - 1;
		if (ultimoIndice < 0)
			return "ART000";
		ClaseArtista artista = obtener(ultimoIndice);
		if (artista != null)
			return artista.getIdArtista();
		return null;
	}

	public void grabarArtista() {
		String linea;
		ArrayList<String> datos = new ArrayList<String>();
		for (ClaseArtista artista : artistaList) {
			String dato1 = artista.getIdArtista() + ";";
			String dato2 = artista.getNombreArtistico() + ";";
			String dato3 = artista.getGenero().getIdGenero() + ";";
			String dato4 = artista.fechaComoCadena() + ";";
			String dato5 = artista.isEstado() + ";";
			linea = dato1 + dato2 + dato3 + dato4 + dato5;
			datos.add(linea);
		}

		try {
			manejoArchivos.grabarData(datos, nombreArchivo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}

	public void cargarArtistas() {
		String[] datos;
		ClaseArtista artista;
		ArrayList<String> lineas;
		ArreGeneros arrGeneros = new ArreGeneros();
		try {
			lineas = manejoArchivos.cargarData(nombreArchivo);
			if (lineas != null)
				for (String linea : lineas) {
					datos = linea.split(";");
					String idArtista = datos[0];
					String nombreArtistico = datos[1];
					String idGenero = datos[2];
					ClaseGenero genero = arrGeneros.buscaID(idGenero);
					Date fechaRegistro = fechaComoDate(datos[3]);
					boolean estado = Boolean.parseBoolean(datos[4]);
					artista = new ClaseArtista(idArtista, nombreArtistico, fechaRegistro, genero, estado);
					adicionar(artista, false);
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Date fechaComoDate(String fechaText) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		Date fechaComoDate = null;
		try {
			fechaComoDate = formatter.parse(fechaText);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fechaComoDate;
	}

}

