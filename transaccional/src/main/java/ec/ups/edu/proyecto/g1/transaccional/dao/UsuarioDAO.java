package ec.ups.edu.proyecto.g1.transaccional.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.proyecto.g1.transaccional.modelo.Usuario;

@Stateless
public class UsuarioDAO {

	@Inject	
	private Connection con;
	
	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean insert(Usuario usuario) throws SQLException {
	
	String sql = "INSERT INTO Usuario (id, correo, clave, rol)"+ 
	"VALUES (?, ?, ?, ?)";
	
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, usuario.getId());
	ps.setString(2, usuario.getCorreo());
	ps.setString(3, usuario.getClave());
	ps.setString(4, usuario.getRol());
	
	ps.executeUpdate();
	ps.close();
		return true;
	}
}
