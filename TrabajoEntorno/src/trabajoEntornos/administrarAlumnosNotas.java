package trabajoEntornos;

import java.util.ArrayList;
import java.util.Scanner;

public class administrarAlumnosNotas {

	public static Scanner tec=new Scanner (System.in);
	public static void main(String[] args) {
		
		/**
		 * MAIN PRINCIPAL. NO ESTÁ ACABADO. NO HACER PRUEBAS AQUÍ
		 * AUN QUEDA AÑADIR CODIGO EN ESTE FICHERO Y TAL VEZ MODIFICAR EL QUE YA ESTÁ
		 * 
		 * DE TODAS MANERAS SE RECOMIENDA ECHARLE UN VISTAZO
		 * 
		 */
		
		// TODO Auto-generated method stub
		Alumno Marcelo = new Alumno ("Marcelo");;
		Alumno Perico = new Alumno ("Perico");
		Alumno Rihmanna = new Alumno ("Rihmanna");
		
		ArrayList <Alumno> listaAlumnos = new ArrayList ();
		listaAlumnos.add(Marcelo);
		listaAlumnos.add(Perico);
		listaAlumnos.add(Rihmanna);
		
		boolean runningOperation=true;
		int length = listaAlumnos.size();
		
		System.out.println("Este programa te permitira administrar los examenes, trabajos y notas de los alumnos");
		
		do {
			System.out.println("Que operación desea hacer?");
			System.out.println("a)Administrar alumno   b)Salir"); //1er MENU
			String resp1 = tec.nextLine().toLowerCase();
			
			switch (resp1) {
			case "a","a)":
				System.out.println("Introduce el nombre del alumno");
				String nombre=tec.nextLine();
				//La función principal del siguiente bucle sirve para comparar el contenido de la variable "nombre" con la lista de alumnos
				//Mientras el bucle esté en funcionamieto se podra: Añadir notas, modificar notas y administrar la entrega de trabajos.
				//El bucle terminará cuando se seleccione la opción "atras" o no se encuentre el alumno introduciodo por teclado
				for (int i=0;i<length;i++) { //2do Bucle
					if (listaAlumnos.get(i).getNombre().equalsIgnoreCase(nombre)) {
						System.out.println("¿Que desea hacer?");
						//2do MENU
						System.out.println("a)Añadir notas de examen b)Mostrar examenes y trabajos hechos  c)Administrar enetrega de trabajos  d)atras ");
						
						String resp2=tec.nextLine();
						switch (resp2) {
						case "a":
							boolean seguirAñadiendo=true;
							while (seguirAñadiendo==true&&listaAlumnos.get(i).getExamenesPresentados()<5) { //3er Bucle
								System.out.println("Introduce id");
								int id=tec.nextInt();
								
								switch (id) {
								case 1,2,3:
									
									System.out.println("Introduce nota");
									double nota=tec.nextDouble();
									if (nota>-1||nota<11) {
										listaAlumnos.get(i).getExamenAlumno(id).setNota(nota);
									}
									else System.out.println("Error: Introduce un valor de 0 a 10");
									break;
									
								case 4,5:
									System.out.println("Introduce Nº de preguntas acertadas");
									int aciertos=tec.nextInt();
									int fallos=0;
									if (aciertos!=30) {
										System.out.println("Introduce Nº de fallos");
										fallos=tec.nextInt();
									}
									
									ExamenTest temp=(ExamenTest)listaAlumnos.get(i).getExamenAlumno(id);
									temp.setAciertos(aciertos);
									temp.setFallos(fallos);
									temp.setNota(temp.calcularNota());
									
									break;
								default:
									System.out.println("Id de examen no existente");
								}
								
								
								tec.nextLine();
								
								boolean esperaResp=true;
								while(esperaResp==true) {
									System.out.println("¿Seguir añadiendo notas? y/n");
									String resp3=tec.nextLine().toLowerCase();
									switch (resp3) {
									case "y","yes":
										esperaResp=false;
										break;
									case "n","no":
										esperaResp=false;
										seguirAñadiendo=false;
										break;
									default:
										System.out.println("Respuesta no reconocida");
									}	
								}
							}
							
							break;
						case "b":
							listaAlumnos.get(i).printExPresentados();
							
							break;
						case "c":
							//aquí iría el codigo para gestionar la entrega de trabajos
							//...
							break;
						case "d":
						
							break;
						}
						
						
						break;
					}
					else
						if (i==listaAlumnos.size()-1) {
						System.out.println("no se encuentra el alumno");
						}
				}
			
				break;
			
			case "b","b)":
				runningOperation=false;
				break;
			default:
				System.out.println("Opción no valida o no reconocida");
			}
			
			
			
		}while(runningOperation==true);
		
		
		System.out.println(Marcelo.getNotaEx1());
		System.out.println(Marcelo.examenes.size());
		
		
		
		System.out.println(Marcelo.getNotaEx2());
		System.out.println(Marcelo.examenes.size());
		System.out.println(Marcelo.getNotaEx3());
		

	}

}
