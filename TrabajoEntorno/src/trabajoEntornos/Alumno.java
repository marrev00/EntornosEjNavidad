package trabajoEntornos;

import java.util.*;

public class Alumno {
	private String nombre;
	private double notafinal;
	private int examenesPresentados=0;
	
	protected ArrayList <Examen> examenes = new ArrayList ();
	protected ArrayList <Trabajo> trabajosCurso = new ArrayList();
	int [] idsExamenesPresentados = new int [5];
	
	
	int examenesHechos=0;
	
	//CONSTRUCTORES
	public Alumno(String nombre) {
		this.nombre=nombre;
		examenes.add(new ExamenClasico(1));
		examenes.add(new ExamenClasico(2));
		examenes.add(new ExamenClasico(3));
		examenes.add(new ExamenTest(4));
		examenes.add(new ExamenTest(5));
		trabajosCurso.add(new Trabajo(1));
		trabajosCurso.add(new Trabajo(2));
		trabajosCurso.add(new Trabajo(3));
	}
	
	//GETTERS
	public String getNombre() {
		return nombre;
	}
	public double getNotaEx1() {
		return examenes.get(0).getNota();
	}
	public double getNotaEx2() {
		return examenes.get(1).getNota();
	}
	public double getNotaEx3() {
		return examenes.get(2).getNota();
	}
	public double getNotaEx4() {
		return examenes.get(3).getNota();
	}
	public double getNotaEx5() {
		return examenes.get(4).getNota();
	}
	public int getExamenesPresentados() {
		return examenesPresentados;
	}
	public int getLengthExamenList() {
		return examenes.size();
	}
	
	
	
	public Examen getExamenAlumno (int id) {
		return examenes.get(id-1);
	}
	//SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setExamen (Examen a, int id) {
		examenes.set(id, a);
		examenesPresentados++;
	}
	
	//METODOS
	
	public void printExPresentados () {
		for (int j=0;j<examenes.size();j++) {
			if (getExamenAlumno(j+1).getPresentado()) {
				System.out.println(getExamenAlumno(j+1));
			}
		}
	}
	
	
	//IGNORAR EL SIGUIENTE CODIGO. LOS SIGUIENTES METODOS SON BORRADORES. BORRAR SI NO LLEGAN A SERVIR
	
	/*public int getIdExamenesPresnetados (int index) {
	return idsExamenesPresentados[index];
}*/
	
	/*public void printExPresentados () {
	char [] letras = new char [] {'a','b','c','d','e'};
	int count=0;
	checkExPresentados();
	for (int i=0;i<examenesPresentados;i++) {
			System.out.println(letras[i]+") Examen Nº "+idsExamenesPresentados[i]);
			count++;
	}
}*/
	
	/*public void checkExPresentados () {
		int index=0;
		for (int i=0;i<examenes.size();i++) {
			
			if (examenes.get(i).getPresentado()==true) {
				idsExamenesPresentados[index]=examenes.get(i).getIdExamen();
				index++;
			}
		}
		
		
	}*/
}
