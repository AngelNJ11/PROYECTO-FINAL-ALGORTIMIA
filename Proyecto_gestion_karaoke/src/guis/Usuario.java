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
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArreUsuarios;
import clases.ClaseUsuarios;

public class Usuario extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JTextField txtNombre;
	@SuppressWarnings("rawtypes")
	private JComboBox cbmTipoEmpleado;
	private JButton bntListar;
	private JButton btnModificar;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblCdigo;
	private JLabel lblNombre;
	private JLabel lblTipo;
	private JButton btnFiltar;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Usuario dialog = new Usuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Usuario() {
		setTitle("Usuario");
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(106, 8, 86, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(314, 8, 170, 20);
		contentPanel.add(txtNombre);
		
		cbmTipoEmpleado = new JComboBox();
		cbmTipoEmpleado.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Supervisor", "Mozo"}));
		cbmTipoEmpleado.setBounds(106, 39, 120, 20);
		contentPanel.add(cbmTipoEmpleado);
		
		bntListar = new JButton("Nuevo");
		bntListar.addActionListener(this);
		bntListar.setBounds(494, 7, 89, 23);
		contentPanel.add(bntListar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(685, 7, 89, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(685, 38, 89, 23);
		contentPanel.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 764, 369);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre completo");
		modelo.addColumn("Tipo");
		modelo.addColumn("Login");
		modelo.addColumn("Password");
		modelo.addColumn("Turno");
		table.setModel(modelo);
		
		ajustarAnchoColumnas();
		listar();
		
		lblCdigo = new JLabel("C\u00F3digo :");
		lblCdigo.setBounds(10, 11, 86, 14);
		contentPanel.add(lblCdigo);
		
		lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(230, 11, 74, 14);
		contentPanel.add(lblNombre);
		
		lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(10, 42, 46, 14);
		contentPanel.add(lblTipo);
		
		btnFiltar = new JButton("Filtar");
		btnFiltar.addActionListener(this);
		btnFiltar.setBounds(314, 38, 89, 23);
		contentPanel.add(btnFiltar);
	}
	ArreUsuarios arrUs = new ArreUsuarios();

	int idUsuario;
	String nombres;
	String apePaterno;
	String apeMaterno;
	int tipo;
	String login;
	String password;
	int turno;
	private JButton btnEliminar;

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnFiltar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == bntListar) {
			actionPerformedBtnNuevo(arg0);
		}
	}

	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		Form_Usuario formUs = new Form_Usuario();
		formUs.setLocationRelativeTo(this);
		formUs.setVisible(true);
		formUs.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		formUs.addWindowListener(new WindowListener() {

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				idUsuario = arrUs.tamanio() + 1;
				nombres = Form_Usuario.nombres;
				apePaterno = Form_Usuario.apellidoPaterno;
				apeMaterno = Form_Usuario.apellidoMaterno;
				tipo = Form_Usuario.tipo;
				login = Form_Usuario.login;
				password = Form_Usuario.password;
				turno = Form_Usuario.turno;
				ClaseUsuarios Usuario = new ClaseUsuarios(idUsuario, nombres, apePaterno, apeMaterno, tipo, login, password, turno);
				arrUs.adicionar(Usuario);
				listar();
				mensaje("Registro exitoso");
			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	}
	
	void ajustarAnchoColumnas(){
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(5)); // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20)); // nombre completo
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10)); // tipo
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10)); // login
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10)); // password
		tcm.getColumn(5).setPreferredWidth(anchoColumna(10)); 
	}
	
	
	void listar(){
		ClaseUsuarios usu;
		modelo.setRowCount(0);
		for(int i = 0; i < arrUs.tamanio(); i++){
			usu = arrUs.obtener(i);
			Object[] fila ={
					usu.correlativ(usu.getIdUsuario()),
					usu.nombreComple(),
					usu.cargo(usu.getTipoEmpleado()),
					usu.getLogin(),
					usu.getPassword(),
					usu.turno(usu.getTurno())
			};
			modelo.addRow(fila);
		}
	}
	void mensaje(String s){
		JOptionPane.showMessageDialog(this, s, "Persona", 1);
	}
	
	int anchoColumna(int porcentaje){
		return porcentaje *scrollPane.getWidth() / 100;
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		ClaseUsuarios usu;
		tipo = cbmTipoEmpleado.getSelectedIndex();
		nombres = txtNombre.getText();
		modelo.setRowCount(0);
		for(int i = 0; i <arrUs.tamanio(); i++){
			usu = arrUs.obtener(i);
			nombres = txtNombre.getText().isEmpty() ? usu.nombreComple().toLowerCase() : nombres;
			if(usu != null && usu.getTipoEmpleado() == tipo && usu.nombreComple().toLowerCase().contains(nombres)){
				Object[] fila ={
						usu.correlativ(usu.getIdUsuario()),
						usu.nombreComple(),
						usu.cargo(usu.getTipoEmpleado()),
						usu.getLogin(),
						usu.getPassword(),
						usu.turno(usu.getTurno())
				};
				modelo.addRow(fila);
			}
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0){
		txtNombre.setText("");
		cbmTipoEmpleado.setSelectedIndex(0);
		listar();
	}
}
