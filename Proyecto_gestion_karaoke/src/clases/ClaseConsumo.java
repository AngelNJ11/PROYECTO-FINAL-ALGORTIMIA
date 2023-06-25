package clases;

import java.util.Date;

public class ClaseConsumo {

	

	
	// Atrubutos privados 
	
					//CON0001
	private  String idConsumo;
	private  ClaseCliente cliente;
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


	public String getIdConsumo() {
		return idConsumo;
	}


	public void setIdConsumo(String idConsumo) {
		this.idConsumo = idConsumo;
	}


	public ClaseCliente getCliente() {
		return cliente;
	}


	public void setCliente(ClaseCliente cliente) {
		this.cliente = cliente;
	}



	
	
	// metodos
	
	
	
}
