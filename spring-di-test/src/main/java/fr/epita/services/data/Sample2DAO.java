package fr.epita.services.data;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

public class Sample2DAO {

	@Inject
	DataSource ds;


	void create(Object obj) throws SQLException {
		Connection connection = ds.getConnection();
		connection.close();
	}


}
