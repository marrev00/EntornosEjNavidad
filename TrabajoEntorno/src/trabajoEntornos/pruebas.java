package trabajoEntornos;

public class pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno Marcelo = new Alumno ("Marcelo");
		ExamenClasico ex1Marcelo = new ExamenClasico (Marcelo, 10.00, 2);
		ExamenTest ex4Marcelo = new ExamenTest (Marcelo, 3, 27, 4);
		
		System.out.println(Marcelo.getNotaEx2());
		System.out.println(Marcelo.getNotaEx4());
	}

}
