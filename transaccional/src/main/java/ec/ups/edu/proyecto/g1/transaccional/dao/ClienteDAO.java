package ec.ups.edu.proyecto.g1.transaccional.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.proyecto.g1.transaccional.modelo.Cliente;

@Stateless
public class ClienteDAO {
	
	@Inject
	private Connection con;
	
	public ClienteDAO() {
		
	}
	public boolean insert(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO Cliente (id, nombre, apellido, correo, direccion )" 
	+ " VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cliente.getId());
		ps.setString(2, cliente.getNombre());
		ps.setString(3, cliente.getApellido());
		ps.setString(4, cliente.getCorreo());
		ps.setString(5, cliente.getDireccion());
		
		ps.executeUpdate();
		ps.close();
		return true;
	}

	public boolean update(Cliente cliente) {
		return true;
	}

	public boolean delete(Cliente cliente) {
		return true;
	}

	public boolean read(Cliente cliente) {
		return true;
	}
}
