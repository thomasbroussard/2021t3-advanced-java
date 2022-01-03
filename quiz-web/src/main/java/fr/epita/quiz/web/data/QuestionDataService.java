package fr.epita.quiz.web.data;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.data.api.IMCQQuestionDAO;
import fr.epita.quiz.services.data.api.IQuestionDAO;

@Component
public class QuestionDataService {

    @Inject
    IMCQQuestionDAO choiceDAO;

    @Inject
    IQuestionDAO questionDAO;


    @Transactional
    public void saveMcqQuestion(Question question, List<MCQChoice> choices) //should throw functional exceptions
    {

        if (question == null) {
            //inconsistency to report
            //TODO throw exception
        }
        if (choices == null || choices.isEmpty()) {
            //inconsistency to report
            //TODO throw exception
        }


        questionDAO.create(question);

        for (MCQChoice choice : choices) {
            choice.setQuestion(question);
            choiceDAO.create(choice);
        }


    }


}
