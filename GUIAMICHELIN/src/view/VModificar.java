package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import control.RestauranteListener;
import model.Restaurantes;

public class VModificar extends JPanel {
	private JTextField txtNombre;
	private JTextField txtCiudad;
	private JTextField txtDireccion;
	private JTextField txtPrecioMin;
	private JTextField txtPrecioMax;
	private JTextField txtTelefono;
	private JTextField txtWeb;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblModificar;
	private JLabel lblNombre;
	private JButton btnBuscar;
	private JLabel lblRegion;
	private JLabel lblCiudad;
	private JLabel lblDireccion;
	private JLabel lblCocina;
	private JLabel lblDistincion;
	private JSpinner spnDistincion;
	private JLabel lblPrecioMin;
	private JLabel lblPrecioMax;
	private JLabel lblTelefono;
	private JLabel lblWeb;
	private DefaultComboBoxModel<String> dcbm;
	private DefaultComboBoxModel<String> dcbm1;
	private JComboBox<String> cmbCocina;
	private JComboBox<String> cmbRegion;
	public static final String GUARDAR = "Guardar";
	public static final String CANCELAR = "Cancelar";
	public static final String BUSCAR = "Buscar";

	public VModificar() {

		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setLayout(null);

		lblModificar = new JLabel("Modificar restaurante");
		lblModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModificar.setBounds(10, 10, 154, 29);
		add(lblModificar);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 65, 45, 13);
		add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(68, 62, 96, 19);
		add(txtNombre);
		txtNombre.setColumns(10);

		btnBuscar = new JButton(BUSCAR);
		btnBuscar.setBounds(322, 61, 85, 21);
		add(btnBuscar);

		lblRegion = new JLabel("Region:");
		lblRegion.setBounds(10, 104, 45, 13);
		add(lblRegion);

		cmbRegion = new JComboBox<String>();
		dcbm = new DefaultComboBoxModel<String>(Restaurantes.REGIONES);
		cmbRegion.setModel(dcbm);
		cmbRegion.setEnabled(false);
		cmbRegion.setBounds(68, 100, 96, 21);
		add(cmbRegion);

		lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(234, 104, 45, 13);
		add(lblCiudad);

