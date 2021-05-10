package trabajoEntornos;

import java.util.*;

public class ExamenTest extends Examen {
	//public static Scanner tec=new Scanner (System.in); //BORRAR SI AL FINAL NINGUNO DE LOS METODOS LLEGA A USA EL SCANNER
	protected int fallos=0;
	protected int aciertos=0;
	protected final static int preguntasTest=30;
	
	//CONSTRUCTORES
	public ExamenTest (int idExamen) {
		super(idExamen);
	}
	public ExamenTest (int idExamen, int aciertos, int fallos) {
		super(idExamen);
		double n=0;
		this.fallos=fallos;
		this.aciertos=aciertos;
		nota=calcularNota();
		presentado=true;
	}
	
	//SETTERS
	public void setAciertos(int aciertos) {
		if (aciertos<=preguntasTest&&aciertos>=0) {
			this.aciertos=aciertos;
		}
		else System.out.println("Valor fuera del limite");
	}
	
	public void setFallos(int fallos) {
		if (fallos<=(preguntasTest-aciertos)&&fallos>-1) {
			this.fallos=fallos;
		}
		else System.out.println("Valor fuera del limite");
	}
	
	//GETTERS
	public int getAciertos() {
		return aciertos;
	}
	public int getFallos() {
		return fallos;
	}
	public static int getPreguntasTest() {
		return preguntasTest;
	}
	//METODOS
	
	
	public double calcularNota() { //DEVOLVERÁ UN DOUBLE CON LA NOTA CALCULADA EN BASE A LOS ACIERTOS Y FALLOS. 
								   //TAL VEZ SEA BUENA IDEA HACER QUE PONGA LA NOTA Y YA, EN VEZ DE DEVOLVER LA NOTA SIN HABERLA PUESTO ANTES
		int resta=0;
		int newNota=0;
		if (fallos%3==0) {
		resta=fallos/3;
		}
		newNota=((aciertos-resta)*10)/preguntasTest;
		return newNota;
	}
	
	
	//IGNORAR ESTOS METODOS. BORRAR SI NO SE PUEDE REUSAR EL CODIGO O YA NO SON USADOS AL FINAL
	
	/*public void calcularNota(int aciertos, int fallos) {
	double newNota=nota;
	if (aciertos<=preguntasTest&&aciertos>-1) {
		this.aciertos=aciertos;
		if (fallos<=(preguntasTest-aciertos)) {
			int resta=0;
			if (fallos>2&&fallos<=preguntasTest) {
			resta=fallos/3;
			}
			nota=aciertos-resta;
		}
		
	}
	
}*/
	
	
	/*public void setNota (){
		System.out.println("Introduce Nº de preguntas acertadas");
		int aciertos=tec.nextInt();
		int fallos=0;
		if (aciertos>30||aciertos<0) {
			System.out.println("Error: los aciertos no pueden ser mayor a las preguntas");
		}
		else {
			
			if (aciertos<30&&aciertos>0) {
				System.out.println("Introduce Nº de preguntas fallidas");
				fallos=tec.nextInt();
				if (fallos>=(ExamenTest.getPreguntasTest()-aciertos)) {
					this.aciertos=aciertos;
					this.fallos=fallos;
				}
				else System.out.println("Error: los fallos deben de ser menor a los aciertos");
			}
			else {
				this.aciertos=aciertos;
			}
				
			
			
			int resta=0;
			if (fallos>2&&fallos<=preguntasTest) {
			resta=fallos/3;
			}
			nota=aciertos-resta;
		}
	}*/
	
	

}
