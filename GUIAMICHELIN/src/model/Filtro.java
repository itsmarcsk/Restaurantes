package model;

public class Filtro {
	private String region;
	private int distincion;
	private String nombre;
	public Filtro(String region, int distincion) {
		this.region = region;
		this.distincion = distincion;
		
	}
	public Filtro(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public String getRegion() {
		return region;
	}
	public int getDistincion() {
		return distincion;
	}
	

}
