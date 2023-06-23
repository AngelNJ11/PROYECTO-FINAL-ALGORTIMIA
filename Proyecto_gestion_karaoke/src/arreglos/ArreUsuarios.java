package arreglos;

import java.util.ArrayList;

import clases.ClaseUsuarios;

public class ArreUsuarios {
	
	private ArrayList<ClaseUsuarios> usuarioList;

	public ArreUsuarios(){
		usuarioList = new ArrayList<ClaseUsuarios>();
		adicionar(new ClaseUsuarios(1001, "Arue", "Palma", "Casavarde", 0, "aruepalma", "arue123", 1));
		adicionar(new ClaseUsuarios(1002, "Gustavo", "Osorio", "Hernandez", 1, "gosoher", "1234", 0));
		adicionar(new ClaseUsuarios(1003, "Jennifer", "Vilcapuma", "Chevarria", 2, "jvilche", "1234", 1));
		adicionar(new ClaseUsuarios(1004, "Rosa", "Ugarte", "Villafuerte", 2, "rugavil", "1234", 0));
		adicionar(new ClaseUsuarios(1005, "Felipe", "Hurtado", "Solis", 1, "fhursol", "1234", 1));
		adicionar(new ClaseUsuarios(1006, "jaun", "mendes", "Lopez", 2, "juan12", "12345",0));
	}
	
	public void adicionar(ClaseUsuarios x){
		usuarioList.add(x);
	}
	
	public int tamanio(){
		return usuarioList.size();
	}
	
	public ClaseUsuarios obtener(int posicion){
		return usuarioList.get(posicion);
	}
	
	public void eliminar(ClaseUsuarios x){
		usuarioList.remove(x);
	}
	
	public ClaseUsuarios buscacod(int codigo){
		for(ClaseUsuarios usuario : usuarioList){
			if(usuario.getIdUsuario() == codigo){
				return usuario;
			}
		}
		return null;
	}
	
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 1001;
		else
			return obtener(tamanio()-1).getIdUsuario() + 1;		
	}

	
	
	
}