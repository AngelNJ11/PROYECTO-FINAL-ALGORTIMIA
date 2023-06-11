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

public class Cliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtApPaterno;
	private JTextField txtApMaterno;
	private JTextField txtNombres;
	private JTextField txtDNI;
	private JTextField txtEstadoCivil;
	private JTextField textDireccion;
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
	private JButton btnListar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblDireccion;
	private JLabel lblFecNacimiento;
	private JLabel lblFecAfiliacion;
	private JLabel lblTelefono;
	private JLabel lblTipoCliente;
	private JComboBox<String> cmbTipoCliente;
	private JTable table;

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
		setBounds(100, 100, 960, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblIdCliente = new JLabel("Id Cliente:");
		lblIdCliente.setBounds(10, 11, 130, 14);
		contentPanel.add(lblIdCliente);
		
		lblApPaterno = new JLabel("Apellido Paterno:");
		lblApPaterno.setBounds(10, 36, 130, 14);
		contentPanel.add(lblApPaterno);
		
		lblApMaterno = new JLabel("Apellido Materno:");
		lblApMaterno.setBounds(10, 61, 130, 14);
		contentPanel.add(lblApMaterno);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 86, 130, 14);
		contentPanel.add(lblNombres);
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(330, 11, 130, 14);
		contentPanel.add(lblDireccion);
		
		lblFecNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFecNacimiento.setBounds(330, 36, 130, 14);
		contentPanel.add(lblFecNacimiento);
		
		lblFecAfiliacion = new JLabel("Fecha de Afiliacion:\r\n");
		lblFecAfiliacion.setBounds(330, 61, 130, 14);
		contentPanel.add(lblFecAfiliacion);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(330, 86, 130, 14);
		contentPanel.add(lblTelefono);
		
		lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(10, 111, 130, 14);
		contentPanel.add(lblDNI);
		
		lblTipoCliente = new JLabel("Tipo de Cliente:");
		lblTipoCliente.setBounds(330, 111, 130, 14);
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
		txtApPaterno.setBounds(134, 33, 120, 20);
		contentPanel.add(txtApPaterno);
		
		txtApMaterno = new JTextField();
		txtApMaterno.setColumns(10);
		txtApMaterno.setBounds(134, 58, 120, 20);
		contentPanel.add(txtApMaterno);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(134, 83, 120, 20);
		contentPanel.add(txtNombres);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(134, 108, 120, 20);
		contentPanel.add(txtDNI);
		
		txtEstadoCivil = new JTextField();
		txtEstadoCivil.setColumns(10);
		txtEstadoCivil.setBounds(134, 133, 120, 20);
		contentPanel.add(txtEstadoCivil);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(470, 8, 200, 20);
		contentPanel.add(textDireccion);
		
		txtFecNacimiento = new JTextField();
		txtFecNacimiento.setColumns(10);
		txtFecNacimiento.setBounds(470, 33, 200, 20);
		contentPanel.add(txtFecNacimiento);
		
		txtFecAfiliacion = new JTextField();
		txtFecAfiliacion.setColumns(10);
		txtFecAfiliacion.setBounds(470, 58, 200, 20);
		contentPanel.add(txtFecAfiliacion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(470, 83, 200, 20);
		contentPanel.add(txtTelefono);
		
		cmbTipoCliente = new JComboBox<String>();
		cmbTipoCliente.setModel(new DefaultComboBoxModel<String>(new String[] {"Estandar", "Bronce", "Plata", "Oro", "Diamante"}));
		cmbTipoCliente.setBounds(470, 107, 120, 22);
		contentPanel.add(cmbTipoCliente);
		
		scrollResultado = new JScrollPane();
		scrollResultado.setBounds(10, 161, 924, 339);
		contentPanel.add(scrollResultado);
		
		table = new JTable();
		scrollResultado.setViewportView(table);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(845, 7, 89, 23);
		contentPanel.add(btnListar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(845, 32, 89, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(845, 57, 89, 23);
		contentPanel.add(btnEliminar);
	}
}
