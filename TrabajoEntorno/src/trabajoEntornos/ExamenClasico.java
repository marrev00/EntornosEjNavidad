package trabajoEntornos;

/**
 * Clase ExamenClasico. Esta clase simulará ser un examen clásico que solo recibe una nota de 0 a 10. Clase hija de Examen.
 * @author Marcelo y Rafa
 *
 */
public class ExamenClasico extends Examen{	//Pensando en borrar esta clase ya que hace lo mismo que la clase padre
	
	/**
	 * Constructor para instanciar un objeto de tipo ExamenClasico sin la nota.
	 * @param id Recibe el id del examen.
	 */
	public ExamenClasico (int id) {
		super(id);
	}
	/**
	 * Constructor para instanciar un objeto de tipo ExamenClasico con su respectiva nota.
	 * @param id Recibe en id del examen.
	 * @param nota
	 */
	public ExamenClasico (int id, double nota) {
		super(id, nota);
	}
	/**
	 * Metodo para generar la nota de ExamenClasico aleatoriamente.
	 * 
	 */
	public void generarNota() {
		int numEntero=r.nextInt(11);
		double newNota;
		if (numEntero<10) {
			int numDecimal=r.nextInt(999);
			String tempN = numEntero+"."+numDecimal;
			newNota= Double.parseDouble(tempN);
		}
		else newNota=numEntero;
		setNota(newNota);
		
	}

}
