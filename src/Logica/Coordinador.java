package Logica;

public class Coordinador extends Cargo{
	private String nombre = "coordinador";
	private int capacidad = 9;
	private String info = "coeficiente de habilidad >80";
	
	public Coordinador(String cargo) {
		super(cargo);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getCapacidad() {
		return this.capacidad;
	}
	
	public String getInfo() {
		return this.info;
	}
}
