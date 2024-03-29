package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClaseArtista {
	private String idArtista;
	private String nombreArtistico;
	//private String idGenero;
	private ClaseGenero genero;
	private Date fechaRegistro;
	private boolean estado;
	
	public ClaseArtista(String idArtista, String nombreArtistico, Date fechaRegistro, ClaseGenero genero, boolean estado) {
		this.idArtista = idArtista;
		this.nombreArtistico = nombreArtistico;
		this.genero = genero;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
	}

	public String getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(String idArtista) {
		this.idArtista = idArtista;
	}

	public String getNombreArtistico() {
		return nombreArtistico;
	}

	public void setNombreArtistico(String nombreArtistico) {
		this.nombreArtistico = nombreArtistico;
	}

	public ClaseGenero getGenero() {
		return genero;
	}

	public void setGenero(ClaseGenero genero) {
		this.genero = genero;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public String nombreEstado() {
		return estado ? "Activo" : "Inactivo";
	}
	
	public String fechaComoCadena() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		String fechaComoCadena = sdf.format(fechaRegistro);
		return fechaComoCadena;
	}
}
