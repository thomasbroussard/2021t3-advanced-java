package fr.epita.services.data;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

import fr.epita.datamodel.MCQChoice;
import fr.epita.datamodel.Question;
import fr.epita.services.data.jpa.MCQChoiceJPADAO;
import fr.epita.services.data.jpa.QuestionJPADAO;

public class QuestionDataService {

    @Inject
    MCQChoiceJPADAO choiceJPADAO;

    @Inject
    QuestionJPADAO questionJPADAO;

    @Inject
    SessionFactory sessionFactory;


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


        Question ques = new Question();
        questionJPADAO.create(ques);

        for (MCQChoice choice : choices) {
            choice.setQuestion(ques);
            choiceJPADAO.create(choice);
        }


    }


}
