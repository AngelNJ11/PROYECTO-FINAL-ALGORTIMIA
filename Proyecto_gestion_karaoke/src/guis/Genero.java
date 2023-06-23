package guis;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Genero extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtGenero;
	private JTextField txtDescripcion;
	private JTextField txtEpoca;
	private JComboBox<String> cmbEstado;
	private JLabel lblEstado;
	private JLabel lblEpoca;
	private JLabel lblDescripcion;
	private JLabel lblGenero;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnBuscar;
	private JButton btnOpciones;
	private JButton btnNuevo;
	private JButton btnAceptar;
	private JButton btnListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Genero dialog = new Genero();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Genero() {
		setTitle("Genero");
		setBounds(100, 100, 806, 505);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblGenero = new JLabel("Id Genero");
		lblGenero.setBounds(10, 11, 86, 14);
		contentPanel.add(lblGenero);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 36, 86, 14);
		contentPanel.add(lblDescripcion);
		
		lblEpoca = new JLabel("Epoca");
		lblEpoca.setBounds(10, 61, 86, 14);
		contentPanel.add(lblEpoca);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 86, 86, 14);
		contentPanel.add(lblEstado);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(120, 8, 120, 20);
		contentPanel.add(txtGenero);
		txtGenero.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(120, 33, 120, 20);
		contentPanel.add(txtDescripcion);
		
		txtEpoca = new JTextField();
		txtEpoca.setColumns(10);
		txtEpoca.setBounds(120, 58, 120, 20);
		contentPanel.add(txtEpoca);
		
		cmbEstado = new JComboBox<String>();
		cmbEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"Habilitado", "Inhabilitado"}));
		cmbEstado.setBounds(120, 83, 120, 20);
		contentPanel.add(cmbEstado);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(679, 57, 97, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(679, 82, 97, 23);
		contentPanel.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 766, 294);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(252, 6, 97, 25);
		contentPanel.add(btnBuscar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.setBounds(578, 13, 97, 92);
		contentPanel.add(btnOpciones);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(679, 6, 97, 25);
		contentPanel.add(btnNuevo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(252, 31, 97, 25);
		contentPanel.add(btnAceptar);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(679, 31, 97, 25);
		contentPanel.add(btnListar);
	}
	public void actionPerformed(ActionEvent arg0) {
	}
}
