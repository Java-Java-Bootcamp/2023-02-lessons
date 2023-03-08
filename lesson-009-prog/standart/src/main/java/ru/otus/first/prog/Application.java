package ru.otus.first.prog;

import java.util.Arrays;

public class Application {
	public static void main(String ... args) {
		float a = Float.parseFloat(args[0]);
		float b = Float.parseFloat(args[1]);
		float c = Float.parseFloat(args[2]);

		System.out.println("Result: " + Arrays.toString(QuadraticEquationSolver.solve(a, b, c)));
	}
}
