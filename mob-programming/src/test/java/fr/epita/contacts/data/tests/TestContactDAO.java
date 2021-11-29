package fr.epita.contacts.data.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.contacts.datamodel.Contact;
import fr.epita.contacts.services.data.ContactDAO;
import fr.epita.contacts.services.data.IContactDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigForUnitTest.class)
public class TestContactDAO {


    @Inject
    @Named("services.data.mainDS")
    private DataSource ds;

    @Inject
    @Named("services.data.contactDAO")
    private IContactDAO dao;

    @Before
    public void loadDatabase() throws IOException {
        String s = Files.readString(new File("src/main/resources/create-contacts.sql").toPath());
        try (Connection connection = ds.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(s);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCreate() {
        //given
        Contact contact = new Contact();
        //we want to create this one :
        //Lenna,Paprocki,Feltz Printing Service,639 Main St,Anchorage,Anchorage,AK,99501,907-385-4412,907-921-2010,lpaprocki@hotmail.com
        contact.setName("Lenna");
        contact.setLastName("Paprocki");

        //when
        dao.create(contact);

        //then
        try (Connection connection = ds.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement("select name, lastname from contacts");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastname");
            Assert.assertEquals("Lenna", name);
            Assert.assertEquals("Paprocki", lastName);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
