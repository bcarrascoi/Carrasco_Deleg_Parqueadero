package ec.ups.edu.appdis.g1.parqueadero.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.appdis.g1.parqueadero.modelo.Ticket;

@Stateless
public class TicketDAO {

	@Inject
	private Connection con;

	public boolean insert(Ticket entity) throws SQLException {
		String sql = "INSERT INTO Ticket(codigo, fechaIngreso,fechaSalida,tiempo,valor)" + "VALUES(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, entity.getCodigo());
		ps.setDate(2, (Date) entity.getFechaIngreso());
		ps.setDate(3, (Date) entity.getFechaSalida());
		ps.setInt(4, entity.getTiempo());
		ps.setDouble(5, entity.getValor());

		ps.executeUpdate();
		ps.close();

		return true;
	}

	public boolean update(Ticket entity) throws SQLException {
		String sql = "UPDATE Ticket SET (codigo, fechaIngreso, fechaSaida, timepo, valor)" + "VALUES (?,?,?,?,?)";
		PreparedStatement ps1 = con.prepareStatement(sql);
		ps1.setInt(1, entity.getCodigo());
		ps1.setDate(2, (Date) entity.getFechaIngreso());
		ps1.setDate(3, (Date) entity.getFechaSalida());
		ps1.setInt(4, entity.getTiempo());
		ps1.setDouble(5, entity.getValor());

		ps1.executeUpdate();
		ps1.close();
		return true;
	}

	public Ticket read(Ticket codigo) throws SQLException {
		String sql = "SELECT * FROM Ticket WHERE codigo=" + codigo.getCodigo();
		PreparedStatement ps3 = con.prepareStatement(sql);
		ps3.setInt(1, codigo.getCodigo());
		ps3.executeUpdate();
		ps3.close();
		return null;
	}

	public boolean delete(Ticket codigo) throws SQLException {
		String sql = "DELETE FROM Ticket WHERE codigo=" + codigo.getCodigo();
		PreparedStatement ps4 = con.prepareStatement(sql);
		ps4.setInt(1, codigo.getCodigo());
		ps4.executeUpdate();
		ps4.close();
		return true;
	}
}
