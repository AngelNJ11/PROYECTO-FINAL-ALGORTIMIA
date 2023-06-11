package clases;

import java.util.Date;



public class ClasePedidos {

	
	ClaseUsuarios usuario = new ClaseUsuarios();
	ClaseCliente cliente = new ClaseCliente();
	ClaseBebida bebidas = new ClaseBebida();
	ClasePiqueo piqueos = new ClasePiqueo();

	
					//PED0001
	private Date fechaPedido;
	private  String idPiqueo;
	private final int idUsuario = usuario.getIdUsuario();
	private final String idCliente = cliente.getIdCliente();
						 //0 = Pendiente  1 = Atendido  2 = Anulado
	private  int estado = 0;




	public ClasePedidos() {

	}




	public Date getFechaPedido() {
		return fechaPedido;
	}




	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}




	public String getIdPiqueo() {
		return idPiqueo;
	}




	public void setIdPiqueo(String idPiqueo) {
		this.idPiqueo = idPiqueo;
	}




	public int getIdUsuario() {
		return idUsuario;
	}




	public String getIdCliente() {
		return idCliente;
	}




	public int getEstado() {
		return estado;
	}




	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}