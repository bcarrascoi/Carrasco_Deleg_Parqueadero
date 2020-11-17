package ec.ups.edu.appdis.g1.parqueadero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.appdis.g1.parqueadero.modelo.Vehiculo;

@Stateless
public class VehiculoDAO {

	@Inject
	private Connection con;

	public boolean insert(Vehiculo entity) throws SQLException {
		String sql = "INSERT INTO Vehiculo (placa,marca,color)" + "VALUES (?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, entity.getPlaca());
		ps.setString(2, entity.getMarca());
		ps.setString(3, entity.getColor());

		ps.executeUpdate();
		ps.close();

		return true;
	}

	public boolean update(Vehiculo entity) throws SQLException {
		String sql = "UPDATE Vehiculo SET(placa,marca,color)" + "VALUES(?,?,?)";
		PreparedStatement ps1 = con.prepareStatement(sql);
		ps1.setString(1, entity.getPlaca());
		ps1.setString(2, entity.getMarca());
		ps1.setString(3, entity.getColor());

		ps1.executeUpdate();
		ps1.close();

		return true;
	}

	public Vehiculo read(Vehiculo placa) throws SQLException {
		String sql = "SELECT * FROM Vehiculo WHERE placa=" + placa.getPlaca();
		PreparedStatement ps3 = con.prepareStatement(sql);
		ps3.setString(1, placa.getPlaca());
		ps3.executeUpdate();
		ps3.close();
		return null;
	}

	public boolean delete(Vehiculo placa) throws SQLException {
		String sql = "DELETE FROM Vehiculo WHERE placa=" + placa.getPlaca();
		PreparedStatement ps4 = con.prepareStatement(sql);
		ps4.setString(1, placa.getPlaca());
		ps4.executeUpdate();
		ps4.close();
		return true;
	}
}
