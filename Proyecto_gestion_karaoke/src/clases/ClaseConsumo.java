package clases;

import java.time.LocalDate;
import java.util.Date;

public class ClaseConsumo {

	
	ClaseCliente cliente = new ClaseCliente();

	
	// Atrubutos privados 
	
					//CON0001
	private  String codigoConsumo;
	private final String idCliente = cliente.getIdCliente();
	private  Date fechaConsumo;
	private  double importeTotal;
	
	Date fachaConsumo = new Date();
	
	
	// constructores
	
	public ClaseConsumo() {
		
	}


	public ClaseConsumo(ClaseCliente cliente, String codigoConsumo, Date fechaConsumo, double importeTotal) {

		
		this.cliente = cliente;
		this.codigoConsumo = codigoConsumo;
		this.fechaConsumo = fechaConsumo;
		this.importeTotal = importeTotal;
	}


	// get y seters
	
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
	
	
	// metodos
	
	

	public String correlativ(int codigo){
		String cod = "CON" + String.format("%03d", codigo);
		return cod;
	}
	
}
