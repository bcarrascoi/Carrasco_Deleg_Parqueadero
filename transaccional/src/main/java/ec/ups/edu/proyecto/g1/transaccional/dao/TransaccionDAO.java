package ec.ups.edu.proyecto.g1.transaccional.dao;

import javax.ejb.Stateless;

import ec.ups.edu.proyecto.g1.transaccional.modelo.Transaccion;

@Stateless
public class TransaccionDAO {
	public boolean insert(Transaccion transaccion) {

		return true;
	}
}
