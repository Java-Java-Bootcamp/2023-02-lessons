package ru.otus.first.prog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuadraticEquationSolverTest {
	@Test
	void fullEquation() {
		var res = QuadraticEquationSolver.solve(2, 4, -4);
		assertEquals(res.length, 2);
		assertEquals(res[0], -2.73, 0.01);
		assertEquals(res[1], 0.73, 0.01);
	}

	@Test
	void noRoots() {
		var res = QuadraticEquationSolver.solve(2, 4, 4);
		assertEquals(res.length, 0);
	}

}