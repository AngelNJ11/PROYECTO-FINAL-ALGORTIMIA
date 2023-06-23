package guis;

import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import arreglos.ArrePiqueos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mantePiqueo extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdPiqueo;
	private JTextField txtNombre;
	private JTable table;
	private JLabel lblIdPiqueo;
	private JLabel lblNombre;
	private JLabel lblIdTipoPiqueo;
	private JLabel lblPrecio;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JComboBox<String> cbmEstado;
	private JButton btnListar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel label;
	private JTextField txtPrecio;
	private JComboBox<String> cmbTipoPiqueo;
	private JButton button;
	private JButton btnBuscar;

	
	// Tipo de operaci�n a procesar: Adicionar, Consultar, Modificar o Eliminar

	
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public mantePiqueo() {
		setTitle("Piqueo");
		setBounds(100, 100, 882, 457);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblIdPiqueo = new JLabel("Id Piqueo:");
		lblIdPiqueo.setBounds(10, 11, 134, 14);
		contentPanel.add(lblIdPiqueo);
		
		lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(10, 36, 134, 14);
		contentPanel.add(lblNombre);
		
		lblIdTipoPiqueo = new JLabel("Tipo Piqueo:");
		lblIdTipoPiqueo.setBounds(10, 61, 134, 14);
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
		txtNombre.setColumns(10);
		txtNombre.setBounds(105, 33, 123, 20);
		contentPanel.add(txtNombre);
		
		cbmEstado = new JComboBox<String>();
		cbmEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"Inhabilitado", "Habilitado"}));
		cbmEstado.setBounds(324, 34, 123, 20);
		contentPanel.add(cbmEstado);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(778, 82, 89, 23);
		contentPanel.add(btnListar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(778, 32, 89, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(778, 57, 89, 23);
		contentPanel.add(btnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(459, 36, 123, 23);
		contentPanel.add(btnAceptar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 857, 288);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		label = new JLabel("Estado:");
		label.setBounds(241, 36, 89, 14);
		contentPanel.add(label);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(324, 8, 123, 20);
		contentPanel.add(txtPrecio);
		
		cmbTipoPiqueo = new JComboBox<String>();
		cmbTipoPiqueo.setModel(new DefaultComboBoxModel<String>(new String[] {"Frios", "Calientes", "Snacks"}));
		cmbTipoPiqueo.setBounds(106, 62, 123, 20);
		contentPanel.add(cmbTipoPiqueo);
		
		button = new JButton("Opciones");
		button.setEnabled(false);
		button.setBounds(643, 6, 123, 98);
		contentPanel.add(button);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(459, 11, 123, 23);
		contentPanel.add(btnBuscar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(778, 6, 89, 25);
		contentPanel.add(btnNuevo);
	}
	
	ArrePiqueos piq = new ArrePiqueos();
	private JButton btnNuevo;
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {

	}
}
