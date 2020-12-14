package ec.ups.edu.proyecto.g1.transaccional.dao;

import javax.ejb.Stateless;

import ec.ups.edu.proyecto.g1.transaccional.modelo.Transferencia;

@Stateless
public class TransferenciaDAO {
	public boolean insert(Transferencia transferencia) {
		return true;
	}
	
	public Transferencia read(int id) {
		return null;
	}
}
