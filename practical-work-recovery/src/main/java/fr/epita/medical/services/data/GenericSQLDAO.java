package fr.epita.medical.services.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.epita.medical.datamodel.Insurance;

public abstract class GenericSQLDAO {


    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("", "", "");
    }

    public void create(Insurance instance) throws SQLException {
        try {
            Connection connection = getConnection();
            try (connection){
                PreparedStatement preparedStatement = getCreatePreparedStatement(instance, connection);
                preparedStatement.executeUpdate();
            }catch (Exception e){
                //deal with data access exception
                e.printStackTrace();
            }
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            //Map it to GeneralFailureException
        }
    }

    protected abstract PreparedStatement getCreatePreparedStatement(Insurance instance, Connection connection) throws SQLException;



}
