package Interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import Logica.*;

public class Menu extends JFrame {

	private JPanel contentPane;

	//Crea el Frame pasando la clase principal para poder llamar a sus metodos

	public Menu(Principal principal) {
		setBounds(100, 100, 588, 440);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Listado");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Listado(principal).setVisible(true);
				setVisible(false);
			}
		});
		
		btnNewButton_2.setBounds(322, 196, 219, 56);
		contentPane.add(btnNewButton_2);
		
		//Cierra la sesion actual
		JButton btnNewButton_3 = new JButton("Cerrar sesi\u00F3n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Comprueba si el volcado a fichero se realiza correctamente
				if(principal.closePrograma()) {
					JOptionPane.showMessageDialog(null, "Se ha cerrado sesion con exito");
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al actualizar la base de datos. Por favor contacte con un tecnico");
				}
			}
		});
		
		btnNewButton_3.setBounds(322, 273, 219, 56);
		contentPane.add(btnNewButton_3);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Añadir(principal).setVisible(true);
				setVisible(false);
			}
		});
		
		btnAadir.setBounds(32, 196, 219, 56);
		contentPane.add(btnAadir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Editar(principal).setVisible(true);
				setVisible(false);
			}
		});
		
		btnEditar.setBounds(32, 273, 219, 56);
		contentPane.add(btnEditar);
		
		JLabel lblNewLabel = new JLabel("PASA");
		lblNewLabel.setFont(new Font("Felix Titling", Font.PLAIN, 90));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(151, 40, 277, 114);
		contentPane.add(lblNewLabel);
	}
}
