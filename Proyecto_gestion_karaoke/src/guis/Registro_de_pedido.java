package guis;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Registro_de_pedido extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdPedido;
	private JTextField txtFechaPedido;
	private JTextField txtIdUsuario;
	private JTextField txtIdCliente;
	private JLabel lblIdPedido;
	private JLabel lblFechaPedido;
	private JLabel lblIdUsuario;
	private JLabel lblIdCliente;
	private JScrollPane scrollResultado;
	private JTable tableResultado;
	private JLabel lblCanciones;
	private JLabel lblBebidas;
	private JComboBox<String> cmbUsuario;
	private JComboBox<String> cmbCliente;
	private JComboBox<String> cmbCanciones;
	private JComboBox<String> cmbBebidas;
	private JLabel lblPiqueos;
	private JLabel lblEstado;
	private JComboBox<String> cmbPiqueo;
	private JComboBox<String> cmbEstado;
	private JButton btnAceptar;
	private JButton btnListar;
	private JButton btnModificar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registro_de_pedido dialog = new Registro_de_pedido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Registro_de_pedido() {
		setTitle("Reporte Pedido");
		setBounds(100, 100, 1000, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblIdPedido = new JLabel("Id Pedido");
		lblIdPedido.setBounds(10, 11, 110, 14);
		contentPanel.add(lblIdPedido);
		
		lblFechaPedido = new JLabel("Fecha Pedido");
		lblFechaPedido.setBounds(10, 36, 110, 14);
		contentPanel.add(lblFechaPedido);
		
		lblIdUsuario = new JLabel("Id Usuario");
		lblIdUsuario.setBounds(10, 61, 110, 14);
		contentPanel.add(lblIdUsuario);
		
		lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(10, 86, 110, 14);
		contentPanel.add(lblIdCliente);
		
		lblCanciones = new JLabel("Canciones");
		lblCanciones.setBounds(275, 11, 110, 14);
		contentPanel.add(lblCanciones);
		
		lblBebidas = new JLabel("Bebidas");
		lblBebidas.setBounds(275, 36, 110, 14);
		contentPanel.add(lblBebidas);
		
		lblPiqueos = new JLabel("Piqueos");
		lblPiqueos.setBounds(500, 11, 110, 14);
		contentPanel.add(lblPiqueos);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(500, 36, 110, 14);
		contentPanel.add(lblEstado);
		
		txtIdPedido = new JTextField();
		txtIdPedido.setEditable(false);
		txtIdPedido.setBounds(105, 8, 130, 20);
		contentPanel.add(txtIdPedido);
		txtIdPedido.setColumns(10);
		
		txtFechaPedido = new JTextField();
		txtFechaPedido.setColumns(10);
		txtFechaPedido.setBounds(105, 33, 130, 20);
		contentPanel.add(txtFechaPedido);
		
		txtIdUsuario = new JTextField();
		txtIdUsuario.setEditable(false);
		txtIdUsuario.setColumns(10);
		txtIdUsuario.setBounds(105, 61, 130, 20);
		contentPanel.add(txtIdUsuario);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setEditable(false);
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(105, 86, 130, 20);
		contentPanel.add(txtIdCliente);
		
		cmbCanciones = new JComboBox<String>();
		cmbCanciones.setBounds(347, 8, 120, 20);
		contentPanel.add(cmbCanciones);
		
		cmbBebidas = new JComboBox<String>();
		cmbBebidas.setBounds(347, 33, 120, 20);
		contentPanel.add(cmbBebidas);
		
		cmbPiqueo = new JComboBox<String>();
		cmbPiqueo.setBounds(559, 8, 120, 20);
		contentPanel.add(cmbPiqueo);
		
		cmbEstado = new JComboBox<String>();
		cmbEstado.setBounds(559, 33, 120, 20);
		contentPanel.add(cmbEstado);
		
		cmbUsuario = new JComboBox<String>();
		cmbUsuario.setBounds(275, 61, 120, 20);
		contentPanel.add(cmbUsuario);
		
		cmbCliente = new JComboBox<String>();
		cmbCliente.setBounds(275, 86, 120, 20);
		contentPanel.add(cmbCliente);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(689, 7, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(885, 7, 89, 23);
		contentPanel.add(btnListar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(885, 32, 89, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(885, 57, 89, 23);
		contentPanel.add(btnEliminar);
		
		scrollResultado = new JScrollPane();
		scrollResultado.setBounds(10, 111, 964, 289);
		contentPanel.add(scrollResultado);
		
		tableResultado = new JTable();
		scrollResultado.setViewportView(tableResultado);
	}
}
