package trabajoEntornos;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
 * MIRAR LA PAGINA RECOMENDADA ANTERIORMENTE Y MIRAR TAMBIÉN LOS COMENTARIOS MÁS ADELANTE Y LOS QUE PUEDA HABER EN UN FUTURO
 * 
 * 
 */

public class Trabajo {
	DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
	private int idTrabajo;
	private final int diasRetrasoLimite=5;
	LocalDate fechaDeEntrega;
	LocalDate fechaLimite;
	LocalDate fechaQueSeEntrego;
	int diasRetraso;
	boolean estadoEntrega=false;
	
	//CONSTRUCTORES
	public Trabajo (int idTrabajo) {
		this.idTrabajo=idTrabajo;
	}
	
	public Trabajo (int idTrabajo, String fechaDeEntrega) {
		this.idTrabajo=idTrabajo;
		this.fechaDeEntrega=LocalDate.parse(fechaDeEntrega, DateTimeFormatter.ofPattern("d/M/yyyy"));
		fechaLimite=this.fechaDeEntrega.plusDays(diasRetrasoLimite); //.plusDays sirve para sumar días. Solo recibe valores tipo int
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

	public boolean isEstadoEntrega() {
		return estadoEntrega;
	}

	//SETTERS
	public void setFechaDeEntrega(String fechaDeEntrega) {
		this.fechaDeEntrega = LocalDate.parse(fechaDeEntrega, DateTimeFormatter.ofPattern("d/M/yyyy"));
	}

	public void setFechaQueSeEntrego(String fechaQueSeEntrego ) {
		this.fechaQueSeEntrego = LocalDate.parse(fechaQueSeEntrego,DateTimeFormatter.ofPattern("d/M/yyyy"));
		//se cuentan los días de diferencia entre la fecha de entrega y la fecha que se entregó
		int count = (int) ChronoUnit.DAYS.between(fechaDeEntrega,this.fechaQueSeEntrego); //ChronoUnit.DAYS.between COMPARA DOS FECHAS Y DEVUELVE EN ESTE
																						  //CASO LOS DIÁS QUE HAY ENTRE ESAS DOS FECHAS. SIN EMBARGO
																						  //DEVUELVE UN VALOR TIPO DOUBLE, POR ESO SE HAY QUE CONVERTIRLO EN INT
		if (count>5) {
			estadoEntrega=false;
		}
		if (count>diasRetrasoLimite) {
			estadoEntrega=false;
		}
		else estadoEntrega=true;
	}

	/*public void setDiasRetraso(int diasRetraso) {		//BORRAR ESTE SETER SI AL FINAL NO SE VA USAR
		this.diasRetraso = diasRetraso;
	}*/

	public void setEstadoEntrega(boolean estadoEntrega) {
		this.estadoEntrega = estadoEntrega;
	}
	
	//METODOS PRINT
	public String printFechaDeEntrega() {
		return fechaDeEntrega.format(esDateFormat);
	}
	public String printFechaQueSeEntrego() {
		return fechaQueSeEntrego.format(esDateFormat);
	}
	public String printFechaLimite() {
		return fechaLimite.format(esDateFormat);
	}
	
	
	

}
