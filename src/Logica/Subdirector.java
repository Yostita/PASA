package Logica;

public class Subdirector extends Cargo{
	private String nombre = "subdirector";
	private int capacidad = 1;
	private String info = ">10 años de experiencia y >30 años de edad";
	
	public Subdirector(String cargo) {
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
