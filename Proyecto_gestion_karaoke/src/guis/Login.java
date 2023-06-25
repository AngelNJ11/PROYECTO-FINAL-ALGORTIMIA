package guis;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArreUsuarios;
import clases.ClaseUsuarios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField txtLogin;
	private JTextField txtPassword;
	private JLabel lblTipo;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JButton btnIngresar;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbTipo;

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
		setBounds(100, 100, 313, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(21, 6, 123, 14);
		contentPane.add(lblTipo);
		
		lblLogin = new JLabel("Login :");
		lblLogin.setBounds(21, 31, 123, 14);
		contentPane.add(lblLogin);
		
		lblPassword = new JLabel("Password :");
		lblPassword.setBounds(21, 56, 123, 14);
		contentPane.add(lblPassword);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Adminsitrador", "Supervisor", "Mozo"}));
		cmbTipo.setBounds(155, 7, 140, 20);
		contentPane.add(cmbTipo);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(156, 28, 140, 20);
		contentPane.add(txtLogin);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(156, 53, 140, 20);
		contentPane.add(txtPassword);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(100, 82, 133, 48);
		contentPane.add(btnIngresar);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	
	ArreUsuarios arreusu = new ArreUsuarios();
	
	protected void actionPerformedBtnIngresar(ActionEvent e){
		
		
		String login = txtLogin.getText();
		String password = txtPassword.getText();
		int tipoEmpleado = cmbTipo.getSelectedIndex();
		ClaseUsuarios usu = arreusu.buscarUsuLogin(login, password, tipoEmpleado);

		if (usu != null) {
			Menu menu = new Menu();
			menu.x(tipoEmpleado);
			menu.setVisible(true);
			this.setVisible(false);
		} else {
			error("El login y/o el password es incorecto", txtLogin);
		}
		
		
		
		
	}
	
	
	
	
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informaci�n", 0);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
		
}
