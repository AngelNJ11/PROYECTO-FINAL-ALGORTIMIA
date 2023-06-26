package clases;

import java.util.Date;

import arreglos.ArreBebidas;
import arreglos.ArreCanciones;
import arreglos.ArrePiqueos;



public class ClasePedidos {

	
	ClaseUsuarios usuario = new ClaseUsuarios();
	ClaseCliente cliente = new ClaseCliente();
	ArreCanciones canciones = new ArreCanciones();
	ArreBebidas bebidas = new ArreBebidas();
	ArrePiqueos piqueos = new ArrePiqueos();
	
	private String idPedido;
	private Date fechaPedido;
	private String idUsuario = usuario.getIdUsuario();
	private String idCliente = cliente.getIdCliente();
	private int estado;
	
	
	
	
	public ClasePedidos() {
		super();
	}




	public ClasePedidos(String idPedido, Date fechaPedido, String idUsuario, String idCliente, int estado) {
		this.idPedido = idPedido;
		this.fechaPedido = fechaPedido;
		this.idUsuario = idUsuario;
		this.idCliente = idCliente;
		this.estado = estado;
	}




	public String getIdPedido() {
		return idPedido;
	}




	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}




	public Date getFechaPedido() {
		return fechaPedido;
	}




	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}




	public String getIdUsuario() {
		return idUsuario;
	}




	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}




	public String getIdCliente() {
		return idCliente;
	}




	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}




	public int getEstado() {
		return estado;
	}




	public void setEstado(int estado) {
		this.estado = estado;
	}


	public String estado(int estado){
		switch (estado) {
		case 1:
			return "Atendido";
		case 2:
			return "Anulado";
		default:
			return "Pendiente";
		}
	}
	

	
	
}