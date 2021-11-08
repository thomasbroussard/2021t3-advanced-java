import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestSpring {

	@Inject
	@Named("firstQuery")
	String query;

	@Test
	public void testFirstInjection(){
		//given - a proper spring configuration

		//when - injection occurs when junit starts the test

		//then
		Assert.assertNotNull(query);
		System.out.println(query);


	}

}
