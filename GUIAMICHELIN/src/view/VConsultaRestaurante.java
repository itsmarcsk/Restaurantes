package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.RestauranteListener;
import model.Filtro;
import model.Restaurantes;
import javax.swing.JScrollPane;

public class VConsultaRestaurante extends JPanel {
	private JLabel lblConsulta;
	private JLabel lblFiltro;
	private JLabel lblDistincion;
	private JLabel lblRegion;
	private JComboBox<String> cmbRegion;
	private JComboBox<String> cmbDistincion;
	private JButton btnConsulta;
	private DefaultComboBoxModel<String> dcbm;
	private DefaultComboBoxModel<String> dcbm2;
	public static final String CONSULTAR = "CONSULTA";
	public static final String ELIMINAR = "ELIMINAR";
	private DefaultTableModel model = new DefaultTableModel();
	public String[] column = new String[] { "NOMBRE", "CIUDAD", "DISTINCION", "COCINA", "PRECIO" };
	private JTable table;
	private JButton btnEliminar;
	public String[] listaR;
	public String[] listaD = { "TODAS" , "1 estrella" , "2 estrellas" , "3 estrellas"};
	private JScrollPane scrollPane;
	
	public VConsultaRestaurante() {
		init();

	}
	private void init() {
		setLayout(null);
		
		lblConsulta = new JLabel("Consulta de Restaurantes");
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsulta.setBounds(50, 25, 330, 69);
		add(lblConsulta);
		
		lblFiltro = new JLabel("Filtro");
		lblFiltro.setBounds(50, 104, 45, 13);
		add(lblFiltro);
		
		lblDistincion = new JLabel("Distincion:");
		lblDistincion.setBounds(209, 127, 71, 13);
		add(lblDistincion);
		
		lblRegion = new JLabel("Region:");
		lblRegion.setBounds(50, 127, 45, 13);
		add(lblRegion);
		
		cmbRegion = new JComboBox<String>();
		add(cmbRegion);
		
		cmbDistincion = new JComboBox<String>();
		cmbDistincion.setBounds(308, 123, 95, 17);
		dcbm2 = new DefaultComboBoxModel<String>(listaD);
		cmbDistincion.setModel(dcbm2);
		add(cmbDistincion);
		
		btnConsulta = new JButton(CONSULTAR);
		btnConsulta.setBounds(417, 183, 109, 21);
		add(btnConsulta);
		
		btnEliminar = new JButton(ELIMINAR);
		btnEliminar.setBounds(441, 220, 85, 21);
		add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 160, 393, 129);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		configurarTabla();
		hacerInvisible();
	}
	public void reiniciar() {
		cmbRegion.setSelectedIndex(0);
		cmbDistincion.setSelectedIndex(0);
		
	}
	public void setListener(RestauranteListener listener) {
		// TODO Auto-generated method stub
		btnConsulta.addActionListener(listener);
		cmbRegion.addActionListener(listener);
		cmbDistincion.addActionListener(listener);
		btnEliminar.addActionListener(listener);
	}
	
	public void configurarTabla() {
		model = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				/*
				 * if (column == 2) { return true; } else {
				 */
				return false;
				// }
			}

		};
		model.addColumn(column[0]);
		model.addColumn(column[1]);
		model.addColumn(column[2]);
		model.addColumn(column[3]);
		model.addColumn(column[4]);

		table.setModel(model);

	}
	public Filtro getDatos() {
		String region=(String) cmbRegion.getSelectedItem();
		int distincion = (int) cmbDistincion.getSelectedIndex();
		
		return new Filtro(region,distincion);
	}
	public void rellenarTabla(ArrayList<Restaurantes> lR) {
		// vaciamos la tabla
		model.setRowCount(0);

		Object[] fila = new Object[5];

		for (Restaurantes restaurantes : lR) {
			fila[0] = restaurantes.getNombre();
			fila[1] = restaurantes.getCiudad();
			if(restaurantes.getDistincion()==1) {
				fila[2] = "*";
			}else if(restaurantes.getDistincion() == 2) {
				fila[2] = "**";
			}else if(restaurantes.getDistincion() == 3) {
				fila[2] = "***";
			}
//			fila[2] = restaurantes.getDistincion();
			fila[3] = restaurantes.getCocina();
			fila[4] = restaurantes.getPrecio_min()+ "-" + restaurantes.getPrecio_max();
			model.addRow(fila);
		}
	}
	
	public void hacerTablaVisible() {
		table.setVisible(true);
		btnEliminar.setVisible(true);
		scrollPane.setVisible(true);
		
	}
	public String obtenerElemSel() {
		//FIXME solucionar error en caso de no seleccionar ninguno
		if(table.getSelectedRow()== -1) {
			mostrarError("No se ha seleccionado ninguna fila");
			return "";
		}else {
			return (String) table.getValueAt(table.getSelectedRow(), 0);
		}
		
	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
		
	}
	public void mostrarError(String error) {
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	public void setListaRegiones(String[] listaRegiones) {
	    this.listaR = listaRegiones;
	    cmbRegion.setBounds(104, 123, 81, 17);
	    dcbm = new DefaultComboBoxModel<>(listaR);
	    cmbRegion.setModel(dcbm);
	}

	
	public void hacerInvisible() {
		table.setVisible(false);
		btnEliminar.setVisible(false);
		scrollPane.setVisible(false);
	}
}
