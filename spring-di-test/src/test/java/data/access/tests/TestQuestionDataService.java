package data.access.tests;

import java.util.ArrayList;

import javax.inject.Inject;

import org.junit.Test;

import fr.epita.datamodel.Question;
import fr.epita.services.data.QuestionDataService;

public class TestQuestionDataService {

    @Inject
    QuestionDataService dataService;


    @Test
    public void testDataService(){
        Question question = new Question();
        question.setQuestionTitle("What is MongoDB?");
        dataService.saveMcqQuestion(question, new ArrayList<>());

        //should fail because inconsitent
    }
}
