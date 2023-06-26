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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArreBebidas;
import clases.ClaseBebida;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTable;

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
	private JTextField txtIdBebida;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtPrecio;
	private JComboBox<String> cmbTipoDeBebida;
	private JButton btnBuscar;
	private JButton btnAceptar;
	private JButton btnOpciones;
	private JButton btnNuevo;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
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
		setBounds(100, 100, 916, 493);
		
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
		lblMarca.setBounds(10, 89, 62, 14);
		contentPane.add(lblMarca);
		
		lblPrecio = new JLabel("Precio :");
		lblPrecio.setBounds(272, 11, 62, 14);
		contentPane.add(lblPrecio);
		
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
		txtMarca.setBounds(140, 86, 120, 20);
		contentPane.add(txtMarca);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(326, 8, 120, 20);
		contentPane.add(txtPrecio);
		
		cmbTipoDeBebida = new JComboBox<String>();
		cmbTipoDeBebida.setModel(new DefaultComboBoxModel<String>
		(new String[] {"Cerveza", "Vinos", "Whisky", "Ron", "Frutado", "Combinacion preparada", "Agua embotellada"}));
		cmbTipoDeBebida.setEnabled(false);
		cmbTipoDeBebida.setBounds(138, 61, 120, 20);
		contentPane.add(cmbTipoDeBebida);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(485, 7, 120, 23);
		contentPane.add(btnBuscar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(485, 33, 120, 23);
		contentPane.add(btnAceptar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(645, 11, 140, 95);
		contentPane.add(btnOpciones);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(797, 11, 89, 23);
		contentPane.add(btnNuevo);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(797, 37, 89, 23);
		contentPane.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(797, 63, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(797, 95, 89, 23);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 876, 285);
		contentPane.add(scrollPane);
		
		tbtResultado = new JTable();
		tbtResultado.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbtResultado);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID Bebida");
		modelo.addColumn("Nombre Bebida");
		modelo.addColumn("Tipo Bebida"); 
		modelo.addColumn("Marca"); 
		modelo.addColumn("Precio"); 
		modelo.addColumn("Estado"); 
		tbtResultado.setModel(modelo);
		modelo.setRowCount(0); 
		
		chkEstado = new JCheckBox("Estado");
		chkEstado.setSelected(true);
		chkEstado.setEnabled(false);
		chkEstado.setBounds(272, 32, 113, 25);
		contentPane.add(chkEstado);
		
		
		ajustarAnchoColumnas();
		listar();
	}
	
	ArreBebidas arb = new ArreBebidas();
	private JCheckBox chkEstado;
	private JTable tbtResultado;
	
	
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
		consultarBebida();
	}
	public void actionPerformedbtnAceptar(ActionEvent e) {
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionarBebida();
			break;
		case CONSULTAR:
			consultarBebida();
			break;
		case MODIFICAR:
			modificarBebida();
			break;
		case ELIMINAR:
			eliminarBebida();
		}
		arb.actualizarArchivo();
		txtIdBebida.setEditable(false);
		txtNombre.setEditable(false);
		cmbTipoDeBebida.setEnabled(false);
		txtMarca.setEditable(false);
		txtPrecio.setEditable(false);
		chkEstado.setEnabled(false);
		btnBuscar.setEnabled(false);
		btnAceptar.setEnabled(false);
		listar();
		limpieza();
	}

	public void actionPerformedbtnOpciones(ActionEvent e) {
		txtIdBebida.setText("");
		txtNombre.setText("");
		txtMarca.setText("");
		txtPrecio.setText("");
		txtIdBebida.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
		limpieza();
	}
	public void actionPerformedbtnNuevo(ActionEvent e) {
		tipoOperacion=ADICIONAR;
		txtIdBebida.setText(arb.generarCodigoCorrelativo(arb.obtener(arb.tamanio()-1).getIdBebida()));
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombre.requestFocus();
	}
	public void actionPerformedbtnConsultar(ActionEvent e) {
		tipoOperacion=CONSULTAR;
		txtIdBebida.setEditable(true);
		habilitarBotones(false);
		txtIdBebida.requestFocus();
	}
	public void actionPerformedbtnModificar(ActionEvent e) {
		tipoOperacion=MODIFICAR;
		txtIdBebida.setEditable(true);
		habilitarBotones(false);
		txtIdBebida.requestFocus();
	}
	public void actionPerformedbtnEliminar(ActionEvent e) {
		tipoOperacion=ELIMINAR;
		txtIdBebida.setEditable(true);
		habilitarBotones(false);
		txtIdBebida.requestFocus();
	}
	
	void adicionarBebida(){
		String codigo = leerCodigo();
		String nombre= leerNombre();
		if(nombre.length() > 0){
			String marca = leerMarca();
			if (marca.length() > 0) {
				if(arb.buscaID(codigo)==null)
					try {
						int tipo = leerTipo();
						double precio = leerPrecio();
						boolean estado = leerEstado();
						ClaseBebida bebw = new ClaseBebida(codigo, nombre,tipo, marca, precio, estado);
						arb.adicionar(bebw);
						listar();
						limpieza();
					}
					catch (Exception e) {
						mensaje("pipippi");
					}
			}else
				error("Marca no ingresada", txtMarca);
		}else
			error("Nombre no ingresado", txtNombre);	
	}

	void modificarBebida(){
		try {
			ClaseBebida x = arb.buscaID(leerCodigo());
			if(x != null){
				try{
					String nombre = leerNombre();
					double precio = leerPrecio();
					String marca = leerMarca();
					int tipo = leerTipo();
					boolean estado = leerEstado();
					x.setNombre(nombre);
					x.setPrecio(precio);
					x.setMarca(marca);
					x.setTipoBebida(tipo);
					x.setEstado(estado);
					listar();
					txtNombre.requestFocus();
					limpieza();
				}catch (Exception e) {
					error("pipipipip", txtIdBebida);
				}
					
			}
			
		}catch (Exception e) {
			error("pipipipip", txtIdBebida);
		}
		
	}
	
	void consultarBebida(){
		try {
		    String codigo = leerCodigo();
		    ClaseBebida x = arb.buscaID(codigo);
		    if(x != null){
		    	txtIdBebida.setText(x.getIdBebida());
		    	txtNombre.setText(x.getNombre());
		    	cmbTipoDeBebida.setSelectedIndex(x.getTipoBebida());
		    	txtMarca.setText(x.getMarca());
		    	txtPrecio.setText(String.valueOf(x.getPrecio()));
		    	chkEstado.setSelected(x.isEstado());
		    	if(tipoOperacion==MODIFICAR){
		    		habilitarEntradaModificar(true);
		    		txtIdBebida.setEditable(false);
		    		btnBuscar.setEnabled(false);
		    		btnAceptar.setEnabled(true);
		    		txtNombre.requestFocus();
		    	}
		    	if(tipoOperacion == ELIMINAR){
		    		txtIdBebida.setEditable(false);
		    		btnBuscar.setEnabled(false);
		    		btnAceptar.setEnabled(true);
		    	}
		    }
		    else
		    	error("El codigo " + codigo + "no existe.", txtIdBebida);
		}
		catch(Exception e){
			error("Ingrese codigo correcto", txtIdBebida);
		}
	}
	
	void eliminarBebida(){
		try {
			String codigo = leerCodigo();
			ClaseBebida x = arb.buscaID(codigo);
			if(x != null){
				int ok = confirmar("�Dessea eliminar este registro?");
				if(ok == 0){
					arb.eliminar(x);
					listar();
					btnAceptar.setEnabled(false);
					limpieza();
				}
			}else
				error("El c�digo " + codigo + " no existe", txtIdBebida);
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbtResultado.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));  
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10));  
		tcm.getColumn(3).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10)); 
		tcm.getColumn(5).setPreferredWidth(anchoColumna(20));  
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	void limpieza() {
		txtIdBebida.setText("");
		txtNombre.setText("");
		txtMarca.setText("");
		txtPrecio.setText("");
		txtIdBebida.requestFocus();
	}	
	
	void listar() {
		ClaseBebida x;
		modelo.setRowCount(0);
		for (int i = 0; i < arb.tamanio(); i++) {
			x= arb.obtener(i);
			Object[] fila = {
					x.getIdBebida(),
					x.getNombre(),
					tipoBebida(x.getTipoBebida()),
					x.getMarca(),
					x.getPrecio(),
					x.isEstado()};
			modelo.addRow(fila);
		}
	}
		
	void habilitarEntradas(boolean sino) {
		if (tipoOperacion == ADICIONAR)
			txtNombre.setEditable(sino);
			cmbTipoDeBebida.setEnabled(sino);
			txtMarca.setEditable(sino);
			txtPrecio.setEditable(sino);
			chkEstado.setEnabled(sino);
			
	}
	
	void habilitarEntradaModificar(boolean sino){
		if (tipoOperacion == MODIFICAR){
			txtNombre.setEditable(sino);
			txtPrecio.setEditable(sino);
			cmbTipoDeBebida.setEnabled(sino);
			txtMarca.setEditable(sino);
			chkEstado.setEnabled(sino);
		}
	}
	
	void habilitarBotones(boolean sino) {
		if (tipoOperacion == ADICIONAR)
			btnAceptar.setEnabled(!sino);
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
	
	String leerCodigo() {
		return (txtIdBebida.getText().trim());
	}
	//
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	int leerTipo(){
		return cmbTipoDeBebida.getSelectedIndex();
	}
	String leerMarca() {
		return (txtMarca.getText().trim());
	}
	
	double leerPrecio(){
		return Double.parseDouble(txtPrecio.getText().trim());
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
	String tipoBebida(int i){
		return cmbTipoDeBebida.getItemAt(i);
	}
	private boolean leerEstado(){
		return chkEstado.isSelected();
	}
}



