package trabajoEntornos;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

/*
 * ESTA CLASE USA EL JAVA TIME PARA PONER FECHAS COMO TAL A LOS EXAMENES
 * PARA ENTENDER MEJOR MIRA: https://www.campusmvp.es/recursos/post/como-manejar-correctamente-fechas-en-java-el-paquete-java-time.aspx
 * 
 * GUIA BASICA Y RÁPIDA:
 * 
 * LA CLASE LocalDate SIRVE PARA INTRODUCIR UNA FECHA EN EL SIGUIENTE FORMATO "yyyy-m-d" Ej:2020-12-25
 * 
 * EN PRINCIPIO LAS FECHAS QUE INTRODUZCAMOS SERÁN STRINGS. PARA PASARLOS A UNA INSTANCIA DE TIPO LocalDate USAREMOS LocalDate.pharse("aquí iría el String")
 * Ej1: 
 * LocalDate fecha1 = LocalDate.parse("2020-01-16");
 * 
 * Ej2:
 * String fechaTexto = "2020-01-16";
 * LocalDate fecha2 = LocalDate.parse(fechaTexto);
 * 
 * PARA CONVERTIRLO AL FORMATO QUE USAMOS NOSOTROS (d/M/yyyy) SE USA EL DateTimeFormatter.ofPattern()
 * EJ3:
 * LocalDate fecha3 = LocalDate.parse("1/12/2020", DateTimeFormatter.ofPattern("d/M/yyyy"));
 * 
 * TAMBIEN SE PUEDE VER QUE HE CREADO UNA VARIABLE DE TIPO DateTimerFormatter. 
 * DE ESTA MANERA EN LA VARIABLE PODEMOS GUARDAR EL TIPO DE FORMATO QUE QUERAMOS SIN TENER QUE PONER "d/M/yyyy" A MANO TODO EL RATO. SE SUPONE
 * SIN EMBARGO SOLO HE CONSEGUIDO QUE FUNCIONE A LA HORA DE IMPRIMIR FECHAS EN EL FORMATO QUE LE INDIQUEMOS. Y SOLO LA VAMOS A USAR PARA ESO DE MOMENTO
 * DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
 * Ej4: System.out.print(fecha3.format(esDateFormat));
 * 
 * 
 * 
 */
/**
 * Clase para representar un trabajo
 * @author Marcelo y Rafa
 *
 */

public class Trabajo {
	public static Random r=new Random();
	/**
	 * Atributo espDateFormat 
	 * Este atributo de tipo DateTimeFormatter almacena el tipo de formato de fecha que usamos en España
	 * Este atributo sirve para indicar en que tipo de formato queremos que se muestren las fecha almacenadas en la clase
	 */
	DateTimeFormatter espDateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
	
	private int idTrabajo;
	/**
	 * Atributo diasRetrasoLimite
	 * Almacena el número de días máximo que un alumno puede atrasarse en entregar un trabajo
	 */
	private static final int DIAS_DE_RETRASO_LIMITE=5;
	/**
	 * Atributo fechaDeEntrega
	 * Indica la fecha en que el trabajo debe de estar entregado
	 */
	LocalDate fechaDeEntrega;
	/**
	 * Atributo fechaLimite
	 * Indica la fecha límite en que un trabajo puede ser entregado antes de que se considere como no entregado
	 */
	LocalDate fechaLimite;
	/**
	 * Atributo fechaQueSeEntrego
	 * Indica la fecha en que el alumno entregó el trabajo
	 */
	LocalDate fechaQueSeEntrego;
	/**
	 * Atributo diasRestraso
	 * Indica los días que se demoró el alumno en entregar la tarea
	 */
	int diasRetraso;
	boolean estadoEntrega=false;
	
	//CONSTRUCTORES
	/**
	 * Constructor para instanciar un trabajo sin ninguna fecha
	 * @param idTrabajo Recibe el id del trabajo
	 */
	public Trabajo (int idTrabajo) {
		this.idTrabajo=idTrabajo;
	}
	/**
	 * Constructor
	 * @param idTrabajo Recibe id del trabajo
	 * @param fechaDeEntrega Recibe la fecha que debe ser entregado el trabajo
	 */
	public Trabajo (int idTrabajo, String fechaDeEntrega) {
		this.idTrabajo=idTrabajo;
		this.fechaDeEntrega=LocalDate.parse(fechaDeEntrega, DateTimeFormatter.ofPattern("d/M/yyyy"));
		fechaLimite=this.fechaDeEntrega.plusDays(DIAS_DE_RETRASO_LIMITE); //.plusDays sirve para sumar días. Solo recibe valores tipo int
	}
	
