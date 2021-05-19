package trabajoEntornos;

import java.util.Random;

/**
 * Clase Examen. Esta clase almacenar� la nota y un id de un examen, a su vez si se encuentra presentado o no.
 * Necesariamente una clase abstracta dado que el m�todo generarNota ser� diferente seg�n sea ExamenTest o ExamenClasico (clases hijas)
 * @author Marcelo y Rafa
 *
 */
public abstract class Examen {
	public static Random r=new Random();
	/**
	 * Atributo idExamen
	 * 
	 * el id del examen servir� para diferenciar unos examenes con otros
	 */
	protected int idExamen;
	/**
	 * Atributo nota.
	 * Almacenar� la nota del examen
	 */
	protected double nota=0;
	/**
	 * Atributo presentado.
	 * Esta variable servir� para indicar si la nota del examen ha sido puesta.
	 * 
	 */
	protected boolean presentado=false;
	
	/**
	 * Constructor para instanciar examen sin nota y por lo tanto aun pendiente de ser considerado como entregado.
	 * @param idExamen recibir� el id de la nota.
	 */
	public Examen(int idExamen) {
		this.idExamen=idExamen;
	}
	/**
	 * Constructor para instanciar examen con nota y "presentado".
	 * @param idExamen recibir� el id de la nota.
	 * @param nota recibir� la nota del examen.
	 */
	public Examen (int idExamen, double nota) {
		this.idExamen=idExamen;
		
		this.nota=nota;
		presentado=true;
		
	}
	/**
	 * Setter para poner nota al examen. Automaticamente cambiar� el valor del atributo presentado a true
	 * @param nota Recibir� un valor double
	 */
	public void setNota (double nota) {
		if (nota<=10) { //Esta condici�n sirve para que no introduzcan valores negativos o mayor a 10
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
	 * @return Devolver� la nota.
	 */
	public double getNota () {
		return nota;
	}
	/**
	 * 
	 * @return Devolver� el valor de "presentado".
	 */
	public boolean getPresentado() {
		return presentado;
	}
	/**
	 * 
	 * @return Devolver� el id del examen.
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
		return "Examen N� "+idExamen+" Nota:"+nota;
	}
	
	
}
