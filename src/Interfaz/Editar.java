package Interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Logica.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editar extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;

	//Crea el Frame pasando la clase principal para poder llamar a sus metodos

	public Editar(Principal principal) {
		setBounds(100, 100, 588, 440);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(172, 169, 219, 32);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (principal.checkBusqueda(textNombre.getText())!=0) {
					new Editar2(principal,textNombre.getText()).setVisible(true);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "No se ha encontrado ningun resultado");
				}
			}
		});
		
		btnBuscar.setBounds(210, 216, 141, 35);
		contentPane.add(btnBuscar);
		
		JButton button = new JButton("<=");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Menu(principal).setVisible(true);
				setVisible(false);
			}
		});
		
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(21, 21, 55, 27);
		contentPane.add(button);
	}

}
