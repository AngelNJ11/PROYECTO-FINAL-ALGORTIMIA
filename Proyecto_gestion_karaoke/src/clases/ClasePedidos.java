package clases;

import java.util.Date;

import arreglos.ArreBebidas;
import arreglos.ArreCanciones;
import arreglos.ArrePiqueos;



public class ClasePedidos {

	
	ClaseUsuarios idusuario = new ClaseUsuarios();
	ClaseCliente idcliente = new ClaseCliente();
	ArreCanciones canciones = new ArreCanciones();
	ArreBebidas bebidas = new ArreBebidas();
	ArrePiqueos piqueos = new ArrePiqueos();
	
	private String idPedido;
	private Date fechaPedido;
	private int idUsuario = idusuario.getIdUsuario();
	private String idCliente = idcliente.getIdCliente();
	private int estado;




	
	
}