package Interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.*;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listado extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusqueda;

	//Crea el Frame pasando la clase principal para poder llamar a sus metodos

	public Listado(Principal principal) {
		setBounds(100, 100, 588, 496);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		txtBusqueda = new JTextField();
		txtBusqueda.setToolTipText("Escriba el nombre que desea buscar.");
		txtBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBusqueda.setBounds(360, 11, 150, 32);
		contentPane.add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(21, 55, 520, 314);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnPorCargo = new JButton("Por Cargo");
		btnPorCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				textArea.append(principal.toStringCargo());
			}
		});
		
		btnPorCargo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPorCargo.setBounds(100, 10, 104, 35);
		contentPane.add(btnPorCargo);
		
		JButton btnNewButton = new JButton("Por Departamento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				textArea.append(principal.toStringDepartamento());
				//new Departamentos(principal).setVisible(true);
				//setVisible(false);
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(209, 10, 141, 35);
		contentPane.add(btnNewButton);
		textArea.append(principal.toStringAllInfo());
		
		JButton btnBuscar = new JButton("...");
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtBusqueda.getText().contentEquals("")) {
					textArea.setText("");
					textArea.append(principal.toStringAll());
				}else {
					textArea.setText("");
					textArea.append(principal.findBusqueda(txtBusqueda.getText()));
				}
			}
		});
		btnBuscar.setBounds(508, 10, 33, 35);
		contentPane.add(btnBuscar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Menu(principal).setVisible(true);
				setVisible(false);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver.setBounds(21, 10, 76, 35);
		contentPane.add(btnVolver);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean salida=false;
				 
				//Comprueba que la busqueda sea valida para imprimir
				if(txtBusqueda.getText().contentEquals("Direccion")) {
					principal.printMiembro(textArea.getText());
					JOptionPane.showMessageDialog(null, "Se ha impreso correctamente");
					salida=true;
				}
				if(txtBusqueda.getText().contentEquals("Logistica")) {
					principal.printMiembro(textArea.getText());
					JOptionPane.showMessageDialog(null, "Se ha impreso correctamente");
					salida=true;
				}
				if(txtBusqueda.getText().contentEquals("Control de Robots")) {
					principal.printMiembro(textArea.getText());
					JOptionPane.showMessageDialog(null, "Se ha impreso correctamente");
					salida=true;
				}
				if(txtBusqueda.getText().contentEquals("Medico")) {
					principal.printMiembro(textArea.getText());
					JOptionPane.showMessageDialog(null, "Se ha impreso correctamente");
					salida=true;
				}
				if(txtBusqueda.getText().contentEquals("Investigacion Biologica")) {
					principal.printMiembro(textArea.getText());
					JOptionPane.showMessageDialog(null, "Se ha impreso correctamente");
					salida=true;
				}
				if(txtBusqueda.getText().contentEquals("Construccion y Mantenimiento")) {
					principal.printMiembro(textArea.getText());
					JOptionPane.showMessageDialog(null, "Se ha impreso correctamente");
					salida=true;
				}
				if(txtBusqueda.getText().contentEquals("Sistemas informaticos")) {
					principal.printMiembro(textArea.getText());
					JOptionPane.showMessageDialog(null, "Se ha impreso correctamente");
					salida=true;
				}
				if(txtBusqueda.getText().contentEquals("Investigacion astronomica")) {
					principal.printMiembro(textArea.getText());
					JOptionPane.showMessageDialog(null, "Se ha impreso correctamente");
					salida=true;
				}
				if(txtBusqueda.getText().contentEquals("Cometologia")) {
					principal.printMiembro(textArea.getText());
					JOptionPane.showMessageDialog(null, "Se ha impreso correctamente");
					salida=true;
				}
				if(txtBusqueda.getText().contentEquals("Navegacion")) {
					principal.printMiembro(textArea.getText());
					JOptionPane.showMessageDialog(null, "Se ha impreso correctamente");
					salida=true;
				}
				
				if(salida!=true) {
					if(principal.findBusquedaImrimir(txtBusqueda.getText())){
						JOptionPane.showMessageDialog(null, "Se ha impreso correctamente");
					}else {
						JOptionPane.showMessageDialog(null, "No se puede imprimir el contenido que hay en pantalla");
					}
				}
			}
		});
		
		btnImprimir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnImprimir.setBounds(219, 379, 104, 35);
		contentPane.add(btnImprimir);
	}
}
