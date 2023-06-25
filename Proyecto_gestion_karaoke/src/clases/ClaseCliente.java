package clases;

import java.util.Date;

public class ClaseCliente {

					//CLI001
	private  String idCliente;
	private  String nombres;
	private  String apellidoPaterno;
	private  String apellidoMaterno;
	private  String direccion;
	private  Date fechaNacimiento;
	private  Date fechaAfilacion;
	//S = soltero  C = Casado  V = Viudo D = Divorciado  N = No especificada 
	private  String estadoCivil;
	private  String telefono;
	private  String dni;
	//0 = Estandar  1 = Bronce  2 = Plata 3 = Oro  4 = Diamante
	private int tipoDelCliente;
	
	
	
	
	

	public ClaseCliente() {
							
	}

	

	public ClaseCliente(String idCliente, String nombres, String apellidoPaterno, String apellidoMaterno,
			String direccion, Date fechaNacimiento, Date fechaAfilacion, String estadoCivil, String telefono,
			String dni, int tipoDelCliente) {
		this.idCliente = idCliente;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAfilacion = fechaAfilacion;
		this.estadoCivil = estadoCivil;
		this.telefono = telefono;
		this.dni = dni;
		this.tipoDelCliente = tipoDelCliente;
	}

	

	
	
	
	
	
	
	
	public String getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}



	public String getNombres() {
		return nombres;
	}



	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public String getApellidoPaterno() {
		return apellidoPaterno;
	}



	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}



	public String getApellidoMaterno() {
		return apellidoMaterno;
	}



	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public Date getFechaAfilacion() {
		return fechaAfilacion;
	}



	public void setFechaAfilacion(Date fechaAfilacion) {
		this.fechaAfilacion = fechaAfilacion;
	}



	public String getEstadoCivil() {
		return estadoCivil;
	}



	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public int getTipoDelCliente() {
		return tipoDelCliente;
	}



	public void setTipoDelCliente(int tipoDelCliente) {
		this.tipoDelCliente = tipoDelCliente;
	}



	public String nombreComple(){
		return String.format("%s %s %s", nombres, apellidoPaterno, apellidoMaterno);
	}
	
	
	public String estadoCivil(String estado){
	    switch (estado) {
	        case "S":
	        	return "Soltero";
	        case "C":
	            return  "Casado";
	        case "V":
	            return "Viudo";
	        case "D":
	            return "Divorciodo";
	        default:
	        	return "No especifica";
	    }
	}
	public String tipoDeCliente(int tipo){

	    switch (tipo) {
	        case 0:
	            return "Estandar";
	        case 1:
	        	return "Bronce";
	        case 2:
	        	return "Plata";
	        case 3:
	        	return  "Oro";
	        case 4:
	        	return "Diamante";
	        default:
	        	return null;
	    }
	}
	
	
}

