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
        Query<Question> query = session.createQuery("from Question where questionTitle like :questionTitle", Question.class);

        query.setParameter("questionTitle", question.getQuestionTitle());
        List<Question> resultList = query.list();

        session.close();



        return resultList;
    }


    //example of a join query:
    //from MCQChoice mcq
    //join Question q on q = mcq.question
    // will result in a list of Object
    // [[instance of MCQChoice, instance of Question], [...], [...] ]

}
