package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import db.RestaurantePersistance;
import view.VConsultaRestaurante;
import view.VModificar;
import view.VPrincipal;
import view.VRegistro;
import model.Filtro;
import model.Restaurantes;

public class RestauranteListener implements ActionListener{
	private VPrincipal vPal;
	private VConsultaRestaurante vConsulta;
	private VRegistro vRegistro;
	private VModificar vModificar;
	private RestaurantePersistance rP;


	public RestauranteListener(VPrincipal vPal, VConsultaRestaurante vConsulta, VRegistro vRegistro, VModificar vModificar) {
		this.vPal = vPal;
		this.vConsulta = vConsulta;
		this.vRegistro = vRegistro;
		this.vModificar = vModificar;
		rP  = new RestaurantePersistance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof JMenuItem) {
			if(e.getActionCommand().equals(VPrincipal.CONSULTA)) {
				ArrayList<String> listaRegiones = new ArrayList<String>();
				listaRegiones = rP.pasarRegiones();
				String[] listR = new String[listaRegiones.size()];
				
				listR[0]= "TODAS";
				for (int i = 1; i < listR.length; i++) {
					listR[i] = listaRegiones.get(i);
				}
				
				
				vConsulta.listaR = new String[listR.length];
				for (int k = 0; k < listR.length; k++) {
					vConsulta.listaR[k] = listR[k];
				}
				vConsulta.setListaRegiones(listR);
				
				vPal.cargarPanel(vConsulta);
				
			}else if(e.getActionCommand().equals(VPrincipal.SALIR)) {
				int opcion = JOptionPane.showConfirmDialog(vConsulta, 
						"Va a salir de la aplicación, ¿Está seguro?", 
						"Confirmación",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				
				if (opcion == JOptionPane.YES_OPTION) {	
					System.exit(0);
				}
				
			}else if(e.getActionCommand().equals(VPrincipal.REGISTRO)) {
					
				vPal.cargarPanel(vRegistro);
			}else if(e.getActionCommand().equals(VPrincipal.MODIFICACION)) {
				vPal.cargarPanel(vModificar);
			}
		}if(e.getSource() instanceof JButton) {
			Filtro f = vConsulta.getDatos();
			ArrayList<Restaurantes> listaRes = new ArrayList<>();
			if(e.getActionCommand().equals(VConsultaRestaurante.CONSULTAR)) {
				f = vConsulta.getDatos();
				
				if(!f.getRegion().equals("TODAS") && f.getDistincion() != 0) {
					listaRes = rP.consultaTabla(vConsulta.getDatos());
				}else if(f.getDistincion() == 0 && !f.getRegion().equals("TODAS")) {
					listaRes = rP.consultaTablaReg(vConsulta.getDatos());
				}else if(f.getRegion().equals("TODAS") && f.getDistincion() != 0) {
					listaRes = rP.consultaTablaDis(vConsulta.getDatos());
				}else {
					listaRes = rP.consultaTablaTodas();
				}
				
				if(listaRes.isEmpty()) {
					
					vConsulta.mostrarMensaje("No se han encontrado datos con estas características");
					vConsulta.hacerInvisible();
				}else {
					vConsulta.rellenarTabla(listaRes);
					vConsulta.reiniciar();
					vConsulta.hacerTablaVisible();
				}
				
			}else if(e.getActionCommand().equals(VConsultaRestaurante.ELIMINAR)) {
				String nombre = vConsulta.obtenerElemSel();
				if (nombre.equals("")) {
					vConsulta.mostrarError("Debe seleccionar el registro a eliminar");
				} else {
					int opcion = JOptionPane.showConfirmDialog(vConsulta, 
							"Se va a eliminar el registro seleccionado, ¿Desea continuar?", 
							"Confirmación",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE);
					
					if (opcion == JOptionPane.YES_OPTION) {	
						int res = rP.eliminarRestaurante(nombre);
						if(!f.getRegion().equals("TODAS") && f.getDistincion() != 0) {
							listaRes = rP.consultaTabla(vConsulta.getDatos());
						}else if(f.getDistincion() == 0 && !f.getRegion().equals("TODAS")) {
							listaRes = rP.consultaTablaReg(vConsulta.getDatos());
						}else if(f.getRegion().equals("TODAS") && f.getDistincion() != 0) {
							listaRes = rP.consultaTablaDis(vConsulta.getDatos());
						}else {
							listaRes = rP.consultaTablaTodas();
						}
						
						if(listaRes.isEmpty()) {
							
							vConsulta.mostrarMensaje("No se han encontrado datos con estas características");
							vConsulta.hacerInvisible();
						}else {
							vConsulta.rellenarTabla(listaRes);
							
							vConsulta.hacerTablaVisible();
						}
						if(res == 1) {
							vConsulta.mostrarMensaje("Se ha eliminado el registro seleccionado");
						}else if(res == -1) {
							vConsulta.mostrarError("Se ha producido un error");
						}
					}
				}
			}else if(e.getActionCommand().equals(VRegistro.ELIMINAR)) {
				vRegistro.reiniciar();
				vRegistro.mostrarMensaje("Se han borrado todos los datos del registro");
			}else if(e.getActionCommand().equals(VRegistro.GUARDAR)) {
				
				Restaurantes res = vRegistro.getDatos();
				if(res.getNombre().equals("")) {
					vRegistro.mostrarError("No se ha puesto ningún nombre");
				}
				if(res.getCiudad().equals("")) {
					vRegistro.mostrarError("No se ha puesto ninguna ciudad");
				}
				if(res.getPrecio_min() == 0  || res.getPrecio_max() == 0) {
					vRegistro.mostrarError("Hay que poner valor a precio mínimo y precio máximo");
				}else if(res.getPrecio_max() < res.getPrecio_min()) {
					vRegistro.mostrarError("El valor de precio máximo no puede ser menor al de precio mínimo");
				}else {
					int resultado = rP.registrarRestaurante(res);
					if(resultado == -1) {
						vRegistro.mostrarError("Ya existe un restaurante con el nombre introducido");
					}else{
						
						vRegistro.mostrarMensaje("Se ha realizado el registro con éxito");
						vRegistro.reiniciar();
					}
				}
			}else if(e.getActionCommand().equals(VModificar.BUSCAR)) {
				String nombre = vModificar.getDatos();
				Restaurantes res = rP.consultarNombre(nombre);
				if(nombre.equals("")) {
					vModificar.mostrarError("Debe introducir un nombre");
				}else {
					if(res.getDistincion() > 0) {
						vModificar.meterDatos(res.getNombre(), res.getCiudad(), res.getDireccion(), res.getTelefono(),res.getWeb(), res.getDistincion(),res.getRegion(),res.getCocina(), res.getPrecio_min(), res.getPrecio_max());
						vModificar.activar();
					}
				}
				
				
			}else if(e.getActionCommand().equals(VModificar.CANCELAR)) {
				vModificar.reiniciar();
				vModificar.desactivar();
			}else if(e.getActionCommand().equals(VModificar.GUARDAR)) {
				Restaurantes res = vModificar.getDatos1();
				int resultado = rP.modificarlos(res);
				if(resultado == -1) {
					vRegistro.mostrarError("No se ha hecho la modificación con exito");
				}else{
					
					vModificar.mostrarMensaje("Se ha realizado la modificación con éxito");
					vModificar.reiniciar();
					vModificar.desactivar();
				}
			}
		}
			
		
	}
}
