package es.deusto.prog3.cap01.ejercicios;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFuncionParaTest {
	
	int a;
	int b;

	@Before
	public void setUp() throws Exception {
		a = 2;
		b = 3;
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFactorial() {
		assertEquals(1,FuncionParaTest.factorial(0));
		assertEquals(2,FuncionParaTest.factorial(a));
		assertEquals(6,FuncionParaTest.factorial(b));
	}

}
