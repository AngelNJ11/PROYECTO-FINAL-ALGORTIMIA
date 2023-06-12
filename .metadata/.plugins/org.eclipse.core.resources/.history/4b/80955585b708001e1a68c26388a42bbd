package arreglos;

import java.util.ArrayList;

import clases.ClaseUsuarios;

public class ArreUsuarios {
	
	private ArrayList<ClaseUsuarios> usuarioList;

	public ArreUsuarios(){
		usuarioList = new ArrayList<ClaseUsuarios>();
		adicionar(new ClaseUsuarios(1, "Arue", "Palma", "Casavarde", 0, "aruepalma", "arue123", -1));
		adicionar(new ClaseUsuarios(2, "Gustavo", "Osorio", "Hernandez", 1, "gosoher", "1234", 0));
		adicionar(new ClaseUsuarios(3, "Jennifer", "Vilcapuma", "Chevarria", 2, "jvilche", "1234", 1));
		adicionar(new ClaseUsuarios(4, "Rosa", "Ugarte", "Villafuerte", 2, "rugavil", "1234", 0));
		adicionar(new ClaseUsuarios(5, "Felipe", "Hurtado", "Solis", 2, "fhursol", "1234", 1));
		adicionar(new ClaseUsuarios(6, "jaun", "mendes", "Lopez", 3, "juan12", "12345",0));

		adicionar(new ClaseUsuarios(8, "Jesus", "Gutierrez", "Ortega", 0, "Jes345", "0123",0));
		adicionar(new ClaseUsuarios(9, "Pablo", "Torres", "x", 0, "x", "x",0));
		adicionar(new ClaseUsuarios(10, "Pablo", "Jimenez", "Gonzales", 2, "x", "x",0));

	}
	
	public void adicionar(ClaseUsuarios nuevoUsuario){
		usuarioList.add(nuevoUsuario);
	}
	
	public int tamanio(){
		return usuarioList.size();
	}
	
	public ClaseUsuarios obtener(int posicion){
		return usuarioList.get(posicion);
	}
	
	public ClaseUsuarios buscacod(int codigo){
		for(ClaseUsuarios usuario : usuarioList){
			if(usuario.getIdUsuario() == codigo){
				return usuario;
			}
		}
		return null;
	}
}