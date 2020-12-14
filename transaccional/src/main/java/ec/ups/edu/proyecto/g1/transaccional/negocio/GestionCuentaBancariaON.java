package ec.ups.edu.proyecto.g1.transaccional.negocio;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.proyecto.g1.transaccional.dao.ClienteDAO;
import ec.ups.edu.proyecto.g1.transaccional.dao.CuentaBancariaDAO;
import ec.ups.edu.proyecto.g1.transaccional.modelo.Cliente;
import ec.ups.edu.proyecto.g1.transaccional.modelo.CuentaBancaria;

@Stateless
public class GestionCuentaBancariaON implements GestionCuentaBancariaONRemoto{
	
	@Inject
	private ClienteDAO daoCliente;
	@Inject
	private CuentaBancariaDAO daoCuentaBancaria;
	
	public boolean crearCliente(Cliente cliente) {
		try {
			daoCliente.insert(cliente);
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return true;
	}

	public boolean crearCuenta(CuentaBancaria cuenta) {
		daoCuentaBancaria.insert(cuenta);
		return true;
	}
	
}