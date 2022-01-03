package fr.epita.quiz.web;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication
public class QuizWebApplication {


    public static void main(String[] args) throws IOException {
        SpringApplication springApplication = new SpringApplication(QuizWebApplication.class);
//        String fileLocation = System.getProperty("application-properties-file");
//        Properties properties = new Properties();
//        properties.load(new FileReader(fileLocation));
//        //java -Dapplication-properties-file=C:/Users/User/conf/app.properties -jar <your-jar.jar>
//        springApplication.setDefaultProperties(properties);
        springApplication.run(args);
    }

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext
                .getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping
                .getHandlerMethods();
        map.forEach((key, value) -> System.out.println(key + " => " + value));
    }
}
