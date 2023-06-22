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
	private JPanel contentPane;
	private JLabel lblIdBebida;
	private JLabel lblApellidoMaterno;
	private JLabel lblApellidoPaterno;
	private JLabel lblNombres;
	private JLabel lblTipoDeEmpleado;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JLabel lblTurno;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox<String> cmbEmpleado;
	private JComboBox<String> cmbTurno;
	private JButton btnBuscar;
	private JButton btnAceptar;
	private JButton btnOpciones;
	private JButton btnNuevo;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;

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
		setBounds(100, 100, 797, 450);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		
		lblIdBebida = new JLabel("ID Bebida :");
		lblIdBebida.setBounds(10, 11, 120, 14);
		contentPane.add(lblIdBebida);
		
		lblApellidoMaterno = new JLabel("Apellido Materno :");
		lblApellidoMaterno.setBounds(10, 61, 120, 14);
		contentPane.add(lblApellidoMaterno);
		
		lblApellidoPaterno = new JLabel("Apellido Paterno :");
		lblApellidoPaterno.setBounds(10, 36, 120, 14);
		contentPane.add(lblApellidoPaterno);
		
		lblNombres = new JLabel("Nombres :");
		lblNombres.setBounds(10, 86, 120, 14);
		contentPane.add(lblNombres);
		
		lblTipoDeEmpleado = new JLabel("Tipo de empleado :");
		lblTipoDeEmpleado.setBounds(10, 111, 120, 14);
		contentPane.add(lblTipoDeEmpleado);
		
		lblLogin = new JLabel("Login :");
		lblLogin.setBounds(270, 11, 85, 14);
		contentPane.add(lblLogin);
		
		lblPassword = new JLabel("Password :");
		lblPassword.setBounds(270, 36, 85, 14);
		contentPane.add(lblPassword);
		
		lblTurno = new JLabel("Turno :");
		lblTurno.setBounds(270, 61, 85, 14);
		contentPane.add(lblTurno);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(140, 8, 120, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(140, 33, 120, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(140, 58, 120, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(140, 83, 120, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(365, 8, 120, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(365, 33, 120, 20);
		contentPane.add(textField_5);
		
		cmbEmpleado = new JComboBox<String>();
		cmbEmpleado.setEnabled(false);
		cmbEmpleado.setBounds(140, 108, 120, 20);
		contentPane.add(cmbEmpleado);
		
		cmbTurno = new JComboBox<String>();
		cmbTurno.setEnabled(false);
		cmbTurno.setBounds(365, 58, 120, 20);
		contentPane.add(cmbTurno);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(365, 82, 120, 23);
		contentPane.add(btnBuscar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(365, 107, 120, 23);
		contentPane.add(btnAceptar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(549, 5, 140, 95);
		contentPane.add(btnOpciones);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(701, 8, 89, 23);
		contentPane.add(btnNuevo);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(701, 33, 89, 23);
		contentPane.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(701, 58, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(701, 83, 89, 23);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 934, 328);
		contentPane.add(scrollPane);
	}

}
