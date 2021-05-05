package trabajoEntornos;

public class ExamenTest extends Examen {
	protected double nota;
	protected int fallos;
	protected int aciertos;
	protected final double preguntasTest=30;
	public ExamenTest (Alumno a, int fallos, int aciertos, int numExamen) {
		super(a);
		double n;
		int resta=0;
		if (fallos>2&&fallos<=preguntasTest) {
		resta=fallos/3;
		}
		n=aciertos-resta;
		//super.setNota(n);
		this.aciertos=aciertos;
		this.fallos=fallos;
		nota=n;
		switch (numExamen) {
		case 4:
			a.setNotaEx4(n);
			break;
		case 5:
			a.setNotaEx5(n);
			break;
		}
		a.setNotaEx4(n);
		
		
		
	}
	
	public double calcularNota () {
		int resta=0;
		if (fallos>2&&fallos<=preguntasTest) {
		resta=fallos/3;
		}
		return (double)nota;
	}

}