	//GETTERS
	public int getIdTrabajo(){
		return idTrabajo;
	}

	public LocalDate getFechaDeEntrega() {
		return fechaDeEntrega;
	}

	public LocalDate getFechaLimite() {
		return fechaLimite;
	}

	public LocalDate getFechaQueSeEntrego() {
		return fechaQueSeEntrego;
	}

	public int getDiasRetraso() {
		return diasRetraso;
	}
	/**
	 * 
	 * @return Devuelve un valor de tipo string diciendo el estado del trabajo: "Entregado" o "No entregado"
	 */
	public String getEstadoEntrega() {
		if (estadoEntrega) {
			return "Entregado";
		}
		else return "No entregado";
	}
	/**
	 * 
	 * @return Devuelve un valor booleano indicando si el estado de entrega es "false" o "true"
	 */
	public boolean isEstadoEntrega() {
		return estadoEntrega;
	}

	//SETTERS
	/**
	 * 
	 * @param fechaDeEntrega Recibe un String de la fecha de entrega que luego se convertirá a LocalDate en el formato indicado ("d/M/yyyy")
	 */
	public void setFechaDeEntrega(String fechaDeEntrega) {
		this.fechaDeEntrega = LocalDate.parse(fechaDeEntrega, DateTimeFormatter.ofPattern("d/M/yyyy"));
	}
	
	/**
	 * 
	 * @param fechaQueSeEntrego Recibe un String de la fecha que se entregó en trabajo, que luego se convertirá a LocalDate
	 */
	public void setFechaQueSeEntrego(String fechaQueSeEntrego) {
		this.fechaQueSeEntrego = LocalDate.parse(fechaQueSeEntrego, DateTimeFormatter.ofPattern("d/M/yyyy"));
		setEstadoEntrega();
	}

	/**
	 * Setter que según los diás de diferencia entre la fecha de entrega y la fecha que se entregó el trabajo,
	 * indicará si el estado de entrega es false (indicando que no se entregó), o true (indicando que sí se entregó) 
	 */
	public void setEstadoEntrega() {
		
		int count = (int) ChronoUnit.DAYS.between(fechaDeEntrega,fechaQueSeEntrego);
		if (count>=0) {
			diasRetraso=count;
		}
		else diasRetraso=0;
		
		if (count>DIAS_DE_RETRASO_LIMITE) {
			estadoEntrega=false;
		}
		else estadoEntrega=true;
		}
	
	//METODOS Y PRINT
	/**
	 * Metodo para generar una fecha "aleatoriamente"
	 */
	public void generarFecha() {
		int temp=r.nextInt(3);
		switch (temp) {
		case 0:
			fechaQueSeEntrego=fechaDeEntrega;
			break;
		case 1:
			fechaQueSeEntrego=fechaDeEntrega.plusDays(DIAS_DE_RETRASO_LIMITE+2);
			break;
		case 2:
			fechaQueSeEntrego=fechaDeEntrega.plusDays(DIAS_DE_RETRASO_LIMITE-2);
			break;
		}
		setEstadoEntrega();
	}
	
	public String printFechaDeEntrega() {
		return fechaDeEntrega.format(espDateFormat);
	}
	public String printFechaQueSeEntrego() {
		return fechaQueSeEntrego.format(espDateFormat);
	}
	public String printFechaLimite() {
		return fechaLimite.format(espDateFormat);
	}

	@Override
	public String toString() {
		return "Trabajo Nº " + idTrabajo + ": Fecha a presentar= " + printFechaDeEntrega() + ", Fecha Límite= " + printFechaLimite()
				+ ", Fecha que se entregó=" + printFechaQueSeEntrego() + ", Dias de retraso=" + diasRetraso + ", Estado de entrega ="
				+ getEstadoEntrega();
	}
	
	
	
	

}
