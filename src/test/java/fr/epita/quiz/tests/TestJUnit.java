package fr.epita.quiz.tests;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.epita.maths.IterativeFactorialImpl;
import fr.epita.maths.IFactorialService;
import fr.epita.maths.RecursiveFactorialImpl;

public class TestJUnit {


	@Test
	public void myFirstTest() throws Exception {
		//given
		int number = 5;


		//when
		IFactorialService factorial = new IterativeFactorialImpl();
		int result = factorial.calculateFactorial(number);

		//then
		Assert.assertEquals(120, result);

	}


}
