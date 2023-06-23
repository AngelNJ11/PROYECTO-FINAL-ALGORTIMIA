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

public class Cliente extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtApPaterno;
	private JTextField txtApMaterno;
	private JTextField txtNombres;
	private JTextField txtDNI;
	private JTextField txtDireccion;
	private JTextField txtFecNacimiento;
	private JTextField txtFecAfiliacion;
	private JTextField txtTelefono;
	private JTextField txtCliente;
	private JLabel lblIdCliente;
	private JLabel lblApPaterno;
	private JLabel lblApMaterno;
	private JLabel lblNombres;
	private JLabel lblDNI;
	private JLabel lblEstadoCivil;
	private JScrollPane scrollResultado;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblDireccion;
	private JLabel lblFecNacimiento;
	private JLabel lblFecAfiliacion;
	private JLabel lblTelefono;
	private JLabel lblTipoCliente;
	private JComboBox<String> cmbTipoCliente;
	private JTable table;
	private JComboBox<String> cmbEstadoCivil;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cliente dialog = new Cliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cliente() {
		setTitle("Cliente");
		setBounds(100, 100, 1014, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblIdCliente = new JLabel("ID Cliente:");
		lblIdCliente.setBounds(10, 11, 130, 14);
		contentPanel.add(lblIdCliente);
		
		lblApPaterno = new JLabel("Apellido Paterno:");
		lblApPaterno.setBounds(10, 60, 130, 14);
		contentPanel.add(lblApPaterno);
		
		lblApMaterno = new JLabel("Apellido Materno:");
		lblApMaterno.setBounds(10, 86, 130, 14);
		contentPanel.add(lblApMaterno);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 34, 130, 14);
		contentPanel.add(lblNombres);
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(266, 11, 130, 14);
		contentPanel.add(lblDireccion);
		
		lblFecNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFecNacimiento.setBounds(266, 34, 143, 14);
		contentPanel.add(lblFecNacimiento);
		
		lblFecAfiliacion = new JLabel("Fecha de Afiliacion:\r\n");
		lblFecAfiliacion.setBounds(266, 60, 143, 14);
		contentPanel.add(lblFecAfiliacion);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(266, 86, 130, 14);
		contentPanel.add(lblTelefono);
		
		lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(10, 111, 130, 14);
		contentPanel.add(lblDNI);
		
		lblTipoCliente = new JLabel("Tipo de Cliente:");
		lblTipoCliente.setBounds(266, 112, 130, 14);
		contentPanel.add(lblTipoCliente);
		
		lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setBounds(10, 136, 130, 14);
		contentPanel.add(lblEstadoCivil);
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setBounds(134, 8, 120, 20);
		contentPanel.add(txtCliente);
		txtCliente.setColumns(10);
		
		txtApPaterno = new JTextField();
		txtApPaterno.setColumns(10);
		txtApPaterno.setBounds(134, 57, 120, 20);
		contentPanel.add(txtApPaterno);
		
		txtApMaterno = new JTextField();
		txtApMaterno.setColumns(10);
		txtApMaterno.setBounds(134, 83, 120, 20);
		contentPanel.add(txtApMaterno);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(134, 31, 120, 20);
		contentPanel.add(txtNombres);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(134, 108, 120, 20);
		contentPanel.add(txtDNI);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(421, 8, 200, 20);
		contentPanel.add(txtDireccion);
		
		txtFecNacimiento = new JTextField();
		txtFecNacimiento.setColumns(10);
		txtFecNacimiento.setBounds(421, 31, 200, 20);
		contentPanel.add(txtFecNacimiento);
		
		txtFecAfiliacion = new JTextField();
		txtFecAfiliacion.setColumns(10);
		txtFecAfiliacion.setBounds(421, 57, 200, 20);
		contentPanel.add(txtFecAfiliacion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(421, 83, 200, 20);
		contentPanel.add(txtTelefono);
		
		cmbTipoCliente = new JComboBox<String>();
		cmbTipoCliente.setModel(new DefaultComboBoxModel<String>
		(new String[] {"Estandar", "Bronce", "Plata", "Oro", "Diamante"}));
		cmbTipoCliente.setBounds(421, 108, 120, 22);
		contentPanel.add(cmbTipoCliente);
		
		scrollResultado = new JScrollPane();
		scrollResultado.setBounds(10, 161, 993, 339);
		contentPanel.add(scrollResultado);
		
		table = new JTable();
		scrollResultado.setViewportView(table);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(914, 10, 89, 23);
		contentPanel.add(btnNuevo);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(914, 60, 89, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(914, 86, 89, 23);
		contentPanel.add(btnEliminar);
		
		cmbEstadoCivil = new JComboBox<String>();
		cmbEstadoCivil.setModel(new DefaultComboBoxModel<String>
		(new String[] {"soltero", "Casado", "Viudo", "Divorciado", "No especificada "}));
		cmbEstadoCivil.setBounds(134, 133, 120, 22);
		contentPanel.add(cmbEstadoCivil);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(914, 34, 89, 23);
		contentPanel.add(btnConsultar);
		
		JButton btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(762, 8, 140, 95);
		contentPanel.add(btnOpciones);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(622, 11, 120, 23);
		contentPanel.add(btnBuscar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(622, 36, 120, 23);
		contentPanel.add(btnAceptar);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}
