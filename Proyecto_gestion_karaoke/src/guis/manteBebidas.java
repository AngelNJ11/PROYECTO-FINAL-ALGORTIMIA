package guis;

import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import arreglos.ArreBebidas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manteBebidas extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblIdBebida;
	private JLabel lblNombres;
	private JLabel lblTipoDeBebida;
	private JLabel lblMarca;
	private JLabel lblPrecio;
	private JLabel lblEstado;
	private JTextField txtIdBebida;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtPrecio;
	private JComboBox<String> cmbTipoDeBebida;
	private JComboBox<String> cmbEstado;
	private JButton btnBuscar;
	private JButton btnAceptar;
	private JButton btnOpciones;
	private JButton btnNuevo;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	
	
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
			manteBebidas dialog = new manteBebidas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public manteBebidas() {
		setTitle("Bebida");
		setBounds(100, 100, 824, 450);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		
		lblIdBebida = new JLabel("ID Bebida :");
		lblIdBebida.setBounds(10, 11, 120, 14);
		contentPane.add(lblIdBebida);
		
		lblNombres = new JLabel("Nombres :");
		lblNombres.setBounds(10, 37, 120, 14);
		contentPane.add(lblNombres);
		
		lblTipoDeBebida = new JLabel("Tipo de bebida :");
		lblTipoDeBebida.setBounds(10, 63, 120, 14);
		contentPane.add(lblTipoDeBebida);
		
		lblMarca = new JLabel("Marca :");
		lblMarca.setBounds(270, 11, 62, 14);
		contentPane.add(lblMarca);
		
		lblPrecio = new JLabel("Precio :");
		lblPrecio.setBounds(270, 36, 62, 14);
		contentPane.add(lblPrecio);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(270, 61, 62, 14);
		contentPane.add(lblEstado);
		
		txtIdBebida = new JTextField();
		txtIdBebida.setEditable(false);
		txtIdBebida.setColumns(10);
		txtIdBebida.setBounds(140, 8, 120, 20);
		contentPane.add(txtIdBebida);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(140, 33, 120, 20);
		contentPane.add(txtNombre);
		
		txtMarca = new JTextField();
		txtMarca.setEditable(false);
		txtMarca.setColumns(10);
		txtMarca.setBounds(344, 11, 120, 20);
		contentPane.add(txtMarca);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(344, 36, 120, 20);
		contentPane.add(txtPrecio);
		
		cmbTipoDeBebida = new JComboBox<String>();
		cmbTipoDeBebida.setModel(new DefaultComboBoxModel<String>
		(new String[] {"Cerveza", "Vinos", "Whisky", "Ron", "Frutado", "Combinacion preparada", "Agua embotellada"}));
		cmbTipoDeBebida.setEnabled(false);
		cmbTipoDeBebida.setBounds(138, 61, 120, 20);
		contentPane.add(cmbTipoDeBebida);
		
		cmbEstado = new JComboBox<String>();
		cmbEstado.setModel(new DefaultComboBoxModel<String>
		(new String[] {"Habilitado", "Inhabilitado"}));
		cmbEstado.setEnabled(false);
		cmbEstado.setBounds(344, 61, 120, 20);
		contentPane.add(cmbEstado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(344, 85, 120, 23);
		contentPane.add(btnBuscar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(344, 110, 120, 23);
		contentPane.add(btnAceptar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(577, 11, 140, 95);
		contentPane.add(btnOpciones);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(729, 14, 89, 23);
		contentPane.add(btnNuevo);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(729, 39, 89, 23);
		contentPane.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(729, 64, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(729, 89, 89, 23);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 934, 328);
		contentPane.add(scrollPane);
	}
	
	ArreBebidas arb = new ArreBebidas();
	
	
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
			adicionarPersona();
	}
	}

	public void actionPerformedbtnOpciones(ActionEvent e) {
		txtIdBebida.setText("");
		txtNombre.setText("");
		txtMarca.setText("");
		txtPrecio.setText("");
		txtIdBebida.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	public void actionPerformedbtnNuevo(ActionEvent e) {
	
	}
	public void actionPerformedbtnConsultar(ActionEvent e) {
	}
	public void actionPerformedbtnModificar(ActionEvent e) {
	}
	public void actionPerformedbtnEliminar(ActionEvent e) {
	}
	
	
	
	
	
	
	

	void modificarPersona() {
			
		}

	void adicionarPersona() {
		
		
	
	}
	
	void consultarPersona(){
		
	}
	
	
	void limpieza() {
		txtIdBebida.setText("");
		txtNombre.setText("");
		txtMarca.setText("");
		txtPrecio.setText("");
		txtIdBebida.requestFocus();
	}	
	
	void listar() {
	
	}
	
	String leerCodigo() {
		return (txtIdBebida.getText().trim());
	}
	//
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	String leerMarca() {
		return (txtMarca.getText().trim());
	}
	String LeerPrecio() {
		return (txtPrecio.getText().trim());
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
	//


	
	
	void habilitarEntradas(boolean sino) {
		if (tipoOperacion == ADICIONAR)
			txtNombre.setEditable(sino);
			cmbTipoDeBebida.setEnabled(sino);
			txtMarca.setEditable(sino);
			txtPrecio.setEditable(sino);
			cmbEstado.setEnabled(sino);
			
	}
	void habilitarBotones(boolean sino) {
		if (tipoOperacion == ADICIONAR)
			btnAceptar.setEnabled(!sino);
		else {
			btnBuscar.setEnabled(!sino);
			btnAceptar.setEnabled(false);
		}	
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnOpciones.setEnabled(!sino);		
	}
}



