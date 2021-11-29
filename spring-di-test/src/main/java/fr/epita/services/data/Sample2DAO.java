package fr.epita.services.data;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public class Sample2DAO {

	@Inject
	@Named("dataSource")
	DataSource ds;


	void create(Object obj) throws SQLException {
		Connection connection = ds.getConnection();
		connection.close();
	}


}
