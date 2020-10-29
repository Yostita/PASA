package Interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import Logica.*;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField password;

	//Crea el Frame pasando la clase principal para poder llamar a sus metodos
	public Login(Principal principal) {
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JTextField();
		user.setBounds(106, 55, 215, 32);
		contentPane.add(user);
		user.setColumns(10);
		
		password = new JTextField();
		password.setBounds(106, 108, 215, 32);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usr = user.getText();
				String pws = password.getText();
				
				//Un control de acceso muy sencillo para dar la sensacion de seguridad
				if(usr.contentEquals("Yosta") && pws.contentEquals("semereceun10") || usr.contentEquals("a") && pws.contentEquals("a")){
					JOptionPane.showMessageDialog(null, "Se ha iniciado sesion correctamente");
					new Menu(principal).setVisible(true);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "El usuario o la contraseña son incorrectas");
				}
			}
		});
		
		btnAceptar.setBounds(106, 161, 97, 32);
		contentPane.add(btnAceptar);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(224, 161, 97, 32);
		contentPane.add(btnCancel);
	}
}
