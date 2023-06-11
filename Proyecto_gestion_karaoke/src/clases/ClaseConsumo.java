package clases;

import java.util.Date;

public class ClaseConsumo {

	
	ClaseCliente cliente = new ClaseCliente();

					//CON0001
	private  String codigoConsumo;
	private final String idCliente = cliente.getIdCliente();
	private  Date fechaConsumo;
	private  double importeTotal;
	
	Date fachaConsumo = new Date();
	
	public ClaseConsumo() {
		
	}


	public ClaseConsumo(ClaseCliente cliente, String codigoConsumo, Date fechaConsumo, double importeTotal) {

		
		this.cliente = cliente;
		this.codigoConsumo = codigoConsumo;
		this.fechaConsumo = fechaConsumo;
		this.importeTotal = importeTotal;
	}


	public String getCodigoConsumo() {
		return codigoConsumo;
	}


	public void setCodigoConsumo(String codigoConsumo) {
		this.codigoConsumo = codigoConsumo;
	}


	public Date getFechaConsumo() {
		return fechaConsumo;
	}


	public void setFechaConsumo(Date fechaConsumo) {
		this.fechaConsumo = fechaConsumo;
	}


	public double getImporteTotal() {
		return importeTotal;
	}


	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}


	public String getIdCliente() {
		return idCliente;
	}
	
	
	
	
	
}
