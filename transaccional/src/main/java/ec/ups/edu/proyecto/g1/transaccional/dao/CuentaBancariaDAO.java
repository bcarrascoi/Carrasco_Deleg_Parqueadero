package ec.ups.edu.proyecto.g1.transaccional.dao;

import javax.ejb.Stateless;

import ec.ups.edu.proyecto.g1.transaccional.modelo.CuentaBancaria;

@Stateless
public class CuentaBancariaDAO {

	public boolean insert(CuentaBancaria cuentaBancaria) {
		return false;
	}

	public boolean delete(int id) {
		return false;
	}

	public CuentaBancaria read(int id) {
		return null;
	}
}
