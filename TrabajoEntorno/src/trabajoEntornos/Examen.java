package trabajoEntornos;

public class Examen {
	protected int idExamen;		//el id del examen servirá para diferenciar unos examenes con otros
	protected double nota=0;
	protected boolean presentado=false; //Esta variable servirá para indicar si la nota del examen ha sido puesta. Será llamada por
										//el metodo printExPresentados de la clase Alumno. Cambiar nombre de varibale si se ve optimo
	
	public Examen(int idExamen) {
		this.idExamen=idExamen;
	}
	public Examen (int idExamen, double nota) {
		this.idExamen=idExamen;
		
		this.nota=nota;
		presentado=true;
		
	}
	public void setNota (double nota) {
		if (nota<11&&nota>-1) { //Esta condición sirve para que no introduzcan valores negativos o mayor a 10
			presentado=true;
			this.nota=nota;
		}
		else	System.out.println("Introducir valor de 0 a 10");
	}
	
	public double getNota () {
		return nota;
	}
	public boolean getPresentado() {
		return presentado;
	}
	public int getIdExamen() {
		return idExamen;
	}
	@Override
	public String toString() {
		return "Examen Nº "+idExamen+" Nota:"+nota;
	}
	
	
}
