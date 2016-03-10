/**
 * 
 */
package concesionario;


/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public enum Color {
	ROJO, AZUL, PLATA;
	
	private static final Color[] COLOR = Color.values();
	
	/**
	 * 
	 * @return
	 */
	public String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length];
		int i = 0;
		for (Color color : getValues()) {
			opcionesMenu[i++] = color.name();
		}
		return opcionesMenu;
	}
	/**
	 * 
	 * @return
	 */
	public Color[] getValues() {
		return COLOR;
	}

}
