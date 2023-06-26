package guis;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArreGeneros;
import clases.ClaseGenero;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class manteGenero extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdGenero;
	private JTextField txtDescripcion;
	private JLabel lblEpoca;
	private JLabel lblDescripcion;
	private JLabel lblGenero;
	private JButton btnModificar;
	private JButton btnEliminar;
	private DefaultTableModel modelo;
	private JButton btnBuscar;
	private JButton btnOpciones;
	private JButton btnNuevo;
	private JButton btnAceptar;
	private JButton btnConsultar;
	private JCheckBox chkEstado;
	private JScrollPane scrollPane;
	private JTable tbtResultado;
	private JComboBox<Object> cboEpoca;
	
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
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public manteGenero() {
		setTitle("Genero");
		setBounds(100, 100, 695, 508);
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
		
		txtIdGenero = new JTextField();
		txtIdGenero.setEditable(false);
		txtIdGenero.setBounds(120, 8, 120, 20);
		contentPanel.add(txtIdGenero);
		txtIdGenero.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(120, 33, 120, 20);
		contentPanel.add(txtDescripcion);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(568, 57, 97, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(568, 82, 97, 23);
		contentPanel.add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(252, 6, 97, 25);
		contentPanel.add(btnBuscar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(459, 11, 97, 92);
		contentPanel.add(btnOpciones);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(568, 6, 97, 25);
		contentPanel.add(btnNuevo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(252, 31, 97, 25);
		contentPanel.add(btnAceptar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(568, 31, 97, 25);
		contentPanel.add(btnConsultar);
		

		
		chkEstado = new JCheckBox("Estado");
		chkEstado.setEnabled(false);
		chkEstado.setSelected(true);
		chkEstado.setBounds(10, 84, 113, 25);
		contentPanel.add(chkEstado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 655, 319);
		contentPanel.add(scrollPane);
		
		tbtResultado = new JTable();
		scrollPane.setViewportView(tbtResultado);
		
		cboEpoca = new JComboBox<Object>();
		cboEpoca.setBounds(120, 57, 120, 22);
		contentPanel.add(cboEpoca);	
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID Genero"); 
		modelo.addColumn("Descrpcion"); 
		modelo.addColumn("Epoca"); 
		modelo.addColumn("Estado");
		tbtResultado.setModel(modelo);
		modelo.setRowCount(0);
		ajustarAnchoColumnas();
		cargarEpocas();
		listar();
	}
	
	
	ArreGeneros arg =  new ArreGeneros();
	

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedbtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedbtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedbtnConsultar(e);
		}
		if (e.getSource() == btnOpciones) {
			actionPerformedbtnOpciones(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedbtnAceptar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedbtnNuevo(e);
		}
	}
	
	public void actionPerformedbtnBuscar(ActionEvent e) {
		consultarGenero();
	}
	
	public void actionPerformedbtnAceptar(ActionEvent e) {
			switch (tipoOperacion) {
			case ADICIONAR:
				adicionarGenero();
				break;
			case CONSULTAR:
				consultarGenero();
				break;
			case MODIFICAR:
				modificarGenero();
				break;
			case ELIMINAR:
				eliminarGenero();
		}
			arg.actualizarArchivo();
			txtIdGenero.setEditable(false);
			txtDescripcion.setEditable(false);
			cboEpoca.setEnabled(false);
			chkEstado.setEnabled(false);
			btnBuscar.setEnabled(false);
			btnAceptar.setEnabled(false);
			limpieza();
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultarGenero();
	}
	
	public void actionPerformedbtnOpciones(ActionEvent e) {
		txtIdGenero.setText("");
		txtDescripcion.setText("");
		txtIdGenero.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
		limpieza();
	}
	public void actionPerformedbtnNuevo(ActionEvent e) {
		tipoOperacion = ADICIONAR;
		txtIdGenero.setText(arg.generarCodigoCorrelativo(arg.obtener(arg.tamanio()-1).getIdGenero()));
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
	
	void adicionarGenero() {
		
		String codigo = leerCodigo();
		String descripcion = leerDescripcion();
		if(descripcion.length() > 0){
				if(arg.buscaID(codigo) == null)
					try{
						int epoca = leerEpoca();
						boolean estado = leerEstado();
						ClaseGenero gen = new ClaseGenero(codigo, descripcion, epoca, estado);
						arg.adicionar(gen);
						listar();
						limpieza();
					}
					catch (Exception e) {
						mensaje("pipipipipipipipipipi");
					}
		}else
			error("Descripcion no ingresada", txtDescripcion);
	}
	

	
	void modificarGenero() {
		try {
			ClaseGenero x = arg.buscaID(leerCodigo());
			if(x != null){
				try{
					String descripcion = leerDescripcion();
					int epoca = leerEpoca();
					boolean estado = leerEstado();
					x.setDescripcion(descripcion);
					x.setEpoca(epoca);
					x.setEstado(estado);
					listar();
					limpieza();
				}catch (Exception e) {
					error("pipipipip", txtIdGenero);
				}
					
			}
			
		}catch (Exception e) {
			error("oe y esto pa q sirve", txtIdGenero);
			}
	}
	void consultarGenero(){
		try {
			String codigo = leerCodigo();
			ClaseGenero x = arg.buscaID(codigo);
			if (x != null) {
				txtDescripcion.setText(x.getDescripcion());
				cboEpoca.setSelectedIndex(x.getEpoca());
				chkEstado.setSelected(x.isEstado());
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
	
	void eliminarGenero() {
		try {
			String codigo = leerCodigo();
			ClaseGenero x =	arg.buscaID(codigo);
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
	

	void ajustarAnchoColumnas(){
		TableColumnModel tcm = tbtResultado.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(3).setPreferredWidth(anchoColumna(20));
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	
	
	void listar() {
		modelo.setRowCount(0);
		ClaseGenero genero;
		for (int i = 0; i < arg.tamanio(); i++) {
			genero = arg.obtener(i);
			Object[] fila = { genero.getIdGenero(), genero.getDescripcion(), genero.getEpoca(), genero.estadoTipo() };
			modelo.addRow(fila);
		}
	}
	void limpieza() {
		txtIdGenero.setText("");
		txtDescripcion.setText("");
		txtDescripcion.requestFocus();
	}	
	
	
	void habilitarEntradas(boolean sino) {
		if (tipoOperacion == ADICIONAR){
			txtDescripcion.setEditable(sino);
			cboEpoca.setEnabled(sino);
			chkEstado.setEnabled(sino);
		}
	}
	void habilitarEntradaModificar(boolean sino){
		if (tipoOperacion == MODIFICAR){
			txtDescripcion.setEditable(sino);
			cboEpoca.setEditable(sino);
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
	
	
	//
	String leerCodigo() {
		return txtIdGenero.getText().trim();
	}
	
	String leerDescripcion() {
		return txtDescripcion.getText().trim();
	}
	private int leerEpoca() {
		return Integer.parseInt(cboEpoca.getSelectedItem().toString());
	}

	private boolean leerEstado() {
		return chkEstado.isSelected();
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
	
	void cargarEpocas() {
		int epoca = 1970;
		cboEpoca.addItem("[Seleccione]");
		while (epoca <= 2020) {
			cboEpoca.addItem(epoca);
			epoca += 10;
		}
	}
}
