package trabajoEntornos;

import java.util.ArrayList;
import java.util.Scanner;

public class administrarAlumnosNotas {

	public static Scanner tec=new Scanner (System.in);
	public static void main(String[] args) {
		
		/**
		 * MAIN PRINCIPAL
		 * 
		 * Aquí se ejecuta la "interfaz" de usuario que se mostrará por consola
		 * 
		 */
		
		// TODO Auto-generated method stub
		//Alumnos
		
		ArrayList <Alumno> listaAlumnos = new ArrayList ();
		listaAlumnos.add(new Alumno ("Marcelo"));
		listaAlumnos.add(new Alumno ("Paco"));
		listaAlumnos.add(new Alumno ("Rafaél"));
		listaAlumnos.add(new Alumno ("Francisco"));
		listaAlumnos.add(new Alumno ("Isabel"));
		listaAlumnos.add(new Alumno ("Pedro"));
		listaAlumnos.add(new Alumno ("Pablo"));
		listaAlumnos.add(new Alumno ("José"));
		listaAlumnos.add(new Alumno ("Ana"));
		listaAlumnos.add(new Alumno ("Kevin"));
		int length = listaAlumnos.size();
		
		//Generación aleatoria de notas y fechas de entrega de trabajos para simular un caso en el que los datos ya está introducidos.
		for (int i=0;i<listaAlumnos.size();i++) {
			for (int j=0;j<5;j++) {
				listaAlumnos.get(i).getExamenAlumno(j+1).generarNota();
			}
			for (int j=0;j<3;j++) {
				listaAlumnos.get(i).getTrabajoAlumno(j+1).generarFecha();
			}
			
		}
		
		boolean runningOperation=true;
		
		
		System.out.println("Este programa te permitira administrar los examenes, trabajos y notas de los alumnos");
		
		do {
			System.out.println("Que operación desea hacer?");
			System.out.println("a)Administrar alumno   b)Mostrar alumnos c)Mostrar nota final de alumnos c)Salir"); //1er MENU
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
						boolean adminAlumno=true;
						while (adminAlumno) {
							System.out.println("¿Que desea hacer?");
							//2do MENU
							System.out.println("a)Añadir notas de examen b)Mostrar examenes y trabajos hechos  c)Añadir instancia de trabajo  d)Mostrar nota final e)Atrás ");
							
							String resp2=tec.nextLine().toLowerCase();
							switch (resp2) {
							case "a", "a)":	//a)Añadir notas de examen
								boolean seguirAñadiendo=true;
								while (seguirAñadiendo==true) { //3er Bucle
									System.out.println("Introduce id");
									int id=tec.nextInt();
									
									switch (id) {
									case 1,2,3: //Examenes Clásicos
										
										System.out.println("Introduce nota");
										double nota=tec.nextDouble();
										if (nota>=0||nota<=10) {
											listaAlumnos.get(i).getExamenAlumno(id).setNota(nota);
										}
										else System.out.println("Error: Introduce un valor de 0 a 10");
										break;
										
									case 4,5: //Examenes Test
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
										temp.calcularNota();
										
										break;
									default:
										System.out.println("Id de examen no existente");
									}
									
									tec.nextLine();
									//Código para preguntar al usuario si quiere seguir añadiendo notas
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
								
							case "b", "b)": //b)Mostrar examenes y trabajos hechos
								listaAlumnos.get(i).printExPresentados();
								listaAlumnos.get(i).printTrPresentados();
								listaAlumnos.get(i).calcNotaFinal();
								break;
								
							case "c", "c)": //c)Añadir instancia de trabajo
								System.out.println("selecciona id de trabajo");
								int idTr=tec.nextInt();
								tec.nextLine();
								System.out.println("¿Fecha en la que se entrego? (d/M/yyyy)");
								String fecha=tec.nextLine();
								listaAlumnos.get(i).setTrabajoEntrega(idTr, fecha);
								System.out.println("Trabajo añadido");
								
								break;
								
							case "d", "d)": //d)Mostrar nota final
								listaAlumnos.get(i).calcNotaFinal();
								System.out.println(listaAlumnos.get(i).alumnoYNotaFinal());
								break;
							
							case "e", "e)": //e)Atrás
								adminAlumno=false;
								break;
							default:
								System.out.println("Opción no válida");
								break;
							}
						}
						break;
					}
					else
						if (i==listaAlumnos.size()-1) {
						System.out.println("no se encuentra el alumno");
						}
				}
				break;
			
			case "b","b)": //Mostrar nombres de los alumnos
				for (int i=0;i<length;i++) {
					System.out.println(listaAlumnos.get(i));
				}
				break;
			case "c","c)":	//Mostrar alumnos con su nota final
				for (int i=0;i<length;i++) {
					listaAlumnos.get(i).calcNotaFinal();
					System.out.println(listaAlumnos.get(i).alumnoYNotaFinal());
				}
				break;
				
			case "d","d)": //Terminar el programa
				runningOperation=false;
				break;
				
			default:
				System.out.println("Opción no valida o no reconocida");
			}
			
		}while(runningOperation==true);
		
		
		

	}

}
