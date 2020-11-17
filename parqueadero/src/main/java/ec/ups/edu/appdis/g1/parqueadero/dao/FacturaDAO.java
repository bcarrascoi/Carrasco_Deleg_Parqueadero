package ec.ups.edu.appdis.g1.parqueadero.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.appdis.g1.parqueadero.modelo.Factura;

@Stateless
public class FacturaDAO {

	@Inject
	private Connection con;

	public boolean insert(Factura entity) throws SQLException {
		String sql = "INSERT INTO Factura (numero,fechaEmision,valorTotal)" + "VALUES(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, entity.getNumero());
		ps.setDate(2, (Date) entity.getFechaEmision());
		ps.setDouble(3, entity.getValorTotal());

		ps.executeUpdate();
		ps.close();

		return true;
	}

	public boolean update(Factura entity) throws SQLException {
		String sql = "UPDATE Factura SET (numero,fechaEmision,valorTotal)" + "VALUES(?,?,?)";
		PreparedStatement ps1 = con.prepareStatement(sql);
		ps1.setInt(1, entity.getNumero());
		ps1.setDate(2, (Date) entity.getFechaEmision());
		ps1.setDouble(3, entity.getValorTotal());

		ps1.executeUpdate();
		ps1.close();
		return true;
	}

	public Factura read(Factura numero) throws SQLException {
		String sql = "SELECT * FROM Factura WHERE numero=" + numero.getNumero();
		PreparedStatement ps3 = con.prepareStatement(sql);
		ps3.setInt(1, numero.getNumero());
		return null;
	}

	public boolean delete(Factura numero) throws SQLException {
		String sql = "DELETE FROM Factura WHERE numero= " + numero.getNumero();
		PreparedStatement ps4 = con.prepareStatement(sql);
		ps4.setInt(1, numero.getNumero());
		ps4.executeUpdate();
		ps4.close();
		return true;
	}
}
