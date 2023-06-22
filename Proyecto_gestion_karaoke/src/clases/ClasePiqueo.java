package clases;

public class ClasePiqueo {

					//PIQ001
	private  String idPiqueo;
	private  String nombre;
							//0 = Frios  1 = Calientes  2 = Snaks
	private  int tipoPiqueo;
	private  double precio;
	private  boolean estado;




	public ClasePiqueo() {
		
	}



	public ClasePiqueo(String idPiqueo, String nombre, int tipoPiqueo, double precio, boolean estado) {
		
		this.idPiqueo = idPiqueo;
		this.nombre = nombre;
		this.tipoPiqueo = tipoPiqueo;
		this.precio = precio;
		this.estado = estado;
}



	public String getIdPiqueo() {
		return idPiqueo;
	}



	public void setIdPiqueo(String idPiqueo) {
		this.idPiqueo = idPiqueo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getTipoPiqueo() {
		return tipoPiqueo;
	}



	public void setTipoPiqueo(int tipoPiqueo) {
		this.tipoPiqueo = tipoPiqueo;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public String tipoPiqueo(int tipo){
		switch(tipo){
		case 0:
			return "Frios";
		case 1:
			return "Calientes";
		case 2: 
			return "Snaks";
		default:
			return null;
		}
	}
	
	public String obsEstado(){
		if (estado) {
			return "Habilitado";
		}
		else {
			return "Inhabilitado";
		}
	}
	



}
