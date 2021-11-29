package fr.epita.contacts.services.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import fr.epita.contacts.datamodel.Contact;

@Repository("services.data.contactDAO")
public class ContactDAO implements IContactDAO {

    @Inject
    @Named("services.data.mainDS")
    DataSource ds;

    public void create(Contact contact) {
        try(Connection connection = ds.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into CONTACTS (NAME, LASTNAME) values (?, ?)");
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getLastName());
            preparedStatement.execute();
        }catch(SQLException sqle){
            //TODO handle exception
            sqle.printStackTrace();
        }

    }
}
