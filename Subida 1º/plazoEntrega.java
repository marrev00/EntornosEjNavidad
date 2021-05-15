package trabajoEntornos;

public class plazoEntrega extends main {
	
	public void plazoEntrega(double notaGlobal, int retraso) {
		notaGlobal=notaGlobal-0.1*retraso; //Descuento de una decima por día de retraso.
		if (retraso==5) { //Tope máximo de días de entrega.
			System.out.println("El trabajo no a sido entregado."); //Indicación de la falta de la actividad.
		}
	}
}
