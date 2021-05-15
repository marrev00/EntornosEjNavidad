package trabajoEntornos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Marcelo Marcos
 *
 *ESTE MAIN ES UN CAMPO DE PRUEBAS. IGNORAR COMPLETAMENTE Y BORRAR CUANDO SE TERMINE EL TRABAJO
 *
 */

public class pruebas {
	
	public static Scanner tec=new Scanner (System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno Marcelo = new Alumno ("Marcelo");;
		Alumno Perico = new Alumno ("Perico");
		Alumno Pepa = new Alumno ("Pepa");
		
		ArrayList <Alumno> listaAlumnos = new ArrayList (3);
		listaAlumnos.add(Marcelo);
		listaAlumnos.add(Perico);
		listaAlumnos.add(Pepa);
		listaAlumnos.add(new Alumno("Pepe"));
		
		
		
		
		
		
		System.out.println(Marcelo.getNotaEx1());
		System.out.println(Marcelo.examenes.size());
		
		
		
		System.out.println(Marcelo.getNotaEx2());
		System.out.println(Marcelo.examenes.size());
		System.out.println(Marcelo.getNotaEx3());
		
	}

}
