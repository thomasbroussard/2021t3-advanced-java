package fr.epita.tests.data;

import java.util.Arrays;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.data.QuestionDataService;
import fr.epita.tests.config.DBSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBSpringConfig.class})
public class DataAccessTest {

    @Inject
    QuestionDataService ds;


    @Test
    public void testConf(){
        Question ques = new Question();
        ques.setQuestionTitle("What is an ORM?");
        MCQChoice mcqChoice = new MCQChoice();
        mcqChoice.setQuestion(ques);

        ds.saveMcqQuestion(ques, Arrays.asList(mcqChoice));
    }

}
