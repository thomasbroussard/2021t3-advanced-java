package fr.epita.sandbox;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestLog4J {

	private static final Logger LOGGER = LogManager.getLogger(TestLog4J.class);


	@Test
	public void test(){

		// available levels :ERROR > WARNING > INFO > DEBUG > TRACE > ALL
		//  threshold       :                           ^
		//  message         :           ^
		LOGGER.info("this is an info");

		LOGGER.info("returning");
	}

}
