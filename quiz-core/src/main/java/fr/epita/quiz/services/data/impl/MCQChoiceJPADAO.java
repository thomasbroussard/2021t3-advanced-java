package fr.epita.quiz.services.data.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.services.data.api.IMCQQuestionDAO;

@Repository
public class MCQChoiceJPADAO extends GenericJPADAO<MCQChoice> implements IMCQQuestionDAO {


    @Override
    public List<MCQChoice> search(MCQChoice obj) {
        String jpql = "select c from MCQChoice c where c.question.questionTitle = :question";
        Session session = this.factory.openSession();
        Query<MCQChoice> query = session.createQuery(jpql, MCQChoice.class);
        query.setParameter("question", obj.getQuestion().getQuestionTitle());
        return query.list();
    }
}
