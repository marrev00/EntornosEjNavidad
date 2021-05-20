package trabajoEntornos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void test() {
		
		
		
			double notaFinal=0;
			boolean trabajosEntregados=true;
			int diasRetrasoTotal=10;
			ArrayList <Double> examenes = new ArrayList ();
			examenes.add(5.0);
			examenes.add(5.0);
			examenes.add(4.0);
			examenes.add(6.0);
			examenes.add(5.0);
			double notaCalc=0;
			boolean trabajosPresentados=true;
			for(int i=0;i<examenes.size();i++) {
				notaCalc+=examenes.get(i);
			}
			
			if (trabajosPresentados==true) {
				double restTrabajosDiasAtrasados=diasRetrasoTotal*0.1;
				
				notaFinal=notaCalc/5-restTrabajosDiasAtrasados;
				notaFinal=Math.round(notaFinal*100)/100;
			}
			else notaFinal=3;
			System.out.println(notaFinal);
			
		
		
		assertEquals(4.0, notaFinal);
		
	}

}
