package clases;

public class ClaseDetalleConsumo {

	
	
	ClaseConsumo consumo = new ClaseConsumo();
	
	
	
	private  String idConsumo = consumo.getCodigoConsumo();
	private  int cantidad;
	private  double subtotal;
	
	
	
	public ClaseDetalleConsumo() {
	}



	public ClaseDetalleConsumo(String idConsumo, int cantidad, double subtotal) {
		this.idConsumo = idConsumo;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}



	public String getIdConsumo() {
		return idConsumo;
	}



	public void setIdConsumo(String idConsumo) {
		this.idConsumo = idConsumo;
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
