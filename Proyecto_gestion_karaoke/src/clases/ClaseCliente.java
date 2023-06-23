package clases;

import java.util.Date;

public class ClaseCliente {

					//CLI001
	private  String idCliente;
	private  String nombres;
	private  String apellidoPaterno;
	private  String apellidoMaternoo;
	private  String dni;
	private  Date fechaNacimiento;
	private  Date fechaAfilacion;
	//S = soltero  C = Casado  V = Viudo D = Divorciado  N = No especificada 
	private  String estadoCivil;
	private  String telefono;
	//0 = Estandar  1 = Bronce  2 = Plata 3 = Oro  4 = Diamante
	private int tipoDelCliente;
	
	
	
	
	

	public ClaseCliente() {
							
	}

	public ClaseCliente(String idCliente, String nombres, String apellidoPaterno, 
			       String apellidoMaternoo, String dni, Date fechaNacimiento, Date fechaAfilacion,
			  	   String estadoCivil, String telefono, int tipoDelCliente) {
		this.idCliente = idCliente;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaternoo = apellidoMaternoo;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAfilacion = fechaAfilacion;
		this.estadoCivil = estadoCivil;
		this.telefono = telefono;
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

	public String getApellidoMaternoo() {
		return apellidoMaternoo;
	}

	public void setApellidoMaternoo(String apellidoMaternoo) {
		this.apellidoMaternoo = apellidoMaternoo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public int getTipoDelCliente() {
		return tipoDelCliente;
	}

	public void setTipoDelCliente(int tipoDelCliente) {
		this.tipoDelCliente = tipoDelCliente;
	}
	
	public String correlativo(int codigo) {
		String newcodigos = "CLI" + String.format("%02d", codigo);
		return newcodigos;
	}
	
	public String obsCivil(int estado){
	    switch (estado) {
	        case 1:
	        	return "S";
	        case 2:
	            return  "C";
	        case 3:
	            return "V";
	        case 4:
	            return "D";
	        default:
	        	return "No especifica";
	    }
	}
	public int obsTipoCli(int tipo){

	    switch (tipo) {
	        case 0:
	            return 0;
	        case 1:
	        	return 1;
	        case 2:
	        	return 2;
	        case 3:
	        	return  3;
	        default:
	        	return 4;
	    }
	}
	
	
}

