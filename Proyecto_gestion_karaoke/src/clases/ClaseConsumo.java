package clases;

import java.time.LocalDate;
import java.util.Date;

public class ClaseConsumo {

	
	ClaseCliente cliente = new ClaseCliente();

	
	// Atrubutos privados 
	
					//CON0001
	private  String idConsumo;
	private final String idCliente = cliente.getIdCliente();
	private  Date fechaConsumo;
	private  double importeTotal;
	
	
	
	// constructores
	
	public ClaseConsumo() {
		
	}


	public ClaseConsumo(ClaseCliente cliente, String idConsumo, Date fechaConsumo, double importeTotal) {

		this.cliente = cliente;
		this.idConsumo = idConsumo;
		this.fechaConsumo = fechaConsumo;
		this.importeTotal = importeTotal;
	}


	// get y seters
	
	public String getCodigoConsumo() {
		return idConsumo;
	}


	public void setCodigoConsumo(String codigoConsumo) {
		this.idConsumo = codigoConsumo;
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
	
	
	// metodos
	
	
	
}
