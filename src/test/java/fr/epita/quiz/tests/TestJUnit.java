package fr.epita.quiz.tests;


import org.junit.Assert;
import org.junit.Test;

import fr.epita.maths.Factorial;

public class TestJUnit {


	@Test
	public void myFirstTest() throws Exception {
		//given
		int number = 5;

		//when
		Factorial factorial = new Factorial();
		int result = factorial.calculateFactorial(number);

		//then
		Assert.assertEquals(120, result);

	}


}
