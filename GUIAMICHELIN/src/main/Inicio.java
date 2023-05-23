package main;

import java.awt.EventQueue;

import control.RestauranteListener;
import view.VConsultaRestaurante;
import view.VModificar;
import view.VPrincipal;
import view.VRegistro;

public class Inicio {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				VPrincipal vPpal = new VPrincipal();
				VConsultaRestaurante vConsulta = new VConsultaRestaurante();
				VRegistro vRegistro = new VRegistro();
				VModificar vModificar = new VModificar();
				RestauranteListener listener = new RestauranteListener(vPpal, vConsulta, vRegistro, vModificar);
				vPpal.setListener(listener);
				vConsulta.setListener(listener);
				vRegistro.setListener(listener);
				vModificar.setListener(listener);
				vPpal.hacerVisible();
			}
		});
	}
}