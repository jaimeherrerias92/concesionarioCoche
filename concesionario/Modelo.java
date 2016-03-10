/**
 * 
 */
package concesionario;


/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public enum Modelo {

	SERIE1(Marca.BMW), SERIE3(Marca.BMW), SERIE5(Marca.BMW), TOLEDO(Marca.SEAT), CORDOBA(Marca.SEAT), IBIZA(Marca.SEAT);
	private Marca marca;
	/**
	 * 
	 * @param marca
	 */
	private Modelo(Marca marca){
		this.marca=marca;
	}
	/**
	 * Nos devuelve la marca
	 * @return
	 */
	public Marca getMarca() {
		return marca;
	}
	/**
	 * Almacena los colores posibles
	 */
	private static final Modelo[] MODELO = Modelo.values();

	/**
	 * Genera el menu en un array para usarlo posteriormente
	 * Almacena los colores 
	 * @return
	 */
	public String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[MODELO.length];
		int i = 0;
		for (Modelo color : MODELO) {
			opcionesMenu[i++] = color.name();
		}
		return opcionesMenu;
	}
	
	/**
	 * 
	 */
	public String toString() {
		return "Marca "+getMarca()+ " , modelo "+ name() ;

	}
	public Modelo[] getModelo() {
		return MODELO;
	}
	
}