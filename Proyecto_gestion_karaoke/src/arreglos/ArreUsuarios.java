package arreglos;

import java.util.ArrayList;

import clases.ClaseUsuarios;

public class ArreUsuarios {
	
	private ArrayList<ClaseUsuarios> usuarios;

	public ArreUsuarios(){
		usuarios = new ArrayList<ClaseUsuarios>();
		adicionar(new ClaseUsuarios("USU001", "Arue", "Palma", "Casavarde", 0, "aruepalma", "arue123", 1));
		adicionar(new ClaseUsuarios("USU002", "Gustavo", "Osorio", "Hernandez", 1, "gosoher", "1234", 0));
		adicionar(new ClaseUsuarios("USU003", "Jennifer", "Vilcapuma", "Chevarria", 2, "jvilche", "1234", 1));
		adicionar(new ClaseUsuarios("USU004", "Rosa", "Ugarte", "Villafuerte", 2, "rugavil", "1234", 0));
		adicionar(new ClaseUsuarios("USU005", "Felipe", "Hurtado", "Solis", 1, "fhursol", "1234", 1));
		adicionar(new ClaseUsuarios("USU006", "jaun", "mendes", "Lopez", 2, "juan12", "12345",0));
	}
	
	public void adicionar(ClaseUsuarios x){
		usuarios.add(x);
	}
	
	public int tamanio(){
		return usuarios.size();
	}
	
	public ClaseUsuarios obtener(int posicion){
		return usuarios.get(posicion);
	}
	
	public void eliminar(ClaseUsuarios x){
		usuarios.remove(x);
	}
	
	public ClaseUsuarios buscacod(String codigo){
		for(ClaseUsuarios usuario : usuarios){
			if(usuario.getIdUsuario().equals(codigo)){
				return usuario;
			}
		}
		return null;
	}
	
	public ClaseUsuarios buscarUsuLogin(String login, String Password, int tipoEmpleado){
		
		for(ClaseUsuarios usuario : usuarios){
			if(usuario.getLogin().equals(login)){
				if(usuario.getPassword().equals(Password)){
					if (usuario.getTipoEmpleado() == tipoEmpleado) {
						return usuario;
					}
				}
			}
		}
		return null;
	}

	
	

	
	public String generarCodigoCorrelativo(String codigoAnterior) {
		if (tamanio() == 0) {
			return "USU001";
		}else {
			String codigo = codigoAnterior.substring(3);
		    int correlativo = Integer.parseInt(codigo) + 1; 
		    String nuevoCodigo = "USU" + String.format("%03d", correlativo); 
		    return nuevoCodigo;
		}
	}

	
	
	
}