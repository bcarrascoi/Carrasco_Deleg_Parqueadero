package ec.ups.edu.proyecto.g1.transaccional.negocio;

import javax.ejb.Remote;

import ec.ups.edu.proyecto.g1.transaccional.modelo.Usuario;

@Remote
public interface GestionUsuariosONRemoto {

	public boolean crearUsuario(Usuario usuario)throws Exception;
}
