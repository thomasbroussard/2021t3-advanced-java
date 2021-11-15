import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

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

	@Inject
	@Named("data.connection.connectionPassword")
	String password;

	@Inject
	@Named("data.connection.connectionString")
	String url;

	@Inject
	@Named("data.connection.connectionUser")
	String user;

	@Inject
	@Named("dataSource")
	DataSource ds;

	@Test
	public void testFirstInjection(){
		//given - a proper spring configuration

		//when - injection occurs when junit starts the test

		//then
		Assert.assertNotNull(query);
		System.out.println(query);


	}

	@Test
	public void testOtherInjection(){
		//given - a proper spring configuration

		//when - injection occurs when junit starts the test

		//then
		Assert.assertNotNull(user);
		System.out.println(user);
	}

	@Test
	public void testDatasource() throws SQLException {
		//given - a proper spring configuration

		//when - injection occurs when junit starts the test

		//then
		Assert.assertNotNull(ds);
		Connection connection = ds.getConnection();

		String schema = connection.getSchema();
		System.out.println(schema);
		Assert.assertEquals("PUBLIC",
				schema);
		connection.close();

	}




}
