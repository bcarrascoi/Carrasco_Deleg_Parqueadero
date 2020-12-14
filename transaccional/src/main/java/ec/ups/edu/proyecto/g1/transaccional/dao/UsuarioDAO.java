package ec.ups.edu.proyecto.g1.transaccional.dao;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.proyecto.g1.transaccional.modelo.Usuario;

@Stateless
public class UsuarioDAO {

	@PersistenceContext
	EntityManager em;
	
	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}
	 public boolean insert(Usuario usuario) throws SQLException {
		 em.persist(usuario);
		 return true;
	 }
	
	/**
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
	*/
	
}
