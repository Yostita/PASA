package Logica;

public class Operario extends Cargo{
	private String nombre = "operario";
	private int capacidad = 27;
	private String info =">20 años de edad";
	
	public Operario(String cargo) {
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
