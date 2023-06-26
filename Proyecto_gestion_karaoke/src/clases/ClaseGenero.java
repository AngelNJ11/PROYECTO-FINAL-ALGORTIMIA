package clases;


public class ClaseGenero {
	
					//GEN01
	private  String idGenero;
	private  String descripcion;
	private  int epoca;
	private  boolean estado;
	
	
	
	public ClaseGenero() {	
	}
	
	public ClaseGenero(String idGenero, String descripcion, int epoca, boolean estado) {

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
	
	public String epoca(int anio) {
		switch (anio) {
			case 0:
				return "1970";
			case 1:
				return "1980";
			case 2:
				return "1990";
			case 3:
				return "2000";
			case 4:
				return "2010";
			case 5:
				return "2020";
			default:
				return null;
		}
	}
	
	public String estadoTipo(){	
		return estado ? "Habilitado" : "Inhabilitado";
	}
	
	

	
	

}
