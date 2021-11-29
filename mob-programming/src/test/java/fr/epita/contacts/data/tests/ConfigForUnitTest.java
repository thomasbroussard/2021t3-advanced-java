package fr.epita.contacts.data.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import fr.epita.contacts.services.data.ContactDAO;

@Configuration
@ComponentScan(basePackages = {"fr.epita.contacts.services.data"})
public class ConfigForUnitTest {


//    @Bean
//    public ContactDAO getContactDAO(){
//        return new ContactDAO();
//    }

    @Bean("services.data.mainDS")
    public DataSource getMainDS() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(Driver.class.getName());
        driverManagerDataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        driverManagerDataSource.setPassword("root");
        driverManagerDataSource.setUsername("root");
        return driverManagerDataSource;

    }


}
