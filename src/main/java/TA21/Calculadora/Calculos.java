package TA21.Calculadora;

public class Calculos {
	
	public double calcular(double a, double b, String operacion) {
		double resultado = 0;
		switch (operacion) {
		case "+":
			resultado = sumar(a,b);
			break;
		case "-":
			resultado = restar(a,b);
			break;
		case "*":
			resultado = multiplicar(a,b);
			break;
		case "/":
			resultado = dividir(a,b);
			break;
		default:
			break;
		}
		
		return resultado;
	}
	
	private double sumar(double a, double b) {
		return a+b;
	}
	
	private double restar(double a, double b) {
		return a-b;
	}
	
	private double multiplicar(double a, double b) {
		return a*b;
	}
	
	private double dividir(double a, double b) {
		return a/b;
	}
	
}
