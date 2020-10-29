package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

import Logica.Principal;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Departamentos extends JFrame {

	private JPanel contentPane;

	public Departamentos(Principal principal) {
		setBounds(100, 100, 730, 566);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Listado(principal).setVisible(true);
				setVisible(false);
			}
		});
		
		btnNewButton.setBounds(12, 10, 116, 35);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 54, 239, 420);
		contentPane.add(scrollPane);
		
		JTree departamentos = new JTree();
		departamentos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		departamentos.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Departamentos") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Direcci\u00F3n");
						node_1.add(new DefaultMutableTreeNode("Director"));
						node_1.add(new DefaultMutableTreeNode("Subdirector"));
						node_1.add(new DefaultMutableTreeNode("Responsable"));
						node_1.add(new DefaultMutableTreeNode("Coordinador"));
						node_1.add(new DefaultMutableTreeNode("Operario"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Log\u00EDstica");
						node_1.add(new DefaultMutableTreeNode("Director"));
						node_1.add(new DefaultMutableTreeNode("Subdirector"));
						node_1.add(new DefaultMutableTreeNode("Responsable"));
						node_1.add(new DefaultMutableTreeNode("Coordinador"));
						node_1.add(new DefaultMutableTreeNode("Operario"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Control de Robots");
						node_1.add(new DefaultMutableTreeNode("Director"));
						node_1.add(new DefaultMutableTreeNode("Subdirector"));
						node_1.add(new DefaultMutableTreeNode("Responsable"));
						node_1.add(new DefaultMutableTreeNode("Coordinador"));
						node_1.add(new DefaultMutableTreeNode("Operario"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("M\u00E9dico");
						node_1.add(new DefaultMutableTreeNode("Director"));
						node_1.add(new DefaultMutableTreeNode("Subdirector"));
						node_1.add(new DefaultMutableTreeNode("Responsable"));
						node_1.add(new DefaultMutableTreeNode("Coordinador"));
						node_1.add(new DefaultMutableTreeNode("Operario"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Investigaci\u00F3n Biol\u00F3gica");
						node_1.add(new DefaultMutableTreeNode("Director"));
						node_1.add(new DefaultMutableTreeNode("Subdirector"));
						node_1.add(new DefaultMutableTreeNode("Responsable"));
						node_1.add(new DefaultMutableTreeNode("Coordinador"));
						node_1.add(new DefaultMutableTreeNode("Operario"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Construcci\u00F3n y Mantenimiento");
						node_1.add(new DefaultMutableTreeNode("Director"));
						node_1.add(new DefaultMutableTreeNode("Subdirector"));
						node_1.add(new DefaultMutableTreeNode("Responsable"));
						node_1.add(new DefaultMutableTreeNode("Coordinador"));
						node_1.add(new DefaultMutableTreeNode("Operario"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Sistemas inform\u00E1ticos");
						node_1.add(new DefaultMutableTreeNode("Director"));
						node_1.add(new DefaultMutableTreeNode("Subdirector"));
						node_1.add(new DefaultMutableTreeNode("Responsable"));
						node_1.add(new DefaultMutableTreeNode("Coordinador"));
						node_1.add(new DefaultMutableTreeNode("Operario"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Investigaci\u00F3n astron\u00F3mica");
						node_1.add(new DefaultMutableTreeNode("Director"));
						node_1.add(new DefaultMutableTreeNode("Subdirector"));
						node_1.add(new DefaultMutableTreeNode("Responsable"));
						node_1.add(new DefaultMutableTreeNode("Coordinador"));
						node_1.add(new DefaultMutableTreeNode("Operario"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Cometolog\u00EDa");
						node_1.add(new DefaultMutableTreeNode("Director"));
						node_1.add(new DefaultMutableTreeNode("Subdirector"));
						node_1.add(new DefaultMutableTreeNode("Responsable"));
						node_1.add(new DefaultMutableTreeNode("Coordinador"));
						node_1.add(new DefaultMutableTreeNode("Operario"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Navegaci\u00F3n");
						node_1.add(new DefaultMutableTreeNode("Director"));
						node_1.add(new DefaultMutableTreeNode("Subdirector"));
						node_1.add(new DefaultMutableTreeNode("Responsable"));
						node_1.add(new DefaultMutableTreeNode("Coordinador"));
						node_1.add(new DefaultMutableTreeNode("Operario"));
					add(node_1);
				}
			}
		));
		scrollPane.setViewportView(departamentos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(272, 10, 421, 464);
		contentPane.add(scrollPane_1);
		
		JTextArea txtOutput = new JTextArea();
		txtOutput.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtOutput.setText("Paco;Marzal;director;25;1970;98;direccion;false\r\nJavier;Garcia;subdirector;25;1970;90;direccion;true");
		txtOutput.setEditable(false);
		scrollPane_1.setViewportView(txtOutput);
	}
}
