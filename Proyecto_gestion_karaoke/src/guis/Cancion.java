package guis;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class Cancion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdCancion;
	private JTextField txtNombre;
	private JTextField txtIdArtista;
	private JTextField txtAlbum;
	private JTextField txtFecRegistro;
	private JTextField txtNumReproducion;
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JLabel lblIdArtista;
	private JLabel lblAlbum;
	private JLabel lblFechaRegistro;
	private JLabel lblNumeroDeReproducciones;
	private JLabel lblEstado;
	private JComboBox<String> comboBox;
	private JButton btnAceptar;
	private JButton btnListar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cancion dialog = new Cancion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cancion() {
		setTitle("Cancion");
		setBounds(100, 100, 880, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel = new JLabel("Id Cancion:");
			lblNewLabel.setBounds(10, 11, 100, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 36, 100, 14);
			contentPanel.add(lblNombre);
		}
		{
			lblIdArtista = new JLabel("Id Artista:");
			lblIdArtista.setBounds(10, 61, 100, 14);
			contentPanel.add(lblIdArtista);
		}
		{
			lblAlbum = new JLabel("Album:");
			lblAlbum.setBounds(10, 86, 100, 14);
			contentPanel.add(lblAlbum);
		}
		{
			lblFechaRegistro = new JLabel("Fecha Registro:");
			lblFechaRegistro.setBounds(241, 11, 89, 14);
			contentPanel.add(lblFechaRegistro);
		}
		{
			lblNumeroDeReproducciones = new JLabel("Numero de Reproducciones:");
			lblNumeroDeReproducciones.setBounds(241, 36, 167, 14);
			contentPanel.add(lblNumeroDeReproducciones);
		}
		{
			lblEstado = new JLabel("Estado:");
			lblEstado.setBounds(241, 61, 46, 14);
			contentPanel.add(lblEstado);
		}
		{
			txtIdCancion = new JTextField();
			txtIdCancion.setEditable(false);
			txtIdCancion.setBounds(120, 8, 111, 20);
			contentPanel.add(txtIdCancion);
			txtIdCancion.setColumns(10);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(120, 33, 111, 20);
			contentPanel.add(txtNombre);
		}
		{
			txtIdArtista = new JTextField();
			txtIdArtista.setEditable(false);
			txtIdArtista.setColumns(10);
			txtIdArtista.setBounds(120, 58, 111, 20);
			contentPanel.add(txtIdArtista);
		}
		{
			txtAlbum = new JTextField();
			txtAlbum.setColumns(10);
			txtAlbum.setBounds(120, 83, 111, 20);
			contentPanel.add(txtAlbum);
		}
		{
			txtFecRegistro = new JTextField();
			txtFecRegistro.setColumns(10);
			txtFecRegistro.setBounds(410, 8, 111, 20);
			contentPanel.add(txtFecRegistro);
		}
		{
			txtNumReproducion = new JTextField();
			txtNumReproducion.setColumns(10);
			txtNumReproducion.setBounds(410, 33, 111, 20);
			contentPanel.add(txtNumReproducion);
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 844, 239);
		contentPanel.add(scrollPane);
		{
			table = new JTable();
			scrollPane.setViewportView(table);
		}
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(765, 7, 89, 23);
		contentPanel.add(btnListar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(765, 32, 89, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(765, 57, 89, 23);
		contentPanel.add(btnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(531, 7, 89, 23);
		contentPanel.add(btnAceptar);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Inhabilitado", "Habilitado"}));
		comboBox.setBounds(410, 58, 111, 20);
		contentPanel.add(comboBox);
	}
}
