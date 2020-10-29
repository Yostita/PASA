package Logica;

public class Miembro {
	private String nombre;
	private String apellido;
	Cargo cargos;
	private String cargo;
	private int experiencia;
	private int nacimiento;
	private int habilidad;
	private String departamento;
	private boolean percel;
		
	//Constructor estandar de los parametros directamente desde el fichero
	public Miembro (String nombre,String apellido, String cargo, String experiencia,String nacimiento, String habilidad, String departamento, String percel) {
		this.nombre=nombre;
		this.apellido=apellido;
		//new Cargo(cargo);
		this.cargo=cargo;
		this.experiencia=Integer.parseInt(experiencia);
		this.nacimiento=Integer.parseInt(nacimiento);
		this.habilidad=Integer.parseInt(habilidad);
		this.departamento=departamento;
		this.percel=Boolean.parseBoolean(percel);
	}
	
	//Construcctor basa en los valores reales de la clase Miembro
	public Miembro (String nombre,String apellido, String cargo, int experiencia,int nacimiento, int habilidad, String departamento, boolean percel) {
		this.nombre=nombre;
		this.apellido=apellido;
		
		//Transforma a un formato valido el cargo
		switch(cargo) {
			case "Director":
				this.cargo="director";
				break;
			case "Subdirector":
				this.cargo="subdirector";
				break;
			case "Responsable":
				this.cargo="responsable";
				break;
			case "Coordinador":
				this.cargo="coordinador";
				break;
			case "Operario":
				this.cargo="operario";
				break;
		}

		this.experiencia=experiencia;
		this.nacimiento=nacimiento;
		this.habilidad=habilidad;
		
		//Transforma a un formato valido el departamento
		switch(departamento) {
			case "Direccion":
				this.departamento="direccion";
				break;
			case "Logistica":
				this.departamento="logistica";
				break;
			case "Control de Robots":
				this.departamento="controlderobots";
				break;
			case "Medico":
				this.departamento="medico";
				break;
			case "Investigacion Biologica":
				this.departamento="investigacionbiologica";
				break;
			case "Construccion y Mantenimiento":
				this.departamento="construccionymantenimiento";
				break;
			case "Sistemas Informaticos":
				this.departamento="sistemasinformaticos";
				break;
			case "Investigacion Astronomica":
				this.departamento="investigacionastronomica";
				break;
			case "Cometologia":
				this.departamento="cometologia";
				break;
			case "Navegacion":
				this.departamento="navegacion";
				break;
		}
		
		this.percel=percel;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getCargo() {
		return this.cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo= cargo;
	}
	
	public int getExperiencia() {
		return this.experiencia;
	}
	
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	
	public int getNacimiento() {
		return this.nacimiento;
	}
	
	public void setNacimiento(int nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	public int getHabilidad() {
		return this.habilidad;
	}
	
	public void setHabilidad(int habilidad) {
		this.habilidad = habilidad;
	}
	
	public String getDepartamento() {
		return this.departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public boolean getPercel() {
		return this.percel;
	}	
	
	public void setPercel(boolean percel) {
		this.percel = percel;
	}
}
