package Interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.*;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;

public class A�adir extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;

	//Crea el Frame pasando la clase principal para poder llamar a sus metodos

	public A�adir(Principal principal) {
		setBounds(100, 100, 526, 431);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setDropMode(DropMode.INSERT);
		txtNombre.setBounds(236, 15, 186, 24);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido.setColumns(10);
		txtApellido.setBounds(237, 50, 186, 24);
		contentPane.add(txtApellido);
		
		JSpinner txtNacimiento = new JSpinner();
		txtNacimiento.setModel(new SpinnerNumberModel(2001, 1900, 2001, 0));
		txtNacimiento.setBounds(284, 158, 104, 30);
		contentPane.add(txtNacimiento);
				
		JRadioButton percel = new JRadioButton("");
		percel.setBounds(320, 275, 35, 30);
		contentPane.add(percel);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(89, 14, 92, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(89, 49, 92, 26);
		contentPane.add(lblApellido);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(89, 85, 92, 26);
		contentPane.add(lblCargo);
		
		JLabel lblExperiencia = new JLabel("Experiencia");
		lblExperiencia.setBounds(89, 121, 110, 26);
		contentPane.add(lblExperiencia);
		
		JLabel lblNacimiento = new JLabel("Nacimiento");
		lblNacimiento.setBounds(89, 160, 110, 26);
		contentPane.add(lblNacimiento);
		
		JLabel lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setBounds(89, 197, 110, 26);
		contentPane.add(lblHabilidad);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(89, 235, 151, 26);
		contentPane.add(lblDepartamento);
		
		JLabel lblPercel = new JLabel("Percel");
		lblPercel.setBounds(89, 275, 151, 26);
		contentPane.add(lblPercel);
		
		JComboBox<String> comboBoxCargo = new JComboBox<String>();
		comboBoxCargo.setBounds(236, 86, 186, 24);
		contentPane.add(comboBoxCargo);
		
		comboBoxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Director", "Subdirector", "Responsable", "Coordinador" , "Operario" }));
		
		JComboBox<String> comboBoxDepartamento = new JComboBox<String>();
		comboBoxDepartamento.setBounds(236, 236, 186, 24);
		contentPane.add(comboBoxDepartamento);
		
		comboBoxDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Direccion", "Logistica", "Control de Robots", "Medico", "Investigacion Biologica", "Construccion y Mantenimiento", "Sistemas Informaticos", "Investigacion Astronomica", "Cometologia", "Navegacion" }));
		
		JSpinner txtHabilidad = new JSpinner();
		txtHabilidad.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		txtHabilidad.setBounds(284, 194, 104, 30);
		contentPane.add(txtHabilidad);
		
		JSpinner txtExperiencia = new JSpinner();
		txtExperiencia.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		txtExperiencia.setBounds(284, 118, 104, 30);
		contentPane.add(txtExperiencia);

		JButton btnAceptar = new JButton("Guardar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String cargo = (String) comboBoxCargo.getSelectedItem();
				int experiencia = (int)txtExperiencia.getValue();
				int nacimiento = (int)txtNacimiento.getValue();
				int habilidad = (int)txtHabilidad.getValue();
				String departamento = (String) comboBoxDepartamento.getSelectedItem();
				boolean percels;
				
				if(percel.isSelected()) {
					percels = true;
				}else {
					percels = false;
				}
				
				//Primero comprueba que todo el formulario se haya completado
				if(principal.checkGuardarContent(nombre,apellido,cargo,experiencia,nacimiento,habilidad,departamento,percels)) {
					//Luego comprueba que los parametros introducidos sean validos
					if(principal.checkGuardarContentValue(nombre,apellido,cargo,experiencia,nacimiento,habilidad,departamento,percels).contentEquals("")) {
						//LLama al constructor de Miembro pero puesto que no tiene acceso al ArrayList llama al metodo que tiene Principal
						principal.addMiembro(nombre,apellido,cargo,experiencia,nacimiento,habilidad,departamento,percels);
						JOptionPane.showMessageDialog(null, "El usuario se ha a�adido correctamente");
						new Menu(principal).setVisible(true);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, principal.checkGuardarContentValue(nombre,apellido,cargo,experiencia,nacimiento,habilidad,departamento,percels));
					}
				}else {
					JOptionPane.showMessageDialog(null, "Error. No se han rellenado todos los campos.");
				}
			}
		});
		
		btnAceptar.setBounds(197, 314, 141, 35);
		contentPane.add(btnAceptar);
		
		JButton btnVolver = new JButton("<=");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Menu(principal).setVisible(true);
				setVisible(false);
			}
		});
		btnVolver.setBounds(21, 314, 61, 35);
		contentPane.add(btnVolver);
	}
}
