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

public class Bebidas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdBebida;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTable table;
	private JLabel lblIdBebida;
	private JLabel lblNombre;
	private JLabel lblIdTipoBebida;
	private JLabel lblMarca;
	private JLabel lblPrecio;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JComboBox<String> cbmEstado;
	private JButton btnListar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel label;
	private JTextField txtPrecio;
	private JComboBox<String> cmbTipoBebida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Bebidas dialog = new Bebidas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Bebidas() {
		setTitle("Bebida");
		setBounds(100, 100, 740, 404);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblIdBebida = new JLabel("Id Bebida:");
		lblIdBebida.setBounds(10, 11, 134, 14);
		contentPanel.add(lblIdBebida);
		
		lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(10, 36, 134, 14);
		contentPanel.add(lblNombre);
		
		lblIdTipoBebida = new JLabel("Tipo Bebida:");
		lblIdTipoBebida.setBounds(10, 61, 134, 14);
		contentPanel.add(lblIdTipoBebida);
		
		lblMarca = new JLabel("Marca :");
		lblMarca.setBounds(295, 11, 134, 14);
		contentPanel.add(lblMarca);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(295, 36, 134, 14);
		contentPanel.add(lblPrecio);
		
		txtIdBebida = new JTextField();
		txtIdBebida.setEditable(false);
		txtIdBebida.setBounds(117, 8, 168, 20);
		contentPanel.add(txtIdBebida);
		txtIdBebida.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(117, 33, 168, 20);
		contentPanel.add(txtNombre);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(369, 8, 123, 20);
		contentPanel.add(txtMarca);
		
		cbmEstado = new JComboBox<String>();
		cbmEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"Inhabilitado", "Habilitado"}));
		cbmEstado.setBounds(369, 58, 123, 20);
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
		label.setBounds(295, 61, 134, 14);
		contentPanel.add(label);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(369, 33, 123, 20);
		contentPanel.add(txtPrecio);
		
		cmbTipoBebida = new JComboBox<String>();
		cmbTipoBebida.setModel(new DefaultComboBoxModel<String>(new String[] {"Cerveza", "Vinos", "Whisky", "Ron", "Frutado", "Combinaci\u00F3n preparada", "Agua embotellada"}));
		cmbTipoBebida.setBounds(117, 58, 168, 20);
		contentPanel.add(cmbTipoBebida);
	}

}
