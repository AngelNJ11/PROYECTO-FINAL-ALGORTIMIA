package guis;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApeliidoPa;
	private JTextField txtApellidoMa;
	private JTextField txtLogin;
	private JTextField txtPassword;
	private JLabel lblNombres;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JLabel lblTipo;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JLabel lblTurno;
	private JButton btnGuardar;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbTipo;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbTurno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login frame = new Login();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Login() {
		setTitle("Formulario Usuario ");
		setBounds(100, 100, 434, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombres = new JLabel("Nombres :");
		lblNombres.setBounds(10, 11, 110, 14);
		contentPane.add(lblNombres);
		
		lblApellidoPaterno = new JLabel("Apellido Paterno :");
		lblApellidoPaterno.setBounds(10, 36, 110, 14);
		contentPane.add(lblApellidoPaterno);
		
		lblApellidoMaterno = new JLabel("Apellido Materno :");
		lblApellidoMaterno.setBounds(10, 61, 110, 14);
		contentPane.add(lblApellidoMaterno);
		
		lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(10, 86, 110, 14);
		contentPane.add(lblTipo);
		
		lblLogin = new JLabel("Login :");
		lblLogin.setBounds(10, 111, 110, 14);
		contentPane.add(lblLogin);
		
		lblPassword = new JLabel("Password :");
		lblPassword.setBounds(10, 136, 110, 14);
		contentPane.add(lblPassword);
		
		lblTurno = new JLabel("Turno :");
		lblTurno.setBounds(10, 161, 110, 14);
		contentPane.add(lblTurno);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(130, 8, 140, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApeliidoPa = new JTextField();
		txtApeliidoPa.setColumns(10);
		txtApeliidoPa.setBounds(130, 33, 140, 20);
		contentPane.add(txtApeliidoPa);
		
		txtApellidoMa = new JTextField();
		txtApellidoMa.setColumns(10);
		txtApellidoMa.setBounds(130, 58, 140, 20);
		contentPane.add(txtApellidoMa);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Adminsitrador", "Supervisor", "Mozo"}));
		cmbTipo.setBounds(130, 83, 140, 20);
		contentPane.add(cmbTipo);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(130, 108, 140, 20);
		contentPane.add(txtLogin);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(130, 133, 140, 20);
		contentPane.add(txtPassword);
		
		cmbTurno = new JComboBox();
		cmbTurno.setModel(new DefaultComboBoxModel(new String[] {"Tarde", "Noche"}));
		cmbTurno.setBounds(130, 158, 140, 20);
		contentPane.add(cmbTurno);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(298, 157, 110, 23);
		contentPane.add(btnGuardar);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}
	
	public static String nombres;
	public static String apellidoPaterno;
	public static String apellidoMaterno;
	public static int tipo;
	public static String login;
	public static String password;
	public static int turno;
	
	protected void actionPerformedBtnGuardar(ActionEvent e){
		nombres = txtNombre.getText();
		apellidoPaterno = txtApeliidoPa.getText();
		apellidoMaterno = txtApellidoMa.getText();
		tipo = cmbTipo.getSelectedIndex();
		login = txtLogin.getText();
		password = txtPassword.getText();
		turno = cmbTurno.getSelectedIndex();
		dispose();
	}
}
