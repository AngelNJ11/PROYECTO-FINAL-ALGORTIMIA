package clases;

import java.sql.Date;

public class ClaseArtista {

	ClaseGenero genero = new ClaseGenero();
	// ART001
	private String idArtista;
	private String nombreArtistico;
	private final String idgenero = genero.getIdGenero();
	private Date fechaRegistro;
	private boolean estado = true;

	public ClaseArtista(ClaseGenero genero, String idArtista, String nombreArtistico, Date fechaRegistro,
			boolean estado) {

		this.genero = genero;
		this.idArtista = idArtista;
		this.nombreArtistico = nombreArtistico;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
	}

	public ClaseGenero getGenero() {
		return genero;
	}

	public void setGenero(ClaseGenero genero) {
		this.genero = genero;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getIdgenero() {
		return idgenero;
	}

	public String correlativ(int pos) {
		String artis = "ART" + String.format("%03d", pos);
		return artis;
	}

	/*public int Registrofecha(){
		int dd = getDay();
		int mm = getMonth();
		int aaaa = getYear();
		
	 return dd + "/" + mm + "/" + aaaa;
	}*/
	
	public String ObsEstado(){	
		if (estado) {
			return "Habilitado";	
		}
		else{
			return "Inhabilitado";
		}
	}
}