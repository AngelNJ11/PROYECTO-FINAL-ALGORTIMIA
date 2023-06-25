package guis;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArreCliente;
import clases.ClaseCliente;
import clases.ClaseUsuarios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manteCliente extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtApPaterno;
	private JTextField txtApMaterno;
	private JTextField txtNombres;
	private JTextField txtDni;
	private JTextField txtDireccion;
	private JTextField txtFecNacimiento;
	private JTextField txtFecAfiliacion;
	private JTextField txtTelefono;
	private JTextField txtIdCliente;
	private JLabel lblIdCliente;
	private JLabel lblApPaterno;
	private JLabel lblApMaterno;
	private JLabel lblNombres;
	private JLabel lblDNI;
	private JLabel lblEstadoCivil;
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblDireccion;
	private JLabel lblFecNacimiento;
	private JLabel lblFecAfiliacion;
	private JLabel lblTelefono;
	private JLabel lblTipoCliente;
	private JComboBox<String> cmbTipoCliente;
	private JTable tbResultado;
	private DefaultTableModel modelo;
	private JComboBox<String> cmbEstadoCivil;
	private JButton btnConsultar;
	
	
	private int tipoOperacion;
	
	// Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR  = 3;
	private JButton btnBuscar;
	private JButton btnAceptar;
	private JButton btnOpciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			manteCliente dialog = new manteCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public manteCliente() {
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
		
		txtIdCliente = new JTextField();
		txtIdCliente.setEditable(false);
		txtIdCliente.setBounds(134, 8, 120, 20);
		contentPanel.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
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
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(134, 108, 120, 20);
		contentPanel.add(txtDni);
		
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 161, 993, 339);
		contentPanel.add(scrollPane);
		
		tbResultado = new JTable();
		tbResultado.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbResultado);
		
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
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(630, 11, 120, 23);
		contentPanel.add(btnBuscar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(630, 36, 120, 23);
		contentPanel.add(btnAceptar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(772, 8, 140, 95);
		contentPanel.add(btnOpciones);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID Cliente");
		modelo.addColumn("Nombre Completo");
		modelo.addColumn("Direccion"); 
		modelo.addColumn("Fecha de nacimiento"); 
		modelo.addColumn("Fecha de afilacion"); 
		modelo.addColumn("Estaado Civil"); 
		modelo.addColumn("Telefono"); 
		modelo.addColumn("DNI"); 
		modelo.addColumn("Tipo de Cliente"); 
		tbResultado.setModel(modelo);
		modelo.setRowCount(0); 
		
		ajustarAnchoColumnas();
		listar();
		
		
	}
	
	ArreCliente arc = new ArreCliente();
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnBuscar){
			actionPerformedbtnBuscar(e);
		}
		if(e.getSource() == btnAceptar){
			actionPerformedbtnAceptar(e);
		}
		if(e.getSource() == btnOpciones){
			actionPerformedbtnOpciones(e);
		}
		if(e.getSource() == btnNuevo){
			actionPerformedbtnNuevo(e);
		}
		if(e.getSource() == btnConsultar){
			actionPerformedbtnConsultar(e);
		}
		if(e.getSource() == btnModificar){
			actionPerformedbtnModificar(e);
		}
		if(e.getSource() == btnEliminar){
			actionPerformedbtnEliminar(e);
		}
	}

	private void actionPerformedbtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		txtIdCliente.setEditable(true);
		habilitarBotones(false);
		txtIdCliente.requestFocus();
	}

	private void actionPerformedbtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		txtIdCliente.setEditable(true);
		habilitarBotones(false);
		txtIdCliente.requestFocus();
	}

	private void actionPerformedbtnConsultar(ActionEvent e) {
		
		tipoOperacion = CONSULTAR;
		txtIdCliente.setEditable(true);
		habilitarBotones(false);
		txtIdCliente.requestFocus();
	}

	private void actionPerformedbtnNuevo(ActionEvent e) {
		tipoOperacion = ADICIONAR;
		txtIdCliente.setText(arc.generarCodigoCorrelativo(arc.obtener(arc.tamanio()-1).getIdCliente()));
		habilitarEntradas(true);
		habilitarBotones(false);

	}

	private void actionPerformedbtnOpciones(ActionEvent e) {
	
		txtIdCliente.setEditable(false);
		limpieza();
		habilitarEntradas(false);
		habilitarBotones(true);
	}

	private void actionPerformedbtnAceptar(ActionEvent e) {
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionarCliente();
			break;
		case CONSULTAR:
			consultarCliente();
			break;
		case MODIFICAR:
			modificarCliente();
			break;
		case ELIMINAR:
			eliminarCliente();
		}
	}

	private void actionPerformedbtnBuscar(ActionEvent e) {
		consultarCliente();
	}
	
	
	void eliminarCliente() {
		// TODO Auto-generated method stub
		
	}

	void modificarCliente() {
		// TODO Auto-generated method stub
		
	}

	void consultarCliente() {
		// TODO Auto-generated method stub
		
	}

	void adicionarCliente() {
		
	}
	
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbResultado.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(6));  
		tcm.getColumn(1).setPreferredWidth(anchoColumna(15));  
		tcm.getColumn(2).setPreferredWidth(anchoColumna(13));  
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10));  
		tcm.getColumn(5).setPreferredWidth(anchoColumna(7));  
		tcm.getColumn(6).setPreferredWidth(anchoColumna(7));  
		tcm.getColumn(6).setPreferredWidth(anchoColumna(7));  

	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	
	void listar() {
		ClaseCliente x;
		modelo.setRowCount(0);
		for (int i=0; i<arc.tamanio(); i++) {
			x = arc.obtener(i);
			Object[] fila = { x.getIdCliente(),
					          x.nombreComple(),
					          x.getDireccion(),
					          x.getFechaNacimiento(),
					          x.getFechaAfilacion(),
					          x.estadoCivil(x.getEstadoCivil()),
					          x.getTelefono(),
					          x.getDni(),
					          x.tipoDeCliente(x.getTipoDelCliente())
							};
			modelo.addRow(fila);
		}
	}
	
	void limpieza() {
		txtIdCliente.setText("");
		txtNombres.setText("");
		txtApPaterno.setText("");
		txtApMaterno.setText("");
		txtDni.setText("");
		txtDireccion.setText("");
		txtFecNacimiento.setText("");
		txtFecAfiliacion.setText("");
		txtTelefono.setText("");
		txtNombres.requestFocus();
	}	
	
	
	void habilitarEntradas(boolean sino) {
		if ((tipoOperacion == ADICIONAR) || (tipoOperacion == MODIFICAR)){
			txtNombres.setEditable(sino);
			txtApPaterno.setEditable(sino);
			txtApMaterno.setEditable(sino);
			txtDni.setEditable(sino);
			cmbEstadoCivil.setEnabled(sino);
			txtDireccion.setEnabled(sino);
			txtFecNacimiento.setEditable(sino);
			txtFecAfiliacion.setEditable(sino);
			txtTelefono.setEditable(sino);
			cmbTipoCliente.setEnabled(sino);
		}
	}
	

	void habilitarBotones(boolean sino) {
		if (tipoOperacion == ADICIONAR){
			btnAceptar.setEnabled(!sino);
			btnBuscar.setEnabled(false);
		}
		else {
			btnBuscar.setEnabled(!sino);
			btnAceptar.setEnabled(!sino);
		}	
		btnNuevo.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnOpciones.setEnabled(!sino);	
	}
	

	
	String leerCodigo() {
		return txtIdCliente.getText().trim();
	}
	String leerNombre() {
		return txtNombres.getText().trim();
	}
	String leerApPaterno() {
		return (txtApPaterno.getText().trim());
	}
	String leerApMaterno() {
		return (txtApMaterno.getText().trim());
	}
	String leerDni() {
		return (txtDni.getText().trim());
	}
	String LeerDireccion() {
		return (txtDireccion.getText().trim());
	}
	String LeerFecNacimiento() {
		return (txtFecNacimiento.getText().trim());
	}
	String LeerFecAfiliacion() {
		return (txtFecAfiliacion.getText().trim());
	}
	String LeerTelefono() {
		return (txtTelefono.getText().trim());
	}
	
	
	
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informaci�n", 0);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	//
	String tipoCliente(int i) {
		return cmbTipoCliente.getItemAt(i);
	}
	
	String estadoCivil(int i) {
		return cmbEstadoCivil.getItemAt(i);
	}
	
	
	
	
	
	
}
