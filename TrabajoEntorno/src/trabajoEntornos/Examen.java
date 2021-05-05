package trabajoEntornos;

public class Examen  extends Alumno{
	protected double nota;
	
	public Examen(Alumno a) {
		super(a.getNombre());
	}
	public Examen (Alumno a, double nota, int numExamen) {
		super(a.getNombre());
		this.nota=nota;
		switch(numExamen) {
		case 1:
			super.setNotaEx1(nota);
			break;
		case 2:
			super.setNotaEx2(nota);
			break;
		case 3:
			super.setNotaEx3(nota);
			break;
		case 4:
			super.setNotaEx4(nota);
			break;
		case 5:
			super.setNotaEx5(nota);
			break;
		}
		this.nota=nota;
	}
	public void setNota (double n) {
		nota=n;
	}
}
