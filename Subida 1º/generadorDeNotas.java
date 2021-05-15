package trabajoEntornos;

import java.util.Random;

//
//
//
//
//

public class generadorDeNotas{
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
			NotaDecimal = Double.parseDouble(SSNota);
			return NotaDecimal;
		}
		
	}
			
}
