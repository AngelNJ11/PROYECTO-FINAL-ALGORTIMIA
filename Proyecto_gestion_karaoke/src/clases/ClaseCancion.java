package clases;

import java.sql.Date;

public class ClaseCancion {

	
	
	
					//CAN0001
	private  String idCancion;
	private  String nombre;
	private final String idArtista;
	private  String album;
	private  Date fechaRegistro;
	private  int numeroReproduciones = 0;
	private  boolean estado = true;
	


	public ClaseCancion (String idArtista, String idCancion, String nombre, String album, Date fechaRegistro,
			int numeroReproduciones, boolean estado) {
		super();
		this.idArtista = idArtista;
		this.idCancion = idCancion;
		this.nombre = nombre;
		this.album = album;
		this.fechaRegistro = fechaRegistro;
		this.numeroReproduciones = numeroReproduciones;
		this.estado = estado;
	}


	


	public String getIdCancion() {
		return idCancion;
	}


	public void setIdCancion(String idCancion) {
		this.idCancion = idCancion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getAlbum() {
		return album;
	}


	public void setAlbum(String album) {
		this.album = album;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public int getNumeroReproduciones() {
		return numeroReproduciones;
	}


	public void setNumeroReproduciones(int numeroReproduciones) {
		this.numeroReproduciones = numeroReproduciones;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public String getIdArtista() {
		return idArtista;
	}
	
	
	
	
	
}
