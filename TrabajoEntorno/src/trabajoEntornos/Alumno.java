package trabajoEntornos;

import java.util.*;

/**
 * <h2>Clase Alumno</h2>
 * Esta clase servirá para instanciar los alumnos con sus nombres, los examenes y trabajos que han hecho, y sus notas finales
 * @author Marcelo y Rafa
 *
 */

public class Alumno {
	private String nombre;
	private double notaFinal;
	//private int examenesPresentados=0;
	
	/**
	 * Array "examenes": Aquí se introduciran los objetos de tipo ExamenClasico y ExamtenTest correspondientes al alumno
	 */
	protected ArrayList <Examen> examenes = new ArrayList ();
	/**
	 * Array "trabajosCurso": Aquí se introducirán los objetos de tipo "Trabajo" que correspondan al alumno
	 */
	protected ArrayList <Trabajo> trabajosCurso = new ArrayList();
	
	
	//CONSTRUCTORES
	
	/**
	 * Constructor: Solo pide introducir el nombre. Tras eso se instancia 5 examenes en el array "examenes" sin nota y con un id para
	 * diferenciarlos, y 3 trabajos en el array "trabajosCurso" con una fecha de entrega ya predefinida en el código y con un id para
	 * diferenciarlos.
	 * @param nombre Se introduce el nombre del Alumno.
	 */
	public Alumno(String nombre) {
		this.nombre=nombre;
		examenes.add(new ExamenClasico(1));
		examenes.add(new ExamenClasico(2));
		examenes.add(new ExamenClasico(3));
		examenes.add(new ExamenTest(4));
		examenes.add(new ExamenTest(5));
		trabajosCurso.add(new Trabajo(1, "24/12/2020"));
		trabajosCurso.add(new Trabajo(2, "6/1/2021"));
		trabajosCurso.add(new Trabajo(3, "7/6/2021"));
	}
	
	//GETTERS
	/**
	 * 
	 * @return Devuelve el nombre del alumno
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @return Devuelve un double con la nota del examen en la 1º posición del array "examenes"
	 */
	public double getNotaEx1() {
		return examenes.get(0).getNota();
	}
	/**
	 * 
	 * @return Devuelve un double con la nota del examen en la 2º posición del array "examenes"
	 */
	public double getNotaEx2() {
		return examenes.get(1).getNota();
	}
	/**
	 * 
	 * @return Devuelve un double con la nota del examen en la 3ª posición del array "examenes"
	 */
	public double getNotaEx3() {
		return examenes.get(2).getNota();
	}
	/**
	 * 
	 * @return Devuelve un double con la nota del examen en la 4ª posición del array "examenes"
	 */
	public double getNotaEx4() {
		return examenes.get(3).getNota();
	}
	/**
	 * 
	 * @return Devuelve un double con la nota del examen en la 5ª posición del array "examenes"
	 */
	public double getNotaEx5() {
		return examenes.get(4).getNota();
	}
	
	public int getLengthExamenList() {
		return examenes.size();
	}
	
	
	/**
	 * 
	 * @param id Se introduce una id para localizar en base a esa id, la posición del examen en el array "examenes"
	 * @return Devuelve un objeto del array de la clase Examen
	 */
	public Examen getExamenAlumno (int id) {
		return examenes.get(id-1);
	}
	
	public Trabajo getTrabajoAlumno (int id) {
		return trabajosCurso.get(id-1);
	}
	//SETTERS
	/**
	 * 
	 * @param nombre recibe un String con el nombre que queremos poner al alumnos
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//AÑADIR @deprecated y modificar un poco
	/**
	 * Metodo para añadir un examen al array "examenes"
	 * @param exam Recibe un objeto de tipo Examen
	 * @param id Recivbe una id
	 * @deprecated
	 */
	public void setExamen (Examen exam, int index) {
		examenes.set(index, exam);
	}
	
	/**
	 * 
	 * @param fecha Se introduce la fecha en la que el alumno entregó el examen
	 * @param id Se introduce el id del examen, en base a esa id se seleccionará la posición del array "TrabajosCurso" del cual se
	 * cogerá el trabajo al que se le desea introducir la fecha en que se entregó
	 * 
	 */
	public void setTrabajoEntrega (int id, String fecha) {
		trabajosCurso.get(id-1).setFechaQueSeEntrego(fecha);
	}
	
	//METODOS
	
	
	/**
	 * Este método mostrará en pantalla todos los exámenes del Alumno con sus notas y sus respectivas IDs
	 */
	public void printExPresentados () {
		for (int j=0;j<examenes.size();j++) {
			if (getExamenAlumno(j+1).getPresentado()) {
				System.out.println(getExamenAlumno(j+1));
			}
		}
	}
	/**
	 * Este método mostrará en pantalla todos los trabajos del alumno, con la fecha de entrega y la fecha en que fueron entregados
	 * o si no han sido entregados
	 */
	public void printTrPresentados () {
		for (int i=0;i<trabajosCurso.size();i++) {
			System.out.println(trabajosCurso.get(i));
		}
	}
	/**
	 * Este método sirve para calcular la nota final del alumno
	 */
	public void calcNotaFinal() {
		double notaCalc=0;
		boolean trabajosPresentados=true;
		for(int i=0;i<examenes.size();i++) {
			notaCalc+=examenes.get(i).getNota();
		}
		for (int i=0;i<trabajosCurso.size();i++) {
			if (trabajosCurso.get(i).isEstadoEntrega()==false) {
				trabajosPresentados=false;
			}
		}
		if (trabajosPresentados==true) {
			double restTrabajosDiasAtrasados=0;
			for (int i=0;i<trabajosCurso.size();i++) {
				restTrabajosDiasAtrasados+=trabajosCurso.get(i).getDiasRetraso()*0.1;
			}
			notaFinal=notaCalc/5-restTrabajosDiasAtrasados;
			notaFinal=Math.round(notaFinal*100)/100;
		}
		else notaFinal=3;
		
	}

	@Override
	public String toString() {
		return "Alumno: " + nombre;
	}
	public String alumnoYNotaFinal() {
		return "Alumno: "+nombre+", Nota final:"+notaFinal;
	}
	
	
	
}
