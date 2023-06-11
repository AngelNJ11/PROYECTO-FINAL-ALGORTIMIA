package guis;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class Artista extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdArtista;
	private JTextField txtNomArtista;
	private JTextField txtIdGenero;
	private JTextField txtFechaRegisto;
	private JTable table;
	private JLabel lblIdArtista;
	private JLabel lblNombreartistico;
	private JLabel lblIdGenero;
	private JLabel lblFechaRegistro;
	private JLabel lblEstado;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JComboBox<String> cbmEstado;
	private JButton btnListar;
	private JButton btnModificar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Artista dialog = new Artista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Artista() {
		setTitle("Artista");
		setBounds(100, 100, 740, 510);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblIdArtista = new JLabel("Id Artista:");
		lblIdArtista.setBounds(10, 11, 134, 14);
		contentPanel.add(lblIdArtista);
		
		lblNombreartistico = new JLabel("Nombre Artistico:");
		lblNombreartistico.setBounds(10, 36, 134, 14);
		contentPanel.add(lblNombreartistico);
		
		lblIdGenero = new JLabel("Id Genero:");
		lblIdGenero.setBounds(10, 61, 134, 14);
		contentPanel.add(lblIdGenero);
		
		lblFechaRegistro = new JLabel("Fecha Registro:");
		lblFechaRegistro.setBounds(10, 86, 134, 14);
		contentPanel.add(lblFechaRegistro);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 111, 134, 14);
		contentPanel.add(lblEstado);
		
		txtIdArtista = new JTextField();
		txtIdArtista.setEditable(false);
		txtIdArtista.setBounds(117, 8, 123, 20);
		contentPanel.add(txtIdArtista);
		txtIdArtista.setColumns(10);
		
		txtNomArtista = new JTextField();
		txtNomArtista.setColumns(10);
		txtNomArtista.setBounds(117, 33, 123, 20);
		contentPanel.add(txtNomArtista);
		
		txtIdGenero = new JTextField();
		txtIdGenero.setEditable(false);
		txtIdGenero.setColumns(10);
		txtIdGenero.setBounds(117, 58, 123, 20);
		contentPanel.add(txtIdGenero);
		
		txtFechaRegisto = new JTextField();
		txtFechaRegisto.setColumns(10);
		txtFechaRegisto.setBounds(117, 83, 123, 20);
		contentPanel.add(txtFechaRegisto);
		
		cbmEstado = new JComboBox<String>();
		cbmEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"Inhabilitado", "Habilitado"}));
		cbmEstado.setBounds(117, 108, 123, 20);
		contentPanel.add(cbmEstado);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(625, 7, 89, 23);
		contentPanel.add(btnListar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(625, 32, 89, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(625, 57, 89, 23);
		contentPanel.add(btnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(250, 7, 89, 23);
		contentPanel.add(btnAceptar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 704, 324);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
