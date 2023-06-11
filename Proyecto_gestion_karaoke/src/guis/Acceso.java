package guis;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acceso extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Acceso dialog = new Acceso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Acceso() {
		setTitle("Acceso");
		setBounds(100, 100, 247, 135);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(110, 8, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 11, 90, 14);
		contentPanel.add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 36, 86, 14);
		contentPanel.add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 33, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(71, 62, 89, 23);
		contentPanel.add(btnNewButton);
	}
}
