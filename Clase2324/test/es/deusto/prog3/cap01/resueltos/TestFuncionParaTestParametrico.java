package es.deusto.prog3.cap01.resueltos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestFuncionParaTestParametrico {

	  // Esta anotación prepara un método que devuelve todos los valores a recorrer
    // Tiene que estar en forma de una lista de arrays de Object
	@Parameters
	public static List<Object[]> data() {
		
		int[] y = {
				1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600
		};
		List<Object[]> list = new ArrayList<Object[]>();
		for (int x = 0; x <=12; x++) {
			list.add(new Object[] {x,y[x]});
		}
		return list;
	}
	
	
	@Parameter(0)
	public long inicial;
	
	@Parameter(1)
	public long esperado;

	@Test
	public void testFactorialCorrecto() {
//		assertEquals("Valor incorrecto de factorial",esperado, FuncionParaTest.factorial(inicial));
		assertEquals(esperado, (long)FuncionParaTest.factorial((int) inicial));
	}
		/*
1! = 1
2! = 2
3! = 6
4! = 24
5! = 120
6! = 720
7! = 5040
8! = 40320
9! = 362880
10! = 3628800
11! = 39916800
12! = 479001600
13! = 6227020800
14! = 87178291200
15! = 1307674368000
16! = 20922789888000
17! = 355687428096000
18! = 6402373705728000
19! = 121645100408832000
20! = 2432902008176640000
		 */
	

}
