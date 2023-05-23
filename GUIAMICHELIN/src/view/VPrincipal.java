package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import control.RestauranteListener;

public class VPrincipal extends JFrame {


	/**
	 * Launch the application.
	 */
	
	public static final int ANCHO = 700;
	public static final int ALTO = 500;
	private JPanel contentPane;
	public static final String SALIR = "Salir";
	public static final String REGISTRO = "Registro de Restaurante";
	public static final String MODIFICACION = "Modificación de Restaurante";
	public static final String CONSULTA = "Consulta de Restaurantes";
	private JMenuItem mntmOpcionRegistro;
	private JMenuItem mntmOpcionModificacion;
	private JScrollPane scrpContenedor;
	private JSeparator separator_2;
	private JMenuItem mntmOpcionConsulta;
	private JSeparator separator;
	private JMenuItem mnMenuSalir;
	
	public VPrincipal() {
		super("* * GUIA MICHELIN * *");
		configurarMenu();
		init();
	}


	private void configurarMenu() {
		// TODO Auto-generated method stub
		JMenuBar mnbBarraMenu = new JMenuBar();
		mnbBarraMenu.setFont(new Font("Arial", Font.PLAIN, 12));
		setJMenuBar(mnbBarraMenu);

		JMenu mnMenu1 = new JMenu("Mantenimiento Restaurantes");
		mnMenu1.setFont(new Font("Arial", Font.BOLD, 12));
		mnbBarraMenu.add(mnMenu1);
		
		mnMenuSalir = new JMenuItem(SALIR);
		mnMenuSalir.setFont(new Font("Arial", Font.BOLD, 12));
		mnbBarraMenu.add(mnMenuSalir);

		mntmOpcionConsulta = new JMenuItem(CONSULTA);
		mntmOpcionConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOpcionConsulta.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenu1.add(mntmOpcionConsulta);

		separator = new JSeparator();

		mnMenu1.add(separator);
		mntmOpcionRegistro = new JMenuItem(REGISTRO);
		mntmOpcionRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOpcionRegistro.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenu1.add(mntmOpcionRegistro);

		separator_2 = new JSeparator();
		mnMenu1.add(separator_2);

		mntmOpcionModificacion = new JMenuItem(MODIFICACION);
		mntmOpcionModificacion.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOpcionModificacion.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenu1.add(mntmOpcionModificacion);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
	}


	private void init() {
		// TODO Auto-generated method stub
		scrpContenedor = new JScrollPane();
		scrpContenedor.setBounds(0, 0, 686, 442);
		getContentPane().add(scrpContenedor);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		setSize(ANCHO, ALTO);
		centrarVentana();
	}
	private void centrarVentana() {
		// TODO Auto-generated method stub
		// Se obtienen las dimensiones en pixels de la pantalla.
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Crear un objeto de tipo Dimension con las medidas en pixels de la ventana.
		Dimension ventana = new Dimension(ANCHO, ALTO);
		// Una cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
	}
	
	public void hacerVisible() {
		setVisible(true);

	}
	public void setListener(RestauranteListener l) {
		mntmOpcionRegistro.addActionListener(l);
		mnMenuSalir.addActionListener(l);
		mntmOpcionModificacion.addActionListener(l);
		mntmOpcionConsulta.addActionListener(l);

	}
	public void cargarPanel(JPanel panel) {
		// TODO Auto-generated method stub
		scrpContenedor.setViewportView(panel);
	}

}
