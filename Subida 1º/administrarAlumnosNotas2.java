package trabajoEntornos;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class administrarAlumnosNotas2 {

	//Importaciones
	
	public static Scanner tec=new Scanner (System.in);
	public static Random ran=new Random();
	
	//Metodo de ejecuci�n MAIN.
	public static void main (String []args) {
		
		/**
		 * MAIN PRINCIPAL. NO EST� ACABADO. NO HACER PRUEBAS AQU�
		 * AUN QUEDA A�ADIR CODIGO EN ESTE FICHERO Y TAL VEZ MODIFICAR EL QUE YA EST�
		 * 
		 * DE TODAS MANERAS SE RECOMIENDA ECHARLE UN VISTAZO
		 * 
		 */
		
		// Creaci�n de alumnos
		Alumno Marcelo = new Alumno ("Marcelo");;
		Alumno Perico = new Alumno ("Perico");
		Alumno Rihmanna = new Alumno ("Rihmanna");
		Alumno Rafael = new Alumno ("Rafael");;
		Alumno Francisco = new Alumno ("Francisco");
		Alumno Isabel = new Alumno ("Isabel");
		Alumno Pedro = new Alumno ("Pedro");
		Alumno Pablo = new Alumno ("Pablo");;
		Alumno Jose = new Alumno ("Jos�");
		Alumno Ana = new Alumno ("Ana");
		
		//A�adir alumnos  a la arraylist.
		ArrayList <Alumno> listaAlumnos = new ArrayList ();
		listaAlumnos.add(Marcelo);
		listaAlumnos.add(Perico);
		listaAlumnos.add(Rihmanna);
		listaAlumnos.add(Rafael);
		listaAlumnos.add(Francisco);
		listaAlumnos.add(Isabel);
		listaAlumnos.add(Pedro);
		listaAlumnos.add(Pablo);
		listaAlumnos.add(Jose);
		listaAlumnos.add(Ana);
		
		/* 
		//Zona de los n�meros aleatorios.
		int NotaEntero=ran.nextInt(11);
		if (NotaEntero==10){
			//Enviar n�mero.
		}
		else {
			double NotaDecimal=ran.nextDouble();//Hablar con Marcelo como describir estas secciones.
			
			//Zona a donde se conbierten los tipos de datos a String.
			String SNotaEntero = String.valueOf(NotaEntero);
			String SNumeroDecimal = String.valueOf(NotaDecimal);
			//Zona a donde se substrae el los dos decimales.
			SNumeroDecimal=SNumeroDecimal.substring(1,4);
			//Zona a donde se suman los tipos de datos a String.
			String SSNota= SNotaEntero+SNumeroDecimal;
			//Zona donde se convierte el typo de dato a Double.
			NotaDecimal = Double.parseDouble(SSNota);
		}
		*/
		//A�adir notas de los examenes cl�sicos.
		int length = listaAlumnos.size();
		int NumeroExamen=1;
		while(true) {
			int i=0;
			listaAlumnos.get(i).getExamenAlumno(NumeroExamen).generadorDeNotas();
			NumeroExamen++;
			if (NumeroExamen==3) {
				NumeroExamen=1;
				i++;
			}
			if (i>10) {
				break;
			}
		}
		
		//A�adir las respuestas de examenes de tipo test.
		int RespuestasCorrectas=0;
		int RespuestasFallidas=0;
		NumeroExamen=4;
		while(true) {
			int i=0;
			
			/*
			RespuestasCorrectas=ran.nextInt(31);
			RespuestasFallidas=ran.nextInt(31-RespuestasCorrectas);
			while(RespuestasFallidas>=3) {
				RespuestasCorrectas=RespuestasCorrectas-1;
				RespuestasFallidas=RespuestasFallidas-3;	
			}
			*/
			
			listaAlumnos.get(i).getExamenAlumno(NumeroExamen).generadorTipoTest();
			NumeroExamen++;
			if (NumeroExamen>5) {
				NumeroExamen=4;
				i++;
			}
			
			if(i>10){
				break;
			}
		
		}
		
		
		boolean runningOperation=true;
		
		
		System.out.println("Este programa te permitira administrar los examenes, trabajos y notas de los alumnos");
		
		do {
			System.out.println("Que operaci�n desea hacer?");
			System.out.println("a)Administrar alumno   b)Salir"); //1er MENU
			String resp1 = tec.nextLine().toLowerCase();
			
			switch (resp1) {
			case "a","a)", "A", "A)": // ----------------------------------> CAMBIO A CONTAR A MARCELO
				System.out.println("Introduce el nombre del alumno");
				String nombre=tec.nextLine();
				//La funci�n principal del siguiente bucle sirve para comparar el contenido de la variable "nombre" con la lista de alumnos
				//Mientras el bucle est� en funcionamieto se podra: A�adir notas, modificar notas y administrar la entrega de trabajos.
				//El bucle terminar� cuando se seleccione la opci�n "atr�s" o no se encuentre el alumno introducido por teclado
				for (int i=0;i<length;i++) { //2do Bucle
					if (listaAlumnos.get(i).getNombre().equalsIgnoreCase(nombre)) {
						System.out.println("�Que desea hacer?");
						//2do MENU
						System.out.println("a)A�adir notas de examen b)Mostrar examenes y trabajos hechos  c)Administrar entrega de trabajos  d)Atr�s ");
						
						String resp2=tec.nextLine().toLowerCase();;
						switch (resp2) {
						case "a","a)":
							boolean seguirA�adiendo=true;
							while (seguirA�adiendo==true&&listaAlumnos.get(i).getExamenesPresentados()<5) { //3er Bucle
								System.out.println("Introduce id");
								int id=tec.nextInt();
								
								switch (id) {
								/* case 1,2,3:
									
									System.out.println("Introduce nota");
									double nota=tec.nextDouble();
									if (nota>=0||nota<=10) {
										listaAlumnos.get(i).getExamenAlumno(id).setNota(nota);
									}
									else System.out.println("Error: Introduce un valor de 0 a 10");
									break;
								*/
								case 4,5:
									System.out.println("Introduce N� de preguntas acertadas");
									int aciertos=tec.nextInt();
									int fallos=0;
									if (aciertos!=30) {
										System.out.println("Introduce N� de fallos");
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
									System.out.println("�Seguir a�adiendo notas? y/n");
									String resp3=tec.nextLine().toLowerCase();
									switch (resp3) {
									case "y","yes":
										esperaResp=false;
										break;
									case "n","no":
										esperaResp=false;
										seguirA�adiendo=false;
										break;
									default:
										System.out.println("Respuesta no reconocida");
									}	
								}
							}
							
							break;
						case "b","b)":
							listaAlumnos.get(i).printExPresentados();
							
							break;
						case "c","c)":
							//aqu� ir�a el codigo para gestionar la entrega de trabajos
							//...
							break;
						case "d","d)":
						
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
				System.out.println("Opci�n no valida o no reconocida");
			}
			
			
			
		}while(runningOperation==true);
		
		
		System.out.println(Marcelo.getNotaEx1());
		System.out.println(Marcelo.examenes.size());
		
		
		
		System.out.println(Marcelo.getNotaEx2());
		System.out.println(Marcelo.examenes.size());
		
		System.out.println(Marcelo.getNotaEx3());
		

	}

}
