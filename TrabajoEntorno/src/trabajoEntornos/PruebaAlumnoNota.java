package trabajoEntornos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PruebaAlumnoNota {
	public static Random r=new Random();
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Empieza la prueba");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Acaba la prueba");
	}

	@BeforeEach
	void setUp() throws Exception {
		int numEntero=r.nextInt(11);
		double newNota;
		if (numEntero<10) {
			int numDecimal=r.nextInt(999);
			String tempN = numEntero+"."+numDecimal;
			newNota= Double.parseDouble(tempN);
		}
		else newNota=numEntero;
		System.out.println("Nota examen clásico: "+newNota);
		double n=newNota+2.1;
		System.out.println(n);
		
		//generador notas test
		int randomAciertos=r.nextInt(31);
		int randomFallos=0;
		if (randomAciertos<30) {
			int maxFallos=(30-randomAciertos)+1;
			randomFallos=r.nextInt(maxFallos);
		}
		System.out.println("Aciertos test: "+randomAciertos);
		System.out.println("Fallos test: "+randomFallos);
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
