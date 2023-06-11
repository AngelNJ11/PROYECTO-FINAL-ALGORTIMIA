package clases;

public class ClaseDetalleConsumo {

	
	
	ClaseConsumo consumo = new ClaseConsumo();
	
	
	
	private final String codigoConsumo = consumo.getCodigoConsumo();
	private  int cantidad = 0;
	private  double subtotal = 0;
	
	public String getCodigoConsumo() {
		return codigoConsumo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

}
