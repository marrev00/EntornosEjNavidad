package trabajoEntornos;

import java.util.Random;

public class Examen {
	protected int idExamen;		//el id del examen servirá para diferenciar unos examenes con otros
	protected double nota=0;
	protected boolean presentado=false; //Esta variable servirá para indicar si la nota del examen ha sido puesta. Será llamada por
										//el metodo printExPresentados de la clase Alumno. Cambiar nombre de varibale si se ve optimo
	
	protected double NotaDecimal=0;
	
	public Examen(int idExamen) {
		this.idExamen=idExamen;
	}
	public Examen (int idExamen, double nota) {
		this.idExamen=idExamen;
		
		this.nota=nota;
		presentado=true;
		
	}
	public void setNota (double nota) {
			if (nota<=10&&nota>=0) { //Esta condición sirve para que no introduzcan valores negativos o mayor a 10
				presentado=true;
				this.nota=nota;
			}
			else	System.out.println("Introducir valor de 0 a 10");
	}
	
	public double getNota () {
		return nota;
	}
	public boolean getPresentado() {
		return presentado;
	}
	public int getIdExamen() {
		return idExamen;
	}
	
	public double generadorDeNotas() {
		Random ran=new Random();
		int NotaEntero=ran.nextInt(11);
		if (NotaEntero==10){
			return NotaEntero;
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
			this.NotaDecimal = Double.parseDouble(SSNota);
			return this.NotaDecimal;
		}
		
	}
	public int generadorTipoTest(){
		Random ran=new Random();
		int RespuestasCorrectas=ran.nextInt(31);
		int RespuestasFallidas=ran.nextInt(31-RespuestasCorrectas);
		if (RespuestasCorrectas==0) {
			return RespuestasCorrectas;
		}
		while(RespuestasFallidas>=3) {
			RespuestasCorrectas=RespuestasCorrectas-1;
			RespuestasFallidas=RespuestasFallidas-3;
		}
		return RespuestasCorrectas;
	}
	
	@Override
	public String toString() {
		return "Examen Nº "+idExamen+" Nota:"+NotaDecimal;
	}
	
	
}
