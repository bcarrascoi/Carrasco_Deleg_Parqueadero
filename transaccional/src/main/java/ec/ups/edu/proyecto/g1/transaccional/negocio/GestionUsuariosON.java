package ec.ups.edu.proyecto.g1.transaccional.negocio;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.proyecto.g1.transaccional.dao.UsuarioDAO;

import ec.ups.edu.proyecto.g1.transaccional.modelo.Usuario;

@Stateless
public class GestionUsuariosON implements GestionUsuariosONRemoto {

	@Inject
	private UsuarioDAO daoUsuario;

	public boolean crearUsuario(Usuario usuario) {

		try {
			daoUsuario.insert(usuario);
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}

		return true;
	}

}