		txtCiudad = new JTextField();
		txtCiudad.setEnabled(false);
		txtCiudad.setBounds(303, 101, 96, 19);
		add(txtCiudad);
		txtCiudad.setColumns(10);

		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 153, 55, 13);
		add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setBounds(68, 150, 187, 19);
		add(txtDireccion);
		txtDireccion.setColumns(10);

		lblCocina = new JLabel("Cocina:");
		lblCocina.setBounds(269, 153, 45, 13);
		add(lblCocina);

		cmbCocina = new JComboBox<String>();
		dcbm1 = new DefaultComboBoxModel<String>(Restaurantes.COCINA);
		cmbCocina.setModel(dcbm1);
		cmbCocina.setEnabled(false);
		cmbCocina.setBounds(334, 149, 73, 21);
		add(cmbCocina);

		lblDistincion = new JLabel("Distincion:");
		lblDistincion.setBounds(10, 205, 55, 13);
		add(lblDistincion);

		spnDistincion = new JSpinner();
		spnDistincion.setEnabled(false);
		spnDistincion.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spnDistincion.setBounds(90, 202, 30, 20);
		add(spnDistincion);

		lblPrecioMin = new JLabel("Precio minimo:");
		lblPrecioMin.setBounds(130, 205, 73, 13);
		add(lblPrecioMin);

		txtPrecioMin = new JTextField();
		txtPrecioMin.setEnabled(false);
		txtPrecioMin.setBounds(213, 202, 66, 19);
		add(txtPrecioMin);
		txtPrecioMin.setColumns(10);

		lblPrecioMax = new JLabel("maximo");
		lblPrecioMax.setBounds(289, 205, 45, 13);
		add(lblPrecioMax);

		txtPrecioMax = new JTextField();
		txtPrecioMax.setEnabled(false);
		txtPrecioMax.setBounds(344, 202, 66, 19);
		add(txtPrecioMax);
		txtPrecioMax.setColumns(10);

		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(10, 246, 45, 13);
		add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setBounds(68, 243, 96, 19);
		add(txtTelefono);
		txtTelefono.setColumns(10);

		lblWeb = new JLabel("Web:");
		lblWeb.setBounds(194, 246, 45, 13);
		add(lblWeb);

		txtWeb = new JTextField();
		txtWeb.setEnabled(false);
		txtWeb.setBounds(249, 243, 158, 19);
		add(txtWeb);
		txtWeb.setColumns(10);

		btnGuardar = new JButton(GUARDAR);
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(92, 272, 85, 21);
		add(btnGuardar);

		btnCancelar = new JButton(CANCELAR);
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(249, 272, 85, 21);
		add(btnCancelar);
	}

	public void setListener(RestauranteListener l) {
		btnBuscar.addActionListener(l);
		btnCancelar.addActionListener(l);
		btnGuardar.addActionListener(l);
		cmbCocina.addActionListener(l);
		cmbRegion.addActionListener(l);

	}

	public String getDatos() {
		String nombre = "";
		nombre = txtNombre.getText();

		return nombre;
	}

	public void meterDatos(String nombre, String ciudad, String direccion, String telefono, String web, int distincion,
			String region, String cocina, double precioMin, double precioMax) {
		txtNombre.setText(nombre);
		txtCiudad.setText(ciudad);
		txtDireccion.setText(direccion);
		txtTelefono.setText(telefono);
		txtWeb.setText(web);
		spnDistincion.setValue(distincion);
		int pos = 0;
		for (int i = 0; i < Restaurantes.COCINA.length; i++) {
			if(cocina == Restaurantes.COCINA[i]) {
				pos = 0;
			}
		}
		cmbCocina.setSelectedIndex(pos);
		for (int i = 0; i < Restaurantes.REGIONES.length; i++) {
			if(region == Restaurantes.REGIONES[i]) {
				pos = 0;
			}
		}
		cmbRegion.setSelectedIndex(pos);
		String pM = String.valueOf(precioMin);
		String pMax = String.valueOf(precioMax);
		txtPrecioMin.setText(pM);
		txtPrecioMax.setText(pMax);	
		}

	public Restaurantes getDatos1() {
		String nombre = "";
		String ciudad = "";
		String direccion = "";
		String telefono = "";
		String web = "";
		int distincion = 0;
		String region = "";
		String cocina = "";
		double precioMin = 0;
		double precioMax = 0;
		nombre = txtNombre.getText();
		ciudad = txtCiudad.getText();
		direccion = txtDireccion.getText();
		telefono = txtTelefono.getText();
		web = txtWeb.getText();
		distincion = (int) spnDistincion.getValue();
		region = (String) cmbRegion.getSelectedItem();
		cocina = (String) cmbCocina.getSelectedItem();

		if (!txtPrecioMin.getText().equals("")) {
			try {
				precioMin = Double.parseDouble(txtPrecioMin.getText().trim());
			} catch (Exception e) {
				// TODO: handle exception
				mostrarError("Precio mínimo tinene que ser numérico");
			}
		}
		if (!txtPrecioMax.getText().equals("")) {
			try {
				precioMax = Double.parseDouble(txtPrecioMax.getText().trim());
			} catch (Exception e) {
				// TODO: handle exception
				mostrarError("Precio máximo tinene que ser numérico");
			}

		}

		return new Restaurantes(nombre, region, ciudad, distincion, direccion, precioMin, precioMax, cocina, telefono,
				web);

	}

	public void activar() {
		cmbCocina.setEnabled(true);
		cmbRegion.setEnabled(true);
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
		spnDistincion.setEnabled(true);
		txtCiudad.setEnabled(true);

		txtDireccion.setEnabled(true);
		txtPrecioMax.setEnabled(true);
		txtPrecioMin.setEnabled(true);
		txtTelefono.setEnabled(true);
		txtWeb.setEnabled(true);
		txtNombre.setEnabled(false);
		btnBuscar.setEnabled(false);
	}

	public void desactivar() {
		cmbCocina.setEnabled(false);
		cmbRegion.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);
		spnDistincion.setEnabled(false);
		txtCiudad.setEnabled(false);
		txtDireccion.setEnabled(false);
		txtPrecioMax.setEnabled(false);
		txtPrecioMin.setEnabled(false);
		txtTelefono.setEnabled(false);
		txtWeb.setEnabled(false);
		txtNombre.setEnabled(true);
		btnBuscar.setEnabled(true);
	}

	public void reiniciar() {
		spnDistincion.setValue(1);
		txtNombre.setText("");
		txtCiudad.setText("");
		txtDireccion.setText("");
		txtPrecioMin.setText("");
		txtPrecioMax.setText("");
		txtTelefono.setText("");
		txtNombre.setText("");
		txtWeb.setText("");
		cmbCocina.setSelectedIndex(0);
		cmbRegion.setSelectedIndex(0);
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

	}

	public void mostrarError(String error) {
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);

	}
}