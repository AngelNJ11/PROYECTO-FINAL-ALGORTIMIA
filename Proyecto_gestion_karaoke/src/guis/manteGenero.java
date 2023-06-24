package guis;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArreGeneros;
import clases.ClaseGenero;

public class manteGenero extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdGenero;
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
	private JTable tbResultado;
	private DefaultTableModel modelo;
	private JButton btnBuscar;
	private JButton btnOpciones;
	private JButton btnNuevo;
	private JButton btnAceptar;
	private JButton btnConsultar;
	
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
			manteGenero dialog = new manteGenero();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public manteGenero() {
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
		
		txtIdGenero = new JTextField();
		txtIdGenero.setBounds(120, 8, 120, 20);
		contentPanel.add(txtIdGenero);
		txtIdGenero.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(120, 33, 120, 20);
		contentPanel.add(txtDescripcion);
		
		txtEpoca = new JTextField();
		txtEpoca.setColumns(10);
		txtEpoca.setBounds(120, 58, 120, 20);
		contentPanel.add(txtEpoca);
		
		cmbEstado = new JComboBox<String>();
		cmbEstado.setModel(new DefaultComboBoxModel<String>
		(new String[] {"Habilitado", "Inhabilitado"}));
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
		
		tbResultado = new JTable();
		tbResultado.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbResultado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(252, 6, 97, 25);
		contentPanel.add(btnBuscar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(578, 13, 97, 92);
		contentPanel.add(btnOpciones);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(679, 6, 97, 25);
		contentPanel.add(btnNuevo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(252, 31, 97, 25);
		contentPanel.add(btnAceptar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(679, 31, 97, 25);
		contentPanel.add(btnConsultar);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID Genero"); 
		modelo.addColumn("Descrpcion"); 
		modelo.addColumn("Epoca"); 
		modelo.addColumn("Estado");
		tbResultado.setModel(modelo);
		modelo.setRowCount(0);
		ajustarAnchoColumnas();
		listar();
	}
	
	ArreGeneros arg =  new ArreGeneros();

	
	
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
	}
	public void actionPerformedbtnOpciones(ActionEvent e) {
		txtIdGenero.setText("");
		txtDescripcion.setText("");
		txtEpoca.setText("");
		txtIdGenero.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
		limpieza();
	}
	public void actionPerformedbtnNuevo(ActionEvent e) {
		tipoOperacion = ADICIONAR;
		txtIdGenero.setText("" + arg.generarCodigoCorrelativo(arg.obtener(arg.tamanio()-1).getIdGenero()));
		habilitarEntradas(true);
		habilitarBotones(false);
		txtDescripcion.requestFocus();
	}
	public void actionPerformedbtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		txtIdGenero.setEditable(true);
		habilitarBotones(false);
		txtIdGenero.requestFocus();
	}
	public void actionPerformedbtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		txtIdGenero.setEditable(true);
		habilitarBotones(false);
		txtIdGenero.requestFocus();
	}
	public void actionPerformedbtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		txtIdGenero.setEditable(true);
		habilitarBotones(false);
		txtIdGenero.requestFocus();
	}
	
	void adicionarPersona() {
		
		String codigo = leerCodigo();
		String descripcion = leerDescripcion();
		if(descripcion.length() > 0){
			int epoca = leerEpoca();
			if(epoca > 0){
				if(arg.buscacod(codigo) == null)
					try{
						boolean estado = true;
						ClaseGenero gen = new ClaseGenero(codigo, descripcion, epoca, estado);
						arg.adicionar(gen);
						listar();
						limpieza();
					}
					catch (Exception e) {
						mensaje("pipipipipipipipipipi");
					}	
			}else
				error("Epoca no ingresad", txtEpoca);
		}else
			error("Descripcion no ingresada", txtDescripcion);
	}
	

	
	void modificarPersona() {
		try {
			ClaseGenero x = arg.buscacod(leerCodigo());
			if(x != null){
				try{
					String descripcion = leerDescripcion();
					int epoca = leerEpoca();
					boolean estado = true;
					x.setDescripcion(descripcion);
					x.setEpoca(epoca);
					x.setEstado(estado);
					listar();
					txtDescripcion.requestFocus();
					limpieza();
				}catch (Exception e) {
					error("pipipipip", txtIdGenero);
				}
					
			}
			
		}catch (Exception e) {
			error("oe y esto pa q sirve", txtIdGenero);
			}
	}
	void consultarPersona(){
		try {
			String codigo = leerCodigo();
			ClaseGenero x = arg.buscacod(codigo);
			if (x != null) {
				txtDescripcion.setText(x.getDescripcion());
				txtEpoca.setText(x.getEpoca()+"");
				cmbEstado.setSelectedIndex(0);
				if (tipoOperacion == MODIFICAR) {
					habilitarEntradaModificar(true);
					txtIdGenero.setEditable(false);
					btnBuscar.setEnabled(false);
					btnAceptar.setEnabled(true);
					txtDescripcion.requestFocus();
				}
				if (tipoOperacion == ELIMINAR) {
					txtIdGenero.setEditable(false);
					btnBuscar.setEnabled(false);
					btnAceptar.setEnabled(true);
				}
			}
			else
				error("El c�digo " + codigo + " no existe", txtIdGenero);
		}
		catch (Exception e) {
			error("Ingrese C�DIGO correcto", txtIdGenero);
		}
	}
	
	void eliminarPersona() {
		try {
			String codigo = leerCodigo();
			ClaseGenero x =	arg.buscacod(codigo);
			if (x != null) {
				int ok = confirmar("� Desea eliminar el registro ?");
				if (ok == 0) {
					arg.eliminar(x);
					listar();
					btnAceptar.setEnabled(false);
					limpieza();
				}
			}
			else
				error("El c�digo " + codigo + " no existe", txtIdGenero);
		}
		catch (Exception e) {
			error("Ingrese C�DIGO correcto", txtIdGenero);
		}	
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbResultado.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));  
		tcm.getColumn(1).setPreferredWidth(anchoColumna(10));  
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10));  
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));   
	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	
	
	void listar() {
		ClaseGenero x;
		modelo.setRowCount(0);
		for (int i=0; i<arg.tamanio(); i++) {
			x = arg.obtener(i);
			Object[] fila = { 
							x.getIdGenero(),
							x.getDescripcion(),
							x.getEpoca(),
					        //estado(leerEstado()),
							};
			modelo.addRow(fila);
		}
	}
	void limpieza() {
		txtIdGenero.setText("");
		txtDescripcion.setText("");
		txtEpoca.setText("");
		txtDescripcion.requestFocus();
	}	
	
	
	void habilitarEntradas(boolean sino) {
		if (tipoOperacion == ADICIONAR){
			txtDescripcion.setEditable(sino);
			txtEpoca.setEditable(sino);
			cmbEstado.setEnabled(sino);
		}
	}
	
	void habilitarEntradaModificar(boolean sino){
		if (tipoOperacion == MODIFICAR){
			txtDescripcion.setEditable(sino);
			txtEpoca.setEditable(sino);
			cmbEstado.setEnabled(sino);
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
		return txtIdGenero.getText().trim();
	}
	
	String leerDescripcion() {
		return txtDescripcion.getText().trim();
	}
	int leerEpoca() {
		return Integer.parseInt(txtEpoca.getText().trim());
	}
	String leerEstado(int i) {
		return cmbEstado.getItemAt(i);
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
	
	
	
}
