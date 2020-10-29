package Logica;

public class Director extends Cargo{
	private String nombre = "director";
	private int capacidad = 1;
	private String info = ">20 años de experiencia y no es percel";
	
	public Director(String cargo) {
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
