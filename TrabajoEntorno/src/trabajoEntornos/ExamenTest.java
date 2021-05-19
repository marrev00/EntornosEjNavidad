package trabajoEntornos;

/**
 * Esta clase simular� ser un examen de tipo test.
 * @author Marcelo y Rafa
 *
 */
public class ExamenTest extends Examen {
	//public static Scanner tec=new Scanner (System.in); //BORRAR SI AL FINAL NINGUNO DE LOS METODOS LLEGA A USA EL SCANNER
	/**
	 * Atributo fallos.
	 * Servir� para almacenar el n�mero de preguntas fallidas del examen.
	 */
	protected int fallos=0;
	/**
	 * Atributo aciertos.
	 * Servir� para almacenar el n�mero de preguntas acertadas en el examen.
	 */
	protected int aciertos=0;
	/**
	 * Atributo preguntasTest.
	 * Almacena el n�mero de preguntas que tiene el examen. No se puede cambiar de valor
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
	 * @param idExamen Recibir� el id del examen.
	 * @param aciertos Recibir� las preguntas acertadas.
	 * @param fallos Recibir� las preguntas falladas.
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
	 * @param aciertos recibir� el n�mero de preguntas acertadas.
	 */
	public void setAciertos(int aciertos) {
		if (aciertos<=preguntasTest&&aciertos>=0) {
			this.aciertos=aciertos;
		}
		else System.out.println("Valor fuera del limite");
	}
	/**
	 * 
	 * @param fallos recibir� el n�mero de preguntas fallidas.
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
	 * @return Devolver� el n�mero de aciertos del examen
	 */
	public int getAciertos() {
		return aciertos;
	}
	/**
	 * 
	 * @return Devolver� el n�mero de preguntas fallidas
	 */
	public int getFallos() {
		return fallos;
	}
	/**
	 * 
	 * @return Devolver� el n�mero de preguntas en total que tienen los ex�menes de tipo test
	 */
	public static int getPreguntasTest() {
		return preguntasTest;
	}
	//METODOS
	
	/**
	 * Metodo para calcular la nota del examen en base a los aciertos y preguntas falladas en el examen.
	 * Este m�todo llama tambi�n al setter "setNota" para poner la nota calculada.
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
		return "Examen N� "+idExamen+", Nota: "+nota+", Fallos: "+ fallos + ", aciertos: " + aciertos;
	}
	
	
	

}
