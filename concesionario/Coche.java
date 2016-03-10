/**
 * 
 */
package concesionario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class Coche {
	private String matricula;
	private Color color;
	private Modelo modelo;
	private static final String VALIDARMATRICULA = "^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$";
	/**
	 * Constructor del coche 
	 * @param matricula matricula que comprobmamos si es valida
	 * @param color 
	 * @param modelo
	 * @throws Exception
	 */
	public Coche(String matricula, Color color, Modelo modelo)throws Exception{
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
		
	}
	public Coche(String matricula) throws MatriculaNoValidaException{
		setMatricula(matricula);
	}

	/**
	 * @param modelo2
	 * @throws ModeloInvalidoException 
	 */
	private void setModelo(Modelo modelo) throws ModeloInvalidoException {
		if(modelo ==null)
			throw new ModeloInvalidoException("El modelo no puede ser nulo");
		this.modelo=modelo;
		
	}

	/**
	 * @param color2
	 * @throws ColorInvalidoException 
	 */
	private void setColor(Color color) throws ColorInvalidoException {
		if(color == null)
			throw new ColorInvalidoException("El color no puede ser nulo");
		else
			this.color=color;
		
	}

	/**
	 * Comprueba que la matricula sea valida
	 * 
	 * @return true si es correcta
	 */
	private boolean matriculaValida(String string) {
		Pattern p = Pattern.compile(VALIDARMATRICULA);
		Matcher m = p.matcher(string);
		return m.matches();

	}
	/**
	 * Nos devuelve el color
	 * @return
	 */
	public Color getColor(){
		return color;
	}

	/**
	 * @param matricula
	 * @throws MatriculaNoValidaException 
	 */
	private void setMatricula(String matricula) throws MatriculaNoValidaException {
		if (matriculaValida(matricula))
			this.matricula = matricula;
		else
			throw new MatriculaNoValidaException("Formato de matricula erroneo");

	}
	@Override
	public String toString() {
		return "Matricula "+matricula + ", color=" + color + ", " + modelo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}
