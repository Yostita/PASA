package Logica;

import java.io.*;
import java.util.*;

public class Fichero{
	
	//Vuelca todo el contenido del fichero en un ArrayList
	public void start(ArrayList<Miembro> miembros, Principal principal) throws IOException {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
	         // Apertura del fichero y creacion de BufferedReader
	         archivo = new File ("DataBase.txt");
	         fr = new FileReader (archivo);
	         BufferedReader bufferedReader = br = new BufferedReader(fr);
	         
	         // Lectura del fichero
	         String linea;
	         while((linea=br.readLine())!=null) {
	        	 linea.split(";");
	        	 String []parts = linea.split(";");
	        	 
	        	 //Primero comprobamos si los datos son validos
	        	if(!checkMiembro(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],principal).contentEquals("")) {
	        		//Exception e = new Exception("Error en: "+ parts[0] + " " + parts[1] + ". " + checkMiembro(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],principal));
	        		//throw e;
	        		throw new MiExcepcion("Error en: "+ parts[0] + " " + parts[1] + ". " + checkMiembro(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],principal));
	        	}
	        	if(miembros.size() > Principal.max) {
	        		throw new MiExcepcion("Demasiados miembros");
	        	}
	        	 //Una vez validados llamamos al constructor
	        	miembros.add(new Miembro(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7]));
	         }   
	    //Excepcion de error al abrir el fichero o un dato erroneo
		}catch(MiExcepcion e) {
			System.out.print(e);
			System.exit(0);
    	}
	}
	
	//Almacena en el fichero todo el contenido de ArrayList
	public boolean end(ArrayList<Miembro> miembros) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("DataBase.txt"));
			bw.write("");
			
			int i=0;
			while(i!=miembros.size()) {
				bw.write(getMiembroFichero(miembros,i));
				i++;
	         }  
			bw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	//Transforma el contenido de ArrayList al formato del fichero
	public String getMiembroFichero(ArrayList<Miembro> miembros,int i){
		String mensaje="";
		
		mensaje = miembros.get(i).getNombre() + ";";
		mensaje = mensaje + miembros.get(i).getApellido() + ";";
		mensaje = mensaje + miembros.get(i).getCargo() + ";";
		mensaje = mensaje + miembros.get(i).getExperiencia() + ";";
		mensaje = mensaje + miembros.get(i).getNacimiento() + ";";
		mensaje = mensaje + miembros.get(i).getHabilidad() + ";";
		mensaje = mensaje + miembros.get(i).getDepartamento() + ";";
		mensaje = mensaje + miembros.get(i).getPercel() + "\n";
		
		return mensaje;
	}
	
	//Imprime en un nuevo fichero el String que recibe
	public void btnImprimir(String aImprimir){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("BotonImprimir.txt"));
			bw.write("");
			bw.write(aImprimir);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	//Comprueba si los datos del fichero son validos
	public String checkMiembro(String nombre,String apellido, String cargo, String experiencia,String nacimiento, String habilidad, String departamento, String percel, Principal principal){
		String mensaje="";
		int experiencias = Integer.parseInt(experiencia);
		int nacimientos = Integer.parseInt(nacimiento);
		int habilidads = Integer.parseInt(habilidad);
		boolean percels = Boolean.parseBoolean(percel);
		
		if(nombre.contentEquals("")){
			return "No se han rellenado todos los campos.";
		}
		
		if(apellido.contentEquals("")){
			return "No se han rellenado todos los campos.";
		}
		
		if(cargo.contentEquals("")){
			return "No se han rellenado todos los campos.";
		}
		
		if(experiencias==0) {
			return "No se han rellenado todos los campos.";
		}
		if(habilidads==0) {
			return "No se han rellenado todos los campos.";
		}
		
		if(departamento.contentEquals("")){
			return "No se han rellenado todos los campos.";
		}
		
		//Comprobamos las especificaciones
		
		if(cargo.contentEquals("director") && experiencias<20) {
			return "Un director no puede tener menos de 20 años de experiencia";
		}
		
		if(cargo.contentEquals("director") && percels==true) {
			return "Un director no puede ser percel";
		}
		
		if(cargo.contentEquals("subdirector") && experiencias<10) {
			return "Un subdirector no puede tener menos de 10 años de experiencia";
		}
		
		if(cargo.contentEquals("subdirector") && nacimientos>1990) {
			return "Un subdirector no puede tener menos de 30 años";
		}
		
		if(cargo.contentEquals("responsable") && nacimientos>1995) {
			return "Un responsable no puede tener menos de 25 años";
		}
		
		if(cargo.contentEquals("responsable") && habilidads<70) {
			return "Un responsable tiene que tener como minimo 70 puntos de habilidad especial";
		}
		
		if(cargo.contentEquals("coordinador") && habilidads<80) {
			return "Un coordinador tiene que tener como minimo 80 puntos de habilidad especial";
		}
		
		if(cargo.contentEquals("operario") && nacimientos>1999) {
			return "Un operario no puede tener menos de 20 años";
		}
		
		//Comprobamos la cantidad de cargos por departamento
		//Puesto que el otro switch tenia un parametro diferente en departamento y cargo se tiene que utilizar uno nuevo 
		switch(departamento) {
			case "direccion":
				switch(cargo){
					case "director":
						if(principal.checkDirector("direccion")) {
							mensaje="No puede haber mas directores en el departamento de Direccion";
							return mensaje;
						}
						break;
					case "subdirector":
						if(principal.checkSubdirector("direccion")) {
							mensaje="No puede haber mas subdirectores en el departamento de Direccion";
							return mensaje;
						}
						break;
					case "responsable":
						if(principal.checkResponsable("direccion")) {
							mensaje="No puede haber mas responsables en el departamento de Direccion";
							return mensaje;
						}
						break;
					case "coordinador":
						if(principal.checkCoordinador("direccion")) {
							mensaje="No puede haber mas coordinadores en el departamento de Direccion";
							return mensaje;
						}
						break;
					case "operario":
						if(principal.checkOperario("direccion")) {
							mensaje="No puede haber mas operarios en el departamento de Direccion";
							return mensaje;
						}
						break;
				}
				break;				
			case "logistica":
				switch(cargo){
					case "director":
						if(principal.checkDirector("logistica")) {
							mensaje="No puede haber mas directores en el departamento de Logistica";
							return mensaje;
						}
						break;
					case "subdirector":
						if(principal.checkSubdirector("logistica")) {
							mensaje="No puede haber mas subdirectores en el departamento de Logistica";
							return mensaje;
						}
						break;
					case "responsable":
						if(principal.checkResponsable("logistica")) {
							mensaje="No puede haber mas responsables en el departamento de Logistica";
							return mensaje;
						}
						break;
					case "coordinador":
						if(principal.checkCoordinador("logistica")) {
							mensaje="No puede haber mas coordinadores en el departamento de Logistica";
							return mensaje;
						}
						break;
					case "operario":
						if(principal.checkOperario("logistica")) {
							mensaje="No puede haber mas operarios en el departamento de Logistica";
							return mensaje;
						}
						break;
				}
				break;
			case "controlderobots":
				switch(cargo){
					case "director":
						if(principal.checkDirector("controlderobots")) {
							mensaje="No puede haber mas directores en el departamento de Control de Robots";
							return mensaje;
						}
						break;
					case "subdirector":
						if(principal.checkSubdirector("controlderobots")) {
							mensaje="No puede haber mas subdirectores en el departamento de Control de Robots";
							return mensaje;
						}
						break;
					case "responsable":
						if(principal.checkResponsable("controlderobots")) {
							mensaje="No puede haber mas responsables en el departamento de Control de Robots";
							return mensaje;
						}
						break;
					case "coordinador":
						if(principal.checkCoordinador("controlderobots")) {
							mensaje="No puede haber mas coordinadores en el departamento de Control de Robots";
							return mensaje;
						}
						break;
					case "operario":
						if(principal.checkOperario("controlderobots")) {
							mensaje="No puede haber mas operarios en el departamento de Control de Robots";
							return mensaje;
						}
						break;
				}
				break;
			case "medico":
				switch(cargo){
					case "director":
						if(principal.checkDirector("medico")) {
							mensaje="No puede haber mas directores en el departamento de Medico";
							return mensaje;
						}
						break;
					case "subdirector":
						if(principal.checkSubdirector("medico")) {
							mensaje="No puede haber mas subdirectores en el departamento de Medico";
							return mensaje;
						}
						break;
					case "responsable":
						if(principal.checkResponsable("medico")) {
							mensaje="No puede haber mas responsables en el departamento de Medico";
							return mensaje;
						}
						break;
					case "coordinador":
						if(principal.checkCoordinador("medico")) {
							mensaje="No puede haber mas coordinadores en el departamento de Medico";
							return mensaje;
						}
						break;
					case "operario":
						if(principal.checkOperario("medico")) {
							mensaje="No puede haber mas operarios en el departamento de Medico";
							return mensaje;
						}
						break;
				}
				break;
			case "investigacionbiologica":
				switch(cargo){
					case "director":
						if(principal.checkDirector("investigacionbiologica")) {
							mensaje="No puede haber mas directores en el departamento de Investigacion Biologica";
							return mensaje;
						}
						break;
					case "subdirector":
						if(principal.checkSubdirector("investigacionbiologica")) {
							mensaje="No puede haber mas subdirectores en el departamento de Investigacion Biologica";
							return mensaje;
						}
						break;
					case "responsable":
						if(principal.checkResponsable("investigacionbiologica")) {
							mensaje="No puede haber mas responsables en el departamento de Investigacion Biologica";
							return mensaje;
						}
						break;
					case "coordinador":
						if(principal.checkCoordinador("investigacionbiologica")) {
							mensaje="No puede haber mas coordinadores en el departamento de Investigacion Biologica";
							return mensaje;
						}
						break;
					case "operario":
						if(principal.checkOperario("investigacionbiologica")) {
							mensaje="No puede haber mas operarios en el departamento de Investigacion Biologica";
							return mensaje;
						}
						break;
				}
				break;
			case "construccionymantenimiento":
				switch(cargo){
					case "director":
						if(principal.checkDirector("construccionymantenimiento")) {
							mensaje="No puede haber mas directores en el departamento de Construccion y Mantenimiento";
							return mensaje;
						}
						break;
					case "subdirector":
						if(principal.checkSubdirector("construccionymantenimiento")) {
							mensaje="No puede haber mas subdirectores en el departamento de Construccion y Mantenimiento";
							return mensaje;
						}
						break;
					case "responsable":
						if(principal.checkResponsable("construccionymantenimiento")) {
							mensaje="No puede haber mas responsables en el departamento de Construccion y Mantenimiento";
							return mensaje;
						}
						break;
					case "coordinador":
						if(principal.checkCoordinador("construccionymantenimiento")) {
							mensaje="No puede haber mas coordinadores en el departamento de Construccion y Mantenimiento";
							return mensaje;
						}
						break;
					case "operario":
						if(principal.checkOperario("construccionymantenimiento")) {
							mensaje="No puede haber mas operarios en el departamento de Construccion y Mantenimiento";
							return mensaje;
						}
						break;
				}
				break;
			case "sistemasinformaticos":
				switch(cargo){
					case "director":
						if(principal.checkDirector("sistemasinformaticos")) {
							mensaje="No puede haber mas directores en el departamento de Sistemas Informaticos";
							return mensaje;
						}
						break;
					case "subdirector":
						if(principal.checkSubdirector("sistemasinformaticos")) {
							mensaje="No puede haber mas subdirectores en el departamento de Sistemas Informaticos";
							return mensaje;
						}
						break;
					case "responsable":
						if(principal.checkResponsable("sistemasinformaticos")) {
							mensaje="No puede haber mas responsables en el departamento de Sistemas Informaticos";
							return mensaje;
						}
						break;
					case "coordinador":
						if(principal.checkCoordinador("sistemasinformaticos")) {
							mensaje="No puede haber mas coordinadores en el departamento de Sistemas Informaticos";
							return mensaje;
						}
						break;
					case "operario":
						if(principal.checkOperario("sistemasinformaticos")) {
							mensaje="No puede haber mas operarios en el departamento de Sistemas Informaticos";
							return mensaje;
						}
						break;
				}
				break;
			case "investigacionastronomica":
				switch(cargo){
					case "director":
						if(principal.checkDirector("investigacionastronomica")) {
							mensaje="No puede haber mas directores en el departamento de Investigacion Astronomica";
							return mensaje;
						}
						break;
					case "subdirector":
						if(principal.checkSubdirector("investigacionastronomica")) {
							mensaje="No puede haber mas subdirectores en el departamento de Investigacion Astronomica";
							return mensaje;
						}
						break;
					case "responsable":
						if(principal.checkResponsable("investigacionastronomica")) {
							mensaje="No puede haber mas responsables en el departamento de Investigacion Astronomica";
							return mensaje;
						}
						break;
					case "coordinador":
						if(principal.checkCoordinador("investigacionastronomica")) {
							mensaje="No puede haber mas coordinadores en el departamento de Investigacion Astronomica";
							return mensaje;
						}
						break;
					case "operario":
						if(principal.checkOperario("investigacionastronomica")) {
							mensaje="No puede haber mas operarios en el departamento de Investigacion Astronomica";
							return mensaje;
						}
						break;
				}
				break;
			case "cometologia":
				switch(cargo){
					case "director":
						if(principal.checkDirector("cometologia")) {
							mensaje="No puede haber mas directores en el departamento de Cometologia";
							return mensaje;
						}
						break;
					case "subdirector":
						if(principal.checkSubdirector("cometologia")) {
							mensaje="No puede haber mas subdirectores en el departamento de Cometologia";
							return mensaje;
						}
						break;
					case "responsable":
						if(principal.checkResponsable("cometologia")) {
							mensaje="No puede haber mas responsables en el departamento de Cometologia";
							return mensaje;
						}
						break;
					case "coordinador":
						if(principal.checkCoordinador("cometologia")) {
							mensaje="No puede haber mas coordinadores en el departamento de Cometologia";
							return mensaje;
						}
						break;
					case "operario":
						if(principal.checkOperario("cometologia")) {
							mensaje="No puede haber mas operarios en el departamento de Cometologia";
							return mensaje;
						}
						break;
				}
				break;
			case "navegacion":
				switch(cargo){
					case "director":
						if(principal.checkDirector("navegacion")) {
							mensaje="No puede haber mas directores en el departamento de Navegacion";
							return mensaje;
						}
						break;
					case "subdirector":
						if(principal.checkSubdirector("navegacion")) {
							mensaje="No puede haber mas subdirectores en el departamento de Navegacion";
							return mensaje;
						}
						break;
					case "responsable":
						if(principal.checkResponsable("navegacion")) {
							mensaje="No puede haber mas responsables en el departamento de Navegacion";
							return mensaje;
						}
						break;
					case "coordinador":
						if(principal.checkCoordinador("navegacion")) {
							mensaje="No puede haber mas coordinadores en el departamento de Navegacion";
							return mensaje;
						}
						break;
					case "operario":
						if(principal.checkOperario("navegacion")) {
							mensaje="No puede haber mas operarios en el departamento de Navegacion";
							return mensaje;
						}
						break;
				}
				break;
		}
		return "";
	}
}
