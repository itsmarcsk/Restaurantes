package model;

public class Restaurantes {

	private String nombre;
	private String region;
	private String ciudad;
	private int distincion;
	private String direccion;
	private double precio_min;
	public static final String[] REGIONES = {"Andalucía",
			"Aragón",
			"Asturias",
			"Islas Baleares",
			"Cantabria",
			"Islas Canarias",
			"Castilla - La Mancha",
			"Castilla y León",
			"Cataluña",
			"Galicia",
			"Extremadura",
			"Madrid",
			"Murcia",
			"Navarra",
			"País Vasco",
			"La Rioja"};
	public static final String[] COCINA = {
			"Creativa",
			"Moderna",
			"Tradicional",
			"Regional",
			"Fusión"
	};
	public String getNombre() {
		return nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public int getDistincion() {
		return distincion;
	}
	public double getPrecio_min() {
		return precio_min;
	}
	public double getPrecio_max() {
		return precio_max;
	}
	public String getCocina() {
		return cocina;
	}
	private double precio_max;
	private String cocina;
	private String telefono;
	private String web;
	public Restaurantes(String nombre, String region, String ciudad, int distincion, String direccion,
			double precio_min, double precio_max, String cocina, String telefono, String web) {
		this.nombre = nombre;
		this.region = region;
		this.ciudad = ciudad;
		this.distincion = distincion;
		this.direccion = direccion;
		this.precio_min = precio_min;
		this.precio_max = precio_max;
		this.cocina = cocina;
		this.telefono = telefono;
		this.web = web;
	}
	public String getRegion() {
		return region;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getWeb() {
		return web;
	}
	public Restaurantes(String nombre, String ciudad, int distincion, double precio_min, double precio_max,
			String cocina) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.distincion = distincion;
		this.precio_min = precio_min;
		this.precio_max = precio_max;
		this.cocina = cocina;
	}
	
	
}
