package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mnMantenimiento;
	private JMenuItem mntmUsuario;
	private JMenuItem mntmCliente;
	private JMenuItem mntmGenero;
	private JMenuItem mntmArtista;
	private JMenuItem mntmCancion;
	private JMenuItem mntmBebida;
	private JMenuItem mntmPiqueo;
	private JMenu mnRegistroPedido;
	private JMenu mnRegistroConsumo;
	private JMenu mnConsulta;
	private JMenuItem mntmCancionesPedidas;
	private JMenuItem mntmPedidosCliente;
	private JMenuItem mntmPedidosFechas;
	private JMenuItem mntmUsuarioPedido;
	private JMenuItem mntmConsumoRegistrado;
	private JMenuItem mntmRegistroPedido;
	private JMenuItem mntmRegistroConsumo;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("ARCHIVO");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("MANTENIMIENTO");
		menuBar.add(mnMantenimiento);
		
		mntmUsuario = new JMenuItem("Usuario");
		mntmUsuario.addActionListener(this);
		mnMantenimiento.add(mntmUsuario);
		
		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(this);
		mnMantenimiento.add(mntmCliente);
		
		mntmGenero = new JMenuItem("Genero");
		mntmGenero.addActionListener(this);
		mnMantenimiento.add(mntmGenero);
		
		mntmArtista = new JMenuItem("Artista");
		mntmArtista.addActionListener(this);
		mnMantenimiento.add(mntmArtista);
		
		mntmCancion = new JMenuItem("Cancion");
		mntmCancion.addActionListener(this);
		mnMantenimiento.add(mntmCancion);
		
		mntmBebida = new JMenuItem("Bebida");
		mntmBebida.addActionListener(this);
		mnMantenimiento.add(mntmBebida);
		
		mntmPiqueo = new JMenuItem("Piqueo");
		mntmPiqueo.addActionListener(this);
		mnMantenimiento.add(mntmPiqueo);
		
		mnRegistroPedido = new JMenu("REGISTRO DE PEDIDO");
		menuBar.add(mnRegistroPedido);
		
		mntmRegistroPedido = new JMenuItem("Registro Pedido");
		mntmRegistroPedido.addActionListener(this);
		mnRegistroPedido.add(mntmRegistroPedido);
		
		mnRegistroConsumo = new JMenu("REGISTRO DE CONSUMO");
		menuBar.add(mnRegistroConsumo);
		
		mntmRegistroConsumo = new JMenuItem("Registro Consumo ");
		mntmRegistroConsumo.addActionListener(this);
		mnRegistroConsumo.add(mntmRegistroConsumo);
		
		mnConsulta = new JMenu("CONSULTA");
		menuBar.add(mnConsulta);
		
		mntmCancionesPedidas = new JMenuItem("Canciones m\u00E1s pedidas");
		mntmCancionesPedidas.addActionListener(this);
		mnConsulta.add(mntmCancionesPedidas);
		
		mntmPedidosCliente = new JMenuItem("Pedidos por cliente");
		mntmPedidosCliente.addActionListener(this);
		mnConsulta.add(mntmPedidosCliente);
		
		mntmPedidosFechas = new JMenuItem("Pedidos por rango de fechas");
		mntmPedidosFechas.addActionListener(this);
		mnConsulta.add(mntmPedidosFechas);
		
		JMenu mnReporte = new JMenu("REPORTE");
		menuBar.add(mnReporte);
		
		mntmUsuarioPedido = new JMenuItem(" Usuarios que han atendido m\u00E1s pedidos");
		mntmUsuarioPedido.addActionListener(this);
		mnReporte.add(mntmUsuarioPedido);
		
		mntmConsumoRegistrado = new JMenuItem(" Consumos registrados");
		mntmConsumoRegistrado.addActionListener(this);
		mnReporte.add(mntmConsumoRegistrado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

	public void actionPerformed(ActionEvent e) {
	    if(e.getSource() == mntmUsuario) {
	    	actionPerformedUsuario(e);
	    }
	    if(e.getSource() == mntmCliente) {
	    	actionPerformedCliente(e);
	    }
	    if(e.getSource() == mntmGenero) {
	    	actionPerformedGenero(e);
	    }
	    if(e.getSource() == mntmArtista) {
	    	actionPerformedArtista(e);
	    }
	    if(e.getSource() == mntmCancion) {
	    	actionPerformedCancion(e);
	    }
	    if(e.getSource() == mntmBebida) {
	    	actionPerformedBebida(e);
	    }
	    if(e.getSource() == mntmPiqueo) {
	    	actionPerformedPiqueo(e);
	    }
	    if(e.getSource() == mntmRegistroPedido) {
	    	actionPerformedRegistroPedido(e);
	    }
	    if(e.getSource() == mntmRegistroConsumo) {
	    	actionPerformedRegistroConsumo(e);
	    }
	    if(e.getSource() == mntmCancionesPedidas) {
	    	actionPerformedCancionesPedidas(e);
	    }
	    if(e.getSource() == mntmPedidosCliente) {
	    	actionPerformedPedidosCliente(e);
	    }
	    if(e.getSource() == mntmPedidosFechas) {
	    	actionPerformedPedidosFechas(e);
	    }
	    if(e.getSource() == mntmUsuarioPedido) {
	    	actionPerformedUsuarioPedido(e);
	    }
	    if(e.getSource() == mntmConsumoRegistrado) {
	    	actionPerformedConsumoRegistrado(e);
	    }
	    
	    if(e.getSource() == mntmSalir){
	    	actionPerformedSalir(e);
	    }
	    
	}
	
	public void actionPerformedUsuario(ActionEvent e) {
		Usuario usu = new Usuario();
		usu.setVisible(true);
	}
	
	public void actionPerformedCliente(ActionEvent e) {
		Cliente cli = new Cliente();
		cli.setVisible(true);
	}
	
	public void actionPerformedGenero(ActionEvent e) {
		Genero gen = new Genero();
		gen.setVisible(true);
	}
	
	public void actionPerformedArtista(ActionEvent e) {
		Artista art = new Artista();
		art.setVisible(true);
	}
	
	public void actionPerformedCancion(ActionEvent e) {
		Cancion can = new Cancion();
		can.setVisible(true);
	}
	
	public void actionPerformedBebida(ActionEvent e) {
		Bebidas beb = new Bebidas();
		beb.setVisible(true);
	}
	
	public void actionPerformedPiqueo(ActionEvent e) {
		Piqueo piq = new Piqueo();
		piq.setVisible(true);
	}
	
	public void actionPerformedRegistroPedido(ActionEvent e) {
		Registro_de_pedido reg = new Registro_de_pedido();
		reg.setVisible(true);
	}
	
	public void actionPerformedRegistroConsumo(ActionEvent e) {
		Registro_de_Consumo recon = new Registro_de_Consumo();
		recon.setVisible(true);
	}
	
	public void actionPerformedCancionesPedidas(ActionEvent e) {
		Canciones_mas_pedidas canpe = new Canciones_mas_pedidas();
		canpe.setVisible(true);
	}
	
	public void actionPerformedPedidosCliente(ActionEvent e) {
		Pedido_por_cliente pecli = new Pedido_por_cliente();
		pecli.setVisible(true);
	}
	
	public void actionPerformedPedidosFechas(ActionEvent e) {
		Pedido_por_rango_de_fecha pedfe = new Pedido_por_rango_de_fecha();
		pedfe.setVisible(true);
	}
	
	public void actionPerformedUsuarioPedido(ActionEvent e) {
		Usuarios_que_han_atendido_mas_pedidos usuate = new Usuarios_que_han_atendido_mas_pedidos();
		usuate.setVisible(true);
	}
	
	public void actionPerformedConsumoRegistrado(ActionEvent e) {
		Consumo_registrados conre = new Consumo_registrados();
		conre.setVisible(true);
	}
	
	
	public void actionPerformedSalir(ActionEvent e) {
		System.exit(0);
	}
	
	
	
}
