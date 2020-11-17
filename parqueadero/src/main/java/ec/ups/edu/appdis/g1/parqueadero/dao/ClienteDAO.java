package ec.ups.edu.appdis.g1.parqueadero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.appdis.g1.parqueadero.modelo.Cliente;

@Stateless
public class ClienteDAO {

	@Inject
	private Connection con;

	public ClienteDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean insert(Cliente entity) throws SQLException {
		String sql = "INSERT INTO Cliente (dni, email,nombre,tipoDocumento)" + " VALUES (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, entity.getDni());
		ps.setString(2, entity.getEmail());
		ps.setString(3, entity.getNombre());
		ps.setInt(4, entity.getTipoDocumento());

		ps.executeUpdate();
		ps.close();

		return true;
	}

	public boolean update(Cliente entity) throws SQLException {
		String sql = "UPDATE Cliente SET (dni,email,nombre,tipoDocumento)" + "VALUES (?,?,?,?)";
		PreparedStatement ps1 = con.prepareStatement(sql);
		ps1.setString(1, entity.getDni());
		ps1.setString(2, entity.getEmail());
		ps1.setString(3, entity.getNombre());
		ps1.setInt(4, entity.getTipoDocumento());
		ps1.executeUpdate();
		ps1.close();
		return true;
	}

	public Cliente read(Cliente dni) throws SQLException {
		String sql = "SELECT * FROM Cliente WHERE dni=" + dni.getDni();
		PreparedStatement ps3 = con.prepareStatement(sql);
		ps3.setString(1, dni.getDni());
		ps3.executeUpdate();
		ps3.close();
		return null;
	}

	public boolean delete(Cliente dni) throws SQLException {
		String sql = "DELETE FROM Cliente WHERE dni =" + dni.getDni();
		PreparedStatement ps4 = con.prepareStatement(sql);
		ps4.setString(1, dni.getDni());
		ps4.executeUpdate();
		ps4.close();
		return true;
	}
}
