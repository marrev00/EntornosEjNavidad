package trabajoEntornos;

public class plazoEntrega extends main {
	
	public void plazoEntrega(double notaGlobal, int retraso) {
		notaGlobal=notaGlobal-0.1*retraso; //Descuento de una decima por d�a de retraso.
		if (retraso==5) { //Tope m�ximo de d�as de entrega.
			System.out.println("El trabajo no a sido entregado."); //Indicaci�n de la falta de la actividad.
		}
	}
}
