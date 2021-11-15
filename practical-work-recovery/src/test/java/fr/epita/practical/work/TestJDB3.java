package fr.epita.practical.work;

import java.io.IOException;
import java.sql.SQLException;

import fr.epita.medical.services.data.SQLScriptLoader;

public class TestJDB3 {


    public static void main(String[] args){
        SQLScriptLoader loader = new SQLScriptLoader();
        try {
            loader.readAndExecute("src/main/resources/create-insurances.sql");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(2);
        }
    }

}
