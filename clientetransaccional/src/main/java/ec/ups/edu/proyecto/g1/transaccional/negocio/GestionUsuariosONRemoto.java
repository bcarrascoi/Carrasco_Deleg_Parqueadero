package ec.ups.edu.proyecto.g1.transaccional.negocio;

import ec.ups.edu.proyecto.g1.transaccional.modelo.Cliente;
import ec.ups.edu.proyecto.g1.transaccional.modelo.Usuario;

public interface GestionUsuariosONRemoto {

	public boolean crearCliente(Cliente cliente)throws Exception;
	public boolean crearUsuario(Usuario usuario)throws Exception;
}
