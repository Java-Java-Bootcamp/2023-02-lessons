package ru.otus.first.prog;

public class QuadraticEquationSolver {
	/**
	 * Решает квадратное уравнение вида a * x^2 + b * x + c = 0
	 * @return Массив из 0, 1 или 2 элементов - корней данного уравнения
	 */
	public static float[] solve(float a, float b, float c) {
		float d = b * b - 4 * a * c;

		if (d < 0) {
			return new float[0];
		}

		if (d == 0) {
			return new float[]{-b / 2 / a};
		}

		return new float[]{ (-b  - (float)Math.sqrt(d)) / 2 / a, (-b  + (float)Math.sqrt(d)) / 2 / a};
	}
}
