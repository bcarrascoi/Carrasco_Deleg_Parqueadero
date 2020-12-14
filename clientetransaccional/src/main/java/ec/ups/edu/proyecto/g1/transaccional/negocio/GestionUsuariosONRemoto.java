package ec.ups.edu.proyecto.g1.transaccional.negocio;


import ec.ups.edu.proyecto.g1.transaccional.modelo.Cliente;

public interface GestionUsuariosONRemoto {

	public boolean crearCliente(Cliente cliente)throws Exception;
}
