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

public class Piqueo extends JDialog {
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Piqueo dialog = new Piqueo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Piqueo() {
		setTitle("Piqueo");
		setBounds(100, 100, 740, 404);
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
		lblPrecio.setBounds(295, 11, 134, 14);
		contentPanel.add(lblPrecio);
		
		txtIdPiqueo = new JTextField();
		txtIdPiqueo.setEditable(false);
		txtIdPiqueo.setBounds(117, 8, 168, 20);
		contentPanel.add(txtIdPiqueo);
		txtIdPiqueo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(117, 33, 168, 20);
		contentPanel.add(txtNombre);
		
		cbmEstado = new JComboBox<String>();
		cbmEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"Inhabilitado", "Habilitado"}));
		cbmEstado.setBounds(369, 33, 123, 20);
		contentPanel.add(cbmEstado);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(625, 7, 89, 23);
		contentPanel.add(btnListar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(625, 32, 89, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(625, 57, 89, 23);
		contentPanel.add(btnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(502, 7, 89, 23);
		contentPanel.add(btnAceptar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 704, 261);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		label = new JLabel("Estado:");
		label.setBounds(295, 36, 134, 14);
		contentPanel.add(label);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(369, 8, 123, 20);
		contentPanel.add(txtPrecio);
		
		cmbTipoPiqueo = new JComboBox<String>();
		cmbTipoPiqueo.setModel(new DefaultComboBoxModel<String>(new String[] {"Frios", "Calientes", "Snacks"}));
		cmbTipoPiqueo.setBounds(117, 58, 168, 20);
		contentPanel.add(cmbTipoPiqueo);
	}
}
