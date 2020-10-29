package Logica;

public abstract class Cargo{
	public Cargo(String cargo) {
		switch(cargo) {
			case "Director":
				new Director(cargo);
			case "Subdirector":
				new Subdirector(cargo);
			case "Responsable":
				new Responsable(cargo);
			case "Coordinador":
				new Coordinador(cargo);
			case "Operario":
				new Operario(cargo);
		}
	}
}
