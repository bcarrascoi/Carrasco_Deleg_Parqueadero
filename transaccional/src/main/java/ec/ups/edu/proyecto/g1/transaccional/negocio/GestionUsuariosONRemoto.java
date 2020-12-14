package ec.ups.edu.proyecto.g1.transaccional.negocio;

import javax.ejb.Remote;

import ec.ups.edu.proyecto.g1.transaccional.modelo.Cliente;

@Remote
public interface GestionUsuariosONRemoto {

	public boolean crearCliente(Cliente cliente)throws Exception;
}
