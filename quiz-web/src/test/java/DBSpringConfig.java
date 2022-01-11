import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.h2.Driver;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.util.ResourceUtils;

@Configuration
@ComponentScan(basePackages = {
        "fr.epita.quiz.web.data",
        "fr.epita.quiz.services.data.impl"
}
)
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

    @Bean
    public LocalSessionFactoryBean getSessionFactory(@Autowired DataSource ds){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(ds);
        factoryBean.setPackagesToScan("fr.epita.quiz.datamodel");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        factoryBean.setHibernateProperties(hibernateProperties);
        return factoryBean;
    }

    @Bean
    public TransactionManager getTxManager(@Autowired SessionFactory sf){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sf);
        return transactionManager;
    }


}
