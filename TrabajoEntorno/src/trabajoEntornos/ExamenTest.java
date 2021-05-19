package trabajoEntornos;

/**
 * Esta clase simulará ser un examen de tipo test.
 * @author Marcelo y Rafa
 *
 */
public class ExamenTest extends Examen {
	//public static Scanner tec=new Scanner (System.in); //BORRAR SI AL FINAL NINGUNO DE LOS METODOS LLEGA A USA EL SCANNER
	/**
	 * Atributo fallos.
	 * Servirá para almacenar el número de preguntas fallidas del examen.
	 */
	protected int fallos=0;
	/**
	 * Atributo aciertos.
	 * Servirá para almacenar el número de preguntas acertadas en el examen.
	 */
	protected int aciertos=0;
	/**
	 * Atributo preguntasTest.
	 * Almacena el número de preguntas que tiene el examen. No se puede cambiar de valor
	 */
	protected final static int preguntasTest=30;
	
	//CONSTRUCTORES
	/**
	 * Constructor para instanciar un examen de tipo test sin poner la nota, ni poner los aciertos o fallos.
	 * @param idExamen Recibe el id del examen.
	 */
	public ExamenTest (int idExamen) {
		super(idExamen);
	}
	/**
	 * Constructor para instanciar un examen de tipo test con sus aciertos y fallos.
	 * @param idExamen Recibirá el id del examen.
	 * @param aciertos Recibirá las preguntas acertadas.
	 * @param fallos Recibirá las preguntas falladas.
	 */
	public ExamenTest (int idExamen, int aciertos, int fallos) {
		super(idExamen);
		double n=0;
		this.fallos=fallos;
		this.aciertos=aciertos;
		calcularNota();
		presentado=true;
	}
	//SETTERS
	/**
	 * 
	 * @param aciertos recibirá el número de preguntas acertadas.
	 */
	public void setAciertos(int aciertos) {
		if (aciertos<=preguntasTest&&aciertos>=0) {
			this.aciertos=aciertos;
		}
		else System.out.println("Valor fuera del limite");
	}
	/**
	 * 
	 * @param fallos recibirá el número de preguntas fallidas.
	 */
	public void setFallos(int fallos) {
		if (fallos<=(preguntasTest-aciertos)&&fallos>=0) {
			this.fallos=fallos;
		}
		else System.out.println("Valor fuera del limite");
	}
	
	//GETTERS
	/**
	 * 
	 * @return Devolverá el número de aciertos del examen
	 */
	public int getAciertos() {
		return aciertos;
	}
	/**
	 * 
	 * @return Devolverá el número de preguntas fallidas
	 */
	public int getFallos() {
		return fallos;
	}
	/**
	 * 
	 * @return Devolverá el número de preguntas en total que tienen los exámenes de tipo test
	 */
	public static int getPreguntasTest() {
		return preguntasTest;
	}
	//METODOS
	
	/**
	 * Metodo para calcular la nota del examen en base a los aciertos y preguntas falladas en el examen.
	 * Este método llama también al setter "setNota" para poner la nota calculada.
	 */
	public void calcularNota() {  
		int resta=0;
		int newNota=0;
		if (fallos>=3) {
		resta=fallos/3;
		}
		newNota=((aciertos-resta)*10)/preguntasTest;
		setNota(newNota);
	}
	/**
	 * Metodo para generar aleatoriamente los aciertos y fallos del examen y en base a eso generar una nota
	 */
	public void generarNota() {
		int randomAciertos=r.nextInt(31);
		int randomFallos=0;
		if (randomAciertos<30) {
			int maxFallos=(preguntasTest-randomAciertos)+1;
			randomFallos=r.nextInt(maxFallos);
		}
		
		setAciertos(randomAciertos);
		setFallos(randomFallos);
		calcularNota();
	}
	@Override
	public String toString() {
		return "Examen Nº "+idExamen+", Nota: "+nota+", Fallos: "+ fallos + ", aciertos: " + aciertos;
	}
	
	
	

}
