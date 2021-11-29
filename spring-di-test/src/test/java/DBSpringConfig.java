import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.h2.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.ResourceUtils;

@Configuration
public class DBSpringConfig {

    @Bean("services.data.myFirstQueryAsBeanConfig")
    public String getQuery(){
        return "select * from Questions";
    }


    @Bean("global.conf.mainProperties")
    public Properties getProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(ResourceUtils.getFile("classpath:./config.properties")));
        return properties;
    }

    @Bean("services.data.mainDS")
    public DataSource getMainDS(
            @Autowired
            @Qualifier("global.conf.mainProperties")
            Properties properties
    ){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(Driver.class.getName());
        driverManagerDataSource.setUrl(resolveProperty(properties,"db.url"));
        driverManagerDataSource.setPassword("root");
        driverManagerDataSource.setUsername("root");
        return driverManagerDataSource;

    }

    private String resolveProperty(Properties properties, String propertyKey)  {

            return properties.getProperty(propertyKey);

    }

}
