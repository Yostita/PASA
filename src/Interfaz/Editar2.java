package Interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Logica.*;
import javax.swing.JLabel;

public class Editar2 extends JFrame {

	private JPanel contentPane;

	public Editar2(Principal principal, String nombre) {
		setBounds(100, 100, 588, 462);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("<=");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Editar(principal).setVisible(true);
				setVisible(false);
			}
		});
		
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(21, 21, 55, 27);
		contentPane.add(button);
		
		JButton button_0 = new JButton("");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Editar3(principal,nombre,0).setVisible(true);
				setVisible(false);
			}
		});
		button_0.setEnabled(false);
		button_0.setBounds(65, 145, 187, 35);
		contentPane.add(button_0);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Editar3(principal,nombre,1).setVisible(true);
				setVisible(false);
			}
		});
		button_1.setEnabled(false);
		button_1.setBounds(330, 145, 187, 35);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Editar3(principal,nombre,2).setVisible(true);
				setVisible(false);
			}
		});
		button_2.setEnabled(false);
		button_2.setBounds(65, 201, 187, 35);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Editar3(principal,nombre,3).setVisible(true);
				setVisible(false);
			}
		});
		button_3.setEnabled(false);
		button_3.setBounds(330, 201, 187, 35);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Editar3(principal,nombre,4).setVisible(true);
				setVisible(false);
			}
		});
		button_4.setEnabled(false);
		button_4.setBounds(65, 257, 187, 35);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Editar3(principal,nombre,5).setVisible(true);
				setVisible(false);
			}
		});
		button_5.setEnabled(false);
		button_5.setBounds(330, 257, 187, 35);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Editar3(principal,nombre,6).setVisible(true);
				setVisible(false);
			}
		});
		button_6.setEnabled(false);
		button_6.setBounds(65, 313, 187, 35);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Editar3(principal,nombre,7).setVisible(true);
				setVisible(false);
			}
		});
		button_7.setEnabled(false);
		button_7.setBounds(330, 313, 187, 35);
		contentPane.add(button_7);
		
		JLabel lblNewLabel = new JLabel("\u00BFA quien desea editar?");
		lblNewLabel.setBounds(65, 84, 290, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton(">");
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(319, 362, 55, 27);
		contentPane.add(btnNewButton);
		
		JButton button_8 = new JButton("<");
		button_8.setEnabled(false);
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_8.setBounds(206, 362, 55, 27);
		contentPane.add(button_8);
		
		JLabel lblNewLabel_1 = new JLabel("1/1");
		lblNewLabel_1.setBounds(274, 359, 37, 29);
		contentPane.add(lblNewLabel_1);
		
		switch(principal.checkBusqueda(nombre)) {
			case 1:
				button_0.setEnabled(true);
				button_0.setText(principal.findNombreEditar(nombre,0));
				break;
			case 2:
				button_0.setEnabled(true);
				button_0.setText(principal.findNombreEditar(nombre,0));
				button_1.setEnabled(true);
				button_1.setText(principal.findNombreEditar(nombre,1));
				break;
			case 3:
				button_0.setEnabled(true);
				button_0.setText(principal.findNombreEditar(nombre,0));
				button_1.setEnabled(true);
				button_1.setText(principal.findNombreEditar(nombre,1));
				button_2.setEnabled(true);
				button_2.setText(principal.findNombreEditar(nombre,2));
				break;
			case 4:
				button_0.setEnabled(true);
				button_0.setText(principal.findNombreEditar(nombre,0));
				button_1.setEnabled(true);
				button_1.setText(principal.findNombreEditar(nombre,1));
				button_2.setEnabled(true);
				button_2.setText(principal.findNombreEditar(nombre,2));
				button_3.setEnabled(true);
				button_3.setText(principal.findNombreEditar(nombre,3));
				break;
			case 5:
				button_0.setEnabled(true);
				button_1.setEnabled(true);
				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				break;
			case 6:
				button_1.setEnabled(true);
				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				button_5.setEnabled(true);
				button_6.setEnabled(true);
				break;
			case 8:
				//Añadir una ventana mas y activar el boton de siguiente
			default:
				break;
		}
		
		
	}
}
