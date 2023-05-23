package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import control.RestauranteListener;
import model.Restaurantes;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

//Se haya introducido un nombre
//- Se haya introducido una ciudad.
//- Si se ha introducido precio mínimo y precio máximo deben ser valores numéricos
//- Si se han introducido precio mínimo y precio máximo, el precio mínimo no puede ser
//superior al máximo.
public class VRegistro extends JPanel {
	private JTextField txtNombre;
	private JTextField txtCiudad;
	private JTextField txtDireccion;
	private JTextField txtPrecMin;
	private JTextField txtPrecioMax;
	private JTextField txtTel;
	private JTextField txtWeb;
	private DefaultComboBoxModel<String> dcbm;
	private DefaultComboBoxModel<String> dcbm1;
	private JLabel lblRegistro;
	private JLabel lblNombre;
	private JLabel lblCocina;
	private JLabel lblRegion;
	private JLabel lblCiudad;
	private JLabel lblDireccion;
	private JLabel lblDistincion;
	private JLabel lblPrecMin;
	private JLabel lblPrecMax;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JLabel lblTelefono;
	private JLabel lblWeb;
	private JComboBox<String> cmbCocina;
	private JComboBox<String> cmbRegion;
	private JSpinner spnDistincion;
	public static final String GUARDAR = "GUARDAR";
	public static final String ELIMINAR = "LIMPIAR DATOS";

	public VRegistro() {

		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setLayout(null);

		lblRegistro = new JLabel("Registrar restaurante");
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(29, 10, 232, 30);
		add(lblRegistro);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(29, 60, 45, 13);
		add(lblNombre);

		lblCocina = new JLabel("Cocina:");
		lblCocina.setBounds(241, 60, 45, 13);
		add(lblCocina);

		lblRegion = new JLabel("Region:");
		lblRegion.setBounds(29, 99, 45, 13);
		add(lblRegion);

		lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(241, 99, 45, 13);
		add(lblCiudad);

		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(29, 142, 52, 13);
		add(lblDireccion);

		lblDistincion = new JLabel("Distincion:");
		lblDistincion.setBounds(29, 186, 52, 13);
		add(lblDistincion);

		lblPrecMin = new JLabel("Precio mínimo:");
		lblPrecMin.setBounds(148, 186, 69, 13);
		add(lblPrecMin);

		lblPrecMax = new JLabel("máximo:");
		lblPrecMax.setBounds(299, 186, 45, 13);
		add(lblPrecMax);

		btnGuardar = new JButton(GUARDAR);
		btnGuardar.setBounds(68, 269, 85, 21);
		add(btnGuardar);

		btnEliminar = new JButton(ELIMINAR);
		btnEliminar.setBounds(213, 269, 114, 21);
		add(btnEliminar);

		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(29, 230, 45, 13);
		add(lblTelefono);

		lblWeb = new JLabel("Web:");
		lblWeb.setBounds(186, 230, 31, 13);
		add(lblWeb);

		txtNombre = new JTextField();
		txtNombre.setToolTipText("Introduce nombre");
		txtNombre.setBounds(88, 57, 96, 19);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtCiudad = new JTextField();
		txtCiudad.setToolTipText("Introduce ciudad");
		txtCiudad.setBounds(295, 96, 108, 19);
		add(txtCiudad);
		txtCiudad.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setToolTipText("Introduce dirección");
		txtDireccion.setBounds(99, 139, 258, 19);
		add(txtDireccion);
		txtDireccion.setColumns(10);

		txtPrecMin = new JTextField();
		txtPrecMin.setToolTipText("Introduce precio minimo");
		txtPrecMin.setBounds(227, 183, 59, 19);
		add(txtPrecMin);
		txtPrecMin.setColumns(10);

		txtPrecioMax = new JTextField();
		txtPrecioMax.setToolTipText("Introduce precio máximo");
		txtPrecioMax.setBounds(344, 183, 59, 19);
		add(txtPrecioMax);
		txtPrecioMax.setColumns(10);

		txtTel = new JTextField();
		txtTel.setToolTipText("Introduce número de teléfono");
		txtTel.setBounds(84, 227, 80, 19);
		add(txtTel);
		txtTel.setColumns(10);

		txtWeb = new JTextField();
		txtWeb.setToolTipText("Introduce página web");
		txtWeb.setBounds(213, 227, 190, 19);
		add(txtWeb);
		txtWeb.setColumns(10);

		cmbCocina = new JComboBox<String>();
		dcbm1 = new DefaultComboBoxModel<String>(Restaurantes.COCINA);
		cmbCocina.setModel(dcbm1);
		cmbCocina.setBounds(296, 56, 107, 21);
		add(cmbCocina);

		cmbRegion = new JComboBox<String>();
		dcbm = new DefaultComboBoxModel<String>(Restaurantes.REGIONES);
		cmbRegion.setModel(dcbm);
		cmbRegion.setBounds(84, 95, 97, 21);
		add(cmbRegion);

		spnDistincion = new JSpinner();
		spnDistincion.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spnDistincion.setBounds(88, 183, 30, 20);
		add(spnDistincion);
	}

	public Restaurantes getDatos() {
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
		telefono = txtTel.getText();
		web = txtWeb.getText();
		distincion = (int) spnDistincion.getValue();
		region = (String) cmbRegion.getSelectedItem();
		cocina = (String) cmbCocina.getSelectedItem();

		if (!txtPrecMin.getText().equals("")) {
			try {
				precioMin = Double.parseDouble(txtPrecMin.getText().trim());
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
				mostrarError("Precio máximo tiene que ser numérico");
			}

		}

		return new Restaurantes(nombre, region, ciudad, distincion, direccion, precioMin, precioMax, cocina, telefono,
				web);
	}

	public void reiniciar() {
		spnDistincion.setValue(1);
		txtNombre.setText("");
		txtCiudad.setText("");
		txtDireccion.setText("");
		txtPrecMin.setText("");
		txtPrecioMax.setText("");
		txtTel.setText("");
		txtWeb.setText("");
		cmbCocina.setSelectedIndex(0);
		cmbRegion.setSelectedIndex(0);

	}

	public void setListener(RestauranteListener l) {
		btnEliminar.addActionListener(l);
		btnGuardar.addActionListener(l);
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

	}

	public void mostrarError(String error) {
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);

	}
}
