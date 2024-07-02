package Javalearning;

public class guesstheoutput {

	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 10;
		int result = (num1++ * --num2) + (++num1 / num2--) - (num2++ + --num1);
		System.out.println("Result of complex expression: " + result);
		System.out.println("Final value of num1: " + num1);
		System.out.println("Final value of num2: " + num2);

	}
}
