package Logica;

public class Responsable extends Cargo{
	private String nombre = "responsable";
	private int capacidad = 3;
	private String info = ">25 año de edad y un coeficiente de habilidad >70";
	
	public Responsable(String cargo) {
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
