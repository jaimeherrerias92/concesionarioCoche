/**
 * 
 */
package concesionario;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class Concesionario {
	ArrayList<Coche> concesionario = new ArrayList<Coche>();
	private final String nombre = "IES Gran Capitán";

	/**
	 * Añade un coche
	 * 
	 * @param matricula
	 * @param color
	 * @param modelo
	 * @throws Exception
	 */
	public void addCoche(String matricula, Color color, Modelo modelo) throws Exception {
		if (concesionario.contains(new Coche(matricula)))
			throw new MatriculaYaExiste("El coche ya esta registrado");
		else
			concesionario.add(new Coche(matricula, color, modelo));
	}

	/**
	 * Elimina un coche
	 * 
	 * @param matricula
	 * @return true si se ha eliminado correctamente
	 * @throws MatriculaNoValidaException
	 * @throws MatriculaYaExiste 
	 */
	public void elminarCoche(String matricula) throws MatriculaNoValidaException, MatriculaYaExiste {
		if (concesionario.contains(new Coche(matricula)))
			concesionario.remove(new Coche(matricula));
		else
			throw new MatriculaYaExiste("La matricula no existe en el concesionario");

	}
	/**
	 * Nos muestra un coche por matricula
	 * @param matricula
	 * @return el coche o bien si no existe
	 * @throws MatriculaNoValidaException controla que la matricula sea valida
	 */

	public String mostrarCoche(String matricula) throws MatriculaNoValidaException {
		if (concesionario.contains(new Coche(matricula)))
			return (concesionario.get(concesionario.indexOf(new Coche(matricula)))).toString();
		return "El coche no existe";

	}
	/**
	 * Nos muestra el coche por color dado por el usuario
	 * @param color
	 * @return
	 */
	public String mostrarPorColor(Color color){
		ArrayList<Coche> cochePorColor = new ArrayList<Coche>();
		for(Coche coche: concesionario)
			if(color==coche.getColor())
				cochePorColor.add(coche);
		if(cochePorColor.isEmpty())
			return "La lista esta vacia";
		return cochePorColor.toString();
	}
	/**
	 * Numero de coches alojados en el concesionario
	 * @return
	 */
	public int numeroCochesConcesionario(){
		return concesionario.size();
	}
	/**
	 * Nos muestra el concesionario
	 */
	@Override
	public String toString() {
		if(concesionario.isEmpty())
			return "El concesionario esta vacio";
		//return "Concesionario [concesionario=" + concesionario + ", nombre=" +  + "]";
		return nombre+"\n" + concesionario;
	}

}
