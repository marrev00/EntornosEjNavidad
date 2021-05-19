package trabajoEntornos;

import java.util.Random;

/**
 * Clase Examen. Esta clase almacenará la nota y un id de un examen, a su vez si se encuentra presentado o no.
 * Necesariamente una clase abstracta dado que el método generarNota será diferente según sea ExamenTest o ExamenClasico (clases hijas)
 * @author Marcelo y Rafa
 *
 */
public abstract class Examen {
	public static Random r=new Random();
	/**
	 * Atributo idExamen
	 * 
	 * el id del examen servirá para diferenciar unos examenes con otros
	 */
	protected int idExamen;
	/**
	 * Atributo nota.
	 * Almacenará la nota del examen
	 */
	protected double nota=0;
	/**
	 * Atributo presentado.
	 * Esta variable servirá para indicar si la nota del examen ha sido puesta.
	 * 
	 */
	protected boolean presentado=false;
	
	/**
	 * Constructor para instanciar examen sin nota y por lo tanto aun pendiente de ser considerado como entregado.
	 * @param idExamen recibirá el id de la nota.
	 */
	public Examen(int idExamen) {
		this.idExamen=idExamen;
	}
	/**
	 * Constructor para instanciar examen con nota y "presentado".
	 * @param idExamen recibirá el id de la nota.
	 * @param nota recibirá la nota del examen.
	 */
	public Examen (int idExamen, double nota) {
		this.idExamen=idExamen;
		
		this.nota=nota;
		presentado=true;
		
	}
	/**
	 * Setter para poner nota al examen. Automaticamente cambiará el valor del atributo presentado a true
	 * @param nota Recibirá un valor double
	 */
	public void setNota (double nota) {
		if (nota<=10) { //Esta condición sirve para que no introduzcan valores negativos o mayor a 10
			presentado=true;
			if (nota<0) {
				this.nota=0;
			}
			else this.nota=nota;
			
		}
		else	System.out.println("Introducir valor de 0 a 10");
	}
	
	/**
	 * 
	 * @return Devolverá la nota.
	 */
	public double getNota () {
		return nota;
	}
	/**
	 * 
	 * @return Devolverá el valor de "presentado".
	 */
	public boolean getPresentado() {
		return presentado;
	}
	/**
	 * 
	 * @return Devolverá el id del examen.
	 */
	public int getIdExamen() {
		return idExamen;
	}
	/**
	 * Metodo abstracto para generar aleatoriamente la nota del examen.
	 */
	public abstract void generarNota();
	@Override
	public String toString() {
		return "Examen Nº "+idExamen+" Nota:"+nota;
	}
	
	
}
