package ec.ups.edu.appdis.g1.parqueadero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.appdis.g1.parqueadero.modelo.CierreDiaHora;

@Stateless
public class CierreDAO {

	@Inject
	private Connection con;

	public List<CierreDiaHora> getCierreDia(CierreDiaHora dia) throws SQLException {
		String sql = "SELECT * FROM CierreDiaHora WHERE dia=" + dia.getFecha();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDate(1, (java.sql.Date) dia.getFecha());
		ps.executeUpdate();
		ps.close();
		return null;
	}

	public boolean contabilizar() {
		return true;
	}
}
