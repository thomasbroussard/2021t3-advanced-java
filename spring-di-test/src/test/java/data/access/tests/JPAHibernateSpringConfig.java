package data.access.tests;

import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import configs.DBSpringConfig;


@Configuration
@Import(DBSpringConfig.class)
public class JPAHibernateSpringConfig {

    @Inject
    DataSource ds;

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(this.ds);
        factoryBean.setPackagesToScan("fr.epita.datamodel");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        factoryBean.setHibernateProperties(hibernateProperties);
        return factoryBean;
    }
}
