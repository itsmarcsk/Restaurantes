package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filtro;
import model.Restaurantes;

public class RestaurantePersistance {

	private AccesoDB aDB;
	static final String NOM_TABLA = "RESTAURANTES";
	static final String COL_NOMBRE = "NOMBRE";
	static final String COL_REGION = "REGION";
	static final String COL_CIUDAD = "CIUDAD";
	static final String COL_DISTINCION = "DISTINCION";
	static final String COL_DIRECCION = "DIRECCION";
	static final String COL_PRECIOMIN = "PRECIO_MIN";
	static final String COL_PRECIOMAX = "PRECIO_MAX";
	static final String COL_COCINA = "COCINA";
	static final String COL_TELEFONO = "TELEFONO";
	static final String COL_WEB = "WEB";
	static final String COL_ID = "ID";

	public RestaurantePersistance() {
		aDB = new AccesoDB();
	}

	public ArrayList<String> consulta() {
		String query = "SELECT " + COL_NOMBRE + " FROM " + NOM_TABLA;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		ArrayList<String> lista = new ArrayList<>();
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			rslt = stmt.executeQuery();
			while (rslt.next()) {
				lista.add(rslt.getString(COL_NOMBRE));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return lista;
	}

	public ArrayList<String> pasarRegiones() {
		String query = "SELECT DISTINCT " + COL_REGION + " FROM " + NOM_TABLA;
		ArrayList<String> listaRegion = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			rslt = stmt.executeQuery();
			while (rslt.next()) {
				listaRegion.add(rslt.getString(COL_REGION));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return listaRegion;
	}

	public ArrayList<Integer> pasarDistincion() {
		String query = "SELECT DISTINCT " + COL_REGION + " FROM " + NOM_TABLA;
		ArrayList<Integer> listaDistincion = new ArrayList<Integer>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			rslt = stmt.executeQuery();
			while (rslt.next()) {
				listaDistincion.add(rslt.getInt(COL_REGION));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return listaDistincion;
	}

	// NOMBRE,CIUDAD, DISTINCION,COCINA,PRECIO
	public ArrayList<Restaurantes> consultaTabla(Filtro f) {
		String query = "SELECT " + COL_NOMBRE + ", " + COL_CIUDAD + ", " + COL_DISTINCION + ", " + COL_COCINA + ", "
				+ COL_PRECIOMIN + ", " + COL_PRECIOMAX + " FROM " + NOM_TABLA + " WHERE " + COL_REGION + " = ? AND "
				+ COL_DISTINCION + " = ?" + " ORDER BY " + COL_NOMBRE;

		ArrayList<Restaurantes> listaRestaurantes = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;

		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, f.getRegion());
			stmt.setInt(2, f.getDistincion());
			rslt = stmt.executeQuery();
			while (rslt.next()) {
				listaRestaurantes.add(new Restaurantes(rslt.getString(COL_NOMBRE), rslt.getString(COL_CIUDAD),
						rslt.getInt(COL_DISTINCION), rslt.getDouble(COL_PRECIOMIN), rslt.getDouble(COL_PRECIOMAX),
						rslt.getString(COL_COCINA)));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return listaRestaurantes;

	}

	public ArrayList<Restaurantes> consultaTablaReg(Filtro f) {
		String query = "SELECT " + COL_NOMBRE + ", " + COL_CIUDAD + ", " + COL_DISTINCION + ", " + COL_COCINA + ", "
				+ COL_PRECIOMIN + ", " + COL_PRECIOMAX + " FROM " + NOM_TABLA + " WHERE " + COL_REGION + " = ?" + " ORDER BY " + COL_NOMBRE;

		ArrayList<Restaurantes> listaRestaurantes = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;

		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, f.getRegion());
			rslt = stmt.executeQuery();
			while (rslt.next()) {
				listaRestaurantes.add(new Restaurantes(rslt.getString(COL_NOMBRE), rslt.getString(COL_CIUDAD),
						rslt.getInt(COL_DISTINCION), rslt.getDouble(COL_PRECIOMIN), rslt.getDouble(COL_PRECIOMAX),
						rslt.getString(COL_COCINA)));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return listaRestaurantes;

	}

	public ArrayList<Restaurantes> consultaTablaDis(Filtro f) {
		String query = "SELECT " + COL_NOMBRE + ", " + COL_CIUDAD + ", " + COL_DISTINCION + ", " + COL_COCINA + ", "
				+ COL_PRECIOMIN + ", " + COL_PRECIOMAX + " FROM " + NOM_TABLA + " WHERE " + COL_DISTINCION + " = ?" + " ORDER BY " + COL_NOMBRE;

		ArrayList<Restaurantes> listaRestaurantes = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;

		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, f.getDistincion());
			rslt = stmt.executeQuery();
			while (rslt.next()) {
				listaRestaurantes.add(new Restaurantes(rslt.getString(COL_NOMBRE), rslt.getString(COL_CIUDAD),
						rslt.getInt(COL_DISTINCION), rslt.getDouble(COL_PRECIOMIN), rslt.getDouble(COL_PRECIOMAX),
						rslt.getString(COL_COCINA)));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return listaRestaurantes;

	}

	public ArrayList<Restaurantes> consultaTablaTodas() {
		// TODO Auto-generated method stub
		String query = "SELECT " + COL_NOMBRE + ", " + COL_CIUDAD + ", " + COL_DISTINCION + ", " + COL_COCINA + ", "
				+ COL_PRECIOMIN + ", " + COL_PRECIOMAX + " FROM " + NOM_TABLA + " ORDER BY " + COL_NOMBRE;

		ArrayList<Restaurantes> listaRestaurantes = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;

		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			rslt = stmt.executeQuery();
			while (rslt.next()) {
				listaRestaurantes.add(new Restaurantes(rslt.getString(COL_NOMBRE), rslt.getString(COL_CIUDAD),
						rslt.getInt(COL_DISTINCION), rslt.getDouble(COL_PRECIOMIN), rslt.getDouble(COL_PRECIOMAX),
						rslt.getString(COL_COCINA)));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return listaRestaurantes;
	}
	public Restaurantes consultarNombre(String nombre) {
		String query = "SELECT " + COL_NOMBRE + ", " + COL_REGION + ", " + COL_CIUDAD
				+ ", " + COL_DISTINCION + ", " + COL_DIRECCION + ", " + COL_PRECIOMIN + ", " + COL_PRECIOMAX + ", "
				+ COL_COCINA + ", " + COL_TELEFONO + ", " + COL_WEB + " FROM " + NOM_TABLA + " WHERE "+ COL_NOMBRE + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		Restaurantes r = null;
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, nombre);
			rslt = stmt.executeQuery();
			r =  new Restaurantes(rslt.getString(COL_NOMBRE), rslt.getString(COL_CIUDAD),
						rslt.getInt(COL_DISTINCION), rslt.getDouble(COL_PRECIOMIN), rslt.getDouble(COL_PRECIOMAX),
						rslt.getString(COL_COCINA));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return r;
	}

	public int eliminarRestaurante(String nombre) {
		String query = "DELETE FROM " + NOM_TABLA + " WHERE " + COL_NOMBRE + " = ?";
		int res = 0;
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, nombre);
			res = stmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = -1;
		} finally {
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return res;
	}

	public int registrarRestaurante(Restaurantes r) {
		String query = "INSERT INTO " + NOM_TABLA + "( " + COL_NOMBRE + ", " + COL_REGION + ", " + COL_CIUDAD
				+ ", " + COL_DISTINCION + ", " + COL_DIRECCION + ", " + COL_PRECIOMIN + ", " + COL_PRECIOMAX + ", "
				+ COL_COCINA + ", " + COL_TELEFONO + ", " + COL_WEB + ") VALUES (?, ?, ? , ? , ? , ? , ? , ? , ? , ?);";

		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, r.getNombre());
			stmt.setString(2, r.getRegion());
			stmt.setString(3, r.getCiudad());
			stmt.setInt(4, r.getDistincion());
			stmt.setString(5, r.getDireccion());
			stmt.setDouble(6, r.getPrecio_min());
			stmt.setDouble(7, r.getPrecio_max());
			stmt.setString(8, r.getCocina());
			stmt.setString(9, r.getTelefono());
			stmt.setString(10, r.getWeb());
			res = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = -1;
		}
		return res;
	}
	
	public int modificarlos(Restaurantes r) {
		String query = "UPDATE " + NOM_TABLA + " SET " + COL_REGION + " = ?, " + COL_CIUDAD + " = ?, " + COL_DISTINCION
				+ " = ?, " + COL_DIRECCION + " = ?, " + COL_PRECIOMIN + " = ?, " + COL_PRECIOMAX + " = ?, " + COL_COCINA
				+ " = ?, " + COL_TELEFONO + " = ?, " + COL_WEB + " = ? WHERE " + COL_NOMBRE + " = ?";
		int res = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, r.getRegion());
			stmt.setString(2, r.getCiudad());
			stmt.setInt(3, r.getDistincion());
			stmt.setString(4, r.getDireccion());
			stmt.setDouble(5, r.getPrecio_min());
			stmt.setDouble(6, r.getPrecio_max());
			stmt.setString(7, r.getCocina());
			stmt.setString(8, r.getTelefono());
			stmt.setString(9, r.getWeb());
			stmt.setString(10, r.getNombre());
			res = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = -1;
		} finally {
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return res;
	}
}
