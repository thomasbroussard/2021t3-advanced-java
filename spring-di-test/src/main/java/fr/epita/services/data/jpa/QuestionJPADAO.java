package fr.epita.services.data.jpa;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import fr.epita.datamodel.Question;

public class QuestionJPADAO extends GenericJPADAO<Question>{

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
