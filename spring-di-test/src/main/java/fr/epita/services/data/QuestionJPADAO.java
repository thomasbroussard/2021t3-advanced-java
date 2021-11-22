package fr.epita.services.data;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import fr.epita.datamodel.Question;

public class QuestionJPADAO {

    @Inject
    SessionFactory factory;

    public void create(Question question){

        Session session = factory.openSession();
        session.save(question);
        session.close();
    }


    public void update(Question question){
        Session session = factory.openSession();
        session.update(question);
        session.close();
    }

    public void delete(Question question){
        Session session = factory.openSession();
        session.delete(question);
        session.close();
    }

    public List<Question> search(Question question){
        Session session = factory.openSession();
        Query<Question> query = session.createQuery("from Question where questionTitle like 'What is%'", Question.class);
        List<Question> resultList = query.list();

        session.close();

        return resultList;
    }


}
