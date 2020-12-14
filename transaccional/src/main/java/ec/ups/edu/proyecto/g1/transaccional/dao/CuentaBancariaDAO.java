package ec.ups.edu.proyecto.g1.transaccional.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.ups.edu.proyecto.g1.transaccional.modelo.CuentaBancaria;

@Stateless
public class CuentaBancariaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public boolean insert(CuentaBancaria cuentaBancaria) {
		em.persist(cuentaBancaria);
		return true;
	}

	public CuentaBancaria getCliente(String cedula) {
		return em.find(CuentaBancaria.class, cedula);
	}
	public boolean delete(int id) {
		return false;
	}

	public CuentaBancaria read(int id) {
		return null;
	}
}
