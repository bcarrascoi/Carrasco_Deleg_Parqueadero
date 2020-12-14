package ec.ups.edu.proyecto.g1.transaccional.clientevista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.transaction.Transactional.TxType;

import ec.ups.edu.proyecto.g1.transaccional.modelo.Cliente;
import ec.ups.edu.proyecto.g1.transaccional.modelo.CuentaBancaria;
import ec.ups.edu.proyecto.g1.transaccional.negocio.GestionCuentaBancariaONRemoto;
import ec.ups.edu.proyecto.g1.transaccional.negocio.GestionUsuariosONRemoto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.DefaultComboBoxModel;

public class VtnGestionCuentaBancaria extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtDireccion;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JComboBox cbTipoCuenta;
	private JTextField txtFechaApertura;

	private GestionCuentaBancariaONRemoto on;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VtnGestionCuentaBancaria frame = new VtnGestionCuentaBancaria();
					frame.setVisible(true);
					frame.referenciarONCuentaBancaria();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VtnGestionCuentaBancaria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula:");
		lblNewLabel.setBounds(28, 42, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(28, 78, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setBounds(28, 118, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo:");
		lblNewLabel_3.setBounds(28, 156, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion:");
		lblNewLabel_4.setBounds(28, 192, 61, 13);
		contentPane.add(lblNewLabel_4);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(101, 39, 96, 19);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(101, 75, 96, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(101, 115, 96, 19);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(101, 153, 96, 19);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(101, 189, 96, 19);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JButton btnNewButton = new JButton("Crear Cuenta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCuentaBancaria();
			}
		});
		btnNewButton.setBounds(183, 225, 142, 21);
		contentPane.add(btnNewButton);
		
		lblNewLabel_5 = new JLabel("Cuenta Bancaria");
		lblNewLabel_5.setBounds(275, 42, 101, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Fecha Apertura:");
		lblNewLabel_6.setBounds(239, 78, 74, 13);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Tipo de Cuenta:");
		lblNewLabel_7.setBounds(239, 118, 74, 13);
		contentPane.add(lblNewLabel_7);
		
		cbTipoCuenta = new JComboBox();
		cbTipoCuenta.setModel(new DefaultComboBoxModel(new String[] {"Cuenta Corriente", "Cuenta Ahorros"}));
		cbTipoCuenta.setBounds(323, 114, 108, 21);
		contentPane.add(cbTipoCuenta);
		
		txtFechaApertura = new JTextField();
		txtFechaApertura.setBounds(323, 75, 96, 19);
		contentPane.add(txtFechaApertura);
		txtFechaApertura.setColumns(10);
	}
	protected void crearCuentaBancaria() {
		Cliente c = new Cliente();
		c.setCedula(txtCedula.getText());
		c.setNombre(txtNombre.getText());
		c.setApellido(txtApellido.getText());
		c.setCorreo(txtCorreo.getText());
		c.setDireccion(txtDireccion.getText());
		
		CuentaBancaria cb = new CuentaBancaria();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		String fch = sdf.format(cal.getTime());
		txtFechaApertura.setText(fch);
		
		
		String tipoCuenta = (String) cbTipoCuenta.getSelectedItem();
		cb.setTipoCuenta(tipoCuenta);
		
		try {
			on.crearCliente(c);
			on.crearCuenta(cb);
			System.out.println("Cuenta Bancaria OK");
		} catch (Exception e) {
			System.out.println("Error al guardar"+ e.getMessage());
			e.printStackTrace();
		}
	}

	public void referenciarONCuentaBancaria() throws Exception {
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
	          
	        final String lookupName = "ejb:/transaccional/GestionCuentaBancariaON!ec.ups.edu.proyecto.g1.transaccional.negocio.GestionCuentaBancariaONRemoto";  
	          
	        this.on = (GestionCuentaBancariaONRemoto) context.lookup(lookupName);  
	          
	    } catch (Exception ex) {  
	        ex.printStackTrace();  
	        throw ex;  
	    }  
	}
}
