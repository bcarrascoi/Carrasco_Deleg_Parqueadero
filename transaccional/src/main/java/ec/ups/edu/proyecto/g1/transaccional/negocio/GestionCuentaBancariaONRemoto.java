package ec.ups.edu.proyecto.g1.transaccional.negocio;

import javax.ejb.Remote;

import ec.ups.edu.proyecto.g1.transaccional.modelo.Cliente;
import ec.ups.edu.proyecto.g1.transaccional.modelo.CuentaBancaria;

@Remote
public interface GestionCuentaBancariaONRemoto {

	public boolean crearCliente(Cliente cliente) throws Exception;
	public boolean crearCuenta(CuentaBancaria cuenta) throws Exception;
}
