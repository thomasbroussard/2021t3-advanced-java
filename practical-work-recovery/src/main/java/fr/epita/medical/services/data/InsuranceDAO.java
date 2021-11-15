package fr.epita.medical.services.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.epita.medical.datamodel.Insurance;

public class InsuranceDAO extends GenericSQLDAO {


    @Override
    protected PreparedStatement getCreatePreparedStatement(Insurance instance, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO INSURANCE(ID,NAME) VALUES(?,?)");
        preparedStatement.setInt(1, instance.getId());
        preparedStatement.setString(2, instance.getName());
        return preparedStatement;

    }

}
