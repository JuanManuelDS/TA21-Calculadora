package TA21.Calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

	Calculos calculos;
	Calculadora calculadora;
	@BeforeEach
	public void before() {
		calculos = new Calculos();
		calculadora = new Calculadora();
	}


	@Test
	public void testSuma() {
		double resultado = calculos.calcular(2, 3, "+");
		double esperado = 5.0;
		assertEquals(resultado, esperado);
	}

	@Test
	public void testResta() {
		double resultado = calculos.calcular(2, 3, "-");
		double esperado = -1.0;
		assertEquals(resultado, esperado);
	}

	@Test
	public void testMultiplicacion() {
		double resultado = calculos.calcular(2, 3, "*");
		double esperado = 6.0;
		assertEquals(resultado, esperado);
	}

	@Test
	public void testDivision() {
		double resultado = calculos.calcular(7, 2, "/");
		System.out.println(resultado);
		double esperado = 3.5;
		assertEquals(resultado, esperado);
	}
	
	@Test
	public void testResolver() {
		calculadora.setInput1("2.5");
		calculadora.setInput2("2.5");
		calculadora.setOperacion("+");
		calculadora.resolver();
		double resultado = calculadora.getResultado();
		double esperado = 5.0;
		assertEquals(resultado, esperado);
	}
	
	@Test
	public void testSetInput1() {
		//Si el input en 1 es true, lo que le pase a setInput debería quedar en inputTextfield1
		calculadora.setInput("Hola");
		String resultado = calculadora.getInputText1();
		String esperado = "Hola";
		assertEquals(resultado, esperado);
	}
	
	@Test
	public void testSetInput2() {
		//Si el input en 1 es false, lo que le pase a setInput debería quedar en inputTextfield2
		calculadora.setInput1Focus(false);
		calculadora.setInput("Hola");
		String resultado = calculadora.getInputText2();
		String esperado = "Hola";
		assertEquals(resultado, esperado);
	}

}
