/**
 * 
 */
package testConcesionario;

import concesionario.Color;
import concesionario.Concesionario;
import concesionario.MatriculaNoValidaException;
import concesionario.MatriculaYaExiste;
import concesionario.Modelo;
import utiles.Menu;
import utiles.Teclado;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class TestConcesionario {

	/**
	 * @param args
	 */
	private static Menu menu = new Menu(new String[]{"Alta coche","Baja coche","Mostrar coche", "Mostrar concesionario", "Contar coches del concesionario", "Mostrar coches de un color"}, "Bienvenido al concesionario");
	private static Menu menuColor = new Menu(Color.AZUL.generarOpcionesMenu(),"Colores disponibles");
	private static Menu menuModelo = new Menu(Modelo.CORDOBA.generarOpcionesMenu(),"Modelos disponibles");
	private static Concesionario concesionario = new Concesionario();
	
	public static void main(String[] args) {
		int opcion;
		do{
			switch (opcion=menu.gestionaMenu()) {
			case 1:
				altaCoche();
				break;
			case 2:
				bajaCoche();
				break;
			case 3:
				mostrarCoche();
				break;
			case 4:
				mostrarConcesionario();
				break;
			case 5:
				System.out.println("Los coches actuales en el concesionario son " + concesionario.numeroCochesConcesionario());
				break;
			case 6:
				mostrarPorColor();
				break;
			}
		
			
		}while(opcion!=7);

	}
	/**
	 * Muestra los coches por color
	 */
	private static void mostrarPorColor() {
		System.out.println(concesionario.mostrarPorColor(pedirColor()));
		
	}
	/**
	 * 
	 */
	private static void mostrarConcesionario() {
		System.out.println(concesionario);
		
	}
	/**
	 * Muestra un coche determinado
	 */
	private static void mostrarCoche() {
		try {
			System.out.println(concesionario.mostrarCoche(Teclado.leerCadena("")));
		} catch (MatriculaNoValidaException e) {
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * Da de baja un coche por matricula
	 */
	private static void bajaCoche() {
	
		try {
			concesionario.elminarCoche(Teclado.leerCadena("Dame la matricula que desea eliminar"));
		} catch (MatriculaNoValidaException | MatriculaYaExiste e) {
			System.out.println(e.getMessage());
		}
	
	
		
	}
	/**
	 * Menu de pedir color
	 * @return
	 */
	private static Color pedirColor() {
		int opcion = menuColor.gestionaMenu();
		Color[] color = Color.AZUL.getValues();
		if (opcion == color.length + 1)
			return null;
		return color[opcion - 1];
	}
	/**
	 * Menu de pedir modelo
	 * @return
	 */
	private static Modelo pedirModelo() {
		int opcion = menuModelo.gestionaMenu();
		Modelo[] modelos = Modelo.CORDOBA.getModelo();
		if (opcion == modelos.length + 1)
			return null;
		return modelos[opcion - 1];
	}
	/**
	 * Ingesa un coche en el concesionario
	 */
	private static void altaCoche() {
		try {
			concesionario.addCoche(Teclado.leerCadena("Dame la matricula"), pedirColor(), pedirModelo());
			System.out.println("Coche creado con exito");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
