package ec.ups.edu.proyecto.g1.transaccional.negocio;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.proyecto.g1.transaccional.dao.ClienteDAO;
import ec.ups.edu.proyecto.g1.transaccional.dao.UsuarioDAO;
import ec.ups.edu.proyecto.g1.transaccional.modelo.Cliente;
import ec.ups.edu.proyecto.g1.transaccional.modelo.Usuario;

@Stateless
public class GestionUsuariosON implements GestionUsuariosONRemoto{

	@Inject
	private UsuarioDAO daoUsuario;
	@Inject
	private ClienteDAO daoCliente;
	
	
	public boolean crearUsuario(Usuario usuario) {
			
		daoUsuario.insert(usuario);
		
		return true;
	}

	public boolean crearCliente(Cliente cliente) {
		try {
			daoCliente.insert(cliente);
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return true;
	}
	
}
