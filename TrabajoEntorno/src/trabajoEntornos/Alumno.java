package trabajoEntornos;

public class Alumno {
	private String nombre;
	private int preguntasTest=30;
	private double notaEx1;
	private double notaEx2;
	private double notaEx3;
	private double notaEx4;
	private double notaEx5;
	
	//CONSTRUCTORES
	public Alumno(String nombre, double ex1, double ex2, double ex3, int ex4, int ex5) {
		this.nombre=nombre;
		notaEx1=ex1;
		notaEx2=ex2;
		notaEx3=ex3;
		notaEx4=ex4;
		notaEx5=ex5;
	}
	public Alumno(String nombre) {
		this.nombre=nombre;
	}
	
	//GETTERS
	public String getNombre() {
		return nombre;
	}
	public double getNotaEx1() {
		return notaEx1;
	}
	public double getNotaEx2() {
		return notaEx2;
	}
	public double getNotaEx3() {
		return notaEx3;
	}
	public double getNotaEx4() {
		return notaEx4;
	}
	public double getNotaEx5() {
		return notaEx5;
	}
	
	//SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNotaEx1(double notaEx1) {
		this.notaEx1 = notaEx1;
	}
	public void setNotaEx2(double notaEx2) {
		this.notaEx2 = notaEx2;
	}
	
	public void setNotaEx3(double notaEx3) {
		this.notaEx3 = notaEx3;
	}
	public void setNotaEx4(int aciertos, int fallos) {
		int resta=0;
		int notaSinRestar=aciertos*preguntasTest/100;
		if (fallos>2&&fallos<=preguntasTest) {
		resta=fallos/3;
		}
		this.notaEx4 = notaSinRestar-resta;
		
	}
	
	public void setNotaEx4(double nota) {
		notaEx4=nota;
	}
	public void setNotaEx5(int aciertos, int fallos) {
		int resta=0;
		int notaSinRestar=aciertos*preguntasTest/100;
		if (fallos>2&&fallos<=preguntasTest) {
		resta=fallos/3;
		}
		this.notaEx5 = notaSinRestar-resta;
	}
	public void setNotaEx5(double nota) {
		notaEx4=nota;
	}
	
	
}
