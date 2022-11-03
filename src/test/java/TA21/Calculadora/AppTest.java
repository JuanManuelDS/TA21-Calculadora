package TA21.Calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {

Calculos calculos = new Calculos();
	
	@Test
	private void testSuma() {
		double resultado = calculos.calcular(2,3, "+");
		double esperado = 5.0;
		assertEquals(resultado, esperado);
	}
	
	@Test
	private void testResta() {
		double resultado = calculos.calcular(2,3, "-");
		double esperado = -1.0;
		assertEquals(resultado, esperado);
	}
	
	@Test
	private void testMultiplicacion() {
		double resultado = calculos.calcular(2,3, "*");
		double esperado = 6.0;
		assertEquals(resultado, esperado);
	}
	
	@Test
	private void testDivision() {
		double resultado = calculos.calcular(7,2, "/");
		System.out.println(resultado);
		double esperado = 3.5;
		assertEquals(resultado, esperado);
	}

}
