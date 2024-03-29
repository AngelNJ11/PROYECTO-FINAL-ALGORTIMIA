package helpers;

import javax.swing.JComboBox;

import arreglos.ArreArtistas;
import arreglos.ArreGeneros;
import clases.ClaseArtista;
import clases.ClaseGenero;

public class JComboBoxData extends JComboBox<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JComboBoxData(String nombreClase) {
		addItem("[seleccione]");

		switch (nombreClase) {
		case "GENERO":
			ArreGeneros arrGeneros = new ArreGeneros();
			ClaseGenero genero;
			for (int i = 0; i < arrGeneros.tamanio(); i++) {
				genero = arrGeneros.obtener(i);
				if (genero.isEstado())
					addItem(genero.getIdGenero() + ":" + genero.getDescripcion());
			}
			break;
		case "ARTISTA":
			ArreArtistas arrArtistas = new ArreArtistas();
			ClaseArtista artista;
			for (int i = 0; i < arrArtistas.tamanio(); i++) {
				artista = arrArtistas.obtener(i);
				if (artista.isEstado())
					addItem(artista.getIdArtista() + ":" + artista.getNombreArtistico());
			}
			break;
		default:
			break;
		}
	}
}
