package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import clases.ClaseCliente;



public class ArreCliente {

	
	private ArrayList<ClaseCliente> cliente;

	public ArreCliente(){
		cliente = new ArrayList<ClaseCliente>();
		cargarCliente();
	}
	
	public void adicionar(ClaseCliente  x){
		cliente=new ArrayList<ClaseCliente>();
		grabarCliente();
	}
	
	public int tamanio(){
		return cliente.size();
	}
	
	public ClaseCliente obtener(int posicion){
		return cliente.get(posicion);
	}
	
	public void eliminar(ClaseCliente x){
		cliente.remove(x);
		grabarCliente();
	}
	
	public void actualizarArchivo() {
		grabarCliente();
	}
	
	public ClaseCliente buscarPorID(String codigo){
		for(ClaseCliente cliente : cliente){
			if(cliente.getIdCliente().equals(codigo)){
				return cliente;
			}
		}
		return null;
	}
	

	
	public String generarCodigoCorrelativo(String codigoAnterior) {
		if (tamanio() == 0) {
			return "CLI001";
		}else {
			String codigo = codigoAnterior.substring(3);
		    int correlativo = Integer.parseInt(codigo) + 1; 
		    String nuevoCodigo = "CLI" + String.format("%03d", correlativo); 
		    return nuevoCodigo;
		}
	}
	
	
	public void grabarCliente() {
		try {
			PrintWriter pw;
			String linea;
			ClaseCliente cliente;
			pw = new PrintWriter(new FileWriter("clientes.txt"));
			for (int i = 0; i < tamanio(); i++) {
				cliente = obtener(i);
				String dato1 = cliente.getIdCliente() + ";";
				String dato2 = cliente.getNombres() + ";";
				String dato3 = cliente.getApellidoPaterno() + ";";
				String dato4 = cliente.getApellidoMaterno() + ";";
				String dato5 = cliente.getDireccion() + ";";
				String dato6 = cliente.fechaNacimiento() + ";";
				String dato7 = cliente.fechaAfilacion() + ";";
				String dato8 = cliente.getEstadoCivil() + ";";
				String dato9 = cliente.getTelefono() + ";";
				String dato10 = cliente.getDni() + ";";
				int dato11 = cliente.getTipoDelCliente();

				linea = dato1 + 
						dato2 + 
						dato3 + 
						dato4 + 
						dato5 + 
						dato6 + 
						dato7 + 
						dato8 +
						dato9 + 
						dato10 + 
						dato11;
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void cargarCliente() {
		try {
			BufferedReader br;
			String linea;
			String[] datos;
			br = new BufferedReader(new FileReader("clientes.txt"));
			while ((linea = br.readLine()) != null) {
				datos = linea.split(";");
				
				String idCliente = datos[0];
				String nombres = datos[1];
				String apepaternos = datos[2];
				String apematernos = datos[3];
				String dirreccion = datos[4];
				Date fechaNacimiento = fechaComoDate(datos[5]);
				Date fechaAfilacion = fechaComoDate(datos[6]);
				int estadoCivil = Integer.parseInt(datos[7]);
				String telefono = datos[8];
				String dni = datos[9];
				int tipoCliente = Integer.parseInt(datos[10]);
				adicionar(new ClaseCliente(idCliente,nombres,apepaternos,apematernos,dirreccion,fechaNacimiento,fechaAfilacion,estadoCivil,telefono,dni,tipoCliente));
			}
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Date fechaComoDate(String fechaText) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaComoDate = null;
		try {
			fechaComoDate = formatter.parse(fechaText);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fechaComoDate;
	}
	
	
}
