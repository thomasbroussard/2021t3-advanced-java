package fr.epita.quiz.services.data.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.data.api.IQuestionDAO;


@Repository
public class QuestionJPADAO extends GenericJPADAO<Question> implements IQuestionDAO {

    @Inject
    SessionFactory factory;

    public List<Question> search(Question question){
        Session session = factory.openSession();
        Query<Question> query = session.createQuery("from Question where questionTitle like 'What is%'", Question.class);
        List<Question> resultList = query.list();

        session.close();

        return resultList;
    }


}
