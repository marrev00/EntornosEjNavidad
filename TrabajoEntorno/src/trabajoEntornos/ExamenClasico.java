package trabajoEntornos;

public class ExamenClasico extends Examen{
	protected double nota;
	
	public ExamenClasico (Alumno a, double nota, int numExamen) {
		super(a, nota, numExamen);
		switch (numExamen) {
		case 1:
			a.setNotaEx1(nota);
			break;
		case 2:
			a.setNotaEx2(nota);
			break;
		case 3:
			a.setNotaEx3(nota);
		}
	}
	public void setNota (double n) {
		nota=n;
	}

}
