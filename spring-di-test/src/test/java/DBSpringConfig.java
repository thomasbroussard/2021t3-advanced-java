import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.h2.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.ResourceUtils;

@Configuration
public class DBSpringConfig {

    @Bean("myFirstQueryAsBeanConfig")
    public String getQuery(){
        return "select * from Questions";
    }

    @Bean
    public Properties getProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(ResourceUtils.getFile("classpath:./config.properties")));
        return properties;
    }

    @Bean("mainDS")
    public DataSource getMainDS(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(Driver.class.getName());
        driverManagerDataSource.setUrl(resolveProperty("db.url"));
        driverManagerDataSource.setPassword("root");
        driverManagerDataSource.setUsername("root");
        return driverManagerDataSource;

    }

    private String resolveProperty(String propertyKey)  {
        try {
            return getProperties().getProperty(propertyKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
