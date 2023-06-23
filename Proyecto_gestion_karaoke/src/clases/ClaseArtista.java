package clases;

import java.sql.Date;


public class ClaseArtista{

	ClaseGenero genero = new ClaseGenero();
	// ART001
	private String idArtista;
	private String nombreArtistico;
	private Date fechaRegistro;
	private String idGenero = genero.getIdGenero();
	private boolean estado;


	
	
	
	
	public ClaseArtista() {
		super();
	}



	public ClaseArtista(String idArtista, String nombreArtistico, Date fechaRegistro,String idGenero, boolean estado) {
		this.idArtista = idArtista;
		this.nombreArtistico = nombreArtistico;
		this.fechaRegistro = fechaRegistro;
		this.idGenero = idGenero;
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

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public String getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(String idGenero) {
		this.idGenero = idGenero;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String estado(boolean estado){	
		if (estado) {
			return "Habilitado";	
		}
		else{
			return "Inhabilitado";
		}
	}
}