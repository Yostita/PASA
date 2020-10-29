package Logica;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import Interfaz.*;

public class Principal implements Percel{
	ArrayList<Miembro> miembros = new ArrayList<Miembro>();
	public static int max = 100;
	
	public static void main(String[] args) throws IOException {
		Principal principal = new Principal();
		principal.arranca(principal);
	}
	
	//Arranca el programa haciendo una llamada a la clase Fichero
	public void arranca(Principal principal) throws IOException {
		Fichero fichero = new Fichero();
		
		fichero.start(principal.miembros, principal);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Login(principal).setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Llamada metodo percel
	public int percelPermitidos()
	{
		return 10;
	}
	
	//Cierra el programa almacenando en el fichero todo el contenido del ArrayList
	public boolean closePrograma() {
		sortByCargo();
		return (new Fichero().end(miembros));
	}
	
	//Crea un fichero en el que almacena la informacion en concreto de una persona
	public void printMiembro(String miembro) {
		new Fichero().btnImprimir(miembro);
	}
	
	//Cuenta cual es la posicion exacta de un objeto en concreto dentro del ArrayList
	public int getNumeroMiembro(String miembro, int posicion) {
		int num=0;
		
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getNombre().contentEquals(miembro)) {
				if(num==posicion) {
					return i;
				}
				num++;
			}
		}
		
