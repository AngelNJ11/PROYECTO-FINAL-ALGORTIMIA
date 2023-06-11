package clases;

public class ClaseGenero {

	
	
	
	
	private  String idGenero = "GEN01";
	private  String descripcion;
	private  int epoca = 2012;
	private  boolean estado = true;
	
	
	
	public ClaseGenero() {
		
	}

	public ClaseGenero(String idGenero, String descripcion, int epoca, boolean estado) {
		super();
		this.idGenero = idGenero;
		this.descripcion = descripcion;
		this.epoca = epoca;
		this.estado = estado;
	}

	public String getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(String idGenero) {
		this.idGenero = idGenero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEpoca() {
		return epoca;
	}

	public void setEpoca(int epoca) {
		this.epoca = epoca;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
	

}
