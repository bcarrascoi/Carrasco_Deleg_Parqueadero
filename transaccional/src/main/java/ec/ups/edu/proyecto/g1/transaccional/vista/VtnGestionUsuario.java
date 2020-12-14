package ec.ups.edu.proyecto.g1.transaccional.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VtnGestionUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VtnGestionUsuario frame = new VtnGestionUsuario();
					frame.setVisible(true);
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
		setBounds(100, 100, 335, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID: ");
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
		
		txtID = new JTextField();
		txtID.setBounds(101, 39, 96, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
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
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(73, 232, 85, 21);
		contentPane.add(btnNewButton);
	}
}
