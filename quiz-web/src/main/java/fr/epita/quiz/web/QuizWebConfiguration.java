package fr.epita.quiz.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "fr.epita.quiz.web.data",
        "fr.epita.quiz.services.data.impl"
}
)
public class QuizWebConfiguration {


}
