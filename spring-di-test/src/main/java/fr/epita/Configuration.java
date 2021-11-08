package fr.epita;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configuration {
	public static final String CONNECTION_STRING = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
	public static final String PASSWORD = "test";
	public static final String USER = "user";


	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(Configuration.CONNECTION_STRING, Configuration.USER, Configuration.PASSWORD);

	}


}
