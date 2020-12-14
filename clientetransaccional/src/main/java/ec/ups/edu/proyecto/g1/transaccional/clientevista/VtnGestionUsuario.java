package ec.ups.edu.proyecto.g1.transaccional.clientevista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.ups.edu.proyecto.g1.transaccional.modelo.Usuario;
import ec.ups.edu.proyecto.g1.transaccional.negocio.GestionUsuariosONRemoto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VtnGestionUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtCorreo;

	private GestionUsuariosONRemoto on;
	private JPasswordField txtClave;
	private JComboBox cbRol;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VtnGestionUsuario frame = new VtnGestionUsuario();
					frame.setVisible(true);
					frame.referenciarONUsuario();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VtnGestionUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Correo:");
		lblNewLabel.setBounds(44, 39, 65, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Clave");
		lblNewLabel_1.setBounds(44, 83, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rol:");
		lblNewLabel_2.setBounds(44, 129, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(119, 36, 159, 19);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearUsuario();
			}
		});
		btnCrearUsuario.setBounds(107, 178, 119, 21);
		contentPane.add(btnCrearUsuario);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(119, 80, 159, 19);
		contentPane.add(txtClave);
		
		cbRol = new JComboBox();
		cbRol.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Cajero", "Asistente de captaciones"}));
		cbRol.setBounds(119, 125, 129, 21);
		contentPane.add(cbRol);
	}
	
protected void crearUsuario() {
		Usuario u = new Usuario();
		u.setCorreo(txtCorreo.getText());
		u.setClave(txtClave.getText());
	
		String rol = (String) cbRol.getSelectedItem();
		u.setRol(rol);
		try {
			on.crearUsuario(u);
			System.out.println("Guardado OK");
		} catch (Exception e) {
			System.out.println("Error al guardar"+ e.getMessage());
			e.printStackTrace();
		}
	}

public void referenciarONUsuario() throws Exception {
	try {  
        final Hashtable<String, Comparable> jndiProperties =  
                new Hashtable<String, Comparable>();  
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                "org.wildfly.naming.client.WildFlyInitialContextFactory");  
        jndiProperties.put("jboss.naming.client.ejb.context", true);  
          
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
        jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejbremoto");  
        jndiProperties.put(Context.SECURITY_CREDENTIALS, "ejb01");  
          
        final Context context = new InitialContext(jndiProperties);  
          
        final String lookupName = "ejb:/transaccional/GestionUsuariosON!ec.ups.edu.proyecto.g1.transaccional.negocio.GestionUsuariosONRemoto";  
          
        this.on = (GestionUsuariosONRemoto) context.lookup(lookupName);  
          
    } catch (Exception ex) {  
        ex.printStackTrace();  
        throw ex;  
    }  
}
}
