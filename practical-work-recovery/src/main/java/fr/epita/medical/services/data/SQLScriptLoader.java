package fr.epita.medical.services.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SQLScriptLoader {

    public void readAndExecute(String path) throws IOException, SQLException {
        File file = new File(path);
        List<String> strings = Files.readAllLines(file.toPath());
        String rawSqlStatement = String.join(" ", strings);
        String[] queriesAsArray = rawSqlStatement.split(";");
        for (String query : queriesAsArray){
            Connection connection = DriverManager.getConnection("","","");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        }

    }

}