		return 0;
	}
	
	//Borra un mimebro del array list en base a su posicion dentro del ArrayList
	public void removeMiembro(String miembro, int posicion) {
		miembros.remove(getNumeroMiembro(miembro,posicion));
	}
	
	//Envia de antemano cualquier string de un miembro en un formulario
	public String getProfileText(String miembro, String caso, int posicion) {
		if(caso.contentEquals("nombre")) {
			return miembros.get(getNumeroMiembro(miembro,posicion)).getNombre();
		}
		
		if(caso.contentEquals("apellido")) {
			return miembros.get(getNumeroMiembro(miembro,posicion)).getApellido();
		}
		
		return "Error. Llame a un tecnico";
	}
	
	//Envia cualquier int de un miembro en un formulario
	public int getProfileValue(String miembro, String caso, int posicion) {
		if(caso.contentEquals("experiencia")) {
			return miembros.get(getNumeroMiembro(miembro,posicion)).getExperiencia();
		}
		
		if(caso.contentEquals("nacimiento")) {
			return miembros.get(getNumeroMiembro(miembro,posicion)).getNacimiento();
		}
		
		if(caso.contentEquals("habilidad")) {
			return miembros.get(getNumeroMiembro(miembro,posicion)).getHabilidad();
		}
		
		if(caso.contentEquals("cargo")) {
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getCargo().contentEquals("director"))
				return 0;
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getCargo().contentEquals("subdirector"))
				return 1;
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getCargo().contentEquals("responsable"))
				return 2;
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getCargo().contentEquals("coordinador"))
				return 3;
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getCargo().contentEquals("operario"))
				return 4;
		}
		if(caso.contentEquals("departamento")) {
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getDepartamento().contentEquals("direccion"))
				return 0;
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getDepartamento().contentEquals("logistica"))
				return 1;
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getDepartamento().contentEquals("controlderobots"))
				return 2;
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getDepartamento().contentEquals("medico"))
				return 3;
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getDepartamento().contentEquals("investigacionbiologica"))
				return 4;
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getDepartamento().contentEquals("construccionymantenimiento"))
				return 5;
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getDepartamento().contentEquals("sistemasinformaticos"))
				return 6;
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getDepartamento().contentEquals("investigacionastronomica"))
				return 7;
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getDepartamento().contentEquals("cometologia"))
				return 8;
			if(miembros.get(getNumeroMiembro(miembro,posicion)).getDepartamento().contentEquals("navegacion"))
				return 9;
		}
		
		return 0;
	}
	
	//Imprime de antemano cualquier boolean de un miembro en un formulario
	public boolean getProfilePercel(String miembro, int posicion) {
		return miembros.get(getNumeroMiembro(miembro,posicion)).getPercel();
	}
	
	//Comprueba si hay 1 director en x departamento
	public boolean checkDirector(String departamento) {
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("director") && miembros.get(i).getDepartamento().contentEquals(departamento)) {
				return true;
			}
		}
		return false;
	}
	
	//Comprueba si hay 1 subdirector en x departamento
	public boolean checkSubdirector(String departamento) {
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("subdirector") && miembros.get(i).getDepartamento().contentEquals(departamento)) {
				return true;
			}
		}
		return false;
	}
	
	//Comprueba si hay 3 responsables en x departamento
	public boolean checkResponsable(String departamento) {
		int cont=0;
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("responsable") && miembros.get(i).getDepartamento().contentEquals(departamento)) {
				cont++;
				if(cont==3) {
					return true;
				}
			}
		}
		return false;
	}
	
	//Comprueba si hay 9 coordinadores en x departamento
	public boolean checkCoordinador(String departamento) {	
		int cont=0;
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("coordinador") && miembros.get(i).getDepartamento().contentEquals(departamento)) {
				cont++;
				if(cont==9) {
					return true;
				}
			}
		}
		return false;
	}
	
	//Comprueba si hay 27 director en x departamento
	public boolean checkOperario(String departamento) {	
		int cont=0;
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("operario") && miembros.get(i).getDepartamento().contentEquals(departamento)) {
				cont++;
				if(cont==27) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	//Llama al constructor miembro
	public void addMiembro(String nombre, String apellido, String cargo, int experiencia, int nacimiento, int habilidad, String departamento, boolean percel){
		 miembros.add(new Miembro(nombre,apellido,cargo,experiencia,nacimiento,habilidad,departamento,percel));
	}
	
	//Comprueba que los parametros del formulario esten vacios
	public boolean checkGuardarContent(String nombre, String apellido, String cargo, int experiencia, int nacimiento, int habilidad, String departamento, boolean percel) {
		if(nombre.contentEquals("")){
			return false;
		}
		
		if(apellido.contentEquals("")){
			return false;
		}
		
		if(cargo.contentEquals("")){
			return false;
		}
		
		if(experiencia==0) {
			return false;
		}
		
		if(habilidad==0) {
			return false;
		}
		
		if(departamento.contentEquals("")){
			return false;
		}
		
		return true;
	}
	
	//Comprueba que el contenido del fichero sea valido
	public String checkGuardarContentValue(String nombre, String apellido, String cargo, int experiencia, int nacimiento, int habilidad, String departamento, boolean percel) {
		String mensaje="";
		
		if(cargo.contentEquals("Director") && experiencia<20) {
			mensaje = "Error. Un director no puede tener menos de 20 años de experiencia";
			return mensaje;
		}
		
		if(cargo.contentEquals("Director") && percel==true) {
			mensaje = "Error. Un director no puede ser percel";
			return mensaje;
		}
		
		if(cargo.contentEquals("Subdirector") && experiencia<10) {
			mensaje = "Error. Un subdirector no puede tener menos de 10 años de experiencia";
			return mensaje;
		}
		
		if(cargo.contentEquals("Subdirector") && nacimiento>1990) {
			mensaje = "Error. Un subdirector no puede tener menos de 30 años";
			return mensaje;
		}
		
		if(cargo.contentEquals("Responsable") && nacimiento>1995) {
			mensaje = "Error. Un responsable no puede tener menos de 25 años";
			return mensaje;
		}
		
		if(cargo.contentEquals("Responsable") && habilidad<70) {
			mensaje = "Error. Un responsable tiene que tener como minimo 70 puntos de habilidad especial";
			return mensaje;
		}
		
		if(cargo.contentEquals("Coordinador") && habilidad<80) {
			mensaje = "Error. Un coordinador tiene que tener como minimo 80 puntos de habilidad especial";
			return mensaje;
		}
		
		if(cargo.contentEquals("Operario") && nacimiento>1999) {
			mensaje = "Error. Un operario no puede tener menos de 20 años";
			return mensaje;
		}	
		
		//En base al tipo de departamento comprueba si su cargo esta ya en su maxima capacidad o no 
		switch(departamento) {
			case "Direccion":
				switch(cargo){
					case "Director":
						if(checkDirector("direccion")) {
							mensaje="No puede haber mas directores en el departamento de Direccion";
							return mensaje;
						}
						break;
					case "Subdirector":
						if(checkSubdirector("direccion")) {
							mensaje="No puede haber mas subdirectores en el departamento de Direccion";
							return mensaje;
						}
						break;
					case "Responsable":
						if(checkResponsable("direccion")) {
							mensaje="No puede haber mas responsables en el departamento de Direccion";
							return mensaje;
						}
						break;
					case "Coordinador":
						if(checkCoordinador("direccion")) {
							mensaje="No puede haber mas coordinadores en el departamento de Direccion";
							return mensaje;
						}
						break;
					case "Operario":
						if(checkOperario("direccion")) {
							mensaje="No puede haber mas operarios en el departamento de Direccion";
							return mensaje;
						}
						break;
				}
				break;				
			case "Logistica":
				switch(cargo){
					case "Director":
						if(checkDirector("logistica")) {
							mensaje="No puede haber mas directores en el departamento de Logistica";
							return mensaje;
						}
						break;
					case "Subdirector":
						if(checkSubdirector("logistica")) {
							mensaje="No puede haber mas subdirectores en el departamento de Logistica";
							return mensaje;
						}
						break;
					case "Responsable":
						if(checkResponsable("logistica")) {
							mensaje="No puede haber mas responsables en el departamento de Logistica";
							return mensaje;
						}
						break;
					case "Coordinador":
						if(checkCoordinador("logistica")) {
							mensaje="No puede haber mas coordinadores en el departamento de Logistica";
							return mensaje;
						}
						break;
					case "Operario":
						if(checkOperario("logistica")) {
							mensaje="No puede haber mas operarios en el departamento de Logistica";
							return mensaje;
						}
						break;
				}
				break;
			case "Control de Robots":
				switch(cargo){
					case "Director":
						if(checkDirector("controlderobots")) {
							mensaje="No puede haber mas directores en el departamento de Control de Robots";
							return mensaje;
						}
						break;
					case "Subdirector":
						if(checkSubdirector("controlderobots")) {
							mensaje="No puede haber mas subdirectores en el departamento de Control de Robots";
							return mensaje;
						}
						break;
					case "Responsable":
						if(checkResponsable("controlderobots")) {
							mensaje="No puede haber mas responsables en el departamento de Control de Robots";
							return mensaje;
						}
						break;
					case "Coordinador":
						if(checkCoordinador("controlderobots")) {
							mensaje="No puede haber mas coordinadores en el departamento de Control de Robots";
							return mensaje;
						}
						break;
					case "Operario":
						if(checkOperario("controlderobots")) {
							mensaje="No puede haber mas operarios en el departamento de Control de Robots";
							return mensaje;
						}
						break;
				}
				break;
			case "Medico":
				switch(cargo){
					case "Director":
						if(checkDirector("medico")) {
							mensaje="No puede haber mas directores en el departamento de Medico";
							return mensaje;
						}
						break;
					case "Subdirector":
						if(checkSubdirector("medico")) {
							mensaje="No puede haber mas subdirectores en el departamento de Medico";
							return mensaje;
						}
						break;
					case "Responsable":
						if(checkResponsable("medico")) {
							mensaje="No puede haber mas responsables en el departamento de Medico";
							return mensaje;
						}
						break;
					case "Coordinador":
						if(checkCoordinador("medico")) {
							mensaje="No puede haber mas coordinadores en el departamento de Medico";
							return mensaje;
						}
						break;
					case "Operario":
						if(checkOperario("medico")) {
							mensaje="No puede haber mas operarios en el departamento de Medico";
							return mensaje;
						}
						break;
				}
				break;
			case "Investigacion Biologica":
				switch(cargo){
					case "Director":
						if(checkDirector("investigacionbiologica")) {
							mensaje="No puede haber mas directores en el departamento de Investigacion Biologica";
							return mensaje;
						}
						break;
					case "Subdirector":
						if(checkSubdirector("investigacionbiologica")) {
							mensaje="No puede haber mas subdirectores en el departamento de Investigacion Biologica";
							return mensaje;
						}
						break;
					case "Responsable":
						if(checkResponsable("investigacionbiologica")) {
							mensaje="No puede haber mas responsables en el departamento de Investigacion Biologica";
							return mensaje;
						}
						break;
					case "Coordinador":
						if(checkCoordinador("investigacionbiologica")) {
							mensaje="No puede haber mas coordinadores en el departamento de Investigacion Biologica";
							return mensaje;
						}
						break;
					case "Operario":
						if(checkOperario("investigacionbiologica")) {
							mensaje="No puede haber mas operarios en el departamento de Investigacion Biologica";
							return mensaje;
						}
						break;
				}
				break;
			case "Construccion y Mantenimiento":
				switch(cargo){
					case "Director":
						if(checkDirector("construccionymantenimiento")) {
							mensaje="No puede haber mas directores en el departamento de Construccion y Mantenimiento";
							return mensaje;
						}
						break;
					case "Subdirector":
						if(checkSubdirector("construccionymantenimiento")) {
							mensaje="No puede haber mas subdirectores en el departamento de Construccion y Mantenimiento";
							return mensaje;
						}
						break;
					case "Responsable":
						if(checkResponsable("construccionymantenimiento")) {
							mensaje="No puede haber mas responsables en el departamento de Construccion y Mantenimiento";
							return mensaje;
						}
						break;
					case "Coordinador":
						if(checkCoordinador("construccionymantenimiento")) {
							mensaje="No puede haber mas coordinadores en el departamento de Construccion y Mantenimiento";
							return mensaje;
						}
						break;
					case "Operario":
						if(checkOperario("construccionymantenimiento")) {
							mensaje="No puede haber mas operarios en el departamento de Construccion y Mantenimiento";
							return mensaje;
						}
						break;
				}
				break;
			case "Sistemas Informaticos":
				switch(cargo){
					case "Director":
						if(checkDirector("sistemasinformaticos")) {
							mensaje="No puede haber mas directores en el departamento de Sistemas Informaticos";
							return mensaje;
						}
						break;
					case "Subdirector":
						if(checkSubdirector("sistemasinformaticos")) {
							mensaje="No puede haber mas subdirectores en el departamento de Sistemas Informaticos";
							return mensaje;
						}
						break;
					case "Responsable":
						if(checkResponsable("sistemasinformaticos")) {
							mensaje="No puede haber mas responsables en el departamento de Sistemas Informaticos";
							return mensaje;
						}
						break;
					case "Coordinador":
						if(checkCoordinador("sistemasinformaticos")) {
							mensaje="No puede haber mas coordinadores en el departamento de Sistemas Informaticos";
							return mensaje;
						}
						break;
					case "Operario":
						if(checkOperario("sistemasinformaticos")) {
							mensaje="No puede haber mas operarios en el departamento de Sistemas Informaticos";
							return mensaje;
						}
						break;
				}
				break;
			case "Investigacion Astronomica":
				switch(cargo){
					case "Director":
						if(checkDirector("investigacionastronomica")) {
							mensaje="No puede haber mas directores en el departamento de Investigacion Astronomica";
							return mensaje;
						}
						break;
					case "Subdirector":
						if(checkSubdirector("investigacionastronomica")) {
							mensaje="No puede haber mas subdirectores en el departamento de Investigacion Astronomica";
							return mensaje;
						}
						break;
					case "Responsable":
						if(checkResponsable("investigacionastronomica")) {
							mensaje="No puede haber mas responsables en el departamento de Investigacion Astronomica";
							return mensaje;
						}
						break;
					case "Coordinador":
						if(checkCoordinador("investigacionastronomica")) {
							mensaje="No puede haber mas coordinadores en el departamento de Investigacion Astronomica";
							return mensaje;
						}
						break;
					case "Operario":
						if(checkOperario("investigacionastronomica")) {
							mensaje="No puede haber mas operarios en el departamento de Investigacion Astronomica";
							return mensaje;
						}
						break;
				}
				break;
			case "Cometologia":
				switch(cargo){
					case "Director":
						if(checkDirector("cometologia")) {
							mensaje="No puede haber mas directores en el departamento de Cometologia";
							return mensaje;
						}
						break;
					case "Subdirector":
						if(checkSubdirector("cometologia")) {
							mensaje="No puede haber mas subdirectores en el departamento de Cometologia";
							return mensaje;
						}
						break;
					case "Responsable":
						if(checkResponsable("cometologia")) {
							mensaje="No puede haber mas responsables en el departamento de Cometologia";
							return mensaje;
						}
						break;
					case "Coordinador":
						if(checkCoordinador("cometologia")) {
							mensaje="No puede haber mas coordinadores en el departamento de Cometologia";
							return mensaje;
						}
						break;
					case "Operario":
						if(checkOperario("cometologia")) {
							mensaje="No puede haber mas operarios en el departamento de Cometologia";
							return mensaje;
						}
						break;
				}
				break;
			case "Navegacion":
				switch(cargo){
					case "Director":
						if(checkDirector("navegacion")) {
							mensaje="No puede haber mas directores en el departamento de Navegacion";
							return mensaje;
						}
						break;
					case "Subdirector":
						if(checkSubdirector("navegacion")) {
							mensaje="No puede haber mas subdirectores en el departamento de Navegacion";
							return mensaje;
						}
						break;
					case "Responsable":
						if(checkResponsable("navegacion")) {
							mensaje="No puede haber mas responsables en el departamento de Navegacion";
							return mensaje;
						}
						break;
					case "Coordinador":
						if(checkCoordinador("navegacion")) {
							mensaje="No puede haber mas coordinadores en el departamento de Navegacion";
							return mensaje;
						}
						break;
					case "Operario":
						if(checkOperario("navegacion")) {
							mensaje="No puede haber mas operarios en el departamento de Navegacion";
							return mensaje;
						}
						break;
				}
				break;
		}			
		return mensaje;
	}
	
	//Hace la misma comprobacion que checkGuardarContentValue pero eliminando la comprbacion del cargo y el departamento
	public String checkGuardarContentValueEdit(String nombre, String apellido, String cargo, int experiencia, int nacimiento, int habilidad, String departamento, boolean percel) {
		String mensaje="";
		
		if(cargo.contentEquals("Director") && experiencia<20) {
			mensaje = "Error. Un director no puede tener menos de 20 años de experiencia";
			return mensaje;
		}
		
		if(cargo.contentEquals("Director") && percel==true) {
			mensaje = "Error. Un director no puede ser percel";
			return mensaje;
		}
		
		if(cargo.contentEquals("Subdirector") && experiencia<10) {
			mensaje = "Error. Un subdirector no puede tener menos de 10 años de experiencia";
			return mensaje;
		}
		
		if(cargo.contentEquals("Subdirector") && nacimiento>1990) {
			mensaje = "Error. Un subdirector no puede tener menos de 30 años";
			return mensaje;
		}
		
		if(cargo.contentEquals("Responsable") && nacimiento>1995) {
			mensaje = "Error. Un responsable no puede tener menos de 25 años";
			return mensaje;
		}
		
		if(cargo.contentEquals("Responsable") && habilidad<70) {
			mensaje = "Error. Un responsable no tiene que tener como minimo 70 puntos de habilidad especial";
			return mensaje;
		}
		
		if(cargo.contentEquals("Coordinador") && habilidad<80) {
			mensaje = "Error. Un coordinador no tiene que tener como minimo 80 puntos de habilidad especial";
			return mensaje;
		}
		
		if(cargo.contentEquals("Operario") && nacimiento>1999) {
			mensaje = "Error. Un operario no puede tener menos de 20 años";
			return mensaje;
		}
		return mensaje;
	}
	
	//Comprueba cual es la posision un miembro en el ArrayList en base a un nombre y devuelve su posicion
	public int checkBusqueda(String nombre) {
		boolean encontrado = false;
		int num=0;
		
		if(!miembros.isEmpty()) {
			for (int i=0; i<miembros.size();i++) {
				if(miembros.get(i).getNombre().contentEquals(nombre)) {
					encontrado = true;
					num++;
				}
			}
			if(encontrado) {
				return num;
			}else
				return 0;
		}
		return 0;
	}
	
	//Comprueba la busqueda de un nombre
	public String findNombreEditar(String nombre, int index) {
		String mensaje="";
		int num=0;
		
		if(!miembros.isEmpty()) {
			for (int i=0; i<miembros.size();i++) {
				if(miembros.get(i).getNombre().contentEquals(nombre)) {
					if(num==index) {
						mensaje = miembros.get(i).getNombre() + " " + miembros.get(i).getApellido();
					}
				
					num++;
				}
			}
		}
		return mensaje;
	}
	
	//Devuelve todo el contenido del ArrayList
	public String toStringAll() {
		sortByCargo();
		String mensaje="";
		
		if(!miembros.isEmpty()) {
			for (int i=0; i<miembros.size();i++) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
			return mensaje;
		}
		
		mensaje= "La base de datos esta vacía";
		return mensaje;
	}
	
	//Cuenta cuantos directores hay
	public int countDirectores() {
		int count = 0;
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("director")) {
				count++;
			}
		}
		return count;
	}
	
	//Cuenta cuantos subdirectores hay
	public int countSubdirectores() {
		int count = 0;
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("subdirector")) {
				count++;
			}
		}
		return count;
	}
	
	//Cuenta cuantos responsables hay
	public int countResponsable() {
		int count = 0;
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("responsable")) {
				count++;
			}
		}
		return count;
	}
	
	//Cuenta cuantos coordinadores hay
	public int countCoordinador() {
		int count = 0;
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("coordinador")) {
				count++;
			}
		}
		return count;
	}
	
	//Cuenta cuantos operarios hay
	public int countOperario() {
		int count = 0;
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("operario")) {
				count++;
			}
		}
		return count;
	}
	
	//Devuelve toda la informacion de las anteriores funciones
	public String toStringAllInfo() {
		String mensaje="";
		
		if(!miembros.isEmpty()) {
			mensaje = mensaje + "Numero total de miembros: " + miembros.size() + "\n";
			mensaje = mensaje + "Numero de directores: " + countDirectores() + "\n";
			mensaje = mensaje + "Numero de subdirectores: " + countSubdirectores() + "\n";
			mensaje = mensaje + "Numero de responsables: " + countResponsable() + "\n";
			mensaje = mensaje + "Numero de coordinadores: " + countCoordinador() + "\n";
			mensaje = mensaje + "Numero de operarios: " + countOperario() + "\n";
			return mensaje;
		}
		
		mensaje= "La base de datos esta vacía";
		return mensaje;
	}
	
	/*
	//Devuelve toda la informacion de un miembro del ArrayList tal y como esta en la base de Datos
	public String toStringPersona(Miembro miembros) {
		String mensaje;
		mensaje = miembros.getNombre() + " " + miembros.getApellido() + " " + miembros.getCargo() + " " + miembros.getExperiencia() + " " + miembros.getNacimiento() + " " + miembros.getHabilidad() + " " + miembros.getDepartamento() + " " + miembros.getPercel() + "\n";
		return mensaje;
	}
	*/
	
	//Devuelve toda la informacion de un miembro del ArrayList de forma ordenada
	public String toStringPersona(Miembro miembros) {
		String mensaje;
		mensaje = "Nombre: " + miembros.getNombre() + "\n" + "Apellido: " + miembros.getApellido() + "\n" + "Cargo: " + miembros.getCargo() + "\n" + "Experiencia: " + miembros.getExperiencia() + "\n" + "Fecha de nacimiento: " + miembros.getNacimiento() + "\n" + "Puntos de habilidad: " + miembros.getHabilidad() + "\n" + "Departamento: " + miembros.getDepartamento() + "\n" + "Percel: " + miembros.getPercel() + "\n\n";
		return mensaje;
	}
	
	//Devuelve el valor de busqueda en el formato correcto
	public String findBusquedaDepartamento(String busqueda) {
		switch(busqueda) {
			case "Direccion":
				busqueda="direccion";
				return busqueda;
			case "Logistica":
				busqueda="logistica";
				return busqueda;
			case "Control de Robots":
				busqueda="controlderobots";
				return busqueda;
			case "Medico":
				busqueda="medico";
				return busqueda;
			case "Investigacion Biologica":
				busqueda="investigacionbiologica";
				return busqueda;
			case "Construccion y Mantenimiento":
				busqueda="construccionymantenimiento";
				return busqueda;
			case "Sistemas Informaticos":
				busqueda="sistemasinformaticos";
				return busqueda;
			case "Investigacion Astronomica":
				busqueda="investigacionastronomica";
				return busqueda;
			case "Cometologia":
				busqueda="cometologia";
				return busqueda;
			case "Navegacion":
				busqueda="navegacion";
				return busqueda;
			default:
				busqueda="";
				return busqueda;
		}
	}
	
	/*
	 *
	//Devuelve el valor de busqueda en el formato correcto
	public String findBusquedaCargo(String busqueda) {
		switch(busqueda) {
			case "Director":
				busqueda="director";
				return busqueda;
			case "Subdirector":
				busqueda="subdirector";
				return busqueda;
			case "Responsable":
				busqueda="responsble";
				return busqueda;
			case "Coordinador":
				busqueda="coordinador";
				return busqueda;
			case "Operario":
				busqueda="operario";
				return busqueda;
	}
	*/
	
	//Devuelve en un String el contenido de busqueda ya sea Nombre, Departamento o Cargo
	public String findBusqueda(String busqueda) {
		String mensaje="";
		boolean encontrado = false;
		
		if(!findBusquedaDepartamento(busqueda).contentEquals("")) {
			busqueda = findBusquedaDepartamento(busqueda);
			for (int i=0; i<miembros.size();i++) {
				if(miembros.get(i).getDepartamento().contentEquals(busqueda)) {
					mensaje = mensaje + toStringPersona(miembros.get(i));
				}
			}
		}else {
			for (int i=0; i<miembros.size();i++) {
				if(miembros.get(i).getNombre().contentEquals(busqueda)) {
					encontrado = true;
					mensaje = mensaje + toStringPersona(miembros.get(i));
				}
			}
			if(encontrado) {
				return mensaje;
			}else
				mensaje = "No se ha encontrado ningun miembro con el nombre " + busqueda + ".";
				return mensaje;
		}
		return mensaje;	
	}
	
	public boolean findBusquedaImrimir(String busqueda) {
		String mensaje="";
		boolean encontrado = false;
		
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getNombre().contentEquals(busqueda)) {
				encontrado = true;
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		if(encontrado) {
			printMiembro(mensaje);
			return true;
		}else {
			return false;	
		}	
	}
	
	//Devuelve en un String todo el contenido de ArrayList por cargos
	public String toStringCargo() {
		String mensaje = "Directores: >20 años de experiencia y no es percel";
		mensaje = mensaje + "\n" + "Subdirector: >10 años de experiencia y >30 años de edad";
		mensaje = mensaje + "\n" + "Responsable: >25 año de edad y un coeficiente de habilidad >70";
		mensaje = mensaje + "\n" + "Coordinador: coeficiente de habilidad >80";
		mensaje = mensaje + "\n" + "Operario: >20 años de edad";
		mensaje = mensaje + "\n\n" + "============================ DIRECTORES ==============================================" + "\n";
		
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("director")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		
		mensaje = mensaje + "\n" + "=========================== SUBDIRECTORES =================================================" + "\n";
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("subdirector")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		
		mensaje = mensaje + "\n" + "============================ RESPONSABLES =================================================" + "\n";
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("responsable")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		
		mensaje = mensaje + "\n" + "=========================== COORDINADORES =================================================" + "\n";
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("coordinador")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		
		mensaje = mensaje + "\n" + "============================== OPERARIOS =================================================" + "\n";
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("operario")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}	
		return mensaje;
	}
	
	//Devuelve en un String todo el contenido de ArrayList por departamentos
	public String toStringDepartamento() {
		String mensaje = "============================ DIRECCION ==============================================" + "\n";
		
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getDepartamento().contentEquals("direccion")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		
		mensaje = mensaje + "\n" + "============================ LOGISTICA =================================================" + "\n";
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getDepartamento().contentEquals("logistica")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		
		mensaje = mensaje + "\n" + "======================== CONTROL DE ROBOTS =================================================" + "\n";
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getDepartamento().contentEquals("controlderobots")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		
		mensaje = mensaje + "\n" + "============================= MEDICO =================================================" + "\n";
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getDepartamento().contentEquals("medico")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		
		mensaje = mensaje + "\n" + "======================= INVESTIGACION BIOLOGICA =================================================" + "\n";
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getDepartamento().contentEquals("investigacionbiologica")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		
		mensaje = mensaje + "\n" + "===================== CONSTRUCCION Y MANTENIMIENTO =================================================" + "\n";
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getDepartamento().contentEquals("construccionymantenimiento")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		
		mensaje = mensaje + "\n" + "======================== SISTEMAS INFORMATICOS =================================================" + "\n";
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getDepartamento().contentEquals("sistemasinformaticos")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		
		mensaje = mensaje + "\n" + "====================== INVESTIGACION ASTRONOMICA =================================================" + "\n";
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getDepartamento().contentEquals("investigacionastronomica")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		
		mensaje = mensaje + "\n" + "============================= COMETOLOGIA =================================================" + "\n";
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getDepartamento().contentEquals("cometologia")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		
		mensaje = mensaje + "\n" + "============================== NAVEGACION =================================================" + "\n";
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getDepartamento().contentEquals("navegacion")) {
				mensaje = mensaje + toStringPersona(miembros.get(i));
			}
		}
		return mensaje;
	}	
	
	//Ordena el ArrayList por cargos
	public void sortByCargo() {
		ArrayList <Miembro> miembros_ordenado = new ArrayList <Miembro>();
		
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("director")) {
				miembros_ordenado.add(miembros.get(i));
			}
		}
		
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("subdirector")) {
				miembros_ordenado.add(miembros.get(i));
			}
			
		}
		
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("responsable")) {
				miembros_ordenado.add(miembros.get(i));
			}
		}
		
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("coordinador")) {
				miembros_ordenado.add(miembros.get(i));
			}
		}
		
		for (int i=0; i<miembros.size();i++) {
			if(miembros.get(i).getCargo().contentEquals("operario")) {
				miembros_ordenado.add(miembros.get(i));
			}
		}
		miembros.clear();
		miembros.addAll(miembros_ordenado);
	}
}