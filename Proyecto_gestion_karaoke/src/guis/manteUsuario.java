package guis;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArreUsuarios;
import clases.ClaseUsuarios;

public class manteUsuario extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdUsuario;
	private JTextField txtApPa;
	private JTextField txtApMa;
	private JTextField txtNombre;
	private JTextField txtLogin;
	private JTextField txtPassword;
	private JButton btnBuscar;
	private JButton btnAceptar;
	private JButton btnOpciones;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JComboBox<String> cmbTurno;
	private JComboBox<String> cmbEmpleado;
	private JLabel lblIdUsuario;
	private JLabel lblApellidoMaterno;
	private JLabel lblApellidoPaterno;
	private JLabel lblNombres;
	private JLabel lblTipoDeEmpleado;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JLabel lblTurno;
	private JScrollPane scrollPane;
	private JTable tbResultado;
	private DefaultTableModel modelo;
	
	// Tipo de operaci�n a procesar: Adicionar, Consultar, Modificar o Eliminar
	private int tipoOperacion;
	
	// Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR  = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			manteUsuario dialog = new manteUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public manteUsuario() {
		setTitle("Usuario");
		setBounds(100, 100, 970, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIdUsuario = new JLabel("ID Usuario :");
		lblIdUsuario.setBounds(10, 11, 120, 14);
		contentPane.add(lblIdUsuario);
		
		lblApellidoMaterno = new JLabel("Apellido Materno :");
		lblApellidoMaterno.setBounds(10, 86, 120, 14);
		contentPane.add(lblApellidoMaterno);
		
		lblApellidoPaterno = new JLabel("Apellido Paterno :");
		lblApellidoPaterno.setBounds(10, 61, 120, 14);
		contentPane.add(lblApellidoPaterno);
		
		lblNombres = new JLabel("Nombres :");
		lblNombres.setBounds(10, 36, 120, 14);
		contentPane.add(lblNombres);
		
		lblTipoDeEmpleado = new JLabel("Tipo de empleado :");
		lblTipoDeEmpleado.setBounds(10, 111, 120, 14);
		contentPane.add(lblTipoDeEmpleado);
		
		lblLogin = new JLabel("Login :");
		lblLogin.setBounds(270, 11, 85, 14);
		contentPane.add(lblLogin);
		
		lblPassword = new JLabel("Password :");
		lblPassword.setBounds(270, 36, 85, 14);
		contentPane.add(lblPassword);
		
		lblTurno = new JLabel("Turno :");
		lblTurno.setBounds(270, 61, 85, 14);
		contentPane.add(lblTurno);
		
		txtIdUsuario = new JTextField();
		txtIdUsuario.setEditable(false);
		txtIdUsuario.setBounds(140, 8, 120, 20);
		contentPane.add(txtIdUsuario);
		txtIdUsuario.setColumns(10);
		
		txtApPa = new JTextField();
		txtApPa.setEditable(false);
		txtApPa.setColumns(10);
		txtApPa.setBounds(140, 58, 120, 20);
		contentPane.add(txtApPa);
		
		txtApMa = new JTextField();
		txtApMa.setEditable(false);
		txtApMa.setColumns(10);
		txtApMa.setBounds(140, 83, 120, 20);
		contentPane.add(txtApMa);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(140, 33, 120, 20);
		contentPane.add(txtNombre);
		
		txtLogin = new JTextField();
		txtLogin.setEditable(false);
		txtLogin.setColumns(10);
		txtLogin.setBounds(365, 8, 120, 20);
		contentPane.add(txtLogin);
		
		txtPassword = new JTextField();
		txtPassword.setEditable(false);
		txtPassword.setColumns(10);
		txtPassword.setBounds(365, 33, 120, 20);
		contentPane.add(txtPassword);
		
		cmbEmpleado = new JComboBox<String>();
		cmbEmpleado.setEnabled(false);
		cmbEmpleado.setModel(new DefaultComboBoxModel<String>
		(new String[] {"Administrador ", "Supervisor ", "Mozo"}));
		cmbEmpleado.setBounds(140, 108, 120, 20);
		contentPane.add(cmbEmpleado);
		
		cmbTurno = new JComboBox<String>();
		cmbTurno.setEnabled(false);
		cmbTurno.setModel(new DefaultComboBoxModel<String>
		(new String[] {"Tarde ", "Noche "}));
		cmbTurno.setBounds(365, 58, 120, 20);
		contentPane.add(cmbTurno);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(365, 82, 120, 23);
		contentPane.add(btnBuscar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(365, 107, 120, 23);
		contentPane.add(btnAceptar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(705, 8, 140, 95);
		contentPane.add(btnOpciones);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(855, 7, 89, 23);
		contentPane.add(btnNuevo);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(855, 32, 89, 23);
		contentPane.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(855, 57, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(855, 82, 89, 23);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 934, 328);
		contentPane.add(scrollPane);
		
		tbResultado = new JTable();
		tbResultado.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbResultado);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID Usuario");
		modelo.addColumn("Nombre Completo");
		modelo.addColumn("Tipo Empleado"); 
		modelo.addColumn("Login"); 
		modelo.addColumn("Password"); 
		modelo.addColumn("Turno"); 
		tbResultado.setModel(modelo);
		modelo.setRowCount(0); 
		
		ajustarAnchoColumnas();
		listar();
		
	}
	ArreUsuarios are =  new ArreUsuarios();
		
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
	public void actionPerformedbtnBuscar(ActionEvent e) {
		consultarPersona();
	}
	public void actionPerformedbtnAceptar(ActionEvent e) {
			switch (tipoOperacion) {
			case ADICIONAR:
				adicionarPersona();
				break;
			case CONSULTAR:
				consultarPersona();
				break;
			case MODIFICAR:
				modificarPersona();
				break;
			case ELIMINAR:
				eliminarPersona();
		}
		are.actualizarArchivo();
	}
	public void actionPerformedbtnOpciones(ActionEvent e) {
	
		txtIdUsuario.setEditable(false);
		limpieza();
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	public void actionPerformedbtnNuevo(ActionEvent e) {
		tipoOperacion = ADICIONAR;
		txtIdUsuario.setText(are.generarCodigoCorrelativo(are.obtener(are.tamanio()-1).getIdUsuario()));
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombre.requestFocus();
		
	}
	public void actionPerformedbtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		txtIdUsuario.setEditable(true);
		habilitarBotones(false);
		txtIdUsuario.requestFocus();
	}
	public void actionPerformedbtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		txtIdUsuario.setEditable(true);
		habilitarBotones(false);
		txtIdUsuario.requestFocus();
	}
	public void actionPerformedbtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		txtIdUsuario.setEditable(true);
		habilitarBotones(false);
		txtIdUsuario.requestFocus();
	}
	
	void adicionarPersona() {
			
		String codigo = leerCodigo();
		String nombre =  leerNombre();
		if(nombre.length() > 0){
			String appa = leerApPa();
			if(appa.length() > 0){
				String apma = leerApMa();
				if(apma.length() > 0){
					String login =  leerLogin();
					if(login.length() > 0){
						String password = LeerPassword();
						if(password.length() > 0){
							if(are.buscacod(codigo) == null)
									try{
										int empleado = leerEmpleado();
										int turno = leerTurno();
										ClaseUsuarios cla = new ClaseUsuarios(codigo, nombre, appa, apma, empleado, login, password, turno);
										are.adicionar(cla);
										listar();
										limpieza();
									}
									catch (Exception e) {
										mensaje("pipipipipipipipipipi");
									}
								}else
									error("Password no ingresado", txtPassword);
							}else
								error("Login no ingresado", txtPassword);
						}else
							error("Apellido materno no registrado", txtApMa);
					}else
						error("Apellido paterno no registrado", txtApPa);
				}else
					error("Nombre no registrado", txtNombre);
	}
	

	
	void modificarPersona() {
		try {
			ClaseUsuarios x = are.buscacod(leerCodigo());
			if(x != null){
				try{
					String password =  LeerPassword();
					String login = leerLogin();
					String apma = leerApMa();
					String nombre = leerNombre();
					String appa = leerApPa();
					int empleado = leerEmpleado();
					int turno = leerTurno();
					x.setNombres(nombre);
					x.setApellidoPaterno(appa);
					x.setApellidoMaternoo(apma);
					x.setTipoEmpleado(empleado);
					x.setLogin(login);
					x.setPassword(password);
					x.setTurno(turno);
					listar();
					txtNombre.requestFocus();
					limpieza();
				}catch (Exception e) {
					error("pipipipip", txtIdUsuario);
				}
					
			}
			
		}catch (Exception e) {
			error("pipipipip", txtIdUsuario);
			}
	}
	void consultarPersona(){
		try {
			String codigo = leerCodigo();
			ClaseUsuarios x = are.buscacod(codigo);
			if (x != null) {
				txtNombre.setText(x.getNombres());
				txtApPa.setText(x.getApellidoPaterno());
				txtApMa.setText(x.getApellidoMaternoo());
				cmbEmpleado.setSelectedIndex(x.getTipoEmpleado());
				txtLogin.setText(x.getLogin());
				txtPassword.setText(x.getPassword());
				cmbTurno.setSelectedIndex(x.getTurno());
				if (tipoOperacion == MODIFICAR) {
					habilitarEntradaModificar(true);
					txtIdUsuario.setEditable(false);
					btnBuscar.setEnabled(false);
					btnAceptar.setEnabled(true);
					txtNombre.requestFocus();
				}
				if (tipoOperacion == ELIMINAR) {
					txtIdUsuario.setEditable(false);
					btnBuscar.setEnabled(false);
					btnAceptar.setEnabled(true);
				}
			}
			else
				error("El codigo " + codigo + " no existe", txtIdUsuario);
		}
		catch (Exception e) {
			error("Ingrese CoDIGO correcto", txtIdUsuario);
		}
	}
	
	void eliminarPersona() {
		try {
			String codigo = leerCodigo();
			ClaseUsuarios x = are.buscacod(codigo);
			if (x != null) {
				int ok = confirmar("Desea eliminar el registro ?");
				if (ok == 0) {
					are.eliminar(x);
					listar();
					btnAceptar.setEnabled(false);
					limpieza();
				}
			}
			else
				error("El c�digo " + codigo + " no existe", txtIdUsuario);
		}
		catch (Exception e) {
			error("Ingrese c�digo correcto", txtIdUsuario);
		}	
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbResultado.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));  
		tcm.getColumn(1).setPreferredWidth(anchoColumna(18));  
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10));  
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  
		tcm.getColumn(4).setPreferredWidth(anchoColumna(15));  
		tcm.getColumn(5).setPreferredWidth(anchoColumna(12));  
	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	
	
	void listar() {
		ClaseUsuarios x;
		modelo.setRowCount(0);
		for (int i=0; i<are.tamanio(); i++) {
			x = are.obtener(i);
			Object[] fila = { x.getIdUsuario(),
					          x.nombreComple(),
					          empleadoCargo(x.getTipoEmpleado()),
					          x.getLogin(),
					          x.getPassword(),
					          turnoEmpleado(x.getTurno())};
			modelo.addRow(fila);
		}
	}
	void limpieza() {
		txtIdUsuario.setText("");
		txtNombre.setText("");
		txtApPa.setText("");
		txtApMa.setText("");
		txtLogin.setText("");
		txtPassword.setText("");
		txtNombre.requestFocus();
	}	
	
	
	void habilitarEntradas(boolean sino) {
		if (tipoOperacion == ADICIONAR){
			txtNombre.setEditable(sino);
			txtApPa.setEditable(sino);
			txtApMa.setEditable(sino);
			cmbEmpleado.setEnabled(sino);
			txtLogin.setEditable(sino);
			txtPassword.setEditable(sino);
			cmbTurno.setEnabled(sino);
		}
	}
	
	void habilitarEntradaModificar(boolean sino){
		if (tipoOperacion == MODIFICAR){
			txtNombre.setEditable(sino);
			txtApPa.setEditable(sino);
			txtApMa.setEditable(sino);
			cmbEmpleado.setEnabled(sino);
			txtLogin.setEditable(sino);
			txtPassword.setEditable(sino);
			cmbTurno.setEnabled(sino);
		}
	}
	
	void habilitarBotones(boolean sino) {
		if (tipoOperacion == ADICIONAR){
			btnAceptar.setEnabled(!sino);
		}
		else {
			btnBuscar.setEnabled(!sino);
			btnAceptar.setEnabled(false);
		}	
		btnNuevo.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnOpciones.setEnabled(!sino);	
	}
	
	
	//
	String leerCodigo() {
		return txtIdUsuario.getText().trim();
	}
	
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	String leerApPa() {
		return (txtApPa.getText().trim());
	}
	String leerApMa() {
		return (txtApMa.getText().trim());
	}
	String leerLogin() {
		return (txtLogin.getText().trim());
	}
	String LeerPassword() {
		return (txtPassword.getText().trim());
	}
	int leerEmpleado(){
		return cmbEmpleado.getSelectedIndex();
	}
	int leerTurno(){
		return cmbTurno.getSelectedIndex();
	}
	//
	//
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
	String empleadoCargo(int i) {
		return cmbEmpleado.getItemAt(i);
	}
	
	String turnoEmpleado(int i) {
		return cmbTurno.getItemAt(i);
	}

}