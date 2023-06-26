package clases;

public class ClaseBebida {
					//BEB001
	private String idBebida;
	private String nombre;
	private int tipoBebida;
	private String marca;
	private double precio;
	private boolean estado;

	public ClaseBebida() {

	}

	public ClaseBebida(String idBebida, String nombre, int tipoBebida, String marca, double precio, boolean estado) {
		this.idBebida = idBebida;
		this.nombre = nombre;
		this.tipoBebida = tipoBebida;
		this.marca = marca;
		this.precio = precio;
		this.estado = estado;
	}

	public String getIdBebida() {
		return idBebida;
	}

	public void setIdBebida(String idBebida) {
		this.idBebida = idBebida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTipoBebida() {
		return tipoBebida;
	}

	public void setTipoBebida(int tipoBebida) {
		this.tipoBebida = tipoBebida;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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

	

	public String tipodeBebida(int tipo){
		switch (tipo) {
		case 0:
			return "Cerveza";
		case 1:
			return "Vinos";
		case 2:
			return "Whisky";
		case 3:
			return "Ron";
		case 4:
			return "Frutado";
		case 5:
			return "Combinaci�n preparada";
		case 6:
			return "Agua embotellada";
		default:
			return null;
		}
	}
	
	public String estadoBebida() {
		return estado ? "Habilitado" : "Inhabilitado";
		
	}
}