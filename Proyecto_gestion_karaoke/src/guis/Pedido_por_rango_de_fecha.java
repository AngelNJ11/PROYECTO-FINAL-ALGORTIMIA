package guis;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Pedido_por_rango_de_fecha extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	private JLabel lblFechaInicio;
	private JTable table;
	private JLabel lblFechaDeFin;
	private JButton btnNewButton;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Pedido_por_rango_de_fecha dialog = new Pedido_por_rango_de_fecha();
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
	public Pedido_por_rango_de_fecha() {
		setTitle("Pedidos por rango de fecha");
		setBounds(100, 100, 710, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblFechaInicio = new JLabel("Fecha de inicio");
			lblFechaInicio.setBounds(10, 11, 86, 14);
			contentPanel.add(lblFechaInicio);
		}
		{
			lblFechaDeFin = new JLabel("Fecha de fin");
			lblFechaDeFin.setBounds(10, 36, 86, 14);
			contentPanel.add(lblFechaDeFin);
		}
		{
			txtFechaInicio = new JTextField();
			txtFechaInicio.setBounds(120, 8, 86, 20);
			contentPanel.add(txtFechaInicio);
			txtFechaInicio.setColumns(10);
		}
		{
			txtFechaFin = new JTextField();
			txtFechaFin.setColumns(10);
			txtFechaFin.setBounds(120, 33, 86, 20);
			contentPanel.add(txtFechaFin);
		}
		{
			btnNewButton = new JButton("Consultar");
			btnNewButton.setBounds(595, 7, 89, 23);
			contentPanel.add(btnNewButton);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 124, 674, 196);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
	}

}
