package ec.ups.edu.proyecto.g1.transaccional.dao;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.proyecto.g1.transaccional.modelo.Cliente;

@Stateless
public class ClienteDAO {
	
	
	@PersistenceContext
	private EntityManager em;
	
	public ClienteDAO() {
		
	}
	
	public boolean insert(Cliente cliente) throws SQLException{
		em.persist(cliente);
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
