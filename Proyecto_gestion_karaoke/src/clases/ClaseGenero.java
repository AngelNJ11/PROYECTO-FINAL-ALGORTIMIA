package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClaseGenero {
	private  String idGenero;
	private  String descripcion;
	private  int epoca = 2012;
	private  boolean estado;
	
	
	
	public ClaseGenero() {
		
	}
	
	public ClaseGenero(String idGenero, String descripcion, int epoca, boolean estado) {

		this.idGenero = idGenero;
		this.descripcion = descripcion;
		this.epoca = epoca;
		this.estado = estado;
	}

	public String getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(String idGenero) {
		this.idGenero = idGenero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEpoca() {
		return epoca;
	}

	public void setEpoca(int epoca) {
		this.epoca = epoca;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String correlativoGenero(int codigo){
		String cod = "GEN" + String.format("%03d", codigo);
		return cod;
	}
	
	public String ObsEstado(){	
		if (estado) {
			return "Habilitado";	
		}
		else{
			return "Inhabilitado";
		}
	}
	
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
	
	public void fechaEpoca(){
		Date fechaActual = new Date();
		System.out.print(DateString(fechaActual));
	}
	
	public static String DateString(Date fecha){
		String fechaCadena = sdf.format(fecha);
		return fechaCadena;
	}
	

}
