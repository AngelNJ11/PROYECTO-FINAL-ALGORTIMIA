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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import arreglos.ArrePiqueos;
import clases.ClasePiqueo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class mantePiqueo extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdPiqueo;
	private JTextField txtNombre;
	private JTable tbtResultado;
	private JLabel lblIdPiqueo;
	private JLabel lblNombre;
	private JLabel lblIdTipoPiqueo;
	private JLabel lblPrecio;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextField txtPrecio;
	private JComboBox<String> cmbTipoPiqueo;
	private JButton btnOpciones;
	private JButton btnBuscar;
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
			mantePiqueo dialog = new mantePiqueo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public mantePiqueo() {
		setTitle("Piqueo");
		setBounds(100, 100, 882, 491);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblIdPiqueo = new JLabel("Id Piqueo:");
		lblIdPiqueo.setBounds(10, 11, 134, 14);
		contentPanel.add(lblIdPiqueo);
		
		lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(10, 38, 134, 14);
		contentPanel.add(lblNombre);
		
		lblIdTipoPiqueo = new JLabel("Tipo Piqueo:");
		lblIdTipoPiqueo.setBounds(10, 65, 134, 14);
		contentPanel.add(lblIdTipoPiqueo);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(241, 11, 78, 14);
		contentPanel.add(lblPrecio);
		
		txtIdPiqueo = new JTextField();
		txtIdPiqueo.setEditable(false);
		txtIdPiqueo.setBounds(106, 8, 123, 20);
		contentPanel.add(txtIdPiqueo);
		txtIdPiqueo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(106, 35, 123, 20);
		contentPanel.add(txtNombre);
		

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(759, 61, 89, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(759, 86, 89, 23);
		contentPanel.add(btnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(459, 36, 123, 23);
		contentPanel.add(btnAceptar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 135, 842, 296);
		contentPanel.add(scrollPane);
		
		tbtResultado = new JTable();
		scrollPane.setViewportView(tbtResultado);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(324, 8, 123, 20);
		contentPanel.add(txtPrecio);
		
		cmbTipoPiqueo = new JComboBox<String>();
		cmbTipoPiqueo.setEnabled(false);
		cmbTipoPiqueo.setModel(new DefaultComboBoxModel<String>
		(new String[] {"Frios", "Calientes", "Snacks"}));
		cmbTipoPiqueo.setBounds(106, 62, 123, 20);
		contentPanel.add(cmbTipoPiqueo);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(624, 7, 123, 102);
		contentPanel.add(btnOpciones);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(459, 7, 123, 23);
		contentPanel.add(btnBuscar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(759, 6, 89, 25);
		contentPanel.add(btnNuevo);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(759, 33, 89, 25);
		contentPanel.add(btnConsultar);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID Piqueo");
		modelo.addColumn("Nombre del Piqueo");
		modelo.addColumn("Tipo de Piqueo");
		modelo.addColumn("Precio"); 
		modelo.addColumn("Estado del Piqueo"); 
		tbtResultado.setModel(modelo);
		
		chkEstado = new JCheckBox("Estado");
		chkEstado.setEnabled(false);
		chkEstado.setSelected(true);
		chkEstado.setBounds(241, 33, 113, 25);
		contentPanel.add(chkEstado);
		modelo.setRowCount(0); 
		ajustarAnchoColumnas();
		listar();
	}
	
	ArrePiqueos piq = new ArrePiqueos();
	private JButton btnNuevo;
	private JButton btnConsultar;
	private JCheckBox chkEstado;
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnOpciones) {
			actionPerformedBtnOpciones(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	
	

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultarPiqueo();
	
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionarPiqueo();
			break;
		case CONSULTAR:
			consultarPiqueo();
			break;
		case MODIFICAR:
			modificarPiqueo();
			break;
		case ELIMINAR:
			eLiminarPiqueo();
		}

		piq.actualizarArchivo();
		txtIdPiqueo.setEditable(false);
		txtNombre.setEditable(false);
		txtPrecio.setEditable(false);
		cmbTipoPiqueo.setEnabled(false);
		chkEstado.setEnabled(false);
		btnBuscar.setEnabled(false);
		btnAceptar.setEnabled(false);
		limpieza();
	}
	protected void actionPerformedBtnOpciones(ActionEvent e) {
		txtIdPiqueo.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		txtIdPiqueo.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
		limpieza();
	
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		tipoOperacion = ADICIONAR;
		txtIdPiqueo.setText(piq.generarCodigoCorrelativo(piq.obtener(piq.tamanio()-1).getIdPiqueo()));
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombre.requestFocus();
		
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion= CONSULTAR;
		txtIdPiqueo.setEditable(true);
		habilitarBotones(false);
		txtIdPiqueo.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion= MODIFICAR;
		txtIdPiqueo.setEditable(true);
		habilitarBotones(false);
		txtIdPiqueo.requestFocus();
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion= ELIMINAR;
		txtIdPiqueo.setEditable(true);
		habilitarBotones(false);
		txtIdPiqueo.requestFocus();
	}
	
	void adicionarPiqueo() {
		
		String codigo = leerCodigo();
		String nombre =  leerNombre();
		if(nombre.length() > 0){
				if(piq.buscaID(codigo) == null)
					try{
						int tipo = leerTipo();
						double precio = leerPrecio();
						boolean estado = leerEstado();
						ClasePiqueo piqw = new ClasePiqueo(codigo, nombre, tipo, precio, estado);
						piq.adicionar((piqw),false);
						listar();
						limpieza();
						}
					catch (Exception e) {
						mensaje("valo?");
					}
		}else
			error("Nombre no ingresado", txtNombre);
	}
	
	void modificarPiqueo() {
		try {
			ClasePiqueo x = piq.buscaID(leerCodigo());
			if(x != null){
				try{
					String nombre = leerNombre();
					double precio = leerPrecio();
					int tipo = leerTipo();
					boolean estado = leerEstado();
					x.setNombre(nombre);
					x.setPrecio(precio);
					x.setTipoPiqueo(tipo);
					x.setEstado(estado);
					listar();
					txtNombre.requestFocus();
					limpieza();
				}catch (Exception e) {
					error("pipipipip", txtIdPiqueo);
				}
					
			}
			
		}catch (Exception e) {
			error("pipipipip", txtIdPiqueo);
		}
	}
	
	void consultarPiqueo(){
		try {
		    String codigo = leerCodigo();
		    ClasePiqueo x = piq.buscaID(codigo);
		    if(x != null){
		    	txtIdPiqueo.setText(x.getIdPiqueo());
		    	txtNombre.setText(x.getNombre());
		    	cmbTipoPiqueo.setSelectedIndex(x.getTipoPiqueo());
		    	txtPrecio.setText(String.valueOf(x.getPrecio()));
		    	chkEstado.setSelected(x.isEstado());
		    	if(tipoOperacion==MODIFICAR){
		    		habilitarEntradaModificar(true);
		    		txtIdPiqueo.setEditable(false);
		    		btnBuscar.setEnabled(false);
		    		btnAceptar.setEnabled(true);
		    		txtNombre.requestFocus();
		    	}
		    	if(tipoOperacion == ELIMINAR){
		    		txtIdPiqueo.setEditable(false);
		    		btnBuscar.setEnabled(false);
		    		btnAceptar.setEnabled(true);
		    	}
		    }
		    else
		    	error("El codigo " + codigo + "no existe.", txtIdPiqueo);
		}
		catch(Exception e){
			error("Ingrese codigo correcto", txtIdPiqueo);
		}
	}
	
	void eLiminarPiqueo(){
		try {
			String codigo = leerCodigo();
			ClasePiqueo x = piq.buscaID(codigo);
			if(x != null){
				int ok = confirmar("�Dessea eliminar este registro?");
				if(ok == 0){
					piq.eliminar(x);
					listar();
					btnAceptar.setEnabled(false);
					limpieza();
				}
			}else
				error("El c�digo " + codigo + " no existe", txtIdPiqueo);
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbtResultado.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(3).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(4).setPreferredWidth(anchoColumna(20));  
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	void listar(){
		ClasePiqueo x;
		modelo.setRowCount(0);
		for (int i = 0; i < piq.tamanio(); i++) {
			x = piq.obtener(i);
			Object[] fila = { 
					x.getIdPiqueo(),
					x.getNombre(),
					tipoPiqueo(x.getTipoPiqueo()),
					x.getPrecio(),
					x.tipoEstado()};
			modelo.addRow(fila);
		}
	}
	
	void limpieza(){
		txtIdPiqueo.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		txtNombre.requestFocus();
	}
	
	
	void habilitarEntradas(boolean sino) {
		if (tipoOperacion == ADICIONAR){
			txtNombre.setEditable(sino);
			txtPrecio.setEditable(sino);
			cmbTipoPiqueo.setEnabled(sino);
			chkEstado.setEnabled(sino);
		}
	}
	
	void habilitarEntradaModificar(boolean sino){
		if (tipoOperacion == MODIFICAR){
			txtNombre.setEditable(sino);
			txtPrecio.setEditable(sino);
			cmbTipoPiqueo.setEnabled(sino);
			chkEstado.setEnabled(sino);
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
	
	String leerCodigo(){
		return txtIdPiqueo.getText().trim();
	}
	String leerNombre(){
		return txtNombre.getText().trim();
	}
	double leerPrecio(){
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	int leerTipo(){
		return cmbTipoPiqueo.getSelectedIndex();
	}

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
	
	String tipoPiqueo(int i) {
		return cmbTipoPiqueo.getItemAt(i);
	}
	
	private boolean leerEstado(){
		return chkEstado.isSelected();
	}
}
