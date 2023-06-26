package guis;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArreArtistas;
import arreglos.ArreGeneros;
import clases.ClaseArtista;
import clases.ClaseGenero;
import clases.ClasePiqueo;
import helpers.JComboBoxData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.time.Clock;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class manteArtista extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdArtista;
	private JTextField txtNomArtista;
	private JTextField txtFechaRegisto;
	private JTable table;
	private JLabel lblIdArtista;
	private JLabel lblNombreartistico;
	private JLabel lblIdGenero;
	private JLabel lblFechaRegistro;
	private JLabel lblEstado;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnOpciones;
	private JButton btnNuevo;
	private JCheckBox chcHabilitado;
	private DefaultTableModel modelo;
	private JComboBoxData cboGenero;

	
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
			manteArtista dialog = new manteArtista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public manteArtista() {
		setTitle("Artista");
		setBounds(100, 100, 736, 510);
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
		
		lblIdGenero = new JLabel("Genero:");
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
		txtIdArtista.setBounds(142, 8, 123, 20);
		contentPanel.add(txtIdArtista);
		txtIdArtista.setColumns(10);
		
		txtNomArtista = new JTextField();
		txtNomArtista.setColumns(10);
		txtNomArtista.setBounds(142, 33, 123, 20);
		contentPanel.add(txtNomArtista);
		
		txtFechaRegisto = new JTextField();
		txtFechaRegisto.setColumns(10);
		txtFechaRegisto.setBounds(142, 83, 123, 20);
		contentPanel.add(txtFechaRegisto);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(625, 32, 89, 23);
		contentPanel.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(625, 57, 89, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(625, 82, 89, 23);
		contentPanel.add(btnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(276, 32, 97, 23);
		contentPanel.add(btnAceptar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 147, 704, 324);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID Piqueo");
		modelo.addColumn("Nombre del Piqueo");
		modelo.addColumn("Tipo de Piqueo");
		modelo.addColumn("Precio"); 
		modelo.addColumn("Estado del Piqueo"); 
		table.setModel(modelo);
		ajustarAnchoColumnas();
		listar();
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(276, 6, 97, 25);
		contentPanel.add(btnBuscar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(473, 6, 140, 95);
		contentPanel.add(btnOpciones);
		
		chcHabilitado = new JCheckBox("Habilitado");
		chcHabilitado.setEnabled(false);
		chcHabilitado.setBounds(142, 107, 123, 23);
		contentPanel.add(chcHabilitado);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(625, 7, 89, 23);
		contentPanel.add(btnNuevo);
		
		cboGenero =  new JComboBoxData("GENERO");
		cboGenero.setBounds(142, 58, 123, 20);
		contentPanel.add(cboGenero);
	}
	
	
		ArreArtistas area = new ArreArtistas();
		ArreGeneros gen = new ArreGeneros();
		
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnOpciones) {
			actionPerformedbtnOpciones(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedbtnBuscar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedbtnAceptar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedbtnNuevo(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedbtnConsultar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedbtenModificar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedbtnEliminar(e);
		}
	}
	
	public void actionPerformedbtnOpciones(ActionEvent e) {
		
	}
	
	public void actionPerformedbtnBuscar(ActionEvent e) {
		consultarArtista1();

	}
	
	public void actionPerformedbtnAceptar(ActionEvent e) {
		
	}
	
	public void actionPerformedbtnNuevo(ActionEvent e) {
		
	}
	
	public void actionPerformedbtnConsultar(ActionEvent e) {
		
	}
	
	public void actionPerformedbtenModificar(ActionEvent e) {
		
	}
	
	public void actionPerformedbtnEliminar(ActionEvent e) {
		
	}

	void adicionarArtista() {
		
		String idArtista = area.generarCodigoCorrelativo(leerCodigo());
		String nombre = leerNombre();

		

		ClaseGenero genero = leerGenero();
		Date fechaRegistro = new Date();
		boolean estado = leerEstado();
		ClaseArtista nuevoArtista = new ClaseArtista(idArtista, nombre, genero, fechaRegistro, estado);

		area.adicionar(nuevoArtista, true);
	

	}
	
	void modificarArtista() {
		try {
			ClaseArtista x = area.buscaID(leerCodigo());
			if(x != null){
				try{
					String nombre = leerNombre();
					Date fecha = new Date();
					ClaseGenero genero = leerGenero();
					boolean estado = leerEstado();
					x.setNombreArtistico(nombre);
					x.setFechaRegistro((java.sql.Date) fecha);
					x.setGenero(genero);
					x.setEstado(estado);
					listar();
					txtNomArtista.requestFocus();
					limpieza();
				}catch (Exception e) {
					error("pipipipip", txtIdArtista);
				}
					
			}
			
		}catch (Exception e) {
			error("pipipipip", txtIdArtista);
			}
	}
	
	void consultarArtista1(){
		try {
		    String codigo = leerCodigo();
		    ClaseArtista x = area.buscaID(codigo);
		    if(x != null){
		    	txtIdArtista.setText(x.getIdArtista());
		    	txtNomArtista.setText(x.getNombreArtistico());
		    	if(tipoOperacion==MODIFICAR){
		    		habilitarEntradaModificar(true);
		    		txtIdArtista.setEditable(false);
		    		btnBuscar.setEnabled(false);
		    		btnAceptar.setEnabled(true);
		    		txtNomArtista.requestFocus();
		    	}
		    	if(tipoOperacion == ELIMINAR){
		    		txtIdArtista.setEditable(false);
		    		btnBuscar.setEnabled(false);
		    		btnAceptar.setEnabled(true);
		    	}
		    }
		    else
		    	error("El codigo " + codigo + "no existe.", txtIdArtista);
		}
		catch(Exception e){
			error("Ingrese codigo correcto", txtIdArtista);
		}
	}
	
	void eLiminarArtista(){
		try {
			String codigo = leerCodigo();
			ClaseArtista x = area.buscaID(codigo);
			if(x != null){
				int ok = confirmar("�Dessea eliminar este registro?");
				if(ok == 0){
					area.eliminar(x);
					listar();
					btnAceptar.setEnabled(false);
					limpieza();
				}
			}else
				error("El c�digo " + codigo + " no existe", txtIdArtista);
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	void listar(){
		ClaseArtista x;
		modelo.setRowCount(0);
		for (int i = 0; i < area.tamanio(); i++) {
			x = area.obtener(i);
			Object[] fila = { 
					x.getIdArtista(), 
					x.getNombreArtistico(), 
					x.getGenero().getDescripcion(),
					x.fechaComoCadena(), 
					x.nombreEstado(), };
			modelo.addRow(fila);
		}
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
	void limpieza(){
		txtIdArtista.setText("");
		txtNomArtista.setText("");
		cboGenero.getSelectedIndex();
		txtFechaRegisto.requestFocus();
	}
	
	
	void habilitarEntradas(boolean sino) {
		if (tipoOperacion == ADICIONAR){
			txtNomArtista.setEditable(sino);
			cboGenero.setEditable(sino);
			txtFechaRegisto.setEnabled(sino);
			chcHabilitado.setEnabled(sino);
		}
	}
	
	void habilitarEntradaModificar(boolean sino){
		if (tipoOperacion == MODIFICAR){
			txtNomArtista.setEditable(sino);
			cboGenero.setEditable(sino);
			txtFechaRegisto.setEnabled(sino);
			chcHabilitado.setEnabled(sino);
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
	
	void consultarArtista(){
		try {
		    String codigo = leerCodigo();
		    ClaseArtista x = area.buscaID(codigo);
		    if(x != null){
		    	txtIdArtista.setText(x.getIdArtista());
		    	txtNomArtista.setText(x.getNombreArtistico());
		    	
		    	chcHabilitado.setSelected(x.isEstado());
		    	if(tipoOperacion==MODIFICAR){
		    		habilitarEntradaModificar(true);
		    		txtIdArtista.setEditable(false);
		    		btnBuscar.setEnabled(false);
		    		btnAceptar.setEnabled(true);
		    		txtNomArtista.requestFocus();
		    	}
		    	if(tipoOperacion == ELIMINAR){
		    		txtIdArtista.setEditable(false);
		    		btnBuscar.setEnabled(false);
		    		btnAceptar.setEnabled(true);
		    	}
		    }
		    else
		    	error("El codigo " + codigo + "no existe.", txtIdArtista);
		}
		catch(Exception e){
			error("Ingrese codigo correcto", txtIdArtista);
		}
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(3).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(4).setPreferredWidth(anchoColumna(20));  
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informaci�n", 0);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	String leerCodigo(){
		return txtIdArtista.getText().trim();
	}
	String leerNombre(){
		return txtNomArtista.getText().trim();
	}
	ClaseGenero leerGenero() {
		String item = cboGenero.getSelectedItem().toString();
		String idGenero = item.split(":")[0];
		ClaseGenero genero = gen.buscaID(idGenero);
		return genero;
	}

	
	private boolean leerEstado(){
		return chcHabilitado.isSelected();
	}
}
